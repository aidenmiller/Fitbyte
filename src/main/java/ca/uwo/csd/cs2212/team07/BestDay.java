package ca.uwo.csd.cs2212.team07;

/**
 * BestDay class, stores data pertaining to a "best day" of the user
 * @author Team07
 */
public class BestDay {

    //Instance Variables: declared as public final so they can be easily accessed, but not changed
    public final String date;
    public final String activity;
    public final double value;

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

}
