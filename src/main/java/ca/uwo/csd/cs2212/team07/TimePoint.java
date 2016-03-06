
package ca.uwo.csd.cs2212.team07;

/**
 *
 * @author Team07
**/ 
public class TimePoint {
    
    private String time;
    private double value;
    
    public TimePoint(String timeStr, double val) {
        this.time = timeStr;
        this.value = val;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public String toString() {
        return "Value: " + this.value + ", at time: " + this.time + "\n";
    }
    
    
    
    
} 
