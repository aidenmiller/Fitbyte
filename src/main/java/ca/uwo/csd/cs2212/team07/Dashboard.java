package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Dashboard extends JPanel {

    private JToggleButton menuButton;

    public Dashboard() {
        super();
        initPanel();
        initMenuButton();
    }

    private void initPanel() {
        this.setBackground(Color.GREEN); //Color of the menu bar
        Date date = new Date(); //Generates the current date
        /* Formats the date into a readable format */
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

        JLabel day = new JLabel("Today: " + sdf.format(date));
        JLabel caloriesBurned = new JLabel("Calories Burned: ");
        JLabel caloriesBurnedData = new JLabel("10");
        JLabel totalDistance = new JLabel("Total Distance: ");
        JLabel totalDistanceData = new JLabel("10");
        JLabel floorsClimbed = new JLabel("Floors Climbed: ");
        JLabel floorsClimbedData = new JLabel("10");
        JLabel stepsTaken = new JLabel("Steps Taken: ");
        JLabel stepsTakenData = new JLabel("10");
        JLabel activeMinutes = new JLabel("Active Minutes: ");
        JLabel activeMinutesData = new JLabel("10");
        JLabel sedentaryMinutes = new JLabel("Sedentary Minutes: ");
        JLabel sedentaryMinutesData = new JLabel("10");

        GroupLayout layout;
        layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(day)
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
                .addComponent(day)
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

    private void initMenuButton() {
        ImageIcon icon = new ImageIcon(getFile("dashboard.png"));
        ImageIcon iconP = new ImageIcon(getFile("dashboard_pressed.png"));
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

    public JToggleButton getMenuButton() {
        return this.menuButton;
    }

    /* Found this method online - deals with finding images after packaging */
    private BufferedImage getFile(String fileName) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        BufferedImage image = null;

        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
        }

        return image;

    }
}
