package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * Stores User Configuration as it relates to personal customization options.
 *
 * @author team07
 */
public class UserConfig implements Serializable {

    private static final long serialVersionUID = 11L;

    private boolean testMode;

    private boolean caloriesVisible;
    private boolean distanceVisible;
    private boolean floorsVisible;
    private boolean stepsVisible;
    private boolean activeVisible;
    private boolean sedentaryVisible;

    private boolean fatVisible, peakVisible, cardioVisible, outVisible;

    private boolean caloriesAccoladeBronze;
    private boolean caloriesAccoladeSilver;
    private boolean caloriesAccoladeGold;
    private boolean distanceAccoladeBronze;
    private boolean distanceAccoladeSilver;
    private boolean distanceAccoladeGold;
    private boolean activeAccoladeBronze;
    private boolean activeAccoladeSilver;
    private boolean activeAccoladeGold;
    private boolean stepsAccoladeBronze;
    private boolean stepsAccoladeSilver;
    private boolean stepsAccoladeGold;
    private boolean floorsAccoladeBronze;
    private boolean floorsAccoladeSilver;
    private boolean floorsAccoladeGold;
    private boolean goalsAccoladeBronze;
    private boolean goalsAccoladeSilver;
    private boolean goalsAccoladeGold;
    private boolean accoladesAccoladeBronze;
    private boolean accoladesAccoladeSilver;
    private boolean accoladesAccoladeGold;

    private String caloriesAccoladeBronzeDate;
    private String caloriesAccoladeSilverDate;
    private String caloriesAccoladeGoldDate;
    private String distanceAccoladeBronzeDate;
    private String distanceAccoladeSilverDate;
    private String distanceAccoladeGoldDate;
    private String activeAccoladeBronzeDate;
    private String activeAccoladeSilverDate;
    private String activeAccoladeGoldDate;
    private String stepsAccoladeBronzeDate;
    private String stepsAccoladeSilverDate;
    private String stepsAccoladeGoldDate;
    private String floorsAccoladeBronzeDate;
    private String floorsAccoladeSilverDate;
    private String floorsAccoladeGoldDate;
    private String goalsAccoladeBronzeDate;
    private String goalsAccoladeSilverDate;
    private String goalsAccoladeGoldDate;
    private String accoladesAccoladeBronzeDate;
    private String accoladesAccoladeSilverDate;
    private String accoladesAccoladeGoldDate;

    private long calGoal, activeGoal, stepsGoal, floorsGoal, distanceGoal;
    private int goalsComplete, accoladesComplete;

    /**
     * Generates a new UserConfig with default settings
     */
    public UserConfig() {
        caloriesVisible = true;
        distanceVisible = true;
        floorsVisible = true;
        stepsVisible = true;
        activeVisible = true;
        sedentaryVisible = true;
        fatVisible = true;
        peakVisible = true;
        cardioVisible = true;
        outVisible = true;

        caloriesAccoladeBronze = false;
        caloriesAccoladeSilver = false;
        caloriesAccoladeGold = false;
        distanceAccoladeBronze = false;
        distanceAccoladeSilver = false;
        distanceAccoladeGold = false;
        activeAccoladeBronze = false;
        activeAccoladeSilver = false;
        activeAccoladeGold = false;
        stepsAccoladeBronze = false;
        stepsAccoladeSilver = false;
        stepsAccoladeGold = false;
        floorsAccoladeBronze = false;
        floorsAccoladeSilver = false;
        floorsAccoladeGold = false;
        goalsAccoladeBronze = false;
        goalsAccoladeSilver = false;
        goalsAccoladeGold = false;
        accoladesAccoladeBronze = false;
        accoladesAccoladeSilver = false;
        accoladesAccoladeGold = false;

        caloriesAccoladeBronzeDate = "Not yet achieved.";
        caloriesAccoladeSilverDate = "Not yet achieved.";
        caloriesAccoladeGoldDate = "Not yet achieved.";
        distanceAccoladeBronzeDate = "Not yet achieved.";
        distanceAccoladeSilverDate = "Not yet achieved.";
        distanceAccoladeGoldDate = "Not yet achieved.";
        activeAccoladeBronzeDate = "Not yet achieved.";
        activeAccoladeSilverDate = "Not yet achieved.";
        activeAccoladeGoldDate = "Not yet achieved.";
        stepsAccoladeBronzeDate = "Not yet achieved.";
        stepsAccoladeSilverDate = "Not yet achieved.";
        stepsAccoladeGoldDate = "Not yet achieved.";
        floorsAccoladeBronzeDate = "Not yet achieved.";
        floorsAccoladeSilverDate = "Not yet achieved.";
        floorsAccoladeGoldDate = "Not yet achieved.";
        goalsAccoladeBronzeDate = "Not yet achieved.";
        goalsAccoladeSilverDate = "Not yet achieved.";
        goalsAccoladeGoldDate = "Not yet achieved.";
        accoladesAccoladeBronzeDate = "Not yet achieved.";
        accoladesAccoladeSilverDate = "Not yet achieved.";
        accoladesAccoladeGoldDate = "Not yet achieved.";

        calGoal = -1;
        activeGoal = -1;
        stepsGoal = -1;
        floorsGoal = -1;
        distanceGoal = -1;
        goalsComplete = 0;
    }

    /**
     * Returns whether or not the user is in test mode
     *
     * @return true if user is in test mode
     */
    public boolean isTestMode() {
        return testMode;
    }

    /**
     * Sets the mode that the program is running in
     *
     * @param testMode true if test mode is on, false otherwise
     */
    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    /**
     * Test if calories is visible
     *
     * @return true if calories is visible
     */
    public boolean isCaloriesData() {
        return caloriesVisible;
    }

    /**
     * Set whether or not calories is visible
     *
     * @param caloriesData true if calories is visible, false otherwise
     */
    public void setCaloriesData(boolean caloriesData) {
        this.caloriesVisible = caloriesData;
    }

    /**
     * Test if total distance is visible
     *
     * @return true if total distance is visible
     */
    public boolean isDistanceData() {
        return distanceVisible;
    }

    /**
     * Set whether or not total distance is visible
     *
     * @param distanceData true if total distance is visible, false otherwise
     */
    public void setDistanceData(boolean distanceData) {
        this.distanceVisible = distanceData;
    }

    /**
     * Test if floors is visible
     *
     * @return true if floors is visible
     */
    public boolean isFloorsData() {
        return floorsVisible;
    }

    /**
     * Set whether or not floors is visible
     *
     * @param floorsData true if floors is visible, false otherwise
     */
    public void setFloorsData(boolean floorsData) {
        this.floorsVisible = floorsData;
    }

    /**
     * Test if steps is visible
     *
     * @return true if steps is visible
     */
    public boolean isStepsData() {
        return stepsVisible;
    }

    /**
     * Set whether or not steps is visible
     *
     * @param stepsData true if steps is visible, false otherwise
     */
    public void setStepsData(boolean stepsData) {
        this.stepsVisible = stepsData;
    }

    /**
     * Test if active minutes is visible
     *
     * @return true if active minutes is visible
     */
    public boolean isActiveData() {
        return activeVisible;
    }

    /**
     * Set whether or not active minutes is visible
     *
     * @param activeData true if active minutes is visible, false otherwise
     */
    public void setActiveData(boolean activeData) {
        this.activeVisible = activeData;
    }

    /**
     * Test if sedentary minutes is visible
     *
     * @return true if sedentary minutes is visible
     */
    public boolean isSedentaryData() {
        return sedentaryVisible;
    }

    /**
     * Set whether or not sedentary minutes is visible
     *
     * @param sedentaryData true if sedentary minutes is visible, false
     * otherwise
     */
    public void setSedentaryData(boolean sedentaryData) {
        this.sedentaryVisible = sedentaryData;
    }

    /**
     * Gets the custom calories goal
     *
     * @return custom calories goal, or -1 if none exists
     */
    public long getCalGoal() {
        return calGoal;
    }

    /**
     * Sets the custom calories goal
     *
     * @param calGoal goal to set
     */
    public void setCalGoal(long calGoal) {
        this.calGoal = calGoal;
    }

    /**
     * Gets the custom active minutes goal
     *
     * @return custom active minutes goal, or -1 if none exists
     */
    public long getActiveGoal() {
        return activeGoal;
    }

    /**
     * Sets the custom active minutes goal
     *
     * @param activeGoal goal to set
     */
    public void setActiveGoal(long activeGoal) {
        this.activeGoal = activeGoal;
    }

    /**
     * Gets the custom steps goal
     *
     * @return custom steps goal, or -1 if none exists
     */
    public long getStepsGoal() {
        return stepsGoal;
    }

    /**
     * Sets the custom steps goal
     *
     * @param stepsGoal goal to set
     */
    public void setStepsGoal(long stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    /**
     * Gets the custom floors goal
     *
     * @return custom floors goal, or -1 if none exists
     */
    public long getFloorsGoal() {
        return floorsGoal;
    }

    /**
     * Sets the custom floors goal
     *
     * @param floorsGoal goal to set
     */
    public void setFloorsGoal(long floorsGoal) {
        this.floorsGoal = floorsGoal;
    }

    /**
     * Gets the custom total distance goal
     *
     * @return custom total distance goal, or -1 if none exists
     */
    public long getDistanceGoal() {
        return distanceGoal;
    }

    /**
     * Sets the custom total distance goal
     *
     * @param distanceGoal goal to set
     */
    public void setDistanceGoal(long distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    /**
     * Test if fat zone is visible
     *
     * @return true if fat zone is visible
     */
    public boolean isFatVisible() {
        return fatVisible;
    }

    /**
     * Set whether or not fat zone is visible
     *
     * @param fatVisible true if fat zone is visible, false otherwise
     */
    public void setFatVisible(boolean fatVisible) {
        this.fatVisible = fatVisible;
    }

    /**
     * Test if peak zone is visible
     *
     * @return true if peak zone is visible
     */
    public boolean isPeakVisible() {
        return peakVisible;
    }

    /**
     * Set whether or not peak zone is visible
     *
     * @param peakVisible true if peak zone is visible, false otherwise
     */
    public void setPeakVisible(boolean peakVisible) {
        this.peakVisible = peakVisible;
    }

    /**
     * Test if cardio zone is visible
     *
     * @return true if total distance is visible
     */
    public boolean isCardioVisible() {
        return cardioVisible;
    }

    /**
     * Set whether or not cardio zone is visible
     *
     * @param cardioVisible true if cardio zone is visible, false otherwise
     */
    public void setCardioVisible(boolean cardioVisible) {
        this.cardioVisible = cardioVisible;
    }

    /**
     * Test if out of range zone is visible
     *
     * @return true if total distance is visible
     */
    public boolean isOutVisible() {
        return outVisible;
    }

    /**
     * Set whether or not out of range zone is visible
     *
     * @param outVisible true if out of range zone is visible, false otherwise
     */
    public void setOutVisible(boolean outVisible) {
        this.outVisible = outVisible;
    }

    /**
     * Returns amount of completed daily goals stored
     *
     * @return number of completed daily goals in a day
     */
    public int getGoalsComplete() {
        return goalsComplete;
    }

    /**
     * Sets the amount of goals completed today
     *
     * @param goalsComplete number of completed goals
     */
    public void setGoalsComplete(int goalsComplete) {
        this.goalsComplete = goalsComplete;
    }

    /**
     * Returns true if calories bronze has been earned
     *
     * @return true if calories bronze earned, false otherwise
     */
    public boolean isCaloriesAccoladeBronze() {
        return caloriesAccoladeBronze;
    }

    public void setCaloriesAccoladeBronze(boolean caloriesAccoladeBronze) {
        this.caloriesAccoladeBronze = caloriesAccoladeBronze;
    }

    /**
     * Returns true if calories silver has been earned
     *
     * @return true if calories silver earned, false otherwise
     */
    public boolean isCaloriesAccoladeSilver() {
        return caloriesAccoladeSilver;
    }

    public void setCaloriesAccoladeSilver(boolean caloriesAccoladeSilver) {
        this.caloriesAccoladeSilver = caloriesAccoladeSilver;
    }

    /**
     * Returns true if calories gold has been earned
     *
     * @return true if calories gold earned, false otherwise
     */
    public boolean isCaloriesAccoladeGold() {
        return caloriesAccoladeGold;
    }

    public void setCaloriesAccoladeGold(boolean caloriesAccoladeGold) {
        this.caloriesAccoladeGold = caloriesAccoladeGold;
    }

    /**
     * Returns true if distance bronze has been earned
     *
     * @return true if distance bronze earned, false otherwise
     */
    public boolean isDistanceAccoladeBronze() {
        return distanceAccoladeBronze;
    }

    public void setDistanceAccoladeBronze(boolean distanceAccoladeBronze) {
        this.distanceAccoladeBronze = distanceAccoladeBronze;
    }

    /**
     * Returns true if distance silver has been earned
     *
     * @return true if distance silver earned, false otherwise
     */
    public boolean isDistanceAccoladeSilver() {
        return distanceAccoladeSilver;
    }

    public void setDistanceAccoladeSilver(boolean distanceAccoladeSilver) {
        this.distanceAccoladeSilver = distanceAccoladeSilver;
    }

    /**
     * Returns true if distance gold has been earned
     *
     * @return true if distance gold earned, false otherwise
     */
    public boolean isDistanceAccoladeGold() {
        return distanceAccoladeGold;
    }

    public void setDistanceAccoladeGold(boolean distanceAccoladeGold) {
        this.distanceAccoladeGold = distanceAccoladeGold;
    }

    /**
     * Returns true if active minutes bronze has been earned
     *
     * @return true if active minutes bronze earned, false otherwise
     */
    public boolean isActiveAccoladeBronze() {
        return activeAccoladeBronze;
    }

    /**
     * Set whether or not active minutes bronze has been earned
     *
     * @param activeAccoladeBronze true if earned, false otherwise
     */
    public void setActiveAccoladeBronze(boolean activeAccoladeBronze) {
        this.activeAccoladeBronze = activeAccoladeBronze;
    }

    /**
     * Returns true if active minutes silver has been earned
     *
     * @return true if active minutes silver earned, false otherwise
     */
    public boolean isActiveAccoladeSilver() {
        return activeAccoladeSilver;
    }

    /**
     * Set whether or not active minutes silver has been earned
     *
     * @param activeAccoladeSilver true if earned, false otherwise
     */
    public void setActiveAccoladeSilver(boolean activeAccoladeSilver) {
        this.activeAccoladeSilver = activeAccoladeSilver;
    }

    /**
     * Returns true if active minutes gold has been earned
     *
     * @return true if active minutes gold earned, false otherwise
     */
    public boolean isActiveAccoladeGold() {
        return activeAccoladeGold;
    }

    /**
     * Set whether or not active minutes gold has been earned
     *
     * @param activeAccoladeGold true if earned, false otherwise
     */
    public void setActiveAccoladeGold(boolean activeAccoladeGold) {
        this.activeAccoladeGold = activeAccoladeGold;
    }

    /**
     * Returns true if steps bronze has been earned
     *
     * @return true if steps bronze earned, false otherwise
     */
    public boolean isStepsAccoladeBronze() {
        return stepsAccoladeBronze;
    }

    /**
     * Set whether or not steps bronze has been earned
     *
     * @param stepsAccoladeBronze true if earned, false otherwise
     */
    public void setStepsAccoladeBronze(boolean stepsAccoladeBronze) {
        this.stepsAccoladeBronze = stepsAccoladeBronze;
    }

    /**
     * Returns true if steps silver has been earned
     *
     * @return true if steps silver earned, false otherwise
     */
    public boolean isStepsAccoladeSilver() {
        return stepsAccoladeSilver;
    }

    /**
     * Set whether or not steps silver has been earned
     *
     * @param stepsAccoladeSilver true if earned, false otherwise
     */
    public void setStepsAccoladeSilver(boolean stepsAccoladeSilver) {
        this.stepsAccoladeSilver = stepsAccoladeSilver;
    }

    /**
     * Returns true if steps gold has been earned
     *
     * @return true if steps gold earned, false otherwise
     */
    public boolean isStepsAccoladeGold() {
        return stepsAccoladeGold;
    }

    /**
     * Set whether or not steps gold has been earned
     *
     * @param stepsAccoladeGold true if earned, false otherwise
     */
    public void setStepsAccoladeGold(boolean stepsAccoladeGold) {
        this.stepsAccoladeGold = stepsAccoladeGold;
    }

    /**
     * Returns true if floors bronze has been earned
     *
     * @return true if floors bronze earned, false otherwise
     */
    public boolean isFloorsAccoladeBronze() {
        return floorsAccoladeBronze;
    }

    /**
     * Set whether or not floors bronze has been earned
     *
     * @param floorsAccoladeBronze true if earned, false otherwise
     */
    public void setFloorsAccoladeBronze(boolean floorsAccoladeBronze) {
        this.floorsAccoladeBronze = floorsAccoladeBronze;
    }

    /**
     * Returns true if floors silver has been earned
     *
     * @return true if floors silver earned, false otherwise
     */
    public boolean isFloorsAccoladeSilver() {
        return floorsAccoladeSilver;
    }

    /**
     * Set whether or not floors silver has been earned
     *
     * @param floorsAccoladeSilver true if earned, false otherwise
     */
    public void setFloorsAccoladeSilver(boolean floorsAccoladeSilver) {
        this.floorsAccoladeSilver = floorsAccoladeSilver;
    }

    /**
     * Returns true if floors gold has been earned
     *
     * @return true if floors gold earned, false otherwise
     */
    public boolean isFloorsAccoladeGold() {
        return floorsAccoladeGold;
    }

    /**
     * Set whether or not floors gold has been earned
     *
     * @param floorsAccoladeGold true if earned, false otherwise
     */
    public void setFloorsAccoladeGold(boolean floorsAccoladeGold) {
        this.floorsAccoladeGold = floorsAccoladeGold;
    }

    /**
     * Returns true if daily goals bronze has been earned
     *
     * @return true if daily goals bronze earned, false otherwise
     */
    public boolean isGoalsAccoladeBronze() {
        return goalsAccoladeBronze;
    }

    /**
     * Set whether or not goals complete bronze has been earned
     *
     * @param goalsAccoladeBronze true if earned, false otherwise
     */
    public void setGoalsAccoladeBronze(boolean goalsAccoladeBronze) {
        this.goalsAccoladeBronze = goalsAccoladeBronze;
    }

    /**
     * Returns true if daily goals silver has been earned
     *
     * @return true if daily goals silver earned, false otherwise
     */
    public boolean isGoalsAccoladeSilver() {
        return goalsAccoladeSilver;
    }

    /**
     * Set whether or not goals complete silver has been earned
     *
     * @param goalsAccoladeSilver true if earned, false otherwise
     */
    public void setGoalsAccoladeSilver(boolean goalsAccoladeSilver) {
        this.goalsAccoladeSilver = goalsAccoladeSilver;
    }

    /**
     * Returns true if daily goals gold has been earned
     *
     * @return true if daily goals gold earned, false otherwise
     */
    public boolean isGoalsAccoladeGold() {
        return goalsAccoladeGold;
    }

    /**
     * Set whether or not goals complete gold has been earned
     *
     * @param goalsAccoladeGold true if earned, false otherwise
     */
    public void setGoalsAccoladeGold(boolean goalsAccoladeGold) {
        this.goalsAccoladeGold = goalsAccoladeGold;
    }

    /**
     * Returns true if accolades completed bronze has been earned
     *
     * @return true if accolades completed bronze earned, false otherwise
     */
    public boolean isAccoladesAccoladeBronze() {
        return accoladesAccoladeBronze;
    }

    /**
     * Set whether or not accolades complete bronze has been earned
     *
     * @param accoladesAccoladeBronze true if earned, false otherwise
     */
    public void setAccoladesAccoladeBronze(boolean accoladesAccoladeBronze) {
        this.accoladesAccoladeBronze = accoladesAccoladeBronze;
    }

    /**
     * Returns true if accolades completed silver has been earned
     *
     * @return true if accolades completed silver earned, false otherwise
     */
    public boolean isAccoladesAccoladeSilver() {
        return accoladesAccoladeSilver;
    }

    /**
     * Set whether or not accolades complete silver has been earned
     *
     * @param accoladesAccoladeSilver true if earned, false otherwise
     */
    public void setAccoladesAccoladeSilver(boolean accoladesAccoladeSilver) {
        this.accoladesAccoladeSilver = accoladesAccoladeSilver;
    }

    /**
     * Returns true if accolades completed gold has been earned
     *
     * @return true if accolades completed gold earned, false otherwise
     */
    public boolean isAccoladesAccoladeGold() {
        return accoladesAccoladeGold;
    }

    /**
     * Set whether or not accolades complete gold has been earned
     *
     * @param accoladesAccoladeGold true if earned, false otherwise
     */
    public void setAccoladesAccoladeGold(boolean accoladesAccoladeGold) {
        this.accoladesAccoladeGold = accoladesAccoladeGold;
    }

    /**
     * Returns the String date that calories bronze was achieved
     *
     * @return the String data that calories bronze was achieved
     */
    public String getCaloriesAccoladeBronzeDate() {
        return caloriesAccoladeBronzeDate;
    }

    /**
     * Sets the String date that calories bronze was earned
     *
     * @param caloriesAccoladeBronzeDate the date earned in type String
     */
    public void setCaloriesAccoladeBronzeDate(String caloriesAccoladeBronzeDate) {
        this.caloriesAccoladeBronzeDate = caloriesAccoladeBronzeDate;
    }

    /**
     * Returns the String date that calories silver was achieved
     *
     * @return the String data that calories silver was achieved
     */
    public String getCaloriesAccoladeSilverDate() {
        return caloriesAccoladeSilverDate;
    }

    /**
     * Sets the String date that calories silver was earned
     *
     * @param caloriesAccoladeSilverDate the date earned in type String
     */
    public void setCaloriesAccoladeSilverDate(String caloriesAccoladeSilverDate) {
        this.caloriesAccoladeSilverDate = caloriesAccoladeSilverDate;
    }

    /**
     * Returns the String date that calories gold was achieved
     *
     * @return the String data that calories gold was achieved
     */
    public String getCaloriesAccoladeGoldDate() {
        return caloriesAccoladeGoldDate;
    }

    /**
     * Sets the String date that calories gold was earned
     *
     * @param caloriesAccoladeGoldDate the date earned in type String
     */
    public void setCaloriesAccoladeGoldDate(String caloriesAccoladeGoldDate) {
        this.caloriesAccoladeGoldDate = caloriesAccoladeGoldDate;
    }

    /**
     * Returns the String date that total distance bronze was achieved
     *
     * @return the String data that total distance bronze was achieved
     */
    public String getDistanceAccoladeBronzeDate() {
        return distanceAccoladeBronzeDate;
    }

    /**
     * Sets the String date that total distance bronze was earned
     *
     * @param distanceAccoladeBronzeDate the date earned in type String
     */
    public void setDistanceAccoladeBronzeDate(String distanceAccoladeBronzeDate) {
        this.distanceAccoladeBronzeDate = distanceAccoladeBronzeDate;
    }

    /**
     * Returns the String date that total distance silver was achieved
     *
     * @return the String data that total distance silver was achieved
     */
    public String getDistanceAccoladeSilverDate() {
        return distanceAccoladeSilverDate;
    }

    /**
     * Sets the String date that total distance silver was earned
     *
     * @param distanceAccoladeSilverDate the date earned in type String
     */
    public void setDistanceAccoladeSilverDate(String distanceAccoladeSilverDate) {
        this.distanceAccoladeSilverDate = distanceAccoladeSilverDate;
    }

    /**
     * Returns the String date that total distance gold was achieved
     *
     * @return the String data that total distance gold was achieved
     */
    public String getDistanceAccoladeGoldDate() {
        return distanceAccoladeGoldDate;
    }

    /**
     * Sets the String date that total distance gold was earned
     *
     * @param distanceAccoladeGoldDate the date earned in type String
     */
    public void setDistanceAccoladeGoldDate(String distanceAccoladeGoldDate) {
        this.distanceAccoladeGoldDate = distanceAccoladeGoldDate;
    }

    /**
     * Returns the String date that active minutes bronze was achieved
     *
     * @return the String data that active minutes bronze was achieved
     */
    public String getActiveAccoladeBronzeDate() {
        return activeAccoladeBronzeDate;
    }

    /**
     * Sets the String date that active minutes bronze was earned
     *
     * @param activeAccoladeBronzeDate the date earned in type String
     */
    public void setActiveAccoladeBronzeDate(String activeAccoladeBronzeDate) {
        this.activeAccoladeBronzeDate = activeAccoladeBronzeDate;
    }

    /**
     * Returns the String date that active minutes silver was achieved
     *
     * @return the String data that active minutes silver was achieved
     */
    public String getActiveAccoladeSilverDate() {
        return activeAccoladeSilverDate;
    }

    /**
     * Sets the String date that active minutes silver was earned
     *
     * @param activeAccoladeSilverDate the date earned in type String
     */
    public void setActiveAccoladeSilverDate(String activeAccoladeSilverDate) {
        this.activeAccoladeSilverDate = activeAccoladeSilverDate;
    }

    /**
     * Returns the String date that active minutes gold was achieved
     *
     * @return the String data that active minutes gold was achieved
     */
    public String getActiveAccoladeGoldDate() {
        return activeAccoladeGoldDate;
    }

    /**
     * Sets the String date that active minutes gold was earned
     *
     * @param activeAccoladeGoldDate the date earned in type String
     */
    public void setActiveAccoladeGoldDate(String activeAccoladeGoldDate) {
        this.activeAccoladeGoldDate = activeAccoladeGoldDate;
    }

    /**
     * Returns the String date that steps bronze was achieved
     *
     * @return the String data that steps bronze was achieved
     */
    public String getStepsAccoladeBronzeDate() {
        return stepsAccoladeBronzeDate;
    }

    /**
     * Sets the String date that steps bronze was earned
     *
     * @param stepsAccoladeBronzeDate the date earned in type String
     */
    public void setStepsAccoladeBronzeDate(String stepsAccoladeBronzeDate) {
        this.stepsAccoladeBronzeDate = stepsAccoladeBronzeDate;
    }

    /**
     * Returns the String date that steps silver was achieved
     *
     * @return the String data that steps silver was achieved
     */
    public String getStepsAccoladeSilverDate() {
        return stepsAccoladeSilverDate;
    }

    /**
     * Sets the String date that steps silver was earned
     *
     * @param stepsAccoladeSilverDate the date earned in type String
     */
    public void setStepsAccoladeSilverDate(String stepsAccoladeSilverDate) {
        this.stepsAccoladeSilverDate = stepsAccoladeSilverDate;
    }

    /**
     * Returns the String date that steps gold was achieved
     *
     * @return the String data that steps gold was achieved
     */
    public String getStepsAccoladeGoldDate() {
        return stepsAccoladeGoldDate;
    }

    /**
     * Sets the String date that steps gold was earned
     *
     * @param stepsAccoladeGoldDate the date earned in type String
     */
    public void setStepsAccoladeGoldDate(String stepsAccoladeGoldDate) {
        this.stepsAccoladeGoldDate = stepsAccoladeGoldDate;
    }

    /**
     * Returns the String date that floors bronze was achieved
     *
     * @return the String data that floors bronze was achieved
     */
    public String getFloorsAccoladeBronzeDate() {
        return floorsAccoladeBronzeDate;
    }

    /**
     * Sets the String date that floors bronze was earned
     *
     * @param floorsAccoladeBronzeDate the date earned in type String
     */
    public void setFloorsAccoladeBronzeDate(String floorsAccoladeBronzeDate) {
        this.floorsAccoladeBronzeDate = floorsAccoladeBronzeDate;
    }

    /**
     * Returns the String date that floors silver was achieved
     *
     * @return the String data that floors silver was achieved
     */
    public String getFloorsAccoladeSilverDate() {
        return floorsAccoladeSilverDate;
    }

    /**
     * Sets the String date that floors silver was earned
     *
     * @param floorsAccoladeSilverDate the date earned in type String
     */
    public void setFloorsAccoladeSilverDate(String floorsAccoladeSilverDate) {
        this.floorsAccoladeSilverDate = floorsAccoladeSilverDate;
    }

    /**
     * Returns the String date that floors gold was achieved
     *
     * @return the String data that floors gold was achieved
     */
    public String getFloorsAccoladeGoldDate() {
        return floorsAccoladeGoldDate;
    }

    /**
     * Sets the String date that floors gold was earned
     *
     * @param floorsAccoladeGoldDate the date earned in type String
     */
    public void setFloorsAccoladeGoldDate(String floorsAccoladeGoldDate) {
        this.floorsAccoladeGoldDate = floorsAccoladeGoldDate;
    }

    /**
     * Returns the String date that goals completed bronze was achieved
     *
     * @return the String data that goals completed bronze was achieved
     */
    public String getGoalsAccoladeBronzeDate() {
        return goalsAccoladeBronzeDate;
    }

    /**
     * Sets the String date that daily goals completed bronze was earned
     *
     * @param goalsAccoladeBronzeDate the date earned in type String
     */
    public void setGoalsAccoladeBronzeDate(String goalsAccoladeBronzeDate) {
        this.goalsAccoladeBronzeDate = goalsAccoladeBronzeDate;
    }

    /**
     * Returns the String date that goals completed silver was achieved
     *
     * @return the String data that goals completed silver was achieved
     */
    public String getGoalsAccoladeSilverDate() {
        return goalsAccoladeSilverDate;
    }

    /**
     * Sets the String date that daily goals completed silver was earned
     *
     * @param goalsAccoladeSilverDate the date earned in type String
     */
    public void setGoalsAccoladeSilverDate(String goalsAccoladeSilverDate) {
        this.goalsAccoladeSilverDate = goalsAccoladeSilverDate;
    }

    /**
     * Returns the String date that goals completed gold was achieved
     *
     * @return the String data that goals completed gold was achieved
     */
    public String getGoalsAccoladeGoldDate() {
        return goalsAccoladeGoldDate;
    }

    /**
     * Sets the String date that daily goals completed gold was earned
     *
     * @param goalsAccoladeGoldDate the date earned in type String
     */
    public void setGoalsAccoladeGoldDate(String goalsAccoladeGoldDate) {
        this.goalsAccoladeGoldDate = goalsAccoladeGoldDate;
    }

    /**
     * Returns the String date that accolades completed bronze was achieved
     *
     * @return the String data that accolades completed bronze was achieved
     */
    public String getAccoladesAccoladeBronzeDate() {
        return accoladesAccoladeBronzeDate;
    }

    /**
     * Sets the String date that accolades completed bronze was earned
     *
     * @param accoladesAccoladeBronzeDate the date earned in type String
     */
    public void setAccoladesAccoladeBronzeDate(String accoladesAccoladeBronzeDate) {
        this.accoladesAccoladeBronzeDate = accoladesAccoladeBronzeDate;
    }

    /**
     * Returns the String date that accolades completed silver was achieved
     *
     * @return the String data that accolades completed silver was achieved
     */
    public String getAccoladesAccoladeSilverDate() {
        return accoladesAccoladeSilverDate;
    }

    /**
     * Sets the String date that accolades completed silver was earned
     *
     * @param accoladesAccoladeSilverDate the date earned in type String
     */
    public void setAccoladesAccoladeSilverDate(String accoladesAccoladeSilverDate) {
        this.accoladesAccoladeSilverDate = accoladesAccoladeSilverDate;
    }

    /**
     * Returns the String date that accolades completed gold was achieved
     *
     * @return the String data that accolades completed gold was achieved
     */
    public String getAccoladesAccoladeGoldDate() {
        return accoladesAccoladeGoldDate;
    }

    /**
     * Sets the String date that accolades completed gold was earned
     *
     * @param accoladesAccoladeGoldDate the date earned in type String
     */
    public void setAccoladesAccoladeGoldDate(String accoladesAccoladeGoldDate) {
        this.accoladesAccoladeGoldDate = accoladesAccoladeGoldDate;
    }

    /**
     * Returns the number of completed accolades
     *
     * @return the number of completed accolades
     */
    public int getAccoladesComplete() {
        return accoladesComplete;
    }

    /**
     * Sets the number of accolades completed
     *
     * @param accoladesComplete the number of accolades complete
     */
    public void setAccoladesComplete(int accoladesComplete) {
        this.accoladesComplete = accoladesComplete;
    }

    /**
     * Increments the number of accolades completed
     */
    public void incAccoladesComplete() {
        this.accoladesComplete = accoladesComplete += 1;
    }

}
