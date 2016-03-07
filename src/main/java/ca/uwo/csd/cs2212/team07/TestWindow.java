package ca.uwo.csd.cs2212.team07;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Creates a Test Window that displays the program in test mode to the user.
 *
 * @author team07
 */
public class TestWindow extends JFrame implements ActionListener {

    private FitbitInfo fitbitInfo;

    private JToggleButton dashboardButton;
    private JToggleButton dailyGoalsButton;
    private JButton refreshButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JLabel lastRefresh;

    private Dashboard dashboard;
    private DailyGoals dailyGoals;

    private ButtonGroup buttonGroup;
    private JPanel cardPane;
    private CardLayout cardLayout;

    private Color panelColor;

    /**
     * Constructor for the TestWindow class
     */
    public TestWindow() {
        this.getUserData();
        this.getUserConfig();
        this.initUI();
    }

    /**
     * Generates test data to display to the user
     */
    private void getUserData() {
        fitbitInfo = new FitbitInfo();
        fitbitInfo.generateTestData();
    }

    /**
     * Generates test configurations to display
     */
    private void getUserConfig() {

    }

    /**
     * Initializes the UI displayed in the Test Window
     */
    private void initUI() {
        this.setTitle("CS2212 Team07");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //
        this.setLayout(new BorderLayout());

        panelColor = new Color(0, 80, 105);

        // Creation of the Menu Bar
        JPanel menuBar = new JPanel();
        menuBar.setBackground(panelColor);
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));

        buttonGroup = new ButtonGroup();
        dashboardButton = makeMenuButton("Dashboard", "menubuttons/dashboard.png", "menubuttons/dashboard_pressed.png");
        dailyGoalsButton = makeMenuButton("Daily Goals", "menubuttons/dailygoals.png", "menubuttons/dailygoals_pressed.png");

        menuBar.add(dashboardButton);
        menuBar.add(dailyGoalsButton);
        menuBar.add(Box.createHorizontalGlue());

        refreshButton = new JButton(new ImageIcon(FileReader.getImage("menubuttons/refresh.png")));
        refreshButton.setToolTipText("Refresh");
        refreshButton.setBorderPainted(false);
        refreshButton.setRolloverIcon(new ImageIcon(FileReader.getImage("menubuttons/refresh_pressed.png")));
        refreshButton.addActionListener(this);

        settingsButton = new JButton(new ImageIcon(FileReader.getImage("menubuttons/settings.png")));
        settingsButton.setToolTipText("Settings");
        settingsButton.setBorderPainted(false);
        settingsButton.setRolloverIcon(new ImageIcon(FileReader.getImage("menubuttons/settings_pressed.png")));
        settingsButton.addActionListener(this);

        exitButton = new JButton(new ImageIcon(FileReader.getImage("menubuttons/exit.png")));
        exitButton.setToolTipText("Exit");
        exitButton.setBorderPainted(false);
        exitButton.setRolloverIcon(new ImageIcon(FileReader.getImage("menubuttons/exit_pressed.png")));
        exitButton.addActionListener(this);

        menuBar.add(refreshButton);
        menuBar.add(settingsButton);
        menuBar.add(exitButton);
        // End of Menu Bar creation
        this.add(menuBar, BorderLayout.NORTH);

        //South Bar creation - for refresh info
        JPanel bottomBar = new JPanel();
        bottomBar.setBackground(panelColor);

        lastRefresh = new JLabel("TEST MODE");
        lastRefresh.setFont(new Font(lastRefresh.getFont().getName(), Font.PLAIN, 10));
        lastRefresh.setForeground(Color.white);

        bottomBar.add(lastRefresh);
        //End of South Bar creation
        this.add(bottomBar, BorderLayout.SOUTH);

        // Creation of the CardLayout for displays
        dashboard = new Dashboard(fitbitInfo);
        dailyGoals = new DailyGoals(fitbitInfo);

        cardPane = new JPanel(new CardLayout());
        cardPane.add(dashboard, "Dashboard");
        cardPane.add(dailyGoals, "Daily Goals");
        cardLayout = (CardLayout) cardPane.getLayout();
        // End of CardLayout creation
        this.add(cardPane, BorderLayout.CENTER);

        dashboardButton.doClick();
    }

    /**
     * Creates a toggle button for a display such as Dashboard
     *
     * @param name name of display
     * @param iconFile name of icon stored in resources folder
     * @param iconSelectedFile name of selected icon stored in resources folder
     * @return the created menu button
     */
    private JToggleButton makeMenuButton(String name, String iconFile, String iconSelectedFile) {
        JToggleButton button = new JToggleButton();

        button.addActionListener(this);

        buttonGroup.add(button);
        button.setToolTipText(name);
        button.setBorderPainted(false);
        ImageIcon icon = new ImageIcon(FileReader.getImage(iconFile));
        ImageIcon iconSelected = new ImageIcon(FileReader.getImage(iconSelectedFile));
        button.setIcon(icon);
        button.setRolloverIcon(iconSelected);
        button.setSelectedIcon(iconSelected);
        button.setRolloverSelectedIcon(iconSelected);

        return button;
    }

    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboardButton) {
            cardLayout.show(cardPane, "Dashboard");
        } else if (e.getSource() == dailyGoalsButton) {
            cardLayout.show(cardPane, "Daily Goals");
        } else if (e.getSource() == refreshButton) {
            JOptionPane.showMessageDialog(new JFrame(), "Nice try. Unable to refresh in Test Mode");
        } else if (e.getSource() == settingsButton) {
            System.out.println("Settings");
        } else if (e.getSource() == exitButton) {
            System.exit(0); //exit the program
        }
    }

}
