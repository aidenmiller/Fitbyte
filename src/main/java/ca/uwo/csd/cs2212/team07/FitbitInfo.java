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

    private Daily day;
    private BestDay[] bestDays;
    private Lifetime lifetime;

    // private static final long serialVersionUID = 1L;
    public FitbitInfo() {

    }

    public void refreshInfo(int mode) throws JSONException, RefreshTokenException {
        if (mode == 0) {
            System.out.println("REFRESH INFO - NORMAL MODE");
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //THIS NEEDS TO BE CHANGED WHEN WE ARE ABLE TO SWITCH BETWEEN DAYS
            this.day = Api.getDailySummary(date);
            this.bestDays = Api.getBestDays();
            this.lifetime = Api.getLifetime();

        } else {
            System.out.println("REFRESH INFO - TEST MODE");
        }

    }

    public void loadInfo(int mode) throws Exception {
        if (mode == 0) {
            System.out.println("LOAD INFO");
        } else {
            System.out.println("TEST MODE");
            throw new Exception("test mode");
        }
    }

    public void storeInfo(int mode) throws Exception {
        if (mode == 0) {
            System.out.println("STORE INFO");
        } else {
            System.out.println("TEST MODE");
            throw new Exception("test mode");
        }
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

}
