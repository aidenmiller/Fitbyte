package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a Dashboard panel that displays the Dashboard to the user.
 *
 * @author team07
 */
public class Dashboard extends JPanel {

    private final FitbitInfo fitbitInfo;
    
    private JLabel date;
    private JLabel caloriesBurnedData;
    private JLabel totalDistanceData;
    private JLabel floorsClimbedData;
    private JLabel stepsTakenData;
    private JLabel activeMinutesData;
    private JLabel sedentaryMinutesData;
    
    public Dashboard(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    private void initPanel() {

        this.setBackground(Color.ORANGE); //Color of the menu bar

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        JLabel caloriesBurned = new JLabel("Calories Burned: ");
        caloriesBurnedData = new JLabel("" + fitbitInfo.getDay().getCaloriesOut());
        JLabel totalDistance = new JLabel("Total Distance: ");
        totalDistanceData = new JLabel("" + fitbitInfo.getDay().getDistance());
        JLabel floorsClimbed = new JLabel("Floors Climbed: ");
        floorsClimbedData = new JLabel("" + fitbitInfo.getDay().getFloors());
        JLabel stepsTaken = new JLabel("Steps Taken: ");
        stepsTakenData = new JLabel("" + fitbitInfo.getDay().getSteps());
        JLabel activeMinutes = new JLabel("Active Minutes: ");
        activeMinutesData = new JLabel("" + fitbitInfo.getDay().getActiveMins());
        JLabel sedentaryMinutes = new JLabel("Sedentary Minutes: ");
        sedentaryMinutesData = new JLabel("" + fitbitInfo.getDay().getSedentaryMins());

        //Layout Specifications
        GroupLayout layout;
        layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(date)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(caloriesBurned)
                                .addComponent(caloriesBurnedData)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(totalDistance)
                                .addComponent(totalDistanceData)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(floorsClimbed)
                                .addComponent(floorsClimbedData)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(stepsTaken)
                                .addComponent(stepsTakenData)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(activeMinutes)
                                .addComponent(activeMinutesData)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(sedentaryMinutes)
                                .addComponent(sedentaryMinutesData)
                        )
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(date)
                )
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(caloriesBurned)
                        .addComponent(caloriesBurnedData)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(totalDistance)
                        .addComponent(totalDistanceData)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(floorsClimbed)
                        .addComponent(floorsClimbedData)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(stepsTaken)
                        .addComponent(stepsTakenData)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(activeMinutes)
                        .addComponent(activeMinutesData)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(sedentaryMinutes)
                        .addComponent(sedentaryMinutesData)
                )
        );
        //End of Layout Specifications

        this.setLayout(layout);
    }

    public void refresh() {
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        sedentaryMinutesData.setText("" + fitbitInfo.getDay().getSedentaryMins());
        activeMinutesData.setText("" + fitbitInfo.getDay().getActiveMins());
        stepsTakenData.setText("" + fitbitInfo.getDay().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getDay().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getDay().getDistance());
        caloriesBurnedData.setText("" + fitbitInfo.getDay().getCaloriesOut());
    }

}
