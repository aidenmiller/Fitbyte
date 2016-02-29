package ca.uwo.csd.cs2212.team07;

/**
 * Daily class, contains information of all goals and statistics of any given day
 * @author Team07
 */
public class Daily {

    
    //INSTANCE VARIABLES:
    
    // instance variables are declared as public final so that they can be accessed easily, but not changed
    public final String date;

    public final long activeMinGoal, calOutGoal, stepsGoal, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMins, lightlyActiveMins,
            marginalCalories, sedentaryMins, steps, veryActiveMins, activeMins;
    public final double floorGoal, distanceGoal, distance, elevation, floors;

    /**
     * Contructor Method, creates a new Daily object
     * @param dailyDate 
     * @param dailyActiveMinGoal
     * @param dailyCalOutGoal
     * @param dailyDistanceGoal
     * @param dailyFloorGoal
     * @param dailyStepsGoal
     * @param dailyActivityCalories
     * @param dailyCaloriesBMR
     * @param dailyCaloriesOut
     * @param dailyDistance
     * @param dailyElevation
     * @param dailyFairlyActiveMins
     * @param dailyFloors
     * @param dailyLightActMins
     * @param dailyMargCals
     * @param dailySedMins
     * @param dailySteps
     * @param dailyVeryActMins 
     */
    public Daily(String dailyDate, long dailyActiveMinGoal, long dailyCalOutGoal, double dailyDistanceGoal, double dailyFloorGoal, long dailyStepsGoal, long dailyActivityCalories,
            long dailyCaloriesBMR, long dailyCaloriesOut, double dailyDistance, double dailyElevation, long dailyFairlyActiveMins, double dailyFloors, long dailyLightActMins,
            long dailyMargCals, long dailySedMins, long dailySteps, long dailyVeryActMins) {

        // create Daily object using paramatized information
        this.date = dailyDate;
        this.activeMinGoal = dailyActiveMinGoal;
        this.calOutGoal = dailyCalOutGoal;
        this.distanceGoal = dailyDistanceGoal;
        this.floorGoal = dailyFloorGoal;
        this.stepsGoal = dailyStepsGoal;
        this.activityCalories = dailyActivityCalories;
        this.caloriesBMR = dailyCaloriesBMR;
        this.caloriesOut = dailyCaloriesOut;
        this.distance = dailyDistance;
        this.elevation = dailyElevation;
        this.floors = dailyFloors;
        this.lightlyActiveMins = dailyLightActMins;
        this.marginalCalories = dailyMargCals;
        this.sedentaryMins = dailySedMins;
        this.steps = dailySteps;
        this.veryActiveMins = dailyVeryActMins;
        this.fairlyActiveMins = dailyFairlyActiveMins;
        this.activeMins = fairlyActiveMins + veryActiveMins + lightlyActiveMins;
    }

    /**
     * toString() method, used for testing api calls
     * @return String containing info of Daily object
     */
    @Override
    public String toString() {
        return "Date: " + date + "\n\nGOALS:\nActive Minutes Goal: " + activeMinGoal + "\nCalories Out Goal: " + calOutGoal + "\nSteps Taken Goal: " + stepsGoal
                + "\nFloors Goal: " + floorGoal + "\nDistance Goal: " + distanceGoal + "\n\nDAILY:\nActivity Calories Out: " + activityCalories
                + "\nCalories BMR: " + caloriesBMR + "\nCalories Out: " + caloriesOut + "\nSedentary Minutes: " + sedentaryMins
                + "\nFairly Active Minutes: " + fairlyActiveMins + "\nLightly Active Minutes: " + lightlyActiveMins + "\nVery Active Minutes: " + veryActiveMins
                + "\nMarginal Calories:" + marginalCalories
                + "\nSteps Taken: " + steps + "\nDistance: " + distance + "\nElevation: " + elevation + "\nFloors: " + floors;
    }
}
