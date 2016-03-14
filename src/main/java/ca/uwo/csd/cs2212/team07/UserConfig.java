package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

public class UserConfig implements Serializable {

    private static final long serialVersionUID = 2L;

    private boolean testMode;

    private boolean caloriesData;
    private boolean distanceData;
    private boolean floorsData;
    private boolean stepsData;
    private boolean activeData;
    private boolean sedentaryData;

    private boolean caloriesAccolade[];
    private boolean distanceAccolade[];
    private boolean activeAccolade[];
    private boolean stepsAccolade[];
    private boolean floorsAccolade[];
    private boolean goalsAccolade[];
    private boolean accoladesAccolade[];

    public UserConfig() {
        caloriesData = true;
        distanceData = true;
        floorsData = true;
        stepsData = true;
        activeData = true;
        sedentaryData = true;
        caloriesAccolade = new boolean[3];
        distanceAccolade = new boolean[3];
        activeAccolade = new boolean[3];
        stepsAccolade = new boolean[3];
        floorsAccolade = new boolean[3];
        goalsAccolade = new boolean[3];
        accoladesAccolade = new boolean[3];
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public boolean[] getCaloriesAccolade() {
        return caloriesAccolade;
    }

    public void setCaloriesAccolade(boolean[] caloriesAccolade) {
        this.caloriesAccolade = caloriesAccolade;
    }

    public boolean[] getDistanceAccolade() {
        return distanceAccolade;
    }

    public void setDistanceAccolade(boolean[] distanceAccolade) {
        this.distanceAccolade = distanceAccolade;
    }

    public boolean[] getActiveAccolade() {
        return activeAccolade;
    }

    public void setActiveAccolade(boolean[] activeAccolade) {
        this.activeAccolade = activeAccolade;
    }

    public boolean[] getStepsAccolade() {
        return stepsAccolade;
    }

    public void setStepsAccolade(boolean[] stepsAccolade) {
        this.stepsAccolade = stepsAccolade;
    }

    public boolean[] getFloorsAccolade() {
        return floorsAccolade;
    }

    public void setFloorsAccolade(boolean[] floorsAccolade) {
        this.floorsAccolade = floorsAccolade;
    }

    public boolean[] getGoalsAccolade() {
        return goalsAccolade;
    }

    public void setGoalsAccolade(boolean[] goalsAccolade) {
        this.goalsAccolade = goalsAccolade;
    }

    public boolean[] getAccoladesAccolade() {
        return accoladesAccolade;
    }

    public void setAccoladesAccolade(boolean[] accoladesAccolade) {
        this.accoladesAccolade = accoladesAccolade;
    }

    public boolean isCaloriesData() {
        return caloriesData;
    }

    public void setCaloriesData(boolean caloriesData) {
        this.caloriesData = caloriesData;
    }

    public boolean isDistanceData() {
        return distanceData;
    }

    public void setDistanceData(boolean distanceData) {
        this.distanceData = distanceData;
    }

    public boolean isFloorsData() {
        return floorsData;
    }

    public void setFloorsData(boolean floorsData) {
        this.floorsData = floorsData;
    }

    public boolean isStepsData() {
        return stepsData;
    }

    public void setStepsData(boolean stepsData) {
        this.stepsData = stepsData;
    }

    public boolean isActiveData() {
        return activeData;
    }

    public void setActiveData(boolean activeData) {
        this.activeData = activeData;
    }

    public boolean isSedentaryData() {
        return sedentaryData;
    }

    public void setSedentaryData(boolean sedentaryData) {
        this.sedentaryData = sedentaryData;
    }

    public void testModeConfig() {
        this.testMode = true;
        this.caloriesAccolade[0] = true;
        this.distanceAccolade[0] = true;
        this.distanceAccolade[1] = true;
        this.activeAccolade[0] = true;
        this.floorsAccolade[0] = true;
        this.floorsAccolade[1] = true;
        this.floorsAccolade[2] = true;
        this.goalsAccolade[1] = true;
    }

}
