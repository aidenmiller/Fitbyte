
package ca.uwo.csd.cs2212.team07;


public class BestDay {
    
    public final String date;
    public final String activity;
    public final long value;
    
    public BestDay(String bestDate, String act, long bestValue) {
        
        this.date = bestDate;
        this.activity = act;
        this.value = bestValue;
    }
    
    public String toString() {
        return "Activity: " + this.activity + "\nDate: " + this.date + "\nValue: " + this.value;
    }
    
}
