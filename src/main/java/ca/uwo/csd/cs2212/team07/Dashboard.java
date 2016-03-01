package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import org.json.JSONException;

/**
 * Creates a Dashboard panel that displays the Dashboard to the user.
 *
 * @author team07
 */
public class Dashboard extends JPanel implements ActionListener {

    private final FitbitInfo fitbitInfo;

    private JLabel date;
    private JLabel caloriesBurnedData;
    private JLabel totalDistanceData;
    private JLabel floorsClimbedData;
    private JLabel stepsTakenData;
    private JLabel activeMinutesData;
    private JLabel sedentaryMinutesData;
    private Calendar currDayView;

    private JButton prevButton, nextButton;

    public Dashboard(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    private void initPanel() {

        this.setBackground(Color.ORANGE);

        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        prevButton = new JButton("Previous");
        prevButton.addActionListener(this);
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        JPanel timeData = new JPanel();
        timeData.setOpaque(false);
        timeData.setLayout(new BoxLayout(timeData, BoxLayout.X_AXIS));
        timeData.add(Box.createHorizontalGlue());
        timeData.add(prevButton);
        timeData.add(Box.createRigidArea(new Dimension(10, 40)));
        timeData.add(date);
        timeData.add(Box.createRigidArea(new Dimension(10, 40)));
        timeData.add(nextButton);
        timeData.add(Box.createHorizontalGlue());

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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(timeData);
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

    }

    private JPanel createDataBox(JLabel header, JLabel data, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createRigidArea(new Dimension(20, 50)));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        panel.add(data);
        panel.add(Box.createHorizontalGlue());
        panel.add(Box.createRigidArea(new Dimension(20, 50)));

        return panel;
    }

    public void refresh() {
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        sedentaryMinutesData.setText("" + fitbitInfo.getDay().getSedentaryMins());
        activeMinutesData.setText("" + fitbitInfo.getDay().getActiveMins());
        stepsTakenData.setText("" + fitbitInfo.getDay().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getDay().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getDay().getDistance());
        caloriesBurnedData.setText("" + fitbitInfo.getDay().getCaloriesOut());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, -1);
            showDay(currDayView);
        } else if (e.getSource() == nextButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, 1);
            showDay(currDayView);
        }
    }

    private void showDay(Calendar dayToShow) {
        FitbitInfo dayInfo = new FitbitInfo();

        if (fitbitInfo.getDay().getDate().equals("yyyy-MM-dd")) {
            dayInfo.generateTestData(); //for Test Mode
        } else {
            try {
                dayInfo.refreshInfo(dayToShow);

            } catch (JSONException ex) {
                System.err.println("Error Accessing API");
            } catch (RefreshTokenException ex) {
                System.err.println("Error Accessing API");
            }
        }

        date.setText(new SimpleDateFormat("dd MMM yyyy").format(dayToShow.getTime()));
        sedentaryMinutesData.setText("" + dayInfo.getDay().getSedentaryMins());
        activeMinutesData.setText("" + dayInfo.getDay().getActiveMins());
        stepsTakenData.setText("" + dayInfo.getDay().getSteps());
        floorsClimbedData.setText("" + dayInfo.getDay().getFloors());
        totalDistanceData.setText("" + dayInfo.getDay().getDistance());
        caloriesBurnedData.setText("" + dayInfo.getDay().getCaloriesOut());

    }

}
