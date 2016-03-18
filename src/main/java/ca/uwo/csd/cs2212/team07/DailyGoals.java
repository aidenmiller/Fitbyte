package ca.uwo.csd.cs2212.team07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import org.json.JSONException;

/**
 * Creates a Dashboard panel that displays the Dashboard to the user.
 *
 * @author team07
 */
public class DailyGoals extends JPanel implements ActionListener {
    
    private final FitbitInfo fitbitInfo;
    private final UserConfig userConfig;
    
    private JLabel date;
    private JProgressBar caloriesBurnedBar, totalDistanceBar, floorsClimbedBar, stepsTakenBar, activeMinutesBar;
    
    private JToggleButton calendarButton;
    private DateChooserPanel dateChooser;
    private ButtonGroup buttonGroup;
    private JToggleButton todayButton;
    
    private JPanel displayPanel, caloriesPanel, distancePanel, floorsPanel, stepsPanel, activePanel;
    private JButton caloriesEdit;
    private JButton distanceEdit;
    private JButton floorsEdit;
    private JButton stepsEdit;
    private JButton activeEdit;

    /**
     * Constructor for the Dashboard class
     *
     * @param fitbitInfo container for user data
     * @param userConfig container for user configuration
     */
    public DailyGoals(FitbitInfo fitbitInfo, UserConfig userConfig) {
        super();
        this.fitbitInfo = fitbitInfo;
        this.userConfig = userConfig;
        initPanel();
    }

    /**
     * Initializes the panel that displays the Dashboard
     */
    private void initPanel() {
        this.setBackground(Color.white);
        
        date = new JLabel("");
        dateChooser = new DateChooserPanel((Calendar) fitbitInfo.getLastRefreshTime().clone(), false);
        //Today, Best, Lifetime views
        calendarButton = new JToggleButton();
        calendarButton.addActionListener(this);
        calendarButton.setToolTipText("View Previous Day");
        ImageIcon icon = new ImageIcon(FileReader.getImage("calendar.png"));
        calendarButton.setIcon(icon);
        
        todayButton = new JToggleButton("Today");
        todayButton.setToolTipText("Today's Activity");
        todayButton.addActionListener(this);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(calendarButton);
        buttonGroup.add(todayButton);
        
        displayPanel = new JPanel();
        displayPanel.setOpaque(false);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.add(Box.createHorizontalStrut(15));
        displayPanel.add(calendarButton);
        displayPanel.add(Box.createHorizontalStrut(5));
        displayPanel.add(todayButton);
        displayPanel.add(Box.createHorizontalGlue());
        displayPanel.add(date);
        displayPanel.add(Box.createHorizontalStrut(15));
        //End of Today, Best, Lifetime views

        //Panels for each data item
        caloriesBurnedBar = new JProgressBar();
        caloriesEdit = new JButton("Edit");
        caloriesEdit.addActionListener(this);
        caloriesPanel = this.createDataBox(new JLabel("Calories Burned"), caloriesBurnedBar, caloriesEdit, "dataicons/calories.png", new Color(255, 175, 175));
        
        totalDistanceBar = new JProgressBar();
        distanceEdit = new JButton("Edit");
        distanceEdit.addActionListener(this);
        distancePanel = this.createDataBox(new JLabel("Total Distance"), totalDistanceBar, distanceEdit, "dataicons/distance.png", new Color(180, 255, 190));
        floorsClimbedBar = new JProgressBar();
        floorsEdit = new JButton("Edit");
        floorsEdit.addActionListener(this);
        floorsPanel = this.createDataBox(new JLabel("Floors Climbed"), floorsClimbedBar, floorsEdit, "dataicons/floors.png", new Color(255, 180, 245));
        stepsTakenBar = new JProgressBar();
        stepsEdit = new JButton("Edit");
        stepsEdit.addActionListener(this);
        stepsPanel = this.createDataBox(new JLabel("Steps Taken"), stepsTakenBar, stepsEdit, "dataicons/steps.png", new Color(180, 250, 255));
        activeMinutesBar = new JProgressBar();
        activeEdit = new JButton("Edit");
        activeEdit.addActionListener(this);
        activePanel = this.createDataBox(new JLabel("Active Minutes"), activeMinutesBar, activeEdit, "dataicons/active.png", new Color(250, 255, 180));
        //end of Panels for each data item

        this.setLayout(new BorderLayout());
        //Layout Specifications - Top
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(displayPanel);
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
        centerPanel.add(distancePanel);
        centerPanel.add(floorsPanel);
        centerPanel.add(stepsPanel);
        centerPanel.add(activePanel);
        centerPanel.add(Box.createVerticalStrut(20));
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
    private JPanel createDataBox(JLabel header, JProgressBar progBar, JButton edit, String iconFile, Color color) {
        JPanel panel = new JPanel();
        
        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        JLabel iconLabel = new JLabel(iconImage);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(70));
        
        header.setFont(new Font(header.getFont().getName(), Font.PLAIN, 14));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        
        progBar.setStringPainted(true);
        panel.add(progBar);
        panel.add(Box.createHorizontalStrut(50));
        edit.setName(header.getText());
        panel.add(edit);
        
        panel.add(Box.createHorizontalStrut(20));
        
        return panel;
    }

    /**
     * Refreshes the Dashboard after refreshing the data in FitbitInfo or
     * returning to Today's view
     */
    public void refresh() {
        this.refreshConfig();
        todayButton.setSelected(true);
        
        date.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        
        Daily day = fitbitInfo.getDay();
        int percent;
        int numComplete = 0;

        //CALORIES
        if (userConfig.getCalGoal() < 0) {
            caloriesBurnedBar.setMaximum((int) day.getCalOutGoal());
        } else {
            caloriesBurnedBar.setMaximum((int) userConfig.getCalGoal());
        }
        caloriesBurnedBar.setValue((int) day.getCaloriesOut());
        percent = (int) (caloriesBurnedBar.getPercentComplete() * 100);
        caloriesBurnedBar.setString("" + day.getCaloriesOut() + "/" + caloriesBurnedBar.getMaximum() + " calories (" + percent + "%)");
        if (percent == 100) {
            numComplete++;
        }

        //DISTANCE
        if (userConfig.getDistanceGoal() < 0) {
            totalDistanceBar.setMaximum((int) day.getDistanceGoal());
        } else {
            totalDistanceBar.setMaximum((int) userConfig.getDistanceGoal());
        }
        totalDistanceBar.setValue((int) day.getDistance());
        percent = (int) (totalDistanceBar.getPercentComplete() * 100);
        totalDistanceBar.setString("" + day.getDistance() + "/" + totalDistanceBar.getMaximum() + " km (" + percent + "%)");
        if (percent == 100) {
            numComplete++;
        }

        //STEPS
        if (userConfig.getStepsGoal() < 0) {
            stepsTakenBar.setMaximum((int) day.getStepsGoal());
        } else {
            stepsTakenBar.setMaximum((int) userConfig.getStepsGoal());
        }
        stepsTakenBar.setValue((int) day.getSteps());
        percent = (int) (stepsTakenBar.getPercentComplete() * 100);
        stepsTakenBar.setString("" + day.getSteps() + "/" + stepsTakenBar.getMaximum() + " steps (" + percent + "%)");
        if (percent == 100) {
            numComplete++;
        }

        //FLOORS
        if (userConfig.getFloorsGoal() < 0) {
            floorsClimbedBar.setMaximum((int) day.getFloorGoal());
        } else {
            floorsClimbedBar.setMaximum((int) userConfig.getFloorsGoal());
        }
        floorsClimbedBar.setValue((int) day.getFloors());
        percent = (int) (floorsClimbedBar.getPercentComplete() * 100);
        floorsClimbedBar.setString("" + day.getFloors() + "/" + floorsClimbedBar.getMaximum() + " floors (" + percent + "%)");
        if (percent == 100) {
            numComplete++;
        }

        //ACTIVE MINS
        if (userConfig.getActiveGoal() < 0) {
            activeMinutesBar.setMaximum((int) day.getActiveMinGoal());
        } else {
            activeMinutesBar.setMaximum((int) userConfig.getActiveGoal());
        }
        activeMinutesBar.setValue((int) day.getActiveMins());
        percent = (int) (activeMinutesBar.getPercentComplete() * 100);
        activeMinutesBar.setString("" + day.getActiveMins() + "/" + activeMinutesBar.getMaximum() + " minutes (" + percent + "%)");
        if (percent == 100) {
            numComplete++;
        }
        
        userConfig.setGoalsComplete(numComplete);
    }

    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calendarButton) {
            this.switchDay();
        } else if (e.getSource() == todayButton) {
            this.refreshConfig();
            this.refresh();
        } else if (e.getSource() == caloriesEdit) {
            this.setGoal("Calories Burned");
        } else if (e.getSource() == distanceEdit) {
            this.setGoal("Total Distance");
        } else if (e.getSource() == floorsEdit) {
            this.setGoal("Floors Climbed");
        } else if (e.getSource() == stepsEdit) {
            this.setGoal("Steps Taken");
        } else if (e.getSource() == activeEdit) {
            this.setGoal("Active Minutes");
        }
        
    }
    
    private void switchDay() {
        int n = JOptionPane.showOptionDialog(this, dateChooser,
                "Calendar", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        if (n == JOptionPane.OK_OPTION) {
            Daily dayInfo;
            
            if (fitbitInfo.isTestMode()) { //checks if in Test Mode
                FitbitInfo info = new FitbitInfo();
                info.testModeData();
                dayInfo = info.getDay();
            } else {
                try {
                    dayInfo = Api.getDailySummary(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate()));
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Unable to display data.");
                    return; //so that the data does not update
                } catch (RefreshTokenException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
                    return; //so that the data does not update
                }
            }
            
            date.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(dateChooser.getDate()));
            int percent;

            //CALORIES
            caloriesBurnedBar.setMaximum((int) dayInfo.getCalOutGoal());
            caloriesBurnedBar.setValue((int) dayInfo.getCaloriesOut());
            percent = (int) (caloriesBurnedBar.getPercentComplete() * 100);
            caloriesBurnedBar.setString("" + dayInfo.getCaloriesOut() + "/" + caloriesBurnedBar.getMaximum() + " calories (" + percent + "%)");

            //DISTANCE
            totalDistanceBar.setMaximum((int) dayInfo.getDistanceGoal());
            totalDistanceBar.setValue((int) dayInfo.getDistance());
            percent = (int) (totalDistanceBar.getPercentComplete() * 100);
            totalDistanceBar.setString("" + dayInfo.getDistance() + "/" + totalDistanceBar.getMaximum() + " km (" + percent + "%)");

            //STEPS
            stepsTakenBar.setMaximum((int) dayInfo.getStepsGoal());
            stepsTakenBar.setValue((int) dayInfo.getSteps());
            percent = (int) (stepsTakenBar.getPercentComplete() * 100);
            stepsTakenBar.setString("" + dayInfo.getSteps() + "/" + stepsTakenBar.getMaximum() + " steps (" + percent + "%)");

            //FLOORS
            floorsClimbedBar.setMaximum((int) dayInfo.getFloorGoal());
            floorsClimbedBar.setValue((int) dayInfo.getFloors());
            percent = (int) (floorsClimbedBar.getPercentComplete() * 100);
            floorsClimbedBar.setString("" + dayInfo.getFloors() + "/" + floorsClimbedBar.getMaximum() + " floors (" + percent + "%)");

            //ACTIVE MINS
            activeMinutesBar.setMaximum((int) dayInfo.getActiveMinGoal());
            activeMinutesBar.setValue((int) dayInfo.getActiveMins());
            percent = (int) (activeMinutesBar.getPercentComplete() * 100);
            activeMinutesBar.setString("" + dayInfo.getActiveMins() + "/" + activeMinutesBar.getMaximum() + " minutes (" + percent + "%)");
            
            caloriesEdit.setVisible(false);
            distanceEdit.setVisible(false);
            stepsEdit.setVisible(false);
            floorsEdit.setVisible(false);
            activeEdit.setVisible(false);
        }
    }
    
    public void refreshConfig() {
        caloriesPanel.setVisible(userConfig.isCaloriesData());
        distancePanel.setVisible(userConfig.isDistanceData());
        floorsPanel.setVisible(userConfig.isFloorsData());
        stepsPanel.setVisible(userConfig.isStepsData());
        activePanel.setVisible(userConfig.isActiveData());
    }
    
    private void setGoal(String field) {
        String input = JOptionPane.showInputDialog(this, "New " + field + " Goal (enter negative number to use fitbit goals)", "Edit a Daily Goal", JOptionPane.PLAIN_MESSAGE);
        
        if (input != null) {
            try {
                int val = Integer.parseInt(input);
                if (val < 0) {
                    val = -1;
                }
                if (field.equals("Calories Burned")) {
                    userConfig.setCalGoal(val);
                } else if (field.equals("Total Distance")) {
                    userConfig.setDistanceGoal(val);
                } else if (field.equals("Floors Climbed")) {
                    userConfig.setFloorsGoal(val);
                } else if (field.equals("Steps Taken")) {
                    userConfig.setStepsGoal(val);
                } else if (field.equals("Active Minutes")) {
                    userConfig.setActiveGoal(val);
                }
                this.refresh();
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
        
    }
    
}
