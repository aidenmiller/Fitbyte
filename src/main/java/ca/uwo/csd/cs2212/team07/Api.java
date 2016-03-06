package ca.uwo.csd.cs2212.team07;

import com.github.scribejava.core.model.*; //Request Verb
import java.net.URI;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONException;

/**
 * The API class manages API calls made to Fitbit, it calls on the
 * "RefreshTokens" class gathers data from the Fitbit API, parses through it and
 * then passes information onto other classes
 *
 * @author Team07
 */
public class Api {

    /**
     * syncToday() method, returns a Daily object containing all information
     * from today's date
     *
     * @return Daily object containing information pertaining to today's date
     * @throws JSONException If there is an issue parsing through JSON data
     * provided by API calls
     * @throws RefreshTokenException if there is an issue refreshing tokens
     */
    public static Daily syncToday() throws JSONException, RefreshTokenException {
        String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); //get today's date, in correct format

        return getDailySummary(todayDate);
    }

    /**
     * getDailySummary() method, returns Daily object with information
     * pertaining to the specified date
     *
     * @param date date String that we are returning a daily summary of
     * @return Daily object containing daily summary info of specified date
     * @throws JSONException if there is an issue parsing through JSON data
     * provided by API calls
     * @throws RefreshTokenException if there is an issue refreshing tokens
     */
    public static Daily getDailySummary(String date) throws JSONException, RefreshTokenException {

        String requestUrlPrefix = "https://api.fitbit.com/1/user/-/"; // all api calls begin with this url prefix

        double floorGoal, distanceGoal, distance, elevation, floors; // info that will be returned by api call

        floorGoal = distanceGoal = distance = elevation = floors = 0;

        long activeMinGoal, calOutGoal, stepsGoal, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMins, lightlyActiveMins,
                marginalCalories, sedentaryMins, steps, veryActiveMins; //info that will be returned by api call

        activeMinGoal = calOutGoal = stepsGoal = activityCalories = caloriesBMR = caloriesOut = fairlyActiveMins = lightlyActiveMins = marginalCalories
                = sedentaryMins = steps = veryActiveMins = 0;

        String requestUrl;
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities/date/" + date + ".json";

        Response response = RefreshTokens.getResponse(requestUrl); // get Response JSON object from API
       

        JSONObject obj = new JSONObject(response.getBody());

        JSONObject goals = obj.getJSONObject("goals"); // get "goals" json object out of response

        // Get goal info on specified day
        activeMinGoal = goals.getLong("activeMinutes");
        calOutGoal = goals.getLong("caloriesOut");
        distanceGoal = goals.getDouble("distance");
        floorGoal = goals.getDouble("floors");
        stepsGoal = goals.getLong("steps");

        JSONObject summary = obj.getJSONObject("summary"); // get "summary" json object out of response

        // get summary info on specified day
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

        // return daily object with info gathered from API call
        return new Daily(date, activeMinGoal, calOutGoal, distanceGoal, floorGoal, stepsGoal, activityCalories, caloriesBMR, caloriesOut, distance, elevation, fairlyActiveMins,
                floors, lightlyActiveMins, marginalCalories, sedentaryMins, steps, veryActiveMins);
    }

    /**
     * getLifetime() method, returns a Lifetime object containing all the
     * lifetime statistics of user
     *
     * @return Lifetime object containing statistics from user
     * @throws JSONException if there is an issue parsing through JSON data
     * returned by API
     * @throws RefreshTokenException if there is an issue refreshing tokens when
     * accessing API
     */
    public static Lifetime getLifetime() throws JSONException, RefreshTokenException {

        String requestUrlPrefix = "https://api.fitbit.com/1/user/-/"; // url prefix for all api calls
        String requestUrl;
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities.json";

        Response response = RefreshTokens.getResponse(requestUrl); // get response object from API

        JSONObject obj = new JSONObject(response.getBody()); // get JSON object from response
        JSONObject lifetimeStats = obj.getJSONObject("lifetime").getJSONObject("total");

        // return Lifetime object containing the user's lifetime statistics
        return new Lifetime(lifetimeStats.getDouble("distance"), lifetimeStats.getDouble("floors"), lifetimeStats.getLong("steps"));
    }

    /**
     * getBestDays() method, returns an array of BestDay objects containing info
     * of the user's best days
     *
     * @return BestDay array containing information of the user's best days
     * @throws JSONException if there is an issue parsing through JSON data
     * returned by Api call
     * @throws RefreshTokenException if there is an issue refreshing tokens when
     * accessing the api
     */
    public static BestDay[] getBestDays() throws JSONException, RefreshTokenException {

        String requestUrlPrefix = "https://api.fitbit.com/1/user/-/"; // url prefix for all api calls
        String requestUrl;

        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities.json";

        Response response = RefreshTokens.getResponse(requestUrl); // get response from api
        JSONObject obj = new JSONObject(response.getBody());

        // get JSON objects containing the user's best day info
        JSONObject bestTotalDistance = obj.getJSONObject("best").getJSONObject("total").getJSONObject("distance");
        JSONObject bestTotalFloors = obj.getJSONObject("best").getJSONObject("total").getJSONObject("floors");
        JSONObject bestTotalSteps = obj.getJSONObject("best").getJSONObject("total").getJSONObject("steps");

        // create BestDay objects for distance, floors and steps
        BestDay distanceBestDay = new BestDay(bestTotalDistance.getString("date"), "distance", bestTotalDistance.getDouble("value"));
        BestDay floorsBestDay = new BestDay(bestTotalFloors.getString("date"), "floors", bestTotalFloors.getDouble("value"));
        BestDay stepsBestDay = new BestDay(bestTotalSteps.getString("date"), "steps", bestTotalSteps.getDouble("value"));

        BestDay[] bestDayArray = {distanceBestDay, floorsBestDay, stepsBestDay}; // create array of BestDay objects

        return bestDayArray;
    }
    
    public static HeartData getHeartSummary(String date) throws JSONException, RefreshTokenException {

        String requestUrlPrefix = "https://api.fitbit.com/1/user/-/"; // all api calls begin with this url prefix

        String requestUrl;
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities/heart/date/" + date + "/1d.json";

        Response response = RefreshTokens.getResponse(requestUrl); // get Response JSON object from API
       

        JSONObject obj = new JSONObject(response.getBody());
        JSONArray intraDayDataset = obj.getJSONObject("activities-heart-intraday").getJSONArray("dataset");
        JSONObject outOfRange = 
                obj.getJSONArray("activities-heart").getJSONObject(0).getJSONObject("value").getJSONArray("heartRateZones").getJSONObject(0);
        JSONObject fatBurn = 
                obj.getJSONArray("activities-heart").getJSONObject(0).getJSONObject("value").getJSONArray("heartRateZones").getJSONObject(1);
        JSONObject cardio = 
                obj.getJSONArray("activities-heart").getJSONObject(0).getJSONObject("value").getJSONArray("heartRateZones").getJSONObject(2);
        JSONObject peak = 
                obj.getJSONArray("activities-heart").getJSONObject(0).getJSONObject("value").getJSONArray("heartRateZones").getJSONObject(3);
        
        int restingHeartRate = obj.getJSONArray("activities-heart").getJSONObject(0).getJSONObject("value").getInt("restingHeartRate");
        int outOfRangeMins = outOfRange.getInt("minutes");
        int fatBurnMins = fatBurn.getInt("minutes");
        int cardioMins = cardio.getInt("minutes");
        int peakMins = peak.getInt("minutes");
        double outOfRangeCalsOut = outOfRange.getDouble("caloriesOut");
        double fatBurnCalsOut = fatBurn.getDouble("caloriesOut");
        double cardioCalsOut = cardio.getDouble("caloriesOut");
        double peakCalsOut = peak.getDouble("caloriesOut");
        
        return new HeartData(date, restingHeartRate, outOfRangeMins, fatBurnMins, cardioMins, peakMins, outOfRangeCalsOut, fatBurnCalsOut,
                             cardioCalsOut, peakCalsOut, intraDayDataset);

    }
    
    public static void getTimeSeriesData(String date, String activity, int resolution) throws JSONException, RefreshTokenException {
        
        String requestUrlPrefix = "https://api.fitbit.com/1/user/-/"; // all api calls begin with this url prefix

        String requestUrl;
        
        
        if (activity.equals("heartrate")) {
            requestUrl = requestUrlPrefix + "activities/heart/date/" +date + "/1d/" + resolution + "min.json";
        }
        else {
        //    The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + "activities/" + activity + "/date/" + date + "/" + date  + "/" + resolution + "min.json";
        }

        Response response = RefreshTokens.getResponse(requestUrl); // get Response JSON object from API
        System.out.println(response.getBody());
    
        ArrayList timeDataList = new ArrayList();
        JSONObject obj = new JSONObject(response.getBody());
        JSONArray intradayData = obj.getJSONObject("activities-" + activity+ "-intraday").getJSONArray("dataset");
        
        for(int i = 0; i< intradayData.length() - 1; i++) {
            if(activity.equals("steps"))
                timeDataList.add(intradayData.getJSONObject(i).getDouble("value"));
            else if (activity.equals("calories"))
                timeDataList.add(intradayData.getJSONObject(i).getInt("value"));
            else
                timeDataList.add(intradayData.getJSONObject(i).getDouble("value"));
                
                
                    
        }
        
        
        //return timeDataList;
    } 


}
