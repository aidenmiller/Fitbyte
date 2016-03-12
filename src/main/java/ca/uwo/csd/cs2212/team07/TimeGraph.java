package ca.uwo.csd.cs2212.team07;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.json.JSONException;

public class TimeGraph extends ApplicationFrame {

    public TimeGraph(final String title, final String yAxisTitle, TimeSeriesData timeData) {
        super(title);
        final XYDataset dataset = createDataset(timeData);
        final JFreeChart chart = createChart(dataset, title, yAxisTitle);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        chartPanel.setMouseZoomable(true, false);
        chartPanel.setRangeZoomable(false);
        setContentPane(chartPanel);

        StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();
        chart.getPlot().setBackgroundPaint(Color.WHITE);

        chart.getTitle().setFont(new Font("Arial", 1, 24));

        chart.getXYPlot().setDomainCrosshairVisible(true);
        chart.getXYPlot().setDomainCrosshairLockedOnData(true);
        chart.getXYPlot().setRangeCrosshairVisible(true);
        chart.getXYPlot().setRangeCrosshairLockedOnData(true);

    }
    
    private void showGraph() {
        this.pack();
        this.setVisible(true);
    }
    

    private XYDataset createDataset(TimeSeriesData test) {
        final TimeSeries series = new TimeSeries("Fitbit Data");
        for (int i = 0; i < test.getDatasetLength(); i++) {
            try {
                TimePoint currentTimePoint = test.getTimePoint(i);
                series.add(new Minute(Time.valueOf(currentTimePoint.getTime())), currentTimePoint.getValue());

            } catch (SeriesException e) {
                System.err.println("Error adding to series");
            }
        }

        return new TimeSeriesCollection(series);
    }

    private JFreeChart createChart(final XYDataset dataset, String title, String yAxisTitle) {
        return ChartFactory.createTimeSeriesChart(
                title,
                "Time",
                yAxisTitle,
                dataset,
                false,
                false,
                false);
    }

    
    public static void main(final String[] args) {
        try {
            TimeGraph graph = new TimeGraph("Heart Rate Data", "Heart Rate", Api.getTimeSeriesData("2016-02-11", "heart", 1));
            graph.showGraph();
        } catch (JSONException ex) {
            Logger.getLogger(TimeGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RefreshTokenException ex) {
            Logger.getLogger(TimeGraph.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
