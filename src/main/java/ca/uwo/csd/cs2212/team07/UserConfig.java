package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;
import java.util.Date;

/**
 * Stores User Configuration as it relates to personal customization options.
 *
 * @author team07
 */
public class UserConfig implements Serializable {

    private static final long serialVersionUID = 7L;

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
    private int goalsComplete;

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

        calGoal = -1;
        activeGoal = -1;
        stepsGoal = -1;
        floorsGoal = -1;
        distanceGoal = -1;
        goalsComplete = 0;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public boolean isCaloriesData() {
        return caloriesVisible;
    }

    public void setCaloriesData(boolean caloriesData) {
        this.caloriesVisible = caloriesData;
    }

    public boolean isDistanceData() {
        return distanceVisible;
    }

    public void setDistanceData(boolean distanceData) {
        this.distanceVisible = distanceData;
    }

    public boolean isFloorsData() {
        return floorsVisible;
    }

    public void setFloorsData(boolean floorsData) {
        this.floorsVisible = floorsData;
    }

    public boolean isStepsData() {
        return stepsVisible;
    }

    public void setStepsData(boolean stepsData) {
        this.stepsVisible = stepsData;
    }

    public boolean isActiveData() {
        return activeVisible;
    }

    public void setActiveData(boolean activeData) {
        this.activeVisible = activeData;
    }

    public boolean isSedentaryData() {
        return sedentaryVisible;
    }

    public void setSedentaryData(boolean sedentaryData) {
        this.sedentaryVisible = sedentaryData;
    }

    public long getCalGoal() {
        return calGoal;
    }

    public void setCalGoal(long calGoal) {
        this.calGoal = calGoal;
    }

    public long getActiveGoal() {
        return activeGoal;
    }

    public void setActiveGoal(long activeGoal) {
        this.activeGoal = activeGoal;
    }

    public long getStepsGoal() {
        return stepsGoal;
    }

    public void setStepsGoal(long stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    public long getFloorsGoal() {
        return floorsGoal;
    }

    public void setFloorsGoal(long floorsGoal) {
        this.floorsGoal = floorsGoal;
    }

    public long getDistanceGoal() {
        return distanceGoal;
    }

    public void setDistanceGoal(long distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    public boolean isFatVisible() {
        return fatVisible;
    }

    public void setFatVisible(boolean fatVisible) {
        this.fatVisible = fatVisible;
    }

    public boolean isPeakVisible() {
        return peakVisible;
    }

    public void setPeakVisible(boolean peakVisible) {
        this.peakVisible = peakVisible;
    }

    public boolean isCardioVisible() {
        return cardioVisible;
    }

    public void setCardioVisible(boolean cardioVisible) {
        this.cardioVisible = cardioVisible;
    }

    public boolean isOutVisible() {
        return outVisible;
    }

    public void setOutVisible(boolean outVisible) {
        this.outVisible = outVisible;
    }

    public int getGoalsComplete() {
        return goalsComplete;
    }

    public void setGoalsComplete(int goalsComplete) {
        this.goalsComplete = goalsComplete;
    }

    public boolean isCaloriesAccoladeBronze() {
        return caloriesAccoladeBronze;
    }

    public void setCaloriesAccoladeBronze(boolean caloriesAccoladeBronze) {
        this.caloriesAccoladeBronze = caloriesAccoladeBronze;
    }

    public boolean isCaloriesAccoladeSilver() {
        return caloriesAccoladeSilver;
    }

    public void setCaloriesAccoladeSilver(boolean caloriesAccoladeSilver) {
        this.caloriesAccoladeSilver = caloriesAccoladeSilver;
    }

    public boolean isCaloriesAccoladeGold() {
        return caloriesAccoladeGold;
    }

    public void setCaloriesAccoladeGold(boolean caloriesAccoladeGold) {
        this.caloriesAccoladeGold = caloriesAccoladeGold;
    }

    public boolean isDistanceAccoladeBronze() {
        return distanceAccoladeBronze;
    }

    public void setDistanceAccoladeBronze(boolean distanceAccoladeBronze) {
        this.distanceAccoladeBronze = distanceAccoladeBronze;
    }

    public boolean isDistanceAccoladeSilver() {
        return distanceAccoladeSilver;
    }

    public void setDistanceAccoladeSilver(boolean distanceAccoladeSilver) {
        this.distanceAccoladeSilver = distanceAccoladeSilver;
    }

    public boolean isDistanceAccoladeGold() {
        return distanceAccoladeGold;
    }

    public void setDistanceAccoladeGold(boolean distanceAccoladeGold) {
        this.distanceAccoladeGold = distanceAccoladeGold;
    }

    public boolean isActiveAccoladeBronze() {
        return activeAccoladeBronze;
    }

    public void setActiveAccoladeBronze(boolean activeAccoladeBronze) {
        this.activeAccoladeBronze = activeAccoladeBronze;
    }

    public boolean isActiveAccoladeSilver() {
        return activeAccoladeSilver;
    }

    public void setActiveAccoladeSilver(boolean activeAccoladeSilver) {
        this.activeAccoladeSilver = activeAccoladeSilver;
    }

    public boolean isActiveAccoladeGold() {
        return activeAccoladeGold;
    }

    public void setActiveAccoladeGold(boolean activeAccoladeGold) {
        this.activeAccoladeGold = activeAccoladeGold;
    }

    public boolean isStepsAccoladeBronze() {
        return stepsAccoladeBronze;
    }

    public void setStepsAccoladeBronze(boolean stepsAccoladeBronze) {
        this.stepsAccoladeBronze = stepsAccoladeBronze;
    }

    public boolean isStepsAccoladeSilver() {
        return stepsAccoladeSilver;
    }

    public void setStepsAccoladeSilver(boolean stepsAccoladeSilver) {
        this.stepsAccoladeSilver = stepsAccoladeSilver;
    }

    public boolean isStepsAccoladeGold() {
        return stepsAccoladeGold;
    }

    public void setStepsAccoladeGold(boolean stepsAccoladeGold) {
        this.stepsAccoladeGold = stepsAccoladeGold;
    }

    public boolean isFloorsAccoladeBronze() {
        return floorsAccoladeBronze;
    }

    public void setFloorsAccoladeBronze(boolean floorsAccoladeBronze) {
        this.floorsAccoladeBronze = floorsAccoladeBronze;
    }

    public boolean isFloorsAccoladeSilver() {
        return floorsAccoladeSilver;
    }

    public void setFloorsAccoladeSilver(boolean floorsAccoladeSilver) {
        this.floorsAccoladeSilver = floorsAccoladeSilver;
    }

    public boolean isFloorsAccoladeGold() {
        return floorsAccoladeGold;
    }

    public void setFloorsAccoladeGold(boolean floorsAccoladeGold) {
        this.floorsAccoladeGold = floorsAccoladeGold;
    }

    public boolean isGoalsAccoladeBronze() {
        return goalsAccoladeBronze;
    }

    public void setGoalsAccoladeBronze(boolean goalsAccoladeBronze) {
        this.goalsAccoladeBronze = goalsAccoladeBronze;
    }

    public boolean isGoalsAccoladeSilver() {
        return goalsAccoladeSilver;
    }

    public void setGoalsAccoladeSilver(boolean goalsAccoladeSilver) {
        this.goalsAccoladeSilver = goalsAccoladeSilver;
    }

    public boolean isGoalsAccoladeGold() {
        return goalsAccoladeGold;
    }

    public void setGoalsAccoladeGold(boolean goalsAccoladeGold) {
        this.goalsAccoladeGold = goalsAccoladeGold;
    }

    public boolean isAccoladesAccoladeBronze() {
        return accoladesAccoladeBronze;
    }

    public void setAccoladesAccoladeBronze(boolean accoladesAccoladeBronze) {
        this.accoladesAccoladeBronze = accoladesAccoladeBronze;
    }

    public boolean isAccoladesAccoladeSilver() {
        return accoladesAccoladeSilver;
    }

    public void setAccoladesAccoladeSilver(boolean accoladesAccoladeSilver) {
        this.accoladesAccoladeSilver = accoladesAccoladeSilver;
    }

    public boolean isAccoladesAccoladeGold() {
        return accoladesAccoladeGold;
    }

    public void setAccoladesAccoladeGold(boolean accoladesAccoladeGold) {
        this.accoladesAccoladeGold = accoladesAccoladeGold;
    }

    public String getCaloriesAccoladeBronzeDate() {
        return caloriesAccoladeBronzeDate;
    }

    public void setCaloriesAccoladeBronzeDate(String caloriesAccoladeBronzeDate) {
        this.caloriesAccoladeBronzeDate = caloriesAccoladeBronzeDate;
    }

    public String getCaloriesAccoladeSilverDate() {
        return caloriesAccoladeSilverDate;
    }

    public void setCaloriesAccoladeSilverDate(String caloriesAccoladeSilverDate) {
        this.caloriesAccoladeSilverDate = caloriesAccoladeSilverDate;
    }

    public String getCaloriesAccoladeGoldDate() {
        return caloriesAccoladeGoldDate;
    }

    public void setCaloriesAccoladeGoldDate(String caloriesAccoladeGoldDate) {
        this.caloriesAccoladeGoldDate = caloriesAccoladeGoldDate;
    }

    public String getDistanceAccoladeBronzeDate() {
        return distanceAccoladeBronzeDate;
    }

    public void setDistanceAccoladeBronzeDate(String distanceAccoladeBronzeDate) {
        this.distanceAccoladeBronzeDate = distanceAccoladeBronzeDate;
    }

    public String getDistanceAccoladeSilverDate() {
        return distanceAccoladeSilverDate;
    }

    public void setDistanceAccoladeSilverDate(String distanceAccoladeSilverDate) {
        this.distanceAccoladeSilverDate = distanceAccoladeSilverDate;
    }

    public String getDistanceAccoladeGoldDate() {
        return distanceAccoladeGoldDate;
    }

    public void setDistanceAccoladeGoldDate(String distanceAccoladeGoldDate) {
        this.distanceAccoladeGoldDate = distanceAccoladeGoldDate;
    }

    public String getActiveAccoladeBronzeDate() {
        return activeAccoladeBronzeDate;
    }

    public void setActiveAccoladeBronzeDate(String activeAccoladeBronzeDate) {
        this.activeAccoladeBronzeDate = activeAccoladeBronzeDate;
    }

    public String getActiveAccoladeSilverDate() {
        return activeAccoladeSilverDate;
    }

    public void setActiveAccoladeSilverDate(String activeAccoladeSilverDate) {
        this.activeAccoladeSilverDate = activeAccoladeSilverDate;
    }

    public String getActiveAccoladeGoldDate() {
        return activeAccoladeGoldDate;
    }

    public void setActiveAccoladeGoldDate(String activeAccoladeGoldDate) {
        this.activeAccoladeGoldDate = activeAccoladeGoldDate;
    }

    public String getStepsAccoladeBronzeDate() {
        return stepsAccoladeBronzeDate;
    }

    public void setStepsAccoladeBronzeDate(String stepsAccoladeBronzeDate) {
        this.stepsAccoladeBronzeDate = stepsAccoladeBronzeDate;
    }

    public String getStepsAccoladeSilverDate() {
        return stepsAccoladeSilverDate;
    }

    public void setStepsAccoladeSilverDate(String stepsAccoladeSilverDate) {
        this.stepsAccoladeSilverDate = stepsAccoladeSilverDate;
    }

    public String getStepsAccoladeGoldDate() {
        return stepsAccoladeGoldDate;
    }

    public void setStepsAccoladeGoldDate(String stepsAccoladeGoldDate) {
        this.stepsAccoladeGoldDate = stepsAccoladeGoldDate;
    }

    public String getFloorsAccoladeBronzeDate() {
        return floorsAccoladeBronzeDate;
    }

    public void setFloorsAccoladeBronzeDate(String floorsAccoladeBronzeDate) {
        this.floorsAccoladeBronzeDate = floorsAccoladeBronzeDate;
    }

    public String getFloorsAccoladeSilverDate() {
        return floorsAccoladeSilverDate;
    }

    public void setFloorsAccoladeSilverDate(String floorsAccoladeSilverDate) {
        this.floorsAccoladeSilverDate = floorsAccoladeSilverDate;
    }

    public String getFloorsAccoladeGoldDate() {
        return floorsAccoladeGoldDate;
    }

    public void setFloorsAccoladeGoldDate(String floorsAccoladeGoldDate) {
        this.floorsAccoladeGoldDate = floorsAccoladeGoldDate;
    }

    public String getGoalsAccoladeBronzeDate() {
        return goalsAccoladeBronzeDate;
    }

    public void setGoalsAccoladeBronzeDate(String goalsAccoladeBronzeDate) {
        this.goalsAccoladeBronzeDate = goalsAccoladeBronzeDate;
    }

    public String getGoalsAccoladeSilverDate() {
        return goalsAccoladeSilverDate;
    }

    public void setGoalsAccoladeSilverDate(String goalsAccoladeSilverDate) {
        this.goalsAccoladeSilverDate = goalsAccoladeSilverDate;
    }

    public String getGoalsAccoladeGoldDate() {
        return goalsAccoladeGoldDate;
    }

    public void setGoalsAccoladeGoldDate(String goalsAccoladeGoldDate) {
        this.goalsAccoladeGoldDate = goalsAccoladeGoldDate;
    }

    public String getAccoladesAccoladeBronzeDate() {
        return accoladesAccoladeBronzeDate;
    }

    public void setAccoladesAccoladeBronzeDate(String accoladesAccoladeBronzeDate) {
        this.accoladesAccoladeBronzeDate = accoladesAccoladeBronzeDate;
    }

    public String getAccoladesAccoladeSilverDate() {
        return accoladesAccoladeSilverDate;
    }

    public void setAccoladesAccoladeSilverDate(String accoladesAccoladeSilverDate) {
        this.accoladesAccoladeSilverDate = accoladesAccoladeSilverDate;
    }

    public String getAccoladesAccoladeGoldDate() {
        return accoladesAccoladeGoldDate;
    }

    public void setAccoladesAccoladeGoldDate(String accoladesAccoladeGoldDate) {
        this.accoladesAccoladeGoldDate = accoladesAccoladeGoldDate;
    }
    
    

}
