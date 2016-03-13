package ca.uwo.csd.cs2212.team07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a Daily Goals panel that displays the Daily Goals to the user.
 *
 * @author team07
 */
public class Accolades extends JPanel {

    private final FitbitInfo fitbitInfo;

    private JLabel date;
    private JLabel stepsTakenData;
    private JLabel caloriesBurnedData;
    private JLabel totalDistanceData;
    private JLabel floorsClimbedData;
    private JLabel activeMinutesData;
    private JLabel dailyGoalsData;
    private JLabel accoladesEarnedData;

    private JLabel caloriesDate = new JLabel("Date Achieved : " + "");
    private JLabel distanceDate = new JLabel("Date Achieved : " + "");
    private JLabel activeDate = new JLabel("Date Achieved : " + "");
    private JLabel stepsDate = new JLabel("Date Achieved : " + "");
    private JLabel floorsDate = new JLabel("Date Achieved : " + "");
    private JLabel goalsDate = new JLabel("Date Achieved : " + "");
    private JLabel accoladesDate = new JLabel("Date Achieved : " + "");

    private JPanel datePanel;
    private JPanel stepsPanel;
    private JPanel caloriesPanel;
    private JPanel distancePanel;
    private JPanel floorsPanel;
    private JPanel activePanel;
    private JPanel goalsPanel;
    private JPanel accoladesPanel;

    private long calories, active, steps;
    private double distance, floors;
    private int goals, accolades;

    /**
     * Constructor for the Daily Goals class
     *
     * @param fitbitInfo container for user data
     */
    public Accolades(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    /**
     * Initializes the panel to display Daily Goals to the user
     */
    private void initPanel() {

        this.setBackground(Color.white); //Color of the menu bar
        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        this.add(date);

        //Check for new records
        if (fitbitInfo.getDay().getCaloriesOut() > calories) {
            calories = fitbitInfo.getDay().getCaloriesOut();
            caloriesDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        if (fitbitInfo.getDay().getDistance() > distance) {
            distance = fitbitInfo.getDay().getDistance();
            distanceDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        if (fitbitInfo.getDay().getFloors() > floors) {
            floors = fitbitInfo.getDay().getFloors();
            floorsDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        if (fitbitInfo.getDay().getSteps() > steps) {
            steps = fitbitInfo.getDay().getSteps();
            stepsDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        if (fitbitInfo.getDay().getActiveMins() > active) {
            active = fitbitInfo.getDay().getActiveMins();
            activeDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        if (fitbitInfo.getDay().getCaloriesOut() > goals) {
            goals = 10;
            goalsDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        if (fitbitInfo.getDay().getCaloriesOut() > accolades) {
            accolades = 20;
            accoladesDate = new JLabel("Date Achieved : " + fitbitInfo.getDay().getDate());
        }

        //Panels for each data item
        caloriesBurnedData = new JLabel(calories + " Calories Burned (100, 250, 500)");
        caloriesPanel = this.createDataBox(caloriesBurnedData, caloriesDate, "dataicons/calories.png", "dataicons/calories.png", "dataicons/calories.png", new Color(255, 150, 150));

        totalDistanceData = new JLabel(distance + " Distance Travelled (1 km, 2 km, 5 km");
        distancePanel = this.createDataBox(totalDistanceData, distanceDate, "dataicons/distance.png", "dataicons/distance.png", "dataicons/distance.png", new Color(200, 255, 200));

        floorsClimbedData = new JLabel(floors + " Floors Climbed (5, 10, 25)");
        floorsPanel = this.createDataBox(floorsClimbedData, floorsDate, "dataicons/floors.png", "dataicons/floors.png", "dataicons/floors.png", new Color(255, 160, 255));

        stepsTakenData = new JLabel(steps + " Steps Taken (200, 500, 1000)");
        stepsPanel = this.createDataBox(stepsTakenData, stepsDate, "dataicons/steps.png", "dataicons/steps.png", "dataicons/steps.png", new Color(250, 200, 160));

        activeMinutesData = new JLabel(active + " Active Minutes (20 min, 40 min, 60 min)");
        activePanel = this.createDataBox(activeMinutesData, activeDate, "accolades/activeBronze.png", "accolades/activeBronzeGray.png", "accolades/activeSilverGray.png", new Color(250, 255, 150));

        dailyGoalsData = new JLabel(goals + " Daily Goals Met (5, 10, 20)");
        goalsPanel = this.createDataBox(dailyGoalsData, goalsDate, "dataicons/sedentary.png", "dataicons/sedentary.png", "dataicons/sedentary.png", new Color(100, 255, 255));

        accoladesEarnedData = new JLabel(accolades + " Accolades Earned (10, 20)");
        accoladesPanel = this.createDataBox2(accoladesEarnedData, accoladesDate, "dataicons/sedentary.png", "dataicons/sedentary.png", new Color(255, 204, 203));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(caloriesPanel);
        this.add(distancePanel);
        this.add(floorsPanel);
        this.add(stepsPanel);
        this.add(activePanel);
        this.add(goalsPanel);
        this.add(accoladesPanel);
    }

    /**
     * Refresh the data displayed to the user
     */
    public void refresh() {
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
    }

    /**
     * Create a data box for one of the data items displayed on the Dashboard
     *
     * @param data data to display
     * @param date date of record achieved
     * @param color the color of the data box
     * @param iconFile bronze accolade earned
     * @param iconFile2 silver accolade earned
     * @param iconFile3 gold accolade earned
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox(JLabel header, JLabel date, String iconFile, String iconFile2, String iconFile3, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        ImageIcon iconImage2 = new ImageIcon(FileReader.getImage(iconFile2));
        ImageIcon iconImage3 = new ImageIcon(FileReader.getImage(iconFile3));
        JLabel iconLabel = new JLabel(iconImage);
        JLabel iconLabel2 = new JLabel(iconImage2);
        JLabel iconLabel3 = new JLabel(iconImage3);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(iconLabel2);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(iconLabel3);
        panel.add(Box.createHorizontalStrut(75));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        panel.add(date);
        panel.add(Box.createHorizontalStrut(50));

        return panel;
    }
    
    /**
     * Create a data box for accolades earned to display on the Dashboard
     * same as createDataBox but only for accolades earned
     *
     * @param data data to display
     * @param date date of record achieved
     * @param color the color of the data box
     * @param iconFile first accolade trophy
     * @param iconFile2 second accolade trophy
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox2(JLabel header, JLabel date, String iconFile, String iconFile2, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        ImageIcon iconImage2 = new ImageIcon(FileReader.getImage(iconFile2));
        JLabel iconLabel = new JLabel(iconImage);
        JLabel iconLabel2 = new JLabel(iconImage2);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(iconLabel2);
        panel.add(Box.createHorizontalStrut(133));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        panel.add(date);
        panel.add(Box.createHorizontalStrut(50));

        return panel;
    }

}
