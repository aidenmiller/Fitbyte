package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Creates a Dashboard panel that displays the Dashboard to the user.
 *
 * @author team07
 */
public class Dashboard extends JPanel {

    private JToggleButton menuButton;
    private FitbitInfo fitbitInfo;
    private JLabel date;
    private JLabel sedentaryMinutesData;
    private JLabel activeMinutesData;
    private JLabel stepsTakenData;
    private JLabel floorsClimbedData;
    private JLabel totalDistanceData;
    private JLabel caloriesBurnedData;

    /**
     * Constructor for the Dashboard class
     *
     * @param info FitBit data for the user to display
     */
    public Dashboard(FitbitInfo info) {
        super();
        fitbitInfo = info;
        initPanel();
        initMenuButton();
    }

    /**
     * Creates the panel to display the page to the user with the relevant
     * information.
     */
    private void initPanel() {

        this.setBackground(Color.GREEN); //Color of the menu bar

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(new Date()));
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

        GroupLayout layout;
        layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(date)
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                .addComponent(date)
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

        this.setLayout(layout);
    }

    /**
     * Creates a Menu Button to be displayed on the menu bar of the program
     */
    private void initMenuButton() {
        ImageIcon icon = new ImageIcon(FileReader.getImage("dashboard.png"));
        ImageIcon iconP = new ImageIcon(FileReader.getImage("dashboard_pressed.png"));
        menuButton = new JToggleButton();
        menuButton.setToolTipText("Dashboard");
        menuButton.setBorderPainted(false);
        menuButton.setIcon(icon);
        menuButton.setRolloverIcon(iconP);
        menuButton.setSelectedIcon(iconP);
        menuButton.setRolloverSelectedIcon(iconP);

        final JPanel panel = this;
        menuButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {
                if (ev.getStateChange() == ItemEvent.SELECTED) {
                    panel.setVisible(true);
                } else if (ev.getStateChange() == ItemEvent.DESELECTED) {
                    panel.setVisible(false);
                }
            }
        });

    }

    /**
     * Returns the Menu Button for this page
     *
     * @return a JToggleButton for this page
     */
    public JToggleButton getMenuButton() {
        return this.menuButton;
    }

    /**
     * Refreshes the info on this page with the info contained in the FitbitInfo
     * provided
     *
     * @param info the FitbitInfo provided with new data
     */
    public void refreshInfo(FitbitInfo info) {
        this.fitbitInfo = info;
        System.out.println("Dashboard Refreshing");

        date.setText(new SimpleDateFormat("dd MMM yyyy").format(new Date()));
        sedentaryMinutesData.setText("" + fitbitInfo.getDay().getSedentaryMins());
        activeMinutesData.setText("" + fitbitInfo.getDay().getActiveMins());
        stepsTakenData.setText("" + fitbitInfo.getDay().getSteps());
        floorsClimbedData.setText("" + fitbitInfo.getDay().getFloors());
        totalDistanceData.setText("" + fitbitInfo.getDay().getDistance());
        caloriesBurnedData.setText("" + fitbitInfo.getDay().getCaloriesOut());

    }

}
