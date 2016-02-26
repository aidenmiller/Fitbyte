package ca.uwo.csd.cs2212.team07;

public class Daily {

    public final String date;

    public final long activeMinGoal, calOutGoal, stepsGoal, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMins, lightlyActiveMins,
            marginalCalories, sedentaryMins, steps, veryActiveMins;
    public final double floorGoal, distanceGoal, distance, elevation, floors;

    public Daily(String dailyDate, long dailyActiveMinGoal, long dailyCalOutGoal, double dailyDistanceGoal, double dailyFloorGoal, long dailyStepsGoal, long dailyActivityCalories,
            long dailyCaloriesBMR, long dailyCaloriesOut, double dailyDistance, double dailyElevation, long dailyFairlyActiveMins, double dailyFloors, long dailyLightActMins,
            long dailyMargCals, long dailySedMins, long dailySteps, long dailyVeryActMins) {

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

    }

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
