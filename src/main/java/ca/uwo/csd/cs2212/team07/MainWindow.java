package ca.uwo.csd.cs2212.team07;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class MainWindow extends JFrame {

    /* Container used to store the different panels (dashboard, daily goals, etc) */
    private JPanel cards;
    /* Containers for each of the pages, these need to be be designed better (maybe separate classes for each panel) */
    private Dashboard dashboard;
    private DailyGoals dailyGoals;
    private Accolades accolades;
    private HeartRate heartRate;
    private Settings settings;
    /* Object that groups together buttons like Radio Buttons, allowing only one to be selected */
    private ButtonGroup buttonGroup;

    /* Constructor for this class, called by App*/
    public MainWindow() {
        /*calls initUI method below which does most of the work */
        this.initUI();
    }

    /* Most of the UI generation */
    private void initUI() {
        this.setTitle("FitBit Program - CS2212 Team07");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false); //disables resizing
        /* This will need to be removed at some point as only the X button created should close the app and Serialize data */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* BorderLayout allows positions through NORTH, EAST, SOUTH, WEST, etc. from the swingTut */
        this.setLayout(new BorderLayout());

        /* Initialization of each of the panest */
        dashboard = new Dashboard();
        dailyGoals = new DailyGoals();
        accolades = new Accolades();
        heartRate = new HeartRate();
        settings = new Settings();

        /* Adding the panels to the cards pane*/
        cards = new JPanel(new CardLayout());
        cards.add(dashboard, "");
        cards.add(dailyGoals, "");
        cards.add(accolades, "");
        cards.add(heartRate, "");
        cards.add(settings, "");

        /* adds menu and cards pane to the window */
        this.add(this.createMenu(), BorderLayout.NORTH);
        this.add(cards, BorderLayout.CENTER);

    }

    private JPanel createMenu() {
        JPanel panel = new JPanel();
        buttonGroup = new ButtonGroup();

        JToggleButton dashboardButton = dashboard.getMenuButton();
        buttonGroup.add(dashboardButton);

        JToggleButton dailyGoalsButton = dailyGoals.getMenuButton();
        buttonGroup.add(dailyGoalsButton);

        JToggleButton accoladesButton = accolades.getMenuButton();
        buttonGroup.add(accoladesButton);

        JToggleButton heartRateButton = heartRate.getMenuButton();
        buttonGroup.add(heartRateButton);

        JToggleButton settingsButton = settings.getMenuButton();
        buttonGroup.add(settingsButton);

        dashboardButton.doClick();

        /* REFRESHING */
        JButton refreshButton = new JButton(new ImageIcon(getFile("refresh.png")));
        refreshButton.setBorderPainted(false);
        refreshButton.setRolloverIcon(new ImageIcon(getFile("refresh_pressed.png")));
        // JLabel to display the last refreshed time, initially will be never but should pull from stored data...
        final JLabel refreshLabel = new JLabel("last synced: never");
        // Literally just to make the font smaller, but allows font change if we want to 
        refreshLabel.setFont(new Font(refreshLabel.getFont().getName(), Font.PLAIN, 10));
        //MouseListener for Refresh
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Date date = new Date(); //Generates the current date
                // Formats the date into a readable format 
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss aa zzz");
                // Sets the label to display the new last synced time 
                refreshLabel.setText("last synced: " + sdf.format(date));
            }
        });
        /* END OF REFRESHING */

 /* EXITING PROGRAM */
        JButton exitButton = new JButton(new ImageIcon(getFile("exit.png")));
        exitButton.setBorderPainted(false);
        exitButton.setRolloverIcon(new ImageIcon(getFile("exit_pressed.png")));
        //MouseListener for Exit
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0); //this needs to be handle serialization of data and make sure program closes properly
            }
        });
        /* END OF EXITING */

 /* Adding the menu buttons to the panel */
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(dashboardButton);
        panel.add(dailyGoalsButton);
        panel.add(accoladesButton);
        panel.add(heartRateButton);
        panel.add(settingsButton);
        panel.add(Box.createHorizontalGlue());
        panel.add(refreshLabel);
        panel.add(refreshButton);
        panel.add(exitButton);

        return panel;
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
