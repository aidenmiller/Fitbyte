package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * Daily class, contains information of all goals and statistics of any given day
 * @author Team07
 */
public class Daily implements Serializable {

    
    //INSTANCE VARIABLES:
    
    // instance variables are declared as public final so that they can be accessed easily, but not changed
    private String date;
    private long activeMinGoal;
    private long activityCalories;
  private long calOutGoal;
    private long stepsGoal;
    private long caloriesBMR;
    private long caloriesOut;
    private long fairlyActiveMins;
    private long lightlyActiveMins;
    private long marginalCalories;
    private long sedentaryMins;
    private long steps;
    private long veryActiveMins;
    private long activeMins;
    private double floorGoal, distanceGoal, distance, elevation, floors;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getActiveMinGoal() {
        return activeMinGoal;
    }

    public void setActiveMinGoal(long activeMinGoal) {
        this.activeMinGoal = activeMinGoal;
    }

    public long getActivityCalories() {
        return activityCalories;
    }

    public void setActivityCalories(long activityCalories) {
        this.activityCalories = activityCalories;
    }

    public long getCalOutGoal() {
        return calOutGoal;
    }

    public void setCalOutGoal(long calOutGoal) {
        this.calOutGoal = calOutGoal;
    }

    public long getStepsGoal() {
        return stepsGoal;
    }

    public void setStepsGoal(long stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    public long getCaloriesBMR() {
        return caloriesBMR;
    }

    public void setCaloriesBMR(long caloriesBMR) {
        this.caloriesBMR = caloriesBMR;
    }

    public long getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(long caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    public long getFairlyActiveMins() {
        return fairlyActiveMins;
    }

    public void setFairlyActiveMins(long fairlyActiveMins) {
        this.fairlyActiveMins = fairlyActiveMins;
    }

    public long getLightlyActiveMins() {
        return lightlyActiveMins;
    }

    public void setLightlyActiveMins(long lightlyActiveMins) {
        this.lightlyActiveMins = lightlyActiveMins;
    }

    public long getMarginalCalories() {
        return marginalCalories;
    }

    public void setMarginalCalories(long marginalCalories) {
        this.marginalCalories = marginalCalories;
    }

    public long getSedentaryMins() {
        return sedentaryMins;
    }

    public void setSedentaryMins(long sedentaryMins) {
        this.sedentaryMins = sedentaryMins;
    }

    public long getSteps() {
        return steps;
    }

    public void setSteps(long steps) {
        this.steps = steps;
    }

    public long getVeryActiveMins() {
        return veryActiveMins;
    }

    public void setVeryActiveMins(long veryActiveMins) {
        this.veryActiveMins = veryActiveMins;
    }

    public long getActiveMins() {
        return activeMins;
    }

    public void setActiveMins(long activeMins) {
        this.activeMins = activeMins;
    }

    public double getFloorGoal() {
        return floorGoal;
    }

    public void setFloorGoal(double floorGoal) {
        this.floorGoal = floorGoal;
    }

    public double getDistanceGoal() {
        return distanceGoal;
    }

    public void setDistanceGoal(double distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getFloors() {
        return floors;
    }

    public void setFloors(double floors) {
        this.floors = floors;
    }

    
}
