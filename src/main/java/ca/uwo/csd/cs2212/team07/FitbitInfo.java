package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONException;

public class FitbitInfo implements Serializable {

    private static final long serialVersionUID = 3L;

    private Daily day; //holds daily data
    private BestDay[] bestDays; //holds best days data
    private Lifetime lifetime; //hold lifetime data
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

    }

    public Daily getDay() {
        return this.day;
    }

    public BestDay[] getBestDays() {
        return this.bestDays;
    }

    public Lifetime getLifetime() {
        return this.lifetime;
    }

    public void setDay(Daily day) {
        this.day = day;
    }

    public void setBestDays(BestDay[] bestDays) {
        this.bestDays = bestDays;
    }

    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
    }

    public void setLastRefreshTime(Calendar lastRefreshTIme) {
        this.lastRefreshTime = lastRefreshTIme;
    }

    public Calendar getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    public void generateTestData() {
       Random rand = new Random();
       
       Daily randDay = new Daily("yyyy-MM-dd",rand.nextLong(),rand.nextLong(),rand.nextDouble(),
               rand.nextDouble(),rand.nextLong(),rand.nextLong(),rand.nextLong(),rand.nextLong(),
               rand.nextDouble(),rand.nextDouble(),rand.nextLong(),rand.nextDouble(),rand.nextLong(),
                rand.nextLong(),rand.nextLong(),rand.nextLong(),rand.nextLong());
       
       BestDay randDistanceBestDay = new BestDay("yyyy-MM-dd", "distance", rand.nextDouble());
       BestDay randFloorsBestDay = new BestDay("yyyy-MM-dd", "floors", rand.nextDouble());
       BestDay randStepsBestDay = new BestDay("yyyy-MM-dd", "steps", rand.nextDouble());
       BestDay[] randBest = {randDistanceBestDay, randFloorsBestDay, randStepsBestDay};
       
       Lifetime randLifetime = new Lifetime(rand.nextDouble(), rand.nextDouble(), rand.nextLong());
       
       this.lastRefreshTime = Calendar.getInstance();
       this.day = randDay;
       this.bestDays = randBest;
       this.lifetime = randLifetime;
    }

}
