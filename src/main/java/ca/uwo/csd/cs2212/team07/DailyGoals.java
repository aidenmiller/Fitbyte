package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a Daily Goals panel that displays the Daily Goals to the user.
 *
 * @author team07
 */
public class DailyGoals extends JPanel {

    private final FitbitInfo fitbitInfo;

    private int cal=100, dist=10, floors=10, steps=10;
    
    
    private JLabel caloriesBurnedData; 
    private JLabel totalDistanceData;
    private JLabel floorsClimbedData;
    private JLabel stepsTakenData;
            
    private void setCalGoal (int i){
        cal = i;
    }
    private void setDistGoal (int i){
        dist = i;
    }
    private void setFloorsGoal (int i){
        floors = i;
    }
    private void setStepsGoal (int i){
        steps = i;
    }

    /**
     * Constructor for the Daily Goals class
     *
     * @param fitbitInfo container for user data
     */
    public DailyGoals(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    /**
     * Initializes the panel to display Daily Goals to the user
     */
    private void initPanel() {

        this.setBackground(Color.RED); //Color of the menu bar
        
        JLabel caloriesBurned = new JLabel("Calories Burned Daily Goal: ");
        JLabel caloriesBurnedGoal = new JLabel("" + cal);
        JLabel message_cal;
        caloriesBurnedData = new JLabel("" + fitbitInfo.getDay().getCaloriesOut());
        if(fitbitInfo.getDay().getCaloriesOut() >= cal){
            message_cal = new JLabel ("You've already achieved your calories burned daily goal. Congratulations! ");
        }
        else{
            message_cal = new JLabel ("You've not achieved your calories burned daily goal yet. Keep going! ");
        }
        
        JLabel totalDistance = new JLabel("Total Distance Daily Goal: ");
        JLabel totalDistanceGoal = new JLabel("" + dist);
        JLabel message_dist;
        totalDistanceData = new JLabel("" + fitbitInfo.getDay().getDistance());
        if(fitbitInfo.getDay().getDistance() >= dist){
            message_dist = new JLabel ("You've already achieved your distance daily daily goal. Congratulations! ");
        }
        else{
            message_dist = new JLabel ("You've not achieved your total distance daily goal yet. Keep going! ");
        }
        
        
        JLabel floorsClimbed = new JLabel("Floors Climbed Daily Goal: ");
        JLabel floorsClimbedGoal = new JLabel("" + floors);
        JLabel message_floors;
        floorsClimbedData = new JLabel("" + fitbitInfo.getDay().getFloors());
        if(fitbitInfo.getDay().getFloors() >= floors){
            message_floors = new JLabel ("You've already achieved your floors climbed daily goal. Congratulations! ");
        }
        else{
            message_floors = new JLabel ("You've not achieved your floors climbed daily goal yet. Keep going! ");
        }
        
        
        JLabel stepsTaken = new JLabel("Steps Taken Daily Goal: ");
        JLabel stepsTakenGoal = new JLabel("" + steps);
        JLabel message_steps;
        stepsTakenData = new JLabel("" + fitbitInfo.getDay().getFloors());
        if(fitbitInfo.getDay().getFloors() >= cal){
            message_steps = new JLabel ("You've already achieved your steps taken daily goal. Congratulations! ");
        }
        else{
            message_steps = new JLabel ("You've not achieved your calories steps taken goal yet. Keep going! ");
        }
        
        
    
    GroupLayout layout;
        layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(caloriesBurned)
                                .addComponent(caloriesBurnedGoal)
                                .addGap(50)
                                .addComponent(message_cal)
                        )
                       .addGroup(layout.createSequentialGroup()
                                .addComponent(totalDistance)
                                .addComponent(totalDistanceGoal)
                                .addGap(55)
                                .addComponent(message_dist)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(floorsClimbed)
                                .addComponent(floorsClimbedGoal)
                                .addGap(60)
                                .addComponent(message_floors)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(stepsTaken)
                                .addComponent(stepsTakenGoal)
                                .addGap(65)
                                .addComponent(message_steps)
                        )                      
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(caloriesBurned)
                        .addComponent(caloriesBurnedGoal)
                        .addComponent(message_cal)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(totalDistance)
                        .addComponent(totalDistanceGoal)
                        .addComponent(message_dist)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(floorsClimbed)
                        .addComponent(floorsClimbedGoal)
                        .addComponent(message_floors)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(stepsTaken)
                        .addComponent(stepsTakenGoal)
                        .addComponent(message_steps)
                )
        );

        this.setLayout(layout);

    }

    /**
     * Refresh the data displayed to the user
     */
    public void refresh() {
        
    }

}
