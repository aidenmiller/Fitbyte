package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.JSONException;

public class FitbitInfo implements Serializable {

    private static final long serialVersionUID = 2L;

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
        System.out.println("REFRESH INFO - NORMAL MODE"); //for testing
        lastRefreshTime = day;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(lastRefreshTime.getTime());
        this.day = Api.getDailySummary(date);
        this.bestDays = Api.getBestDays();
        this.lifetime = Api.getLifetime();

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

    public void setLastRefreshTime(Calendar lastRefreshTIme) {
        this.lastRefreshTime = lastRefreshTIme;
    }

    public Calendar getLastRefreshTime() {
        return this.lastRefreshTime;
    }

}
