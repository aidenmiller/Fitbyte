package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;

public class FitbitInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Daily day; //holds daily data
    private BestDay[] bestDays; //holds best days data
    private Lifetime lifetime; //hold lifetime data
    private String lastRefreshTime; //hold last refresh time

    /**
     * Constructor for the FitbitInfo class.
     */
    public FitbitInfo() {

    }

    /**
     * Refreshes user data by getting the current date and calling the API for
     * the relevant data
     *
     * @param mode whether or not the user is on normal mode (0) or test mode
     * (1)
     * @throws JSONException Thrown from API calls
     * @throws RefreshTokenException Thrown if Token is out of date
     */
    public void refreshInfo(int mode) throws JSONException, RefreshTokenException {
        if (mode == 0) {
            System.out.println("REFRESH INFO - NORMAL MODE"); //for testing
            Date now = new Date();
            lastRefreshTime = new SimpleDateFormat("dd MMM yyyy hh:mm:ss aa zzz").format(now);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(now);
            this.day = Api.getDailySummary(date);
            this.bestDays = Api.getBestDays();
            this.lifetime = Api.getLifetime();

        } else {
            System.out.println("REFRESH INFO - TEST MODE"); //for testing
        }

    }

    /**
     * Gets the Daily object stored in the FitbitInfo class
     *
     * @return the Daily object stored.
     */
    public Daily getDay() {
        return this.day;
    }

    /**
     * Gets the BestDays object stored in the FitbitInfo class
     *
     * @return the BestDays object stored.
     */
    public BestDay[] getBestDays() {
        return this.bestDays;
    }

    /**
     * Gets the Lifetime object stored in the FitbitInfo class
     *
     * @return the Lifetime object stored.
     */
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

    public void setLastRefreshTime(String lastRefreshTIme) {
        this.lastRefreshTime = lastRefreshTIme;
    }

    public String getLastRefreshTime() {
        return this.lastRefreshTime;
    }

}
