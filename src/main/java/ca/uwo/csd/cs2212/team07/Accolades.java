package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
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
    private final UserConfig userConfig;

    private JLabel stepsTakenData, caloriesBurnedData, totalDistanceData, floorsClimbedData, activeMinutesData, dailyGoalsData, accoladesEarnedData;

    private String caloriesDate1, caloriesDate2, caloriesDate3;
    private String distanceDate1, distanceDate2, distanceDate3;
    private String activeDate1, activeDate2, activeDate3;
    private String stepsDate1, stepsDate2, stepsDate3;
    private String floorsDate1, floorsDate2, floorsDate3;
    private String goalsDate1, goalsDate2, goalsDate3;
    private String accoladesDate1, accoladesDate2, accoladesDate3;

    private JPanel stepsPanel, caloriesPanel, distancePanel, floorsPanel, activePanel, goalsPanel, accoladesPanel;
    
    private JLabel calLabel1, calLabel2, calLabel3;
    private JLabel disLabel1, disLabel2, disLabel3;
    private JLabel flLabel1, flLabel2, flLabel3;
    private JLabel stLabel1, stLabel2, stLabel3;
    private JLabel actLabel1, actLabel2, actLabel3;
    private JLabel goLabel1, goLabel2, goLabel3;
    private JLabel acLabel1, acLabel2, acLabel3;
    
    private long calories, active, steps;
    private double distance, floors;
    private int goals, totalAccolades;

    private String caloriesBronze, caloriesSilver, caloriesGold;
    private String distanceBronze, distanceSilver, distanceGold;
    private String activeBronze, activeSilver, activeGold;
    private String stepsBronze, stepsSilver, stepsGold;
    private String floorsBronze, floorsSilver, floorsGold;
    private String goalsBronze, goalsSilver, goalsGold;
    private String accoladesBronze, accoladesSilver, accoladesGold;
    
    private ImageIcon calImage1, calImage2, calImage3;
    private ImageIcon disImage1, disImage2, disImage3;
    private ImageIcon flImage1, flImage2, flImage3;
    private ImageIcon stImage1, stImage2, stImage3;
    private ImageIcon actImage1, actImage2, actImage3;
    private ImageIcon goImage1, goImage2, goImage3;
    private ImageIcon acImage1, acImage2, acImage3;   

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

        //Background color
        this.setBackground(Color.white);
        
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
        accoladesBronze = "accolades/totalBronzeGray.png";
        accoladesSilver = "accolades/totalSilverGray.png";
        accoladesGold = "accolades/totalGoldGray.png";
        
        //Panels for each data item
        caloriesBurnedData = new JLabel(calories + " Calories Burned (1000, 2000, 3000)");
        calImage1 = new ImageIcon(FileReader.getImage(caloriesBronze));
        calImage2 = new ImageIcon(FileReader.getImage(caloriesSilver));
        calImage3 = new ImageIcon(FileReader.getImage(caloriesGold));
        calLabel1 = new JLabel(calImage1);
        calLabel1.setToolTipText("Achieved on: " + caloriesDate1);
        calLabel2 = new JLabel(calImage2);
        calLabel2.setToolTipText("Achieved on: " + caloriesDate2);
        calLabel3 = new JLabel(calImage3);
        calLabel3.setToolTipText("Achieved on: " + caloriesDate3);
        caloriesPanel = this.createDataBox(caloriesBurnedData, calLabel1, calLabel2, calLabel3, new Color(255, 150, 150));
        caloriesPanel.setToolTipText("The amount of calories burned on the current day.");

        totalDistanceData = new JLabel(distance + " Distance Travelled (1 km, 3 km, 5 km)");
        disImage1 = new ImageIcon(FileReader.getImage(distanceBronze));
        disImage2 = new ImageIcon(FileReader.getImage(distanceSilver));
        disImage3 = new ImageIcon(FileReader.getImage(distanceGold));
        disLabel1 = new JLabel(disImage1);
        disLabel1.setToolTipText("Achieved on: " + distanceDate1);
        disLabel2 = new JLabel(disImage2);
        disLabel2.setToolTipText("Achieved on: " + distanceDate2);
        disLabel3 = new JLabel(disImage3);
        disLabel3.setToolTipText("Achieved on: " + distanceDate3);
        distancePanel = this.createDataBox(totalDistanceData, disLabel1, disLabel2, disLabel3, new Color(200, 255, 200));
        distancePanel.setToolTipText("The total distance travelled on the current day.");

        floorsClimbedData = new JLabel(floors + " Floors Climbed (10, 20, 30)");
        flImage1 = new ImageIcon(FileReader.getImage(floorsBronze));
        flImage2 = new ImageIcon(FileReader.getImage(floorsSilver));
        flImage3 = new ImageIcon(FileReader.getImage(floorsGold));
        flLabel1 = new JLabel(flImage1);
        flLabel1.setToolTipText("Achieved on: " + floorsDate1);
        flLabel2 = new JLabel(flImage2);
        flLabel2.setToolTipText("Achieved on: " + floorsDate2);
        flLabel3 = new JLabel(flImage3);
        flLabel3.setToolTipText("Achieved on: " + floorsDate3);
        floorsPanel = this.createDataBox(floorsClimbedData, flLabel1, flLabel2, flLabel3, new Color(255, 160, 255));
        floorsPanel.setToolTipText("The number of floors climbed on the current day.");

        stepsTakenData = new JLabel(steps + " Steps Taken (2000, 5000, 10000)");
        stImage1 = new ImageIcon(FileReader.getImage(stepsBronze));
        stImage2 = new ImageIcon(FileReader.getImage(stepsSilver));
        stImage3 = new ImageIcon(FileReader.getImage(stepsGold));
        stLabel1 = new JLabel(stImage1);
        stLabel1.setToolTipText("Achieved on: " + stepsDate1);
        stLabel2 = new JLabel(stImage2);
        stLabel2.setToolTipText("Achieved on: " + stepsDate2);
        stLabel3 = new JLabel(stImage3);
        stLabel3.setToolTipText("Achieved on: " + stepsDate3);
        stepsPanel = this.createDataBox(stepsTakenData, stLabel1, stLabel2, stLabel3, new Color(250, 200, 160));
        stepsPanel.setToolTipText("The number of steps taken on the current day.");

        activeMinutesData = new JLabel(active + " Active Minutes (120 min, 180 min, 240 min)");
        actImage1 = new ImageIcon(FileReader.getImage(activeBronze));
        actImage2 = new ImageIcon(FileReader.getImage(activeSilver));
        actImage3 = new ImageIcon(FileReader.getImage(activeGold));
        actLabel1 = new JLabel(actImage1);
        actLabel1.setToolTipText("Achieved on: " + activeDate1);
        actLabel2 = new JLabel(actImage2);
        actLabel2.setToolTipText("Achieved on: " + activeDate2);
        actLabel3 = new JLabel(actImage3);
        actLabel3.setToolTipText("Achieved on: " + activeDate3);
        activePanel = this.createDataBox(activeMinutesData, actLabel1, actLabel2, actLabel3, new Color(250, 255, 150));
        activePanel.setToolTipText("The number of active minutes on the current day.");

        dailyGoalsData = new JLabel(goals + " Daily Goals Met (1, 3, 5)");
        goImage1 = new ImageIcon(FileReader.getImage(goalsBronze));
        goImage2 = new ImageIcon(FileReader.getImage(goalsSilver));
        goImage3 = new ImageIcon(FileReader.getImage(goalsGold));
        goLabel1 = new JLabel(goImage1);
        goLabel1.setToolTipText("Achieved on: " + goalsDate1);
        goLabel2 = new JLabel(goImage2);
        goLabel2.setToolTipText("Achieved on: " + goalsDate2);
        goLabel3 = new JLabel(goImage3);
        goLabel3.setToolTipText("Achieved on: " + goalsDate3);
        goalsPanel = this.createDataBox(dailyGoalsData, goLabel1, goLabel2, goLabel3, new Color(100, 255, 255));
        goalsPanel.setToolTipText("The number of daily goals met in the current day.");

        accoladesEarnedData = new JLabel(totalAccolades + " Total Accolades Earned (5, 10, 20)");
        acImage1 = new ImageIcon(FileReader.getImage(accoladesBronze));
        acImage2 = new ImageIcon(FileReader.getImage(accoladesSilver));
        acImage3 = new ImageIcon(FileReader.getImage(accoladesGold));
        acLabel1 = new JLabel(acImage1);
        acLabel1.setToolTipText("Achieved on: " + accoladesDate1);
        acLabel2 = new JLabel(acImage2);
        acLabel2.setToolTipText("Achieved on: " + accoladesDate2);
        acLabel3 = new JLabel(acImage3);
        acLabel3.setToolTipText("Achieved on: " + accoladesDate3);
        accoladesPanel = this.createDataBox(accoladesEarnedData, acLabel1, acLabel2, acLabel3, new Color(255, 204, 203));
        accoladesPanel.setToolTipText("The number of accolades earned in the user's lifetime.");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(caloriesPanel);
        this.add(distancePanel);
        this.add(floorsPanel);
        this.add(stepsPanel);
        this.add(activePanel);
        this.add(goalsPanel);
        this.add(accoladesPanel);
        
        this.refresh();        
    }

    /**
     * Refresh the data displayed to the user
     */
    public void refresh() {
        //this method is called by MainWindow as soon as program launches (therefore you do not need to set any values in initUI, just init JPanels and layouts and stuff)
        //this method is called by MainWindow whenever the refresh button is pressed
        //Refreshing any data relevant to FitbitInfo
        //Refreshing UI elements (updating trophy icons, setting dates, etc)
        
        this.refreshConfig();
        
        //Check for new records
        calories = fitbitInfo.getDay().getCaloriesOut();
        distance = fitbitInfo.getDay().getDistance();
        floors = fitbitInfo.getDay().getFloors();
        steps = fitbitInfo.getDay().getSteps();
        active = fitbitInfo.getDay().getActiveMins();
        goals = userConfig.getGoalsComplete();
        totalAccolades = userConfig.getAccoladesComplete();  
        
        //Update accolade icons based on records
        if (calories >= 1000) {
            if (false == userConfig.isCaloriesAccoladeBronze()) {
                caloriesDate1 = fitbitInfo.getDay().getDate();
                userConfig.setCaloriesAccoladeBronze(true);
                userConfig.setCaloriesAccoladeBronzeDate(caloriesDate1);
                userConfig.incAccoladesComplete();
            }
            if (calories >= 2000) {
                if (false == userConfig.isCaloriesAccoladeSilver()) {
                    caloriesDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setCaloriesAccoladeSilver(true);
                    userConfig.setCaloriesAccoladeSilverDate(caloriesDate2);
                    userConfig.incAccoladesComplete();
                }
                if (calories >= 3000) {
                    if (false == userConfig.isCaloriesAccoladeGold()) {
                        caloriesDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setCaloriesAccoladeGold(true);
                        userConfig.setCaloriesAccoladeGoldDate(caloriesDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }

        if (distance >= 1.0) {
            if (false == userConfig.isDistanceAccoladeBronze()) {
                distanceDate1 = fitbitInfo.getDay().getDate();
                userConfig.setDistanceAccoladeBronze(true);
                userConfig.setDistanceAccoladeBronzeDate(distanceDate1);
                userConfig.incAccoladesComplete();
            }
            if (distance >= 3.0) {
                if (false == userConfig.isDistanceAccoladeSilver()) {
                    distanceDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setDistanceAccoladeSilver(true);
                    userConfig.setDistanceAccoladeSilverDate(distanceDate2);
                    userConfig.incAccoladesComplete();
                }
                if (distance >= 5.0) {
                    if (false == userConfig.isDistanceAccoladeGold()) {
                        distanceDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setDistanceAccoladeGold(true);
                        userConfig.setDistanceAccoladeGoldDate(distanceDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (floors >= 10.0) {
            if (false == userConfig.isFloorsAccoladeBronze()) {
                floorsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setFloorsAccoladeBronze(true);
                userConfig.setFloorsAccoladeBronzeDate(floorsDate1);
                userConfig.incAccoladesComplete();
            }
            if (floors >= 20.0) {
                if (false == userConfig.isFloorsAccoladeSilver()) {
                    floorsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setFloorsAccoladeSilver(true);
                    userConfig.setFloorsAccoladeSilverDate(floorsDate2);
                    userConfig.incAccoladesComplete();
                }
                if (floors >= 30.0) {
                    if (false == userConfig.isFloorsAccoladeGold()) {
                        floorsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setFloorsAccoladeGold(true);
                        userConfig.setFloorsAccoladeGoldDate(floorsDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (steps >= 2000) {
            if (false == userConfig.isStepsAccoladeBronze()) {
                stepsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setStepsAccoladeBronze(true);
                userConfig.setStepsAccoladeBronzeDate(stepsDate1);
                userConfig.incAccoladesComplete();
            }
            if (steps >= 5000) {
                if (false == userConfig.isStepsAccoladeSilver()) {
                    stepsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setStepsAccoladeSilver(true);
                    userConfig.setStepsAccoladeSilverDate(stepsDate2);
                    userConfig.incAccoladesComplete();
                }
                if (steps >= 10000) {
                    if (false == userConfig.isStepsAccoladeGold()) {
                        stepsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setStepsAccoladeGold(true);
                        userConfig.setStepsAccoladeGoldDate(stepsDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (active >= 120.0) {
            if (false == userConfig.isActiveAccoladeBronze()) {
                activeDate1 = fitbitInfo.getDay().getDate();
                userConfig.setActiveAccoladeBronze(true);
                userConfig.setActiveAccoladeBronzeDate(activeDate1);
                userConfig.incAccoladesComplete();
            }
            if (active >= 180.0) {
                if (false == userConfig.isActiveAccoladeSilver()) {
                    activeDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setActiveAccoladeSilver(true);
                    userConfig.setActiveAccoladeSilverDate(activeDate2);
                    userConfig.incAccoladesComplete();
                }
                if (active >= 240.0) {
                    if (false == userConfig.isActiveAccoladeGold()) {
                        activeDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setActiveAccoladeGold(true);
                        userConfig.setActiveAccoladeGoldDate(activeDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }

        if (goals >= 1) {
            if (false == userConfig.isGoalsAccoladeBronze()) {
                goalsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setGoalsAccoladeBronze(true);
                userConfig.setGoalsAccoladeBronzeDate(goalsDate1);
                userConfig.incAccoladesComplete();
            }
            if (goals >= 3) {
                if (false == userConfig.isGoalsAccoladeSilver()) {
                    goalsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setGoalsAccoladeSilver(true);
                    userConfig.setGoalsAccoladeSilverDate(goalsDate2);
                    userConfig.incAccoladesComplete();
                }
                if (goals >= 5) {
                    if (false == userConfig.isGoalsAccoladeGold()) {
                        goalsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setGoalsAccoladeGold(true);
                        userConfig.setGoalsAccoladeGoldDate(goalsDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        
        totalAccolades = userConfig.getAccoladesComplete(); 
        if (totalAccolades >= 5) {
            if (false == userConfig.isAccoladesAccoladeBronze()) {
                accoladesDate1 = fitbitInfo.getDay().getDate();
                userConfig.setAccoladesAccoladeBronze(true);
                userConfig.setAccoladesAccoladeBronzeDate(accoladesDate1);
                userConfig.incAccoladesComplete();
            }
            totalAccolades = userConfig.getAccoladesComplete();
            if (totalAccolades >= 10) {
                if (false == userConfig.isAccoladesAccoladeSilver()) {
                    accoladesDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setAccoladesAccoladeSilver(true);
                    userConfig.setAccoladesAccoladeSilverDate(accoladesDate2);
                    userConfig.incAccoladesComplete();
                }
                totalAccolades = userConfig.getAccoladesComplete();
                if (totalAccolades >= 20) {
                    if (false == userConfig.isAccoladesAccoladeGold()) {
                        accoladesDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setAccoladesAccoladeGold(true);
                        userConfig.setAccoladesAccoladeGoldDate(accoladesDate3);
                        userConfig.incAccoladesComplete();
                    }
                    totalAccolades = userConfig.getAccoladesComplete();
                }
            }
        }
        
        //Update which trophies to display based on stored information in userConfig
        //Calories
        if (true == userConfig.isCaloriesAccoladeBronze()) {
            caloriesBronze = "accolades/caloriesBronze.png";
        }
        if (true == userConfig.isCaloriesAccoladeSilver()) {
            caloriesSilver = "accolades/caloriesSilver.png";
        }
        if (true == userConfig.isCaloriesAccoladeGold()) {
            caloriesGold = "accolades/caloriesGold.png";
        }
        //Distance
        if (true == userConfig.isDistanceAccoladeBronze()) {
            distanceBronze = "accolades/distanceBronze.png";
        }
        if (true == userConfig.isDistanceAccoladeSilver()) {
            distanceSilver = "accolades/distanceSilver.png";
        }
        if (true == userConfig.isDistanceAccoladeGold()) {
            distanceGold = "accolades/distanceGold.png";
        }

        //Active
        if (true == userConfig.isActiveAccoladeBronze()) {
            activeBronze = "accolades/activeBronze.png";
        }
        if (true == userConfig.isActiveAccoladeSilver()) {
            activeSilver = "accolades/activeSilver.png";
        }
        if (true == userConfig.isActiveAccoladeGold()) {
            activeGold = "accolades/activeGold.png";
        }

        //Steps
        if (true == userConfig.isStepsAccoladeBronze()) {
            stepsBronze = "accolades/stepsBronze.png";
        }
        if (true == userConfig.isStepsAccoladeSilver()) {
            stepsSilver = "accolades/stepsSilver.png";
        }
        if (true == userConfig.isStepsAccoladeGold()) {
            stepsGold = "accolades/stepsGold.png";
        }

        //Floors
        if (true == userConfig.isFloorsAccoladeBronze()) {
            floorsBronze = "accolades/floorsBronze.png";
        }
        if (true == userConfig.isFloorsAccoladeSilver()) {
            floorsSilver = "accolades/floorsSilver.png";
        }
        if (true == userConfig.isFloorsAccoladeGold()) {
            floorsGold = "accolades/floorsGold.png";
        }

        //Goals
        if (true == userConfig.isGoalsAccoladeBronze()) {
            goalsBronze = "accolades/goalsBronze.png";
        }
        if (true == userConfig.isGoalsAccoladeSilver()) {
            goalsSilver = "accolades/goalsSilver.png";
        }
        if (true == userConfig.isGoalsAccoladeGold()) {
            goalsGold = "accolades/goalsGold.png";
        }

        //Accolades
        if (true == userConfig.isAccoladesAccoladeBronze()) {
            accoladesBronze = "accolades/totalBronze.png";
        }
        if (true == userConfig.isAccoladesAccoladeSilver()) {
            accoladesSilver = "accolades/totalSilver.png";
        }
        if (true == userConfig.isAccoladesAccoladeGold()) {
            accoladesGold = "accolades/totalGold.png";
        }
        
        //Update labels with refreshed information
        caloriesBurnedData.setText(calories + " Calories Burned (1000, 2000, 3000)");
        calImage1 = new ImageIcon(FileReader.getImage(caloriesBronze));
        calImage2 = new ImageIcon(FileReader.getImage(caloriesSilver));
        calImage3 = new ImageIcon(FileReader.getImage(caloriesGold));
        calLabel1.setIcon(calImage1);
        calLabel1.setToolTipText("Achieved on: " + userConfig.getCaloriesAccoladeBronzeDate());
        calLabel2.setIcon(calImage2);
        calLabel2.setToolTipText("Achieved on: " + userConfig.getCaloriesAccoladeSilverDate());
        calLabel3.setIcon(calImage3);
        calLabel3.setToolTipText("Achieved on: " + userConfig.getCaloriesAccoladeGoldDate());

        
        totalDistanceData.setText(distance + " Distance Travelled (1 km, 3 km, 5 km)");
        disImage1 = new ImageIcon(FileReader.getImage(distanceBronze));
        disImage2 = new ImageIcon(FileReader.getImage(distanceSilver));
        disImage3 = new ImageIcon(FileReader.getImage(distanceGold));
        disLabel1.setIcon(disImage1);
        disLabel1.setToolTipText("Achieved on: " + userConfig.getDistanceAccoladeBronzeDate());
        disLabel2.setIcon(disImage2);
        disLabel2.setToolTipText("Achieved on: " + userConfig.getCaloriesAccoladeSilverDate());
        disLabel3.setIcon(disImage3);
        disLabel3.setToolTipText("Achieved on: " + userConfig.getCaloriesAccoladeGoldDate());

        floorsClimbedData.setText(floors + " Floors Climbed (10, 20, 30)");
        flImage1 = new ImageIcon(FileReader.getImage(floorsBronze));
        flImage2 = new ImageIcon(FileReader.getImage(floorsSilver));
        flImage3 = new ImageIcon(FileReader.getImage(floorsGold));
        flLabel1.setIcon(flImage1);
        flLabel1.setToolTipText("Achieved on: " + userConfig.getFloorsAccoladeBronzeDate());
        flLabel2.setIcon(flImage2);
        flLabel2.setToolTipText("Achieved on: " + userConfig.getFloorsAccoladeSilverDate());
        flLabel3.setIcon(flImage3);
        flLabel3.setToolTipText("Achieved on: " + userConfig.getFloorsAccoladeGoldDate());

        stepsTakenData.setText(steps + " Steps Taken (2000, 5000, 10000)");
        stImage1 = new ImageIcon(FileReader.getImage(stepsBronze));
        stImage2 = new ImageIcon(FileReader.getImage(stepsSilver));
        stImage3 = new ImageIcon(FileReader.getImage(stepsGold));
        stLabel1.setIcon(stImage1);
        stLabel1.setToolTipText("Achieved on: " + userConfig.getStepsAccoladeBronzeDate());
        stLabel2.setIcon(stImage2);
        stLabel2.setToolTipText("Achieved on: " + userConfig.getStepsAccoladeSilverDate());
        stLabel3.setIcon(stImage3);
        stLabel3.setToolTipText("Achieved on: " + userConfig.getStepsAccoladeGoldDate());

        activeMinutesData.setText(active + " Active Minutes (120 min, 180 min, 240 min)");
        actImage1 = new ImageIcon(FileReader.getImage(activeBronze));
        actImage2 = new ImageIcon(FileReader.getImage(activeSilver));
        actImage3 = new ImageIcon(FileReader.getImage(activeGold));
        actLabel1.setIcon(actImage1);
        actLabel1.setToolTipText("Achieved on: " + userConfig.getActiveAccoladeBronzeDate());
        actLabel2.setIcon(actImage2);
        actLabel2.setToolTipText("Achieved on: " + userConfig.getActiveAccoladeSilverDate());
        actLabel3.setIcon(actImage3);
        actLabel3.setToolTipText("Achieved on: " + userConfig.getActiveAccoladeGoldDate());

        dailyGoalsData.setText(goals + " Daily Goals Met (1, 3, 5)");
        goImage1 = new ImageIcon(FileReader.getImage(goalsBronze));
        goImage2 = new ImageIcon(FileReader.getImage(goalsSilver));
        goImage3 = new ImageIcon(FileReader.getImage(goalsGold));
        goLabel1.setIcon(goImage1);
        goLabel1.setToolTipText("Achieved on: " + userConfig.getGoalsAccoladeBronzeDate());
        goLabel2.setIcon(goImage2);
        goLabel2.setToolTipText("Achieved on: " + userConfig.getGoalsAccoladeSilverDate());
        goLabel3.setIcon(goImage3);
        goLabel3.setToolTipText("Achieved on: " + userConfig.getGoalsAccoladeGoldDate());

        accoladesEarnedData.setText(totalAccolades + " Total Accolades Earned (5, 10, 20)");
        acImage1 = new ImageIcon(FileReader.getImage(accoladesBronze));
        acImage2 = new ImageIcon(FileReader.getImage(accoladesSilver));
        acImage3 = new ImageIcon(FileReader.getImage(accoladesGold));
        acLabel1.setIcon(acImage1);
        acLabel1.setToolTipText("Achieved on: " + userConfig.getAccoladesAccoladeBronzeDate());
        acLabel2.setIcon(acImage2);
        acLabel2.setToolTipText("Achieved on: " + userConfig.getAccoladesAccoladeSilverDate());
        acLabel3.setIcon(acImage3);
        acLabel3.setToolTipText("Achieved on: " + userConfig.getAccoladesAccoladeGoldDate());
    }

    public void refreshConfig() {
        //Refreshing any data relevant to UserConfig - (ex. if isCaloriesData is false, then Calories Accolades panel should not be visible)
        caloriesPanel.setVisible(userConfig.isCaloriesData());
        distancePanel.setVisible(userConfig.isDistanceData());
        floorsPanel.setVisible(userConfig.isFloorsData());
        stepsPanel.setVisible(userConfig.isStepsData());
        activePanel.setVisible(userConfig.isActiveData());
        if (userConfig.isCaloriesData() == false && userConfig.isDistanceData() == false && userConfig.isFloorsData() == false && userConfig.isStepsData() == false && userConfig.isActiveData() == false){
            goalsPanel.setVisible(false);
            accoladesPanel.setVisible(false);
        }
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
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel2);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel3);
        panel.add(Box.createHorizontalStrut(100));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        return panel;
    }
}
