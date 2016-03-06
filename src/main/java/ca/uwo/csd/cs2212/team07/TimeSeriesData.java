
package ca.uwo.csd.cs2212.team07;

import java.util.ArrayList;

/**
 *
 * @author Team07
 */
public class TimeSeriesData {
    
    private ArrayList<TimePoint> data;
    private String date;
    private int resolution;
    private String activity;

    public TimeSeriesData(ArrayList<TimePoint> data, String date, int resolution, String activity) {
        this.data = data;
        this.date = date;
        this.resolution = resolution;
        this.activity = activity;
    }
    
    
    
    
    
}
