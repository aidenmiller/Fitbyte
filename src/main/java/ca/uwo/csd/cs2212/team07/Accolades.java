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

    private String caloriesDate1;
    private String caloriesDate2;
    private String caloriesDate3;
    private String distanceDate1;
    private String distanceDate2;
    private String distanceDate3;    
    private String activeDate1;
    private String activeDate2;
    private String activeDate3;
    private String stepsDate1;
    private String stepsDate2;
    private String stepsDate3;
    private String floorsDate1;
    private String floorsDate2;
    private String floorsDate3;
    private String goalsDate1;
    private String goalsDate2;
    private String goalsDate3;
    private String accoladesDate1;
    private String accoladesDate2;
    private String accoladesDate3;    

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
    private String accoladesBronze;
    private String accoladesSilver;
    private String accoladesGold;

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
        accoladesBronze = "";
        accoladesSilver = "";
        accoladesGold = "";

        caloriesDate1 = "Not yet achieved.";
        caloriesDate2 = "Not yet achieved.";
        caloriesDate3 = "Not yet achieved.";
        distanceDate1 = "Not yet achieved.";
        distanceDate2 = "Not yet achieved.";
        distanceDate3 = "Not yet achieved.";
        activeDate1 = "Not yet achieved.";
        activeDate2 = "Not yet achieved.";
        activeDate3 = "Not yet achieved.";
        stepsDate1 = "Not yet achieved.";
        stepsDate2 = "Not yet achieved.";
        stepsDate3 = "Not yet achieved.";
        floorsDate1 = "Not yet achieved.";
        floorsDate2 = "Not yet achieved.";
        floorsDate3 = "Not yet achieved.";
        goalsDate1 = "Not yet achieved.";
        goalsDate2 = "Not yet achieved.";
        goalsDate3 = "Not yet achieved.";
        accoladesDate1 = "Not yet achieved.";
        accoladesDate2 = "Not yet achieved.";
        accoladesDate3 = "Not yet achieved.";

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
        if (calories >= 1000) {
            if (false == userConfig.isCaloriesAccoladeBronze()) {
                caloriesDate1 = fitbitInfo.getDay().getDate();
                userConfig.setCaloriesAccoladeBronze(true);
                userConfig.setCaloriesAccoladeBronzeDate(caloriesDate1);
                totalAccolades += 1;
            }
            caloriesBronze = "accolades/caloriesBronze.png";
            userConfig.setCaloriesAccoladeBronze(true);
            if (calories >= 2000) {
                if (false == userConfig.isCaloriesAccoladeBronze()) {
                    caloriesDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setCaloriesAccoladeSilver(true);
                    userConfig.setCaloriesAccoladeSilverDate(caloriesDate2);
                    totalAccolades += 1;
                }
                caloriesSilver = "accolades/caloriesSilver.png";
                if (calories >= 3000) {
                    if (false == userConfig.isCaloriesAccoladeGold()) {
                        caloriesDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setCaloriesAccoladeGold(true);
                        userConfig.setCaloriesAccoladeSilverDate(caloriesDate3);
                        totalAccolades += 1;
                    }
                    caloriesGold = "accolades/caloriesGold.png";
                }
            }
        }

        if (distance >= 1.0) {
            if (false == userConfig.isDistanceAccoladeBronze()) {
                distanceDate1 = fitbitInfo.getDay().getDate();
                userConfig.setDistanceAccoladeBronze(true);
                userConfig.setDistanceAccoladeBronzeDate(distanceDate1);
                totalAccolades += 1;
            }
            distanceBronze = "accolades/distanceBronze.png";
            if (distance >= 2.0) {
                if (false == userConfig.isDistanceAccoladeSilver()) {
                    distanceDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setDistanceAccoladeSilver(true);
                    userConfig.setDistanceAccoladeSilverDate(distanceDate2);
                    totalAccolades += 1;
                }
                distanceSilver = "accolades/distanceSilver.png";
                if (distance >= 3.0) {
                    if (false == userConfig.isDistanceAccoladeGold()) {
                        distanceDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setDistanceAccoladeGold(true);
                        userConfig.setDistanceAccoladeGoldDate(distanceDate3);
                        totalAccolades += 1;
                    }
                    distanceGold = "accolades/distanceGold.png";
                }
            }
        }
        if (floors >= 5.0) {
            if (false == userConfig.isFloorsAccoladeBronze()) {
                floorsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setFloorsAccoladeBronze(true);
                userConfig.setFloorsAccoladeBronzeDate(floorsDate1);
                totalAccolades += 1;
            }
            floorsBronze = "accolades/floorsBronze.png";
            if (floors >= 10.0) {
                if (false == userConfig.isFloorsAccoladeSilver()) {
                    floorsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setFloorsAccoladeSilver(true);
                    userConfig.setFloorsAccoladeSilverDate(floorsDate2);
                    totalAccolades += 1;
                }
                floorsSilver = "accolades/floorsSilver.png";
                if (floors >= 15.0) {
                    if (false == userConfig.isFloorsAccoladeGold()) {
                        floorsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setFloorsAccoladeGold(true);
                        userConfig.setFloorsAccoladeGoldDate(floorsDate3);
                        totalAccolades += 1;
                    }
                    floorsGold = "accolades/floorsGold.png";
                }
            }
        }
        if (steps >= 2000) {
            if (false == userConfig.isStepsAccoladeBronze()) {
                stepsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setStepsAccoladeBronze(true);
                userConfig.setStepsAccoladeBronzeDate(stepsDate1);
                totalAccolades += 1;
            }
            stepsBronze = "accolades/stepsBronze.png";
            if (steps >= 5000) {
                if (false == userConfig.isStepsAccoladeSilver()) {
                    stepsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setStepsAccoladeSilver(true);
                    userConfig.setStepsAccoladeSilverDate(stepsDate2);
                    totalAccolades += 1;
                }
                stepsSilver = "accolades/stepsSilver.png";
                if (steps >= 10000) {
                    if (false == userConfig.isStepsAccoladeGold()) {
                        stepsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setStepsAccoladeGold(true);
                        userConfig.setStepsAccoladeGoldDate(stepsDate3);
                        totalAccolades += 1;
                    }
                    stepsGold = "accolades/stepsGold.png";
                }
            }
        }
        if (active >= 30.0) {
            if (false == userConfig.isActiveAccoladeBronze()) {
                activeDate1 = fitbitInfo.getDay().getDate();
                userConfig.setActiveAccoladeBronze(true);
                userConfig.setActiveAccoladeBronzeDate(activeDate1);
                totalAccolades += 1;
            }
            activeBronze = "accolades/activeBronze.png";
            if (active >= 60.0) {
                if (false == userConfig.isActiveAccoladeSilver()) {
                    activeDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setActiveAccoladeSilver(true);
                    userConfig.setActiveAccoladeSilverDate(activeDate2);
                    totalAccolades += 1;
                }
                activeSilver = "accolades/activeSilver.png";
                if (active >= 90.0) {
                    if (false == userConfig.isActiveAccoladeGold()) {
                        activeDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setActiveAccoladeGold(true);
                        userConfig.setActiveAccoladeGoldDate(activeDate3);
                        totalAccolades += 1;
                    }
                    activeGold = "accolades/activeGold.png";
                }
            }
        }

        if (goals >= 1) {
            if (false == userConfig.isGoalsAccoladeBronze()) {
                goalsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setGoalsAccoladeBronze(true);
                userConfig.setGoalsAccoladeBronzeDate(goalsDate1);
                totalAccolades += 1;
            }
            goalsBronze = "accolades/goalsBronze.png";
            if (goals >= 3) {
                if (false == userConfig.isGoalsAccoladeSilver()) {
                    goalsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setGoalsAccoladeSilver(true);
                    userConfig.setGoalsAccoladeSilverDate(goalsDate2);
                    totalAccolades += 1;
                }
                goalsSilver = "accolades/goalsSilver.png";
                if (goals >= 5) {
                    if (false == userConfig.isGoalsAccoladeGold()) {
                        goalsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setGoalsAccoladeGold(true);
                        userConfig.setGoalsAccoladeGoldDate(goalsDate3);
                        totalAccolades += 1;
                    }
                    goalsGold = "accolades/goalsGold.png";
                }
            }
        }

        if (totalAccolades >= 4) {
            if (false == userConfig.isAccoladesAccoladeBronze()) {
                accoladesDate1 = fitbitInfo.getDay().getDate();
                userConfig.setAccoladesAccoladeBronze(true);
                userConfig.setAccoladesAccoladeBronzeDate(accoladesDate1);
                totalAccolades += 1;
            }
            accoladesBronze = "accolades/goalsBronze.png";
            if (totalAccolades >= 9) {
                if (false == userConfig.isGoalsAccoladeSilver()) {
                    accoladesDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setGoalsAccoladeSilver(true);
                    userConfig.setGoalsAccoladeSilverDate(accoladesDate2);
                    totalAccolades += 1;
                }
                accoladesSilver = "accolades/goalsSilver.png";
                if (totalAccolades >= 19) {
                    if (false == userConfig.isGoalsAccoladeGold()) {
                        accoladesDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setGoalsAccoladeGold(true);
                        userConfig.setGoalsAccoladeGoldDate(accoladesDate3);
                        totalAccolades += 1;
                    }
                    accoladesGold = "accolades/goalsGold.png";
                }
            }
        }

        //Panels for each data item
        caloriesBurnedData = new JLabel(calories + " Calories Burned (1000, 2000, 3000)");
        ImageIcon calImage1 = new ImageIcon(FileReader.getImage(caloriesBronze));
        ImageIcon calImage2 = new ImageIcon(FileReader.getImage(caloriesSilver));
        ImageIcon calImage3 = new ImageIcon(FileReader.getImage(caloriesGold));
        JLabel calLabel1 = new JLabel(calImage1);
        calLabel1.setToolTipText("Achieved on: " + caloriesDate1);
        JLabel calLabel2 = new JLabel(calImage2);
        calLabel2.setToolTipText("Achieved on: " + caloriesDate2);
        JLabel calLabel3 = new JLabel(calImage3);
        calLabel3.setToolTipText("Achieved on: " + caloriesDate3);
        caloriesPanel = this.createDataBox(caloriesBurnedData, calLabel1, calLabel2, calLabel3, new Color(255, 150, 150));
        caloriesPanel.setToolTipText("The amount of calories burned on the current day.");

        totalDistanceData = new JLabel(distance + " Distance Travelled (1 km, 2 km, 3 km)");
        ImageIcon disImage1 = new ImageIcon(FileReader.getImage(distanceBronze));
        ImageIcon disImage2 = new ImageIcon(FileReader.getImage(distanceSilver));
        ImageIcon disImage3 = new ImageIcon(FileReader.getImage(distanceGold));
        JLabel disLabel1 = new JLabel(disImage1);
        disLabel1.setToolTipText("Achieved on: " + distanceDate1);
        JLabel disLabel2 = new JLabel(disImage2);
        disLabel2.setToolTipText("Achieved on: " + distanceDate2);
        JLabel disLabel3 = new JLabel(disImage3);
        disLabel3.setToolTipText("Achieved on: " + distanceDate3);
        distancePanel = this.createDataBox(totalDistanceData, disLabel1, disLabel2, disLabel3, new Color(200, 255, 200));
        distancePanel.setToolTipText("The total distance travelled on the current day.");

        floorsClimbedData = new JLabel(floors + " Floors Climbed (5, 10, 20)");
        ImageIcon flImage1 = new ImageIcon(FileReader.getImage(floorsBronze));
        ImageIcon flImage2 = new ImageIcon(FileReader.getImage(floorsSilver));
        ImageIcon flImage3 = new ImageIcon(FileReader.getImage(floorsGold));
        JLabel flLabel1 = new JLabel(flImage1);
        flLabel1.setToolTipText("Achieved on: " + floorsDate1);
        JLabel flLabel2 = new JLabel(flImage2);
        flLabel2.setToolTipText("Achieved on: " + floorsDate2);
        JLabel flLabel3 = new JLabel(flImage3);
        flLabel3.setToolTipText("Achieved on: " + floorsDate3);
        floorsPanel = this.createDataBox(floorsClimbedData, flLabel1, flLabel2, flLabel3, new Color(255, 160, 255));
        floorsPanel.setToolTipText("The number of floors climbed on the current day.");

        stepsTakenData = new JLabel(steps + " Steps Taken (2000, 5000, 10000)");
        ImageIcon stImage1 = new ImageIcon(FileReader.getImage(stepsBronze));
        ImageIcon stImage2 = new ImageIcon(FileReader.getImage(stepsSilver));
        ImageIcon stImage3 = new ImageIcon(FileReader.getImage(stepsGold));
        JLabel stLabel1 = new JLabel(stImage1);
        stLabel1.setToolTipText("Achieved on: " + stepsDate1);
        JLabel stLabel2 = new JLabel(stImage2);
        stLabel2.setToolTipText("Achieved on: " + stepsDate2);
        JLabel stLabel3 = new JLabel(stImage3);
        stLabel3.setToolTipText("Achieved on: " + stepsDate3);
        stepsPanel = this.createDataBox(stepsTakenData, stLabel1, stLabel2, stLabel3, new Color(250, 200, 160));
        stepsPanel.setToolTipText("The number of steps taken on the current day.");

        activeMinutesData = new JLabel(active + " Active Minutes (30 min, 60 min, 90 min)");
        ImageIcon actImage1 = new ImageIcon(FileReader.getImage(activeBronze));
        ImageIcon actImage2 = new ImageIcon(FileReader.getImage(activeSilver));
        ImageIcon actImage3 = new ImageIcon(FileReader.getImage(activeGold));
        JLabel actLabel1 = new JLabel(actImage1);
        actLabel1.setToolTipText("Achieved on: " + activeDate1);
        JLabel actLabel2 = new JLabel(actImage2);
        actLabel2.setToolTipText("Achieved on: " + activeDate2);
        JLabel actLabel3 = new JLabel(actImage3);
        actLabel3.setToolTipText("Achieved on: " + activeDate3);
        activePanel = this.createDataBox(activeMinutesData, actLabel1, actLabel2, actLabel3, new Color(250, 255, 150));
        activePanel.setToolTipText("The number of active minutes on the current day.");

        dailyGoalsData = new JLabel(goals + " Daily Goals Met (1, 2, 5)");
        ImageIcon goImage1 = new ImageIcon(FileReader.getImage(goalsBronze));
        ImageIcon goImage2 = new ImageIcon(FileReader.getImage(goalsSilver));
        ImageIcon goImage3 = new ImageIcon(FileReader.getImage(goalsGold));
        JLabel goLabel1 = new JLabel(goImage1);
        goLabel1.setToolTipText("Achieved on: " + goalsDate1);
        JLabel goLabel2 = new JLabel(goImage2);
        goLabel2.setToolTipText("Achieved on: " + goalsDate2);
        JLabel goLabel3 = new JLabel(goImage3);
        goLabel3.setToolTipText("Achieved on: " + goalsDate3);
        goalsPanel = this.createDataBox(dailyGoalsData, goLabel1, goLabel2, goLabel3, new Color(100, 255, 255));
        goalsPanel.setToolTipText("The number of daily goals met in the user's lifetime.");

        accoladesEarnedData = new JLabel(totalAccolades + " Total Accolades Earned (5, 10, 20)");
        ImageIcon acImage1 = new ImageIcon(FileReader.getImage(accoladesBronze));
        ImageIcon acImage2 = new ImageIcon(FileReader.getImage(accoladesSilver));
        ImageIcon acImage3 = new ImageIcon(FileReader.getImage(accoladesGold));
        JLabel acLabel1 = new JLabel(acImage1);
        acLabel1.setToolTipText("Achieved on: " + accoladesDate1);
        JLabel acLabel2 = new JLabel(acImage2);
        acLabel2.setToolTipText("Achieved on: " + accoladesDate2);
        JLabel acLabel3 = new JLabel(acImage3);
        acLabel3.setToolTipText("Achieved on: " + accoladesDate3);
        accoladesPanel = this.createDataBox(accoladesEarnedData, acLabel1, acLabel2, acLabel3, new Color(255, 204, 203));
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
    private JPanel createDataBox(JLabel header, JLabel iconLabel1, JLabel iconLabel2, JLabel iconLabel3, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalStrut(25));
        panel.add(iconLabel1);
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
