package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

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
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));

        JPanel caloriesData = new JPanel();
        caloriesData.setBackground(Color.CYAN);
        caloriesData.setBorder(BorderFactory.createLineBorder(Color.black));
        caloriesData.setLayout(new BoxLayout(caloriesData, BoxLayout.X_AXIS));
        caloriesData.add(Box.createRigidArea(new Dimension(20,50)));
        JLabel caloriesBurned = new JLabel("Calories Burned: ");
        caloriesBurnedData = new JLabel("" + fitbitInfo.getDay().getCaloriesOut());
        caloriesData.add(caloriesBurned);
        caloriesData.add(Box.createRigidArea(new Dimension(10,0)));
        caloriesData.add(caloriesBurnedData);
        caloriesData.add(Box.createRigidArea(new Dimension(20,50)));

        JPanel distanceData = new JPanel();
        distanceData.setBackground(Color.PINK);
        distanceData.setBorder(BorderFactory.createLineBorder(Color.black));
        distanceData.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel totalDistance = new JLabel("Total Distance: ");
        totalDistanceData = new JLabel("" + fitbitInfo.getDay().getDistance());
        distanceData.add(totalDistance);
        distanceData.add(totalDistanceData);

        JPanel floorsData = new JPanel();
        floorsData.setBackground(Color.WHITE);
        floorsData.setBorder(BorderFactory.createLineBorder(Color.black));
        floorsData.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel floorsClimbed = new JLabel("Floors Climbed: ");
        floorsClimbedData = new JLabel("" + fitbitInfo.getDay().getFloors());
        floorsData.add(floorsClimbed);
        floorsData.add(floorsClimbedData);

        JPanel stepsData = new JPanel();
        stepsData.setBackground(Color.MAGENTA);
        stepsData.setBorder(BorderFactory.createLineBorder(Color.black));
        stepsData.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel stepsTaken = new JLabel("Steps Taken: ");
        stepsTakenData = new JLabel("" + fitbitInfo.getDay().getSteps());
        stepsData.add(stepsTaken);
        stepsData.add(stepsTakenData);

        JPanel activeData = new JPanel();
        activeData.setBackground(Color.YELLOW);
        activeData.setBorder(BorderFactory.createLineBorder(Color.black));
        activeData.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel activeMinutes = new JLabel("Active Minutes: ");
        activeMinutesData = new JLabel("" + fitbitInfo.getDay().getActiveMins());
        activeData.add(activeMinutes);
        activeData.add(activeMinutesData);

        JPanel sedentaryData = new JPanel();
        sedentaryData.setBackground(Color.green);
        sedentaryData.setBorder(BorderFactory.createLineBorder(Color.black));
        sedentaryData.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel sedentaryMinutes = new JLabel("Sedentary Minutes: ");
        sedentaryMinutesData = new JLabel("" + fitbitInfo.getDay().getSedentaryMins());
        sedentaryData.add(sedentaryMinutes);
        sedentaryData.add(sedentaryMinutesData);

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
                        .addComponent(caloriesData)
                        .addComponent(distanceData)
                        .addComponent(floorsData)
                        .addComponent(stepsData)
                        .addComponent(activeData)
                        .addComponent(sedentaryData)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(date)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(caloriesData)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(distanceData)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(floorsData)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(stepsData)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(activeData)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(sedentaryData)
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
