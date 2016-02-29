package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * BestDay class, stores data pertaining to a "best day" of the user
 * @author Team07
 */
public class BestDay implements Serializable {

    //Instance Variables: declared as public final so they can be easily accessed, but not changed
    private String date;
    private String activity;
    private double value;

    /**
     * Constructor Method: creates a new BestDay object
     * @param bestDate string of date
     * @param act String of the activity
     * @param bestValue double value. The value that the user achieved in the specified activity on this day
     */
    public BestDay(String bestDate, String act, double bestValue) {
        this.date = bestDate;
        this.activity = act;
        this.value = bestValue;
    }

    /**
     * toString() method, used for testing purposes
     * @return String containing activity name, date and value
     */
    public String toString() {
        return "Activity: " + this.activity + "\nDate: " + this.date + "\nValue: " + this.value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    
}
