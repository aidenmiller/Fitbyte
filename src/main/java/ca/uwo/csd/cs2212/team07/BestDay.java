package ca.uwo.csd.cs2212.team07;

public class BestDay {

    public final String date;
    public final String activity;
    public final double value;

    public BestDay(String bestDate, String act, double bestValue) {

        this.date = bestDate;
        this.activity = act;
        this.value = bestValue;
    }

    public String toString() {
        return "Activity: " + this.activity + "\nDate: " + this.date + "\nValue: " + this.value;
    }

}
