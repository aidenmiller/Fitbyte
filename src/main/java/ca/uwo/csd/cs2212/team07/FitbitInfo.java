package ca.uwo.csd.cs2212.team07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;

public class FitbitInfo /*implements Serializable*/ {

    private Daily day; //holds daily data
    private BestDay[] bestDays; //holds best days data
    private Lifetime lifetime; //hold lifetime data
    private Date lastRefreshTime;

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
            lastRefreshTime = new Date();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(lastRefreshTime);
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

    public String getRefreshTime() {
        return new SimpleDateFormat("dd MMM yyyy hh:mm:ss aa zzz").format(lastRefreshTime);
    }

}
