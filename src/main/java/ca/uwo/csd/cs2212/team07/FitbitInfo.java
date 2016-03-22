package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONException;

public class FitbitInfo implements Serializable {

    private static final long serialVersionUID = 13L;

    private boolean testMode;
    private Daily day; //holds daily data
    private BestDay[] bestDays; //holds best days data
    private Lifetime lifetime; //hold lifetime data
    private HeartData heart;
    private Calendar lastRefreshTime; //hold last refresh time

    /**
     * Constructor for the FitbitInfo class.
     */
    public FitbitInfo() {

    }

    /**
     * Refreshes user data by getting the current date and calling the API for
     * the relevant data
     *
     * @param day the day to refresh the info for
     * @throws JSONException Thrown from API calls
     * @throws RefreshTokenException Thrown if Token is out of date
     */
    public void refreshInfo(Calendar day) throws JSONException, RefreshTokenException {
        lastRefreshTime = day;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(lastRefreshTime.getTime());
        this.day = Api.getDailySummary(date);
        this.bestDays = Api.getBestDays();
        this.lifetime = Api.getLifetime();
        try {
            this.heart = Api.getHeartSummary(date);
        } catch (JSONException ex) {
            this.heart = new HeartData(date, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
            System.out.println("Note: HR Data not available yet for today");
        }

    }

    public HeartData getHeart() {
        return this.heart;
    }

    /**
     * Returns the Daily information of the user
     *
     * @return daily information of the user
     */
    public Daily getDay() {
        return this.day;
    }

    /**
     * Returns the Best Days information of the user
     *
     * @return best days information of the user
     */
    public BestDay[] getBestDays() {
        return this.bestDays;
    }

    /**
     * Returns the Lifetime information of the user
     *
     * @return lifetime information of the user
     */
    public Lifetime getLifetime() {
        return this.lifetime;
    }

    /**
     * Gets the last refresh time of the user information
     *
     * @return last refresh time of user information
     */
    public Calendar getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    /**
     * Returns true if FitbitInfo is running in test mode
     *
     * @return true if FitbitInfo is running in test mode
     */
    public boolean isTestMode() {
        return this.testMode;
    }

    /**
     * Sets the Daily information of the user
     *
     * @param day the daily information to set
     */
    public void setDay(Daily day) {
        this.day = day;
    }

    /**
     * Sets the Best Days information of the user
     *
     * @param bestDays the best days information to set
     */
    public void setBestDays(BestDay[] bestDays) {
        this.bestDays = bestDays;
    }

    /**
     * Sets the Lifetime information of the user
     *
     * @param lifetime the lifetime information to set
     */
    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
    }

    public void setHeart(HeartData heartData) {
        this.heart = heartData;
    }

    /**
     * Sets the last refresh time of the FitbitInfo
     *
     * @param lastRefreshTIme last time the user information was refreshed
     */
    public void setLastRefreshTime(Calendar lastRefreshTIme) {
        this.lastRefreshTime = lastRefreshTIme;
    }

    /**
     * Sets whether or not the program is running in Test Mode
     *
     * @param mode whether or not the program is running in test mode
     */
    public void setTestMode(boolean mode) {
        this.testMode = mode;
    }

    /**
     * Generates randomly generated user data and sets test mode to true
     */
    public void testModeData() {
        this.testMode = true; //set test mode to true

        Random rand = new Random();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Daily randDay = new Daily(date, (long) rand.nextInt(100), (long) rand.nextInt(2000),
                (double) rand.nextInt(10), (double) rand.nextInt(20), (long) rand.nextInt(10000), (long) rand.nextInt(1500),
                (long) rand.nextInt(1000), (long) rand.nextInt(3000), (double) rand.nextInt(60), (double) rand.nextInt(20),
                (long) rand.nextInt(60), (double) rand.nextInt(20), (long) rand.nextInt(60), (long) rand.nextInt(1000),
                (long) rand.nextInt(250), (long) rand.nextInt(10000), (long) rand.nextInt(60));

        BestDay randDistanceBestDay = new BestDay(date, "distance", (double) rand.nextInt(20));
        BestDay randFloorsBestDay = new BestDay(date, "floors", (double) rand.nextInt(30));
        BestDay randStepsBestDay = new BestDay(date, "steps", (double) rand.nextInt(15000));
        BestDay[] randBest = {randDistanceBestDay, randFloorsBestDay, randStepsBestDay};

        Lifetime randLifetime = new Lifetime((double) rand.nextInt(100), (double) rand.nextInt(100), (long) rand.nextInt(30000));

        this.lastRefreshTime = Calendar.getInstance();
        this.day = randDay;
        this.bestDays = randBest;
        this.lifetime = randLifetime;
        this.heart = new HeartData(date, rand.nextInt(250), rand.nextInt(250), rand.nextInt(250), rand.nextInt(250), rand.nextInt(250),
                (double) rand.nextInt(250), (double) rand.nextInt(250), (double) rand.nextInt(250), (double) rand.nextInt(250), null);
    }

}
