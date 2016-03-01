package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * Creates a Dashboard panel that displays the Dashboard to the user.
 *
 * @author team07
 */
public class Dashboard extends JPanel {

    private final FitbitInfo fitbitInfo;

    private JLabel date;
    private JLabel caloriesBurnedData;
    private JLabel totalDistanceData;
    private JLabel floorsClimbedData;
    private JLabel stepsTakenData;
    private JLabel activeMinutesData;
    private JLabel sedentaryMinutesData;

    public Dashboard(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    private void initPanel() {

        this.setBackground(Color.ORANGE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
       
        caloriesBurnedData = new JLabel("" + fitbitInfo.getDay().getCaloriesOut());
        JPanel caloriesData = this.createDataBox(new JLabel("Calories Burned"), caloriesBurnedData, Color.cyan);
        
        totalDistanceData = new JLabel("" + fitbitInfo.getDay().getDistance());
        JPanel distanceData = this.createDataBox(new JLabel("Total Distance"), totalDistanceData, Color.yellow);
        
        floorsClimbedData = new JLabel("" + fitbitInfo.getDay().getFloors());
        JPanel floorsData = this.createDataBox(new JLabel("Floors Climbed"), floorsClimbedData, Color.magenta);
        
        stepsTakenData = new JLabel("" + fitbitInfo.getDay().getSteps());
        JPanel stepsData = this.createDataBox(new JLabel("Steps Taken"), stepsTakenData, Color.white);
        
        activeMinutesData = new JLabel("" + fitbitInfo.getDay().getActiveMins());
        JPanel activeData = this.createDataBox(new JLabel("Active Minutes"), activeMinutesData, Color.green);

        sedentaryMinutesData = new JLabel("" + fitbitInfo.getDay().getSedentaryMins());
        JPanel sedentaryData = this.createDataBox(new JLabel("Sedentary Minutes"), sedentaryMinutesData, Color.pink);

        //Layout Specifications
        this.add(date);
        this.add(Box.createVerticalStrut(10));
        this.add(caloriesData);
        this.add(Box.createVerticalStrut(10));
        this.add(distanceData);
        this.add(Box.createVerticalStrut(10));
        this.add(floorsData);
        this.add(Box.createVerticalStrut(10));
        this.add(stepsData);
        this.add(Box.createVerticalStrut(10));
        this.add(activeData);
        this.add(Box.createVerticalStrut(10));
        this.add(sedentaryData);
        this.add(Box.createVerticalStrut(10));
        
    }
    
    private JPanel createDataBox(JLabel header, JLabel data, Color color) {
        JPanel panel = new JPanel();
        
        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createRigidArea(new Dimension(20,50)));
        panel.add(header);
        panel.add(Box.createRigidArea(new Dimension(20,50)));
        panel.add(data);
        panel.add(Box.createHorizontalGlue());
        panel.add(Box.createRigidArea(new Dimension(20,50)));
        
        
        return panel;
    }

    public void refresh() {
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        sedentaryMinutesData.setText("" + fitbitInfo.getDay().getSedentaryMins());
        activeMinutesData.setText("" + fitbitInfo.getDay().getActiveMins());
        stepsTakenData.setText("" + fitbitInfo.getDay().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getDay().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getDay().getDistance());
        caloriesBurnedData.setText("" + fitbitInfo.getDay().getCaloriesOut());
    }

}
