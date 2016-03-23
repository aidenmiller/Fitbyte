package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.Font;
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
     * Constructor for the Accolades class
     *
     * @param fitbitInfo Container for user data
     * @param userConfig Container that holds user configuration through program
     * launches
     */
    public Accolades(FitbitInfo fitbitInfo, UserConfig userConfig) {
        super();
        this.fitbitInfo = fitbitInfo;
        this.userConfig = userConfig;
        initPanel();
    }

    /**
     * Initializes the UI panel for the accolades
     */
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
        caloriesBurnedData = new JLabel("Calories Burned (1000 cal, 2000 cal, 3000 cal)");
        calImage1 = new ImageIcon(FileReader.getImage(caloriesBronze));
        calImage2 = new ImageIcon(FileReader.getImage(caloriesSilver));
        calImage3 = new ImageIcon(FileReader.getImage(caloriesGold));
        calLabel1 = new JLabel(calImage1);
        calLabel1.setToolTipText("Not yet achieved");
        calLabel2 = new JLabel(calImage2);
        calLabel2.setToolTipText("Not yet achieved");
        calLabel3 = new JLabel(calImage3);
        calLabel3.setToolTipText("Not yet achieved");
        caloriesPanel = this.createDataBox(caloriesBurnedData, calLabel1, calLabel2, calLabel3, new Color(255, 175, 175));

        totalDistanceData = new JLabel("Distance Travelled (1 km , 3 km, 5 km)");
        disImage1 = new ImageIcon(FileReader.getImage(distanceBronze));
        disImage2 = new ImageIcon(FileReader.getImage(distanceSilver));
        disImage3 = new ImageIcon(FileReader.getImage(distanceGold));
        disLabel1 = new JLabel(disImage1);
        disLabel1.setToolTipText("Not yet achieved");
        disLabel2 = new JLabel(disImage2);
        disLabel2.setToolTipText("Not yet achieved");
        disLabel3 = new JLabel(disImage3);
        disLabel3.setToolTipText("Not yet achieved");
        distancePanel = this.createDataBox(totalDistanceData, disLabel1, disLabel2, disLabel3, new Color(180, 255, 190));

        floorsClimbedData = new JLabel("Floors Climbed (10 floors, 20 floors, 30 floors)");
        flImage1 = new ImageIcon(FileReader.getImage(floorsBronze));
        flImage2 = new ImageIcon(FileReader.getImage(floorsSilver));
        flImage3 = new ImageIcon(FileReader.getImage(floorsGold));
        flLabel1 = new JLabel(flImage1);
        flLabel1.setToolTipText("Not yet achieved");
        flLabel2 = new JLabel(flImage2);
        flLabel2.setToolTipText("Not yet achieved");
        flLabel3 = new JLabel(flImage3);
        flLabel3.setToolTipText("Not yet achieved");
        floorsPanel = this.createDataBox(floorsClimbedData, flLabel1, flLabel2, flLabel3, new Color(255, 220, 180));

        stepsTakenData = new JLabel("Steps Taken (2000 steps, 5000 steps, 10000 steps)");
        stImage1 = new ImageIcon(FileReader.getImage(stepsBronze));
        stImage2 = new ImageIcon(FileReader.getImage(stepsSilver));
        stImage3 = new ImageIcon(FileReader.getImage(stepsGold));
        stLabel1 = new JLabel(stImage1);
        stLabel1.setToolTipText("Not yet achieved");
        stLabel2 = new JLabel(stImage2);
        stLabel2.setToolTipText("Not yet achieved");
        stLabel3 = new JLabel(stImage3);
        stLabel3.setToolTipText("Not yet achieved");
        stepsPanel = this.createDataBox(stepsTakenData, stLabel1, stLabel2, stLabel3, new Color(180, 250, 255));

        activeMinutesData = new JLabel("Active Minutes (120 mins, 180 mins, 240 mins)");
        actImage1 = new ImageIcon(FileReader.getImage(activeBronze));
        actImage2 = new ImageIcon(FileReader.getImage(activeSilver));
        actImage3 = new ImageIcon(FileReader.getImage(activeGold));
        actLabel1 = new JLabel(actImage1);
        actLabel1.setToolTipText("Not yet achieved");
        actLabel2 = new JLabel(actImage2);
        actLabel2.setToolTipText("Not yet achieved");
        actLabel3 = new JLabel(actImage3);
        actLabel3.setToolTipText("Not yet achieved");
        activePanel = this.createDataBox(activeMinutesData, actLabel1, actLabel2, actLabel3, new Color(250, 255, 180));

        dailyGoalsData = new JLabel("Daily Goals Met (1 goal, 3 goals, 5 goals)");
        goImage1 = new ImageIcon(FileReader.getImage(goalsBronze));
        goImage2 = new ImageIcon(FileReader.getImage(goalsSilver));
        goImage3 = new ImageIcon(FileReader.getImage(goalsGold));
        goLabel1 = new JLabel(goImage1);
        goLabel1.setToolTipText("Not yet achieved");
        goLabel2 = new JLabel(goImage2);
        goLabel2.setToolTipText("Not yet achieved");
        goLabel3 = new JLabel(goImage3);
        goLabel3.setToolTipText("Not yet achieved");
        goalsPanel = this.createDataBox(dailyGoalsData, goLabel1, goLabel2, goLabel3, new Color(160, 245, 185));

        accoladesEarnedData = new JLabel("Total Accolades Earned (5 accolades, 10 accolades, 20 accolades)");
        acImage1 = new ImageIcon(FileReader.getImage(accoladesBronze));
        acImage2 = new ImageIcon(FileReader.getImage(accoladesSilver));
        acImage3 = new ImageIcon(FileReader.getImage(accoladesGold));
        acLabel1 = new JLabel(acImage1);
        acLabel1.setToolTipText("Not yet achieved");
        acLabel2 = new JLabel(acImage2);
        acLabel2.setToolTipText("Not yet achieved");
        acLabel3 = new JLabel(acImage3);
        acLabel3.setToolTipText("Not yet achieved");
        accoladesPanel = this.createDataBox(accoladesEarnedData, acLabel1, acLabel2, acLabel3, new Color(255, 200, 250));

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
     * Refreshes the data displayed to the user
     */
    public void refresh() {

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
                String caloriesDate1 = fitbitInfo.getDay().getDate();
                userConfig.setCaloriesAccoladeBronze(true);
                userConfig.setCaloriesAccoladeBronzeDate("Achieved on: " + caloriesDate1);
                userConfig.incAccoladesComplete();
            }
            if (calories >= 2000) {
                if (false == userConfig.isCaloriesAccoladeSilver()) {
                    String caloriesDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setCaloriesAccoladeSilver(true);
                    userConfig.setCaloriesAccoladeSilverDate("Achieved on: " + caloriesDate2);
                    userConfig.incAccoladesComplete();
                }
                if (calories >= 3000) {
                    if (false == userConfig.isCaloriesAccoladeGold()) {
                        String caloriesDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setCaloriesAccoladeGold(true);
                        userConfig.setCaloriesAccoladeGoldDate("Achieved on: " + caloriesDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (distance >= 1.0) {
            if (false == userConfig.isDistanceAccoladeBronze()) {
                String distanceDate1 = fitbitInfo.getDay().getDate();
                userConfig.setDistanceAccoladeBronze(true);
                userConfig.setDistanceAccoladeBronzeDate(distanceDate1);
                userConfig.incAccoladesComplete();
            }
            if (distance >= 3.0) {
                if (false == userConfig.isDistanceAccoladeSilver()) {
                    String distanceDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setDistanceAccoladeSilver(true);
                    userConfig.setDistanceAccoladeSilverDate("Achieved on: " + distanceDate2);
                    userConfig.incAccoladesComplete();
                }
                if (distance >= 5.0) {
                    if (false == userConfig.isDistanceAccoladeGold()) {
                        String distanceDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setDistanceAccoladeGold(true);
                        userConfig.setDistanceAccoladeGoldDate("Achieved on: " + distanceDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (floors >= 10.0) {
            if (false == userConfig.isFloorsAccoladeBronze()) {
                String floorsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setFloorsAccoladeBronze(true);
                userConfig.setFloorsAccoladeBronzeDate("Achieved on: " + floorsDate1);
                userConfig.incAccoladesComplete();
            }
            if (floors >= 20.0) {
                if (false == userConfig.isFloorsAccoladeSilver()) {
                    String floorsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setFloorsAccoladeSilver(true);
                    userConfig.setFloorsAccoladeSilverDate("Achieved on: " + floorsDate2);
                    userConfig.incAccoladesComplete();
                }
                if (floors >= 30.0) {
                    if (false == userConfig.isFloorsAccoladeGold()) {
                        String floorsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setFloorsAccoladeGold(true);
                        userConfig.setFloorsAccoladeGoldDate("Achieved on: " + floorsDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (steps >= 2000) {
            if (false == userConfig.isStepsAccoladeBronze()) {
                String stepsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setStepsAccoladeBronze(true);
                userConfig.setStepsAccoladeBronzeDate("Achieved on: " + stepsDate1);
                userConfig.incAccoladesComplete();
            }
            if (steps >= 5000) {
                if (false == userConfig.isStepsAccoladeSilver()) {
                    String stepsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setStepsAccoladeSilver(true);
                    userConfig.setStepsAccoladeSilverDate("Achieved on: " + stepsDate2);
                    userConfig.incAccoladesComplete();
                }
                if (steps >= 10000) {
                    if (false == userConfig.isStepsAccoladeGold()) {
                        String stepsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setStepsAccoladeGold(true);
                        userConfig.setStepsAccoladeGoldDate("Achieved on: " + stepsDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (active >= 120.0) {
            if (false == userConfig.isActiveAccoladeBronze()) {
                String activeDate1 = fitbitInfo.getDay().getDate();
                userConfig.setActiveAccoladeBronze(true);
                userConfig.setActiveAccoladeBronzeDate("Achieved on: " + activeDate1);
                userConfig.incAccoladesComplete();
            }
            if (active >= 180.0) {
                if (false == userConfig.isActiveAccoladeSilver()) {
                    String activeDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setActiveAccoladeSilver(true);
                    userConfig.setActiveAccoladeSilverDate("Achieved on: " + activeDate2);
                    userConfig.incAccoladesComplete();
                }
                if (active >= 240.0) {
                    if (false == userConfig.isActiveAccoladeGold()) {
                        String activeDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setActiveAccoladeGold(true);
                        userConfig.setActiveAccoladeGoldDate("Achieved on: " + activeDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        if (goals >= 1) {
            if (false == userConfig.isGoalsAccoladeBronze()) {
                String goalsDate1 = fitbitInfo.getDay().getDate();
                userConfig.setGoalsAccoladeBronze(true);
                userConfig.setGoalsAccoladeBronzeDate("Achieved on: " + goalsDate1);
                userConfig.incAccoladesComplete();
            }
            if (goals >= 3) {
                if (false == userConfig.isGoalsAccoladeSilver()) {
                    String goalsDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setGoalsAccoladeSilver(true);
                    userConfig.setGoalsAccoladeSilverDate("Achieved on: " + goalsDate2);
                    userConfig.incAccoladesComplete();
                }
                if (goals >= 5) {
                    if (false == userConfig.isGoalsAccoladeGold()) {
                        String goalsDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setGoalsAccoladeGold(true);
                        userConfig.setGoalsAccoladeGoldDate("Achieved on: " + goalsDate3);
                        userConfig.incAccoladesComplete();
                    }
                }
            }
        }
        totalAccolades = userConfig.getAccoladesComplete();
        if (totalAccolades >= 5) {
            if (false == userConfig.isAccoladesAccoladeBronze()) {
                String accoladesDate1 = fitbitInfo.getDay().getDate();
                userConfig.setAccoladesAccoladeBronze(true);
                userConfig.setAccoladesAccoladeBronzeDate("Achieved on: " + accoladesDate1);
                userConfig.incAccoladesComplete();
            }
            totalAccolades = userConfig.getAccoladesComplete();
            if (totalAccolades >= 10) {
                if (false == userConfig.isAccoladesAccoladeSilver()) {
                    String accoladesDate2 = fitbitInfo.getDay().getDate();
                    userConfig.setAccoladesAccoladeSilver(true);
                    userConfig.setAccoladesAccoladeSilverDate("Achieved on: " + accoladesDate2);
                    userConfig.incAccoladesComplete();
                }
                totalAccolades = userConfig.getAccoladesComplete();
                if (totalAccolades >= 20) {
                    if (false == userConfig.isAccoladesAccoladeGold()) {
                        String accoladesDate3 = fitbitInfo.getDay().getDate();
                        userConfig.setAccoladesAccoladeGold(true);
                        userConfig.setAccoladesAccoladeGoldDate("Achieved on: " + accoladesDate3);
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
        calImage1 = new ImageIcon(FileReader.getImage(caloriesBronze));
        calImage2 = new ImageIcon(FileReader.getImage(caloriesSilver));
        calImage3 = new ImageIcon(FileReader.getImage(caloriesGold));
        calLabel1.setIcon(calImage1);
        calLabel1.setToolTipText(userConfig.getCaloriesAccoladeBronzeDate());
        calLabel2.setIcon(calImage2);
        calLabel2.setToolTipText(userConfig.getCaloriesAccoladeSilverDate());
        calLabel3.setIcon(calImage3);
        calLabel3.setToolTipText(userConfig.getCaloriesAccoladeGoldDate());

        disImage1 = new ImageIcon(FileReader.getImage(distanceBronze));
        disImage2 = new ImageIcon(FileReader.getImage(distanceSilver));
        disImage3 = new ImageIcon(FileReader.getImage(distanceGold));
        disLabel1.setIcon(disImage1);
        disLabel1.setToolTipText(userConfig.getDistanceAccoladeBronzeDate());
        disLabel2.setIcon(disImage2);
        disLabel2.setToolTipText(userConfig.getDistanceAccoladeSilverDate());
        disLabel3.setIcon(disImage3);
        disLabel3.setToolTipText(userConfig.getDistanceAccoladeGoldDate());

        flImage1 = new ImageIcon(FileReader.getImage(floorsBronze));
        flImage2 = new ImageIcon(FileReader.getImage(floorsSilver));
        flImage3 = new ImageIcon(FileReader.getImage(floorsGold));
        flLabel1.setIcon(flImage1);
        flLabel1.setToolTipText(userConfig.getFloorsAccoladeBronzeDate());
        flLabel2.setIcon(flImage2);
        flLabel2.setToolTipText(userConfig.getFloorsAccoladeSilverDate());
        flLabel3.setIcon(flImage3);
        flLabel3.setToolTipText(userConfig.getFloorsAccoladeGoldDate());

        stImage1 = new ImageIcon(FileReader.getImage(stepsBronze));
        stImage2 = new ImageIcon(FileReader.getImage(stepsSilver));
        stImage3 = new ImageIcon(FileReader.getImage(stepsGold));
        stLabel1.setIcon(stImage1);
        stLabel1.setToolTipText(userConfig.getStepsAccoladeBronzeDate());
        stLabel2.setIcon(stImage2);
        stLabel2.setToolTipText(userConfig.getStepsAccoladeSilverDate());
        stLabel3.setIcon(stImage3);
        stLabel3.setToolTipText(userConfig.getStepsAccoladeGoldDate());

        actImage1 = new ImageIcon(FileReader.getImage(activeBronze));
        actImage2 = new ImageIcon(FileReader.getImage(activeSilver));
        actImage3 = new ImageIcon(FileReader.getImage(activeGold));
        actLabel1.setIcon(actImage1);
        actLabel1.setToolTipText(userConfig.getActiveAccoladeBronzeDate());
        actLabel2.setIcon(actImage2);
        actLabel2.setToolTipText(userConfig.getActiveAccoladeSilverDate());
        actLabel3.setIcon(actImage3);
        actLabel3.setToolTipText(userConfig.getActiveAccoladeGoldDate());

        goImage1 = new ImageIcon(FileReader.getImage(goalsBronze));
        goImage2 = new ImageIcon(FileReader.getImage(goalsSilver));
        goImage3 = new ImageIcon(FileReader.getImage(goalsGold));
        goLabel1.setIcon(goImage1);
        goLabel1.setToolTipText(userConfig.getGoalsAccoladeBronzeDate());
        goLabel2.setIcon(goImage2);
        goLabel2.setToolTipText(userConfig.getGoalsAccoladeSilverDate());
        goLabel3.setIcon(goImage3);
        goLabel3.setToolTipText(userConfig.getGoalsAccoladeGoldDate());

        acImage1 = new ImageIcon(FileReader.getImage(accoladesBronze));
        acImage2 = new ImageIcon(FileReader.getImage(accoladesSilver));
        acImage3 = new ImageIcon(FileReader.getImage(accoladesGold));
        acLabel1.setIcon(acImage1);
        acLabel1.setToolTipText(userConfig.getAccoladesAccoladeBronzeDate());
        acLabel2.setIcon(acImage2);
        acLabel2.setToolTipText(userConfig.getAccoladesAccoladeSilverDate());
        acLabel3.setIcon(acImage3);
        acLabel3.setToolTipText(userConfig.getAccoladesAccoladeGoldDate());
    }

    /**
     * Hides or displays accolades based on user configurations set
     */
    public void refreshConfig() {
        caloriesPanel.setVisible(userConfig.isCaloriesData());
        distancePanel.setVisible(userConfig.isDistanceData());
        floorsPanel.setVisible(userConfig.isFloorsData());
        stepsPanel.setVisible(userConfig.isStepsData());
        activePanel.setVisible(userConfig.isActiveData());
        if (userConfig.isCaloriesData() == false && userConfig.isDistanceData() == false && userConfig.isFloorsData() == false && userConfig.isStepsData() == false && userConfig.isActiveData() == false) {
            goalsPanel.setVisible(false);
            accoladesPanel.setVisible(false);
        } else {
            goalsPanel.setVisible(true);
            accoladesPanel.setVisible(true);
        }
    }

    /**
     * Create a data box for one of the data items displayed on the Accolades
     *
     * @param header Name of data to display
     * @param iconLabel1 JLabel of bronze accolade
     * @param iconLabel2 JLabel of silver accolade
     * @param iconLabel3 JLabel of gold accolade
     * @param color Color of the data box
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox(JLabel header, JLabel iconLabel1, JLabel iconLabel2, JLabel iconLabel3, Color color) {
        Font defaultFont = new Font("Helvetica", Font.PLAIN, 15);
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalStrut(50));
        header.setFont(defaultFont);
        panel.add(header);
        panel.add(Box.createHorizontalGlue());
        panel.add(iconLabel1);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel2);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel3);
        panel.add(Box.createHorizontalStrut(50));

        return panel;
    }
}
