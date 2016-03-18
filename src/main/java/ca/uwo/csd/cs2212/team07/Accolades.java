// Note: implement/finish daily goal counter, accolades counter and accolades trophies, update with changing date

package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates an accolades panel that displays the earned accolades to the user.
 *
 * @author team07
 */
public class Accolades extends JPanel {

    private final FitbitInfo fitbitInfo;
    private UserConfig userConfig;

    private JLabel date;
    private JLabel stepsTakenData;
    private JLabel caloriesBurnedData;
    private JLabel totalDistanceData;
    private JLabel floorsClimbedData;
    private JLabel activeMinutesData;
    private JLabel dailyGoalsData;
    private JLabel accoladesEarnedData;

    private String caloriesDate;
    private String distanceDate;
    private String activeDate;
    private String stepsDate;
    private String floorsDate;
    private String goalsDate;
    private String accoladesDate;

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
    private int goals, totalAccolades;
    
    private String caloriesBronze;
    private String caloriesSilver;
    private String caloriesGold;
    private String distanceBronze;
    private String distanceSilver;
    private String distanceGold;
    private String activeBronze;
    private String activeSilver;
    private String activeGold;
    private String stepsBronze;
    private String stepsSilver;
    private String stepsGold;
    private String floorsBronze;
    private String floorsSilver;
    private String floorsGold;
    private String goalsBronze;
    private String goalsSilver;
    private String goalsGold;
    private String accolades1;
    private String accolades2; 
    private String accolades3;

    /**
     * Constructor for the Daily Goals class
     *
     * @param fitbitInfo container for user data
     * @param userConfig container to save progress data
     */
    public Accolades(FitbitInfo fitbitInfo, UserConfig userConfig) {
        super();
        this.fitbitInfo = fitbitInfo;
        this.userConfig = userConfig;
        initPanel();
    }

    private void initPanel() {

        this.setBackground(Color.white); //Color of the menu bar
        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        this.add(date);
        
        
        //Reset file names for accolades to gray icons
        caloriesBronze = "accolades/caloriesBronzeGray.png";
        caloriesSilver = "accolades/caloriesSilverGray.png";
        caloriesGold = "accolades/caloriesGoldGray.png";
        distanceBronze = "accolades/distanceBronzeGray.png";
        distanceSilver = "accolades/distanceSilverGray.png";
        distanceGold = "accolades/distanceGoldGray.png";
        activeBronze = "accolades/activeBronzeGray.png";
        activeSilver = "accolades/activeSilverGray.png";
        activeGold = "accolades/activeGoldGray.png";
        stepsBronze = "accolades/stepsBronzeGray.png";
        stepsSilver = "accolades/stepsSilverGray.png";
        stepsGold = "accolades/stepsGoldGray.png";
        floorsBronze = "accolades/floorsBronzeGray.png";
        floorsSilver = "accolades/floorsSilverGray.png";
        floorsGold = "accolades/floorsGoldGray.png";
        goalsBronze = "accolades/goalsBronzeGray.png";
        goalsSilver = "accolades/goalsSilverGray.png";
        goalsGold = "accolades/goalsGoldGray.png";
        accolades1 = "";
        accolades2 = "";        
        accolades3 = "";

        //Check for new records
        if (fitbitInfo.getDay().getCaloriesOut() > calories) {
            calories = fitbitInfo.getDay().getCaloriesOut();
        }

        if (fitbitInfo.getDay().getDistance() > distance) {
            distance = fitbitInfo.getDay().getDistance();
        }

        if (fitbitInfo.getDay().getFloors() > floors) {
            floors = fitbitInfo.getDay().getFloors();
        }

        if (fitbitInfo.getDay().getSteps() > steps) {
            steps = fitbitInfo.getDay().getSteps();
        }

        if (fitbitInfo.getDay().getActiveMins() > active) {
            active = fitbitInfo.getDay().getActiveMins();
        }

        if (fitbitInfo.getDay().getCaloriesOut() > goals) {
            goals = 10;
        }

        if (fitbitInfo.getDay().getCaloriesOut() > totalAccolades) {
            totalAccolades = 20;
        }
        
        //Update accolade icons based on records
        if (calories >= 1000){
            if (false == userConfig.isCaloriesAccoladeBronze()){
                userConfig.setCaloriesAccoladeBronze(true);
                userConfig.setCaloriesAccoladeBronzeDate(fitbitInfo.getDay().getDate());
                totalAccolades += 1;
            }
            caloriesBronze = "accolades/caloriesBronze.png";
            userConfig.setCaloriesAccoladeBronze(true);
            if (calories >= 2000){
                if (false == userConfig.isCaloriesAccoladeBronze()){
                userConfig.setCaloriesAccoladeSilver(true);
                userConfig.setCaloriesAccoladeSilverDate(fitbitInfo.getDay().getDate());
                totalAccolades += 1;
                }
                caloriesSilver = "accolades/caloriesSilver.png";
                if (calories >= 3000){
                    if (false == userConfig.isCaloriesAccoladeGold()){
                        userConfig.setCaloriesAccoladeGold(true);
                        userConfig.setCaloriesAccoladeSilverDate(fitbitInfo.getDay().getDate());
                        totalAccolades += 1;
                    }
                    caloriesGold = "accolades/caloriesGold.png";
                }
            }
        }
        
        if (distance >= 1.0){
            if (false == userConfig.isDistanceAccoladeBronze()){
                userConfig.setDistanceAccoladeBronze(true);
                userConfig.setDistanceAccoladeBronzeDate(fitbitInfo.getDay().getDate());
                totalAccolades += 1;
            }
            distanceBronze = "accolades/distanceBronze.png";
            if (distance >= 2.0){
                if (false == userConfig.isDistanceAccoladeSilver()){
                userConfig.setDistanceAccoladeSilver(true);
                userConfig.setDistanceAccoladeSilverDate(fitbitInfo.getDay().getDate());
                totalAccolades += 1;
                }
                distanceSilver = "accolades/distanceSilver.png";
                if (distance >= 3.0){
                    if (false == userConfig.isDistanceAccoladeGold()){
                        userConfig.setDistanceAccoladeGold(true);
                        userConfig.setDistanceAccoladeGoldDate(fitbitInfo.getDay().getDate());
                        totalAccolades += 1;
                    }
                    distanceGold = "accolades/distanceGold.png";
                }
            }
        }
        if (floors >= 5.0){
            if (false == userConfig.isFloorsAccoladeBronze()){
                userConfig.setFloorsAccoladeBronze(true);
                userConfig.setFloorsAccoladeBronzeDate(fitbitInfo.getDay().getDate());
                totalAccolades += 1;
            }
            floorsBronze = "accolades/floorsBronze.png";
            userConfig.setFloorsAccoladeBronze(true);
            if (floors >= 10.0){
                floorsSilver = "accolades/floorsSilver.png";
                userConfig.setFloorsAccoladeSilver(true);
                if (floors >= 15.0){
                    floorsGold = "accolades/floorsGold.png";
                    userConfig.setFloorsAccoladeGold(true);
                    totalAccolades += 1;
                }
            }
        }
        if (steps >= 100){
            stepsBronze = "accolades/stepsBronze.png";
            userConfig.setStepsAccoladeBronze(true);
            if (steps >= 250){
                stepsSilver = "accolades/stepsSilver.png";
                userConfig.setStepsAccoladeSilver(true);
                if (steps >= 500){
                    stepsGold = "accolades/stepsGold.png";
                    userConfig.setStepsAccoladeGold(true);
                    totalAccolades += 1;
                }
            }
        }
        if (active >= 30){
            activeBronze = "accolades/activeBronze.png";
            userConfig.setActiveAccoladeBronze(true);
            if (active >= 60){
                activeSilver = "accolades/activeSilver.png";
                userConfig.setActiveAccoladeSilver(true);
                if (active >= 90){
                    activeGold = "accolades/activeGold.png";
                    userConfig.setActiveAccoladeGold(true);
                    totalAccolades += 1;
                }
            }
        }
        
        if (goals >= 10){
            goalsBronze = "accolades/goalsBronze.png";
            userConfig.setGoalsAccoladeBronze(true);
            if (goals >= 25){
                goalsSilver = "accolades/goalsSilver.png";
                userConfig.setGoalsAccoladeSilver(true);
                if (goals >= 50){
                    goalsGold = "accolades/goalsGold.png";
                    userConfig.setGoalsAccoladeGold(true);
                    totalAccolades += 1;
                }
            }
        }
        
        if (totalAccolades >= 4){
            accolades1 = "accolades/goalsBronze.png";
            userConfig.setAccoladesAccoladeBronze(true);
            if (totalAccolades >= 9){
                accolades2 = "accolades/goalsSilver.png";
                userConfig.setAccoladesAccoladeSilver(true);
                if (totalAccolades >= 19){
                    accolades3 = "accolades/goalsGold.png";
                    userConfig.setAccoladesAccoladeGold(true);
                }
            }
        }

        //Panels for each data item
        caloriesBurnedData = new JLabel(calories + " Calories Burned (1000, 2000, 3000)");
        caloriesPanel = this.createDataBox(caloriesBurnedData, caloriesBronze, caloriesSilver, caloriesGold, new Color(255, 150, 150));
        caloriesPanel.setToolTipText("The amount of calories burned on the current day.");

        totalDistanceData = new JLabel(distance + " Distance Travelled (1 km, 2 km, 3 km)");
        distancePanel = this.createDataBox(totalDistanceData, distanceBronze, distanceSilver, distanceGold, new Color(200, 255, 200));
        distancePanel.setToolTipText("The total distance travelled on the current day.");

        floorsClimbedData = new JLabel(floors + " Floors Climbed (5, 10, 20)");
        floorsPanel = this.createDataBox(floorsClimbedData, floorsBronze, floorsSilver, floorsGold, new Color(255, 160, 255));
        floorsPanel.setToolTipText("The number of floors climbed on the current day.");

        stepsTakenData = new JLabel(steps + " Steps Taken (2000, 5000, 10000)");
        stepsPanel = this.createDataBox(stepsTakenData, stepsBronze, stepsSilver, stepsGold, new Color(250, 200, 160));
        stepsPanel.setToolTipText("The number of steps taken on the current day.");

        activeMinutesData = new JLabel(active + " Active Minutes (30 min, 60 min, 90 min)");
        activePanel = this.createDataBox(activeMinutesData, activeBronze, activeSilver, activeGold, new Color(250, 255, 150));
        activePanel.setToolTipText("The number of active minutes on the current day.");

        dailyGoalsData = new JLabel(goals + " Daily Goals Met (10, 25, 50)");
        goalsPanel = this.createDataBox(dailyGoalsData, goalsDate, goalsSilver, goalsGold, new Color(100, 255, 255));
        goalsPanel.setToolTipText("The number of daily goals met in the user's lifetime.");

        accoladesEarnedData = new JLabel(totalAccolades + " Gold Accolades Earned (25, 50, 100)");
        accoladesPanel = this.createDataBox(accoladesEarnedData, goalsBronze,goalsSilver, goalsGold, new Color(255, 204, 203));
        accoladesPanel.setToolTipText("The number of golden accolades earned in the user's lifetime.");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(caloriesPanel);
        this.add(Box.createVerticalStrut(2));
        this.add(distancePanel);
        this.add(Box.createVerticalStrut(2));
        this.add(floorsPanel);
        this.add(Box.createVerticalStrut(2));
        this.add(stepsPanel);
        this.add(Box.createVerticalStrut(2));
        this.add(activePanel);
        this.add(Box.createVerticalStrut(2));
        this.add(goalsPanel);
        this.add(Box.createVerticalStrut(2));
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
     * @param color the color of the data box
     * @param iconFile bronze accolade earned
     * @param iconFile2 silver accolade earned
     * @param iconFile3 gold accolade earned
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox(JLabel header, String iconFile, String iconFile2, String iconFile3, Color color) {
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
        return panel;
    }
}
