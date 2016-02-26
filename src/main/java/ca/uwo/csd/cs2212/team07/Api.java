package ca.uwo.csd.cs2212.team07;

import com.github.scribejava.core.model.*; //Request Verb
import java.net.URI;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.json.JSONException;

public class Api {



    public static Daily syncToday() throws JSONException, RefreshTokenException {
        String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return getDailySummary(todayDate);
      
    }

    public static Daily getDailySummary(String date) throws JSONException, RefreshTokenException {
        String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
        
        double floorGoal ,distanceGoal, distance, elevation, floors;
        floorGoal = distanceGoal = distance = elevation = floors = 0;
        
        long activeMinGoal, calOutGoal, stepsGoal, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMins, lightlyActiveMins,
                      marginalCalories, sedentaryMins, steps, veryActiveMins;
        activeMinGoal= calOutGoal = stepsGoal = activityCalories = caloriesBMR = caloriesOut = fairlyActiveMins = lightlyActiveMins = marginalCalories
                = sedentaryMins = steps = veryActiveMins = 0;
        
        
         String requestUrl;
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities/date/" + date +".json"; 
        //OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl, service);
        //service.signRequest(accessToken, request);
        Response response = RefreshTokens.getResponse(requestUrl);
        
        JSONObject obj = new JSONObject(response.getBody());
        
        JSONObject goals = obj.getJSONObject("goals");
        activeMinGoal = goals.getLong("activeMinutes");
        calOutGoal = goals.getLong("caloriesOut");
        distanceGoal = goals.getDouble("distance");
        floorGoal = goals.getDouble("floors");
        stepsGoal = goals.getLong("steps");
        
        JSONObject summary = obj.getJSONObject("summary");
        activityCalories = summary.getLong("activityCalories");
        caloriesBMR = summary.getLong("caloriesBMR");
        caloriesOut = summary.getLong("caloriesOut");
        elevation = summary.getDouble("elevation");
        fairlyActiveMins = summary.getLong("fairlyActiveMinutes");
        floors = summary.getDouble("floors");
        lightlyActiveMins = summary.getLong("lightlyActiveMinutes");
        marginalCalories = summary.getLong("marginalCalories");
        sedentaryMins = summary.getLong("sedentaryMinutes");
        steps = summary.getLong("steps");
        veryActiveMins = summary.getLong("veryActiveMinutes");
        
        distance = summary.getJSONArray("distances").getJSONObject(0).getDouble("distance");
        
        
        return new Daily(date, activeMinGoal, calOutGoal, distanceGoal, floorGoal, stepsGoal, activityCalories, caloriesBMR, caloriesOut, distance, elevation, fairlyActiveMins,
        floors, lightlyActiveMins, marginalCalories, sedentaryMins, steps, veryActiveMins);

    }

    /*public void getCalories(SimpleDateFormat date) {
        String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
        String requestUrl;
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + ""; //needs URL
        OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        Response response = request.send();

        return response;
    } */

    public static Lifetime getLifetime() throws JSONException, RefreshTokenException {
        String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
        String requestUrl;
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities.json";
       
        Response response = RefreshTokens.getResponse(requestUrl);
        
        JSONObject obj = new JSONObject(response.getBody());
        JSONObject lifetimeStats = obj.getJSONObject("lifetime").getJSONObject("total");

        return new Lifetime(lifetimeStats.getDouble("distance"), lifetimeStats.getDouble("floors"), lifetimeStats.getLong("steps"));

    }

    public static BestDay[] getBestDays() throws JSONException, RefreshTokenException {
        String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
        String requestUrl;
        
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities.json";
       
        Response response = RefreshTokens.getResponse(requestUrl);
       
        JSONObject obj = new JSONObject(response.getBody());
        
   
        JSONObject bestTotalDistance = obj.getJSONObject("best").getJSONObject("total").getJSONObject("distance");
        JSONObject bestTotalFloors = obj.getJSONObject("best").getJSONObject("total").getJSONObject("floors");
        JSONObject bestTotalSteps = obj.getJSONObject("best").getJSONObject("total").getJSONObject("steps");
        
        BestDay distanceBestDay = new BestDay(bestTotalDistance.getString("date"), "distance", bestTotalDistance.getDouble("value"));
        BestDay floorsBestDay = new BestDay(bestTotalFloors.getString("date"), "floors", bestTotalFloors.getDouble("value"));
        BestDay stepsBestDay = new BestDay(bestTotalSteps.getString("date"), "steps", bestTotalSteps.getDouble("value"));
        
        BestDay[] bestDayArray = {distanceBestDay, floorsBestDay, stepsBestDay};
        
        return bestDayArray;
       
     } 
}



     
  


