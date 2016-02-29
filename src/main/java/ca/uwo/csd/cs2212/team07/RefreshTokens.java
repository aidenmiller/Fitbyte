package ca.uwo.csd.cs2212.team07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.github.scribejava.apis.FitbitApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.model.*; //Request Verb
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.apis.service.FitbitOAuth20ServiceImpl;
import java.awt.Desktop;
import java.net.URI;
import org.json.JSONObject;
import org.json.JSONArray;

public class RefreshTokens {

    private static String CALL_BACK_URI = "http://localhost:8080";
    private static int CALL_BACK_PORT = 8080;

    public static Response getResponse(String requestUrl) throws RefreshTokenException {

        //read credentials from a file
        BufferedReader bufferedReader = null;
        // This will reference one line at a time
        String line = null;

        //Need to save service credentials for Fitbit
        String apiKey = null;
        String apiSecret = null;
        String clientID = null;

        //holder for all the elements we will need to make an access token ( information about an authenticated session )
        String accessTokenItself = null;
        String tokenType = null;
        String refreshToken = null;
        Long expiresIn = null;
        String rawResponse = null;

        //This is the only scope you have access to currently
        String scope = "activity%20heartrate";
        try {
            // File with service credentials.

            FileReader fileReader
                    = new FileReader("src/main/resources/Team7Credentials.txt");
            bufferedReader = new BufferedReader(fileReader);
            clientID = bufferedReader.readLine();
            apiKey = bufferedReader.readLine();
            apiSecret = bufferedReader.readLine();
            bufferedReader.close();
            fileReader = new FileReader("src/main/resources/Team7Tokens.txt");
            bufferedReader = new BufferedReader(fileReader);

            accessTokenItself = bufferedReader.readLine();
            tokenType = bufferedReader.readLine();
            refreshToken = bufferedReader.readLine();
            expiresIn = Long.parseLong(bufferedReader.readLine());
            rawResponse = bufferedReader.readLine();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file\n" + ex.getMessage());
            System.exit(1);
        } catch (IOException ex) {
            System.out.println(
                    "Error reading/write file\n" + ex.getMessage());
            System.exit(1);
        } finally {
            try {
                if (bufferedReader != null) // Always close files.
                {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                System.out.println(
                        "Error closing file\n" + e.getMessage());
            }
        }
        //  Create the Fitbit service - you will ask this to ask for access/refresh pairs
        //     and to add authorization information to the requests to the API
        FitbitOAuth20ServiceImpl service = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
                .apiKey(clientID) //fitbit uses the clientID here
                .apiSecret(apiSecret)
                .callback("http://localhost:8080")
                .scope(scope)
                .grantType("authorization_code")
                .build(FitbitApi20.instance());

        //  The access token contains everything you will need to authenticate your requests
        //  It can expire - at which point you will use the refresh token to refresh it
        //  See: https://dev.fitbit.com/docs/oauth2/#refreshing-tokens
        //    I have authenticated and given you the contents of the response to use
        OAuth2AccessToken accessToken = new OAuth2AccessToken(
                accessTokenItself,
                tokenType,
                refreshToken,
                expiresIn,
                rawResponse);
        // Now let's go and ask for a protected resource!
        // This actually generates an HTTP request from the URL
        //    -it has a header, body ect.
        OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl, service);

        // This adds the information required by Fitbit to add the authorization information to the HTTP request
        // You must do this before the request will work
        // See: https://dev.fitbit.com/docs/oauth2/#making-requests
        service.signRequest(accessToken, request);

        //  This actually sends the request:
        Response response = request.send();

        //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
        //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
        int statusCode = response.getCode();

        switch (statusCode) {
            case 200:
                break;
            case 400:
                throw new RefreshTokenException("Bad Request");
            case 401:
                //Likely Expired token- TRY TO REFRESH

                // This uses the refresh token to get a completely new accessToken object
                //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
                // This accessToken is now the current one, and the old ones will not work
                //   again.  You should save the contents of accessToken.
                accessToken = service.refreshOAuth2AccessToken(accessToken);

                // Now we can try to access the service again
                // Make sure you create a new OAuthRequest object each time!
                request = new OAuthRequest(Verb.GET, requestUrl, service);
                service.signRequest(accessToken, request);
                response = request.send();

                // Hopefully got a response this time:
                break;
            case 429:
                System.out.println("Rate limit exceeded");
                throw new RefreshTokenException("429-Rate Limit Exceeded");
            default:
               /* System.out.println("HTTP response code: " + response.getCode());
                System.out.println("HTTP response body:\n" + response.getBody()); */
        }

        BufferedWriter bufferedWriter = null;
        //  Save the current accessToken information for next time

        // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
        //   - contact Beth if this happens and she can reissue you a fresh set
        try {
            FileWriter fileWriter;
            fileWriter
                    = new FileWriter("src/main/resources/Team7Tokens.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(accessToken.getToken());
            bufferedWriter.newLine();
            bufferedWriter.write(accessToken.getTokenType());
            bufferedWriter.newLine();
            bufferedWriter.write(accessToken.getRefreshToken());
            bufferedWriter.newLine();
            bufferedWriter.write(accessToken.getExpiresIn().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(accessToken.getRawResponse());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(
                    "Error reading/write file\n" + ex.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                System.out.println(
                        "Error closing file\n" + e.getMessage());
            }
        }//end try
        if (response.getCode() != 200) {
            throw new RefreshTokenException("Error Accessing API");
        } else {
            return response;
        }
    }

}
