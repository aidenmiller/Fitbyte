package ca.uwo.csd.cs2212.team07;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.Time;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.general.SeriesException; 
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries; 
import org.jfree.data.time.TimeSeriesCollection; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class TimeGraph extends ApplicationFrame 
{
   public TimeGraph( final String title, final String yAxisTitle, TimeSeriesData timeData )
   {
      super( title );         
      final XYDataset dataset = createDataset(timeData);         
      final JFreeChart chart = createChart( dataset, title, yAxisTitle );         
      final ChartPanel chartPanel = new ChartPanel( chart );         
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );
       
      chartPanel.setMouseZoomable( true , false );    
      chartPanel.setRangeZoomable(false);
      setContentPane( chartPanel );
      
      StandardChartTheme theme = (StandardChartTheme)org.jfree.chart.StandardChartTheme.createJFreeTheme();
      chart.getPlot().setBackgroundPaint(Color.WHITE);
      
    chart.getXYPlot().getRenderer().setSeriesStroke(5, new BasicStroke(2.0f));
      
   }

   private XYDataset createDataset( TimeSeriesData test) 
   {
      final TimeSeries series = new TimeSeries( "Fitbit Data" );                
      for (int i = 0; i < test.getDatasetLength(); i++)    
      {
         try 
         {
            TimePoint currentTimePoint = test.getTimePoint(i);                
            series.add(new Minute(Time.valueOf(currentTimePoint.getTime())),currentTimePoint.getValue() );                 
             
         }
         catch ( SeriesException e ) 
         {
            System.err.println("Error adding to series");
         }
      }

      return new TimeSeriesCollection(series);
   }     

   private JFreeChart createChart( final XYDataset dataset, String title, String yAxisTitle ) 
   {
      return ChartFactory.createTimeSeriesChart(             
      title, 
      "Time",              
      yAxisTitle,              
      dataset,             
      false,              
      false,              
      false);
   }

   public static void main( final String[ ] args )
   {
      final String title = "Time Series Data";   
try {      
      final TimeGraph demo = new TimeGraph( title, "Heart Rate", Api.getTimeSeriesData("2016-02-11", "heart", 1) );
      demo.pack( );         
      RefineryUtilities.positionFrameRandomly( demo );         
      demo.setVisible( true );
} 
catch (Exception e) {
    System.out.println("Test");
}
      
   }
}   