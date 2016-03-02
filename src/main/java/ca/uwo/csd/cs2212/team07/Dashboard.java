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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
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

    private ButtonGroup buttonGroup;
    private JToggleButton todayButton, bestButton, lifetimeButton;
    private JPanel timeData;

    public Dashboard(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    private void initPanel() {

        this.setBackground(Color.ORANGE);

        //Today, Best, Lifetime views
        todayButton = new JToggleButton("Today");
        todayButton.addActionListener(this);
        bestButton = new JToggleButton("Best");
        bestButton.addActionListener(this);
        lifetimeButton = new JToggleButton("Lifetime");
        lifetimeButton.addActionListener(this);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(todayButton);
        buttonGroup.add(bestButton);
        buttonGroup.add(lifetimeButton);

        JPanel displayPanel = new JPanel();
        displayPanel.setOpaque(false);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.add(Box.createHorizontalGlue());
        displayPanel.add(todayButton);
        displayPanel.add(Box.createRigidArea(new Dimension(10, 40)));
        displayPanel.add(bestButton);
        displayPanel.add(Box.createRigidArea(new Dimension(10, 40)));
        displayPanel.add(lifetimeButton);
        displayPanel.add(Box.createHorizontalGlue());
        //End of Today, Best, Lifetime views

        //Time data for changing views
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        prevButton = new JButton("Previous");
        prevButton.addActionListener(this);
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        timeData = new JPanel();
        timeData.setOpaque(false);
        timeData.setLayout(new BoxLayout(timeData, BoxLayout.X_AXIS));
        timeData.add(Box.createHorizontalGlue());
        timeData.add(prevButton);
        timeData.add(Box.createRigidArea(new Dimension(10, 40)));
        timeData.add(date);
        timeData.add(Box.createRigidArea(new Dimension(10, 40)));
        timeData.add(nextButton);
        timeData.add(Box.createHorizontalGlue());
        //end of Time data

        //Panels for each data item
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
        //end of Panels for each data item

        //Layout Specifications
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(displayPanel);
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

        //sets the view to Today
        todayButton.doClick();
    }

    private JPanel createDataBox(JLabel header, JLabel data, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(600, 10)));
        panel.add(header);
        panel.add(data);
        panel.add(Box.createRigidArea(new Dimension(600, 10)));

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
            if (currDayView.after(fitbitInfo.getLastRefreshTime())) {
                this.refresh(); //use refresh and not showDay so fitbitInfo is shown instead of newly pulled data
            } else {
                showDay(currDayView);
            }
        } else if (e.getSource() == todayButton) {
            timeData.setVisible(true);
            this.refresh();
        } else if (e.getSource() == bestButton) {
            timeData.setVisible(false);
            this.displayBest();
        } else if (e.getSource() == lifetimeButton) {
            timeData.setVisible(false);
            this.displayLifetime();
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

    private void displayBest() {
        sedentaryMinutesData.setText("n/a");
        activeMinutesData.setText("n/a");
        stepsTakenData.setText("" + fitbitInfo.getBestDays()[2].getValue() + "\ton\t" + fitbitInfo.getBestDays()[2].getDate());
        floorsClimbedData.setText("" + fitbitInfo.getBestDays()[1].getValue() + "\ton\t" + fitbitInfo.getBestDays()[1].getDate());
        totalDistanceData.setText("" + fitbitInfo.getBestDays()[0].getValue() + "\ton\t" + fitbitInfo.getBestDays()[0].getDate());
        caloriesBurnedData.setText("n/a");
    }

    private void displayLifetime() {
        sedentaryMinutesData.setText("n/a");
        activeMinutesData.setText("n/a");
        stepsTakenData.setText("" + fitbitInfo.getLifetime().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getLifetime().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getLifetime().getDistance());
        caloriesBurnedData.setText("n/a");
    }

}
