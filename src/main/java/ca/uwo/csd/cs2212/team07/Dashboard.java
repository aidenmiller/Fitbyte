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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

    /**
     * Constructor for the Dashboard class
     *
     * @param fitbitInfo container for user data
     */
    public Dashboard(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    /**
     * Initializes the panel that displays the Dashboard
     */
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

    /**
     * Create a data box for one of the data items displayed on the Dashboard
     *
     * @param header name of data item
     * @param data the data to display
     * @param color the color of the data box
     * @return a JPanel containing the data box for the data item
     */
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

    /**
     * Refreshes the Dashboard after refreshing the data in FitbitInfo or
     * returning to Today's view
     */
    public void refresh() {
        todayButton.setSelected(true);
        timeData.setVisible(true);
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        sedentaryMinutesData.setText("" + fitbitInfo.getDay().getSedentaryMins());
        activeMinutesData.setText("" + fitbitInfo.getDay().getActiveMins());
        stepsTakenData.setText("" + fitbitInfo.getDay().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getDay().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getDay().getDistance());
        caloriesBurnedData.setText("" + fitbitInfo.getDay().getCaloriesOut());
    }

    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, -1);
            showDay(currDayView);
            nextButton.setVisible(true);
        } else if (e.getSource() == nextButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, 1);
            if (currDayView.equals(fitbitInfo.getLastRefreshTime())
                    || currDayView.after(fitbitInfo.getLastRefreshTime())) {
                this.refresh(); //use refresh and not showDay so fitbitInfo is shown instead of newly pulled data
                nextButton.setVisible(false);
            } else {
                showDay(currDayView);
            }
        } else if (e.getSource() == todayButton) {
            timeData.setVisible(true);
            nextButton.setVisible(false);
            this.refresh();
        } else if (e.getSource() == bestButton) {
            timeData.setVisible(false);
            this.displayBest();
        } else if (e.getSource() == lifetimeButton) {
            timeData.setVisible(false);
            this.displayLifetime();
        }
    }

    /**
     * Shows the day provided in the parameter to the user.
     *
     * @param dayToShow the day to show to the user
     */
    private void showDay(Calendar dayToShow) {
        FitbitInfo dayInfo = new FitbitInfo();

        if (fitbitInfo.getDay().getDate().equals("yyyy-MM-dd")) { //checks if in Test Mode
            dayInfo.generateTestData();
        } else {
            try {
                dayInfo.refreshInfo(dayToShow);
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Unable to display data.");
            } catch (RefreshTokenException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
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

    /**
     * Displays the Best Days data to the user
     */
    private void displayBest() {
        sedentaryMinutesData.setText("n/a");
        activeMinutesData.setText("n/a");
        stepsTakenData.setText("" + fitbitInfo.getBestDays()[2].getValue() + "\ton\t" + fitbitInfo.getBestDays()[2].getDate());
        floorsClimbedData.setText("" + fitbitInfo.getBestDays()[1].getValue() + "\ton\t" + fitbitInfo.getBestDays()[1].getDate());
        totalDistanceData.setText("" + fitbitInfo.getBestDays()[0].getValue() + "\ton\t" + fitbitInfo.getBestDays()[0].getDate());
        caloriesBurnedData.setText("n/a");
    }

    /**
     * Displays the Lifetime data to the user
     */
    private void displayLifetime() {
        sedentaryMinutesData.setText("n/a");
        activeMinutesData.setText("n/a");
        stepsTakenData.setText("" + fitbitInfo.getLifetime().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getLifetime().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getLifetime().getDistance());
        caloriesBurnedData.setText("n/a");
    }

}
