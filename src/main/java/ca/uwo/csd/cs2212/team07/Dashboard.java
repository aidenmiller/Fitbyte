package ca.uwo.csd.cs2212.team07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.ImageIcon;
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

    private JPanel displayPanel;
    private JPanel timePanel;
    private JPanel caloriesPanel;
    private JPanel distancePanel;
    private JPanel floorsPanel;
    private JPanel stepsPanel;
    private JPanel activePanel;
    private JPanel sedentaryPanel;

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
        this.setBackground(Color.white);

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

        displayPanel = new JPanel();
        displayPanel.setOpaque(false);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.add(Box.createHorizontalGlue());
        displayPanel.add(todayButton);
        displayPanel.add(Box.createHorizontalStrut(15));
        displayPanel.add(bestButton);
        displayPanel.add(Box.createHorizontalStrut(15));
        displayPanel.add(lifetimeButton);
        displayPanel.add(Box.createHorizontalGlue());
        //End of Today, Best, Lifetime views

        //Time data for changing views
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        prevButton = new JButton(new ImageIcon(FileReader.getImage("previous.png")));
        prevButton.addActionListener(this);
        prevButton.setBorderPainted(false);
        nextButton = new JButton(new ImageIcon(FileReader.getImage("next.png")));
        nextButton.addActionListener(this);
        nextButton.setBorderPainted(false);

        timePanel = new JPanel();
        timePanel.setOpaque(false);
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
        timePanel.add(Box.createHorizontalGlue());
        timePanel.add(prevButton);
        timePanel.add(Box.createHorizontalStrut(15));
        timePanel.add(date);
        timePanel.add(Box.createHorizontalStrut(15));
        timePanel.add(nextButton);
        timePanel.add(Box.createHorizontalGlue());
        //end of Time data

        //Panels for each data item
        caloriesBurnedData = new JLabel("" + fitbitInfo.getDay().getCaloriesOut());
        caloriesPanel = this.createDataBox(new JLabel("Calories Burned"), caloriesBurnedData, "dataicons/calories.png", new Color(255, 150, 150));

        totalDistanceData = new JLabel("" + fitbitInfo.getDay().getDistance());
        distancePanel = this.createDataBox(new JLabel("Total Distance"), totalDistanceData, "dataicons/distance.png", new Color(200, 255, 200));

        floorsClimbedData = new JLabel("" + fitbitInfo.getDay().getFloors());
        floorsPanel = this.createDataBox(new JLabel("Floors Climbed"), floorsClimbedData, "dataicons/floors.png", new Color(255, 160, 255));

        stepsTakenData = new JLabel("" + fitbitInfo.getDay().getSteps());
        stepsPanel = this.createDataBox(new JLabel("Steps Taken"), stepsTakenData, "dataicons/steps.png", new Color(250, 200, 160));

        activeMinutesData = new JLabel("" + fitbitInfo.getDay().getActiveMins());
        activePanel = this.createDataBox(new JLabel("Active Minutes"), activeMinutesData, "dataicons/active.png", new Color(250, 255, 150));

        sedentaryMinutesData = new JLabel("" + fitbitInfo.getDay().getSedentaryMins());
        sedentaryPanel = this.createDataBox(new JLabel("Sedentary Minutes"), sedentaryMinutesData, "dataicons/sedentary.png", new Color(100, 255, 255));
        //end of Panels for each data item

        this.setLayout(new BorderLayout());
        //Layout Specifications - Top
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(displayPanel);
        topPanel.add(timePanel);
        this.add(topPanel, BorderLayout.NORTH);
        //Layout Specifications - WEST and EAST
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        westPanel.setOpaque(false);
        eastPanel.setOpaque(false);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        //Layout Specifications - Center
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(caloriesPanel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(distancePanel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(floorsPanel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(stepsPanel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(activePanel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(sedentaryPanel);
        centerPanel.add(Box.createVerticalStrut(5));
        this.add(centerPanel, BorderLayout.CENTER);

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
    private JPanel createDataBox(JLabel header, JLabel data, String iconFile, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        JLabel iconLabel = new JLabel(iconImage);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(150));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        panel.add(data);
        panel.add(Box.createHorizontalStrut(150));

        return panel;
    }

    /**
     * Refreshes the Dashboard after refreshing the data in FitbitInfo or
     * returning to Today's view
     */
    public void refresh() {
        todayButton.setSelected(true);
        timePanel.setVisible(true);
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
            nextButton.setEnabled(true);
        } else if (e.getSource() == nextButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, 1);
            if (currDayView.equals(fitbitInfo.getLastRefreshTime())
                    || currDayView.after(fitbitInfo.getLastRefreshTime())) {
                todayButton.doClick(); // user has moved back to today view, so show Today
            } else {
                showDay(currDayView);
            }
        } else if (e.getSource() == todayButton) {
            timePanel.setVisible(true);
            nextButton.setEnabled(false);

            sedentaryPanel.setVisible(true);
            activePanel.setVisible(true);
            stepsPanel.setVisible(true);
            floorsPanel.setVisible(true);
            distancePanel.setVisible(true);
            caloriesPanel.setVisible(true);
            this.refresh();
        } else if (e.getSource() == bestButton) {
            timePanel.setVisible(false);
            this.displayBest();
        } else if (e.getSource() == lifetimeButton) {
            timePanel.setVisible(false);
            this.displayLifetime();
        }
    }

    /**
     * Shows the day provided in the parameter to the user.
     *
     * @param dayToShow the day to show to the user
     */
    private void showDay(Calendar dayToShow) {
        if (fitbitInfo.getDay().getDate().equals("yyyy-MM-dd")) { //checks if in Test Mode
            FitbitInfo dayInfo = new FitbitInfo();
            dayInfo.generateTestData();
            date.setText(new SimpleDateFormat("dd MMM yyyy").format(dayToShow.getTime()));
            sedentaryMinutesData.setText("" + dayInfo.getDay().getSedentaryMins());
            activeMinutesData.setText("" + dayInfo.getDay().getActiveMins());
            stepsTakenData.setText("" + dayInfo.getDay().getSteps());
            floorsClimbedData.setText("" + dayInfo.getDay().getFloors());
            totalDistanceData.setText("" + dayInfo.getDay().getDistance());
            caloriesBurnedData.setText("" + dayInfo.getDay().getCaloriesOut());
        } else {
            try {
                Daily dayInfo = Api.getDailySummary(new SimpleDateFormat("yyyy-MM-dd").format(dayToShow.getTime()));
                date.setText(new SimpleDateFormat("dd MMM yyyy").format(dayToShow.getTime()));
                sedentaryMinutesData.setText("" + dayInfo.getSedentaryMins());
                activeMinutesData.setText("" + dayInfo.getActiveMins());
                stepsTakenData.setText("" + dayInfo.getSteps());
                floorsClimbedData.setText("" + dayInfo.getFloors());
                totalDistanceData.setText("" + dayInfo.getDistance());
                caloriesBurnedData.setText("" + dayInfo.getCaloriesOut());
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Unable to display data.");
            } catch (RefreshTokenException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
            }
        }

    }

    /**
     * Displays the Best Days data to the user
     */
    private void displayBest() {
        sedentaryPanel.setVisible(false);
        activePanel.setVisible(false);
        stepsTakenData.setText("" + fitbitInfo.getBestDays()[2].getValue() + "\t\ton\t\t" + fitbitInfo.getBestDays()[2].getDate());
        floorsClimbedData.setText("" + fitbitInfo.getBestDays()[1].getValue() + "\t\ton\t\t" + fitbitInfo.getBestDays()[1].getDate());
        totalDistanceData.setText("" + fitbitInfo.getBestDays()[0].getValue() + "\t\ton\t\t" + fitbitInfo.getBestDays()[0].getDate());
        caloriesPanel.setVisible(false);
    }

    /**
     * Displays the Lifetime data to the user
     */
    private void displayLifetime() {
        sedentaryPanel.setVisible(false);
        activePanel.setVisible(false);
        stepsTakenData.setText("" + fitbitInfo.getLifetime().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getLifetime().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getLifetime().getDistance());
        caloriesPanel.setVisible(false);
    }

}
