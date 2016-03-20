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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONException;

/**
 * Creates a Main Window that displays the program to the user.
 *
 * @author team07
 */
public class MainWindow extends JFrame implements ActionListener {

    private FitbitInfo fitbitInfo;
    private UserConfig userConfig;
    private final boolean testMode;

    private JToggleButton dashboardButton;
    private JToggleButton dailyGoalsButton;
    private JToggleButton heartRateButton;
    private JToggleButton accoladesButton;
    private JButton refreshButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JLabel lastRefresh;

    private Dashboard dashboard;
    private DailyGoals dailyGoals;
    private Accolades accolades;

    private ButtonGroup buttonGroup;
    private JPanel cardPane;
    private CardLayout cardLayout;

    private Color panelColor;

    /**
     * Constructs a new Main Window
     *
     * @param testMode which mode to run the program in
     */
    public MainWindow(boolean testMode) {
        this.testMode = testMode;
        this.getUserData();
        this.getUserConfig();
        this.initUI();
    }

    /**
     * Loads the serialized user data into a FitbitInfo object, or generates
     * test data if in test mode
     *
     * @param testMode whether or not the program is run in test mode
     */
    private void getUserData() {
        if (!testMode) {
            try {
                fitbitInfo = loadInfo();
            } catch (Exception e) {
                fitbitInfo = new FitbitInfo();
                try {
                    fitbitInfo.refreshInfo(Calendar.getInstance());
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Unable to refresh. Please try again later.");
                    System.exit(0);
                } catch (RefreshTokenException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
                    System.exit(0);
                }
            }

        } else {
            fitbitInfo = new FitbitInfo();
            fitbitInfo.testModeData();
        }
    }

    /**
     * Loads the serialized user configuration into a UserConfig object
     */
    private void getUserConfig() {
        if (!testMode) {
            try {
                userConfig = loadConfig();
            } catch (Exception e) {
                userConfig = new UserConfig();
            }

        } else {
            userConfig = new UserConfig();
        }
    }

    /**
     * Initializes the UI displayed in the Main Window
     */
    private void initUI() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.setLayout(new BorderLayout());
        panelColor = new Color(0, 80, 105);

        // Creation of the Menu Bar
        JPanel topBar = new JPanel();
        topBar.setBackground(panelColor);
        //topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
        topBar.setLayout(new GridLayout(0, 3));

        //menu bar
        JPanel menuBar = new JPanel();
        menuBar.setOpaque(false);
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));
        buttonGroup = new ButtonGroup();
        dashboardButton = makeMenuButton("Dashboard", "menubuttons/dashboard.png", "menubuttons/dashboard_pressed.png");
        dailyGoalsButton = makeMenuButton("Daily Goals", "menubuttons/dailygoals.png", "menubuttons/dailygoals_pressed.png");
        heartRateButton = makeMenuButton("Heart Rate", "menubuttons/heartrate.png", "menubuttons/heartrate_pressed.png");
        accoladesButton = makeMenuButton("Accolades", "menubuttons/accolades.png", "menubuttons/accolades_pressed.png");
        menuBar.add(dashboardButton);
        menuBar.add(dailyGoalsButton);
        menuBar.add(heartRateButton);
        menuBar.add(accoladesButton);
        topBar.add(menuBar);
        //end of menu bar

        //logo panel
        JPanel logoBar = new JPanel();
        logoBar.setOpaque(false);
        logoBar.setLayout(new BoxLayout(logoBar, BoxLayout.LINE_AXIS));
        JLabel logo = new JLabel(new ImageIcon(FileReader.getImage("fitbyte.png")));
        logo.setToolTipText("FitByte");
        logoBar.add(Box.createHorizontalGlue());
        logoBar.add(logo);
        logoBar.add(Box.createHorizontalGlue());
        topBar.add(logoBar);
        //end of logo

        //options bar
        JPanel optionsBar = new JPanel();
        optionsBar.setOpaque(false);
        optionsBar.setLayout(new BoxLayout(optionsBar, BoxLayout.LINE_AXIS));
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

        optionsBar.add(Box.createHorizontalGlue());
        optionsBar.add(refreshButton);
        optionsBar.add(settingsButton);
        optionsBar.add(exitButton);
        topBar.add(optionsBar);
        //end of options bar

        // End of Menu Bar creation
        this.add(topBar, BorderLayout.NORTH);

        //South Bar creation - for refresh info
        JPanel bottomBar = new JPanel();
        bottomBar.setBackground(panelColor);

        Date date = fitbitInfo.getLastRefreshTime().getTime();
        lastRefresh = new JLabel("last synced: " + new SimpleDateFormat("dd MMM yyyy").format(date)
                + " at " + new SimpleDateFormat("h:mm:ss a z").format(date));
        lastRefresh.setFont(new Font(lastRefresh.getFont().getName(), Font.PLAIN, 10));
        lastRefresh.setForeground(Color.white);

        bottomBar.add(lastRefresh);
        //End of South Bar creation
        this.add(bottomBar, BorderLayout.SOUTH);

        // Creation of the CardLayout for displays
        dashboard = new Dashboard(fitbitInfo, userConfig);
        dailyGoals = new DailyGoals(fitbitInfo, userConfig);
        accolades = new Accolades(fitbitInfo, userConfig);

        cardPane = new JPanel(new CardLayout());
        cardPane.add(dashboard, "Dashboard");
        cardPane.add(dailyGoals, "Daily Goals");
        cardPane.add(accolades, "Accolades");
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
     * Loads the user info from a stored data file
     *
     * @return FitbitInfo object with stored user data
     * @throws Exception thrown when file is not found
     */
    public FitbitInfo loadInfo() throws Exception {

        ObjectInputStream in;
        in = new ObjectInputStream(new FileInputStream("user.info"));

        return (FitbitInfo) in.readObject();
    }

    /**
     * Stores the user info from the stored data file
     *
     */
    public void storeInfo() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.info"));
            out.writeObject(fitbitInfo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR! Unable to store user data.");
        }

    }

    /**
     * Loads the user info from a stored data file
     *
     * @return FitbitInfo object with stored user data
     * @throws Exception thrown when file is not found
     */
    public UserConfig loadConfig() throws Exception {

        ObjectInputStream in;
        in = new ObjectInputStream(new FileInputStream("user.config"));

        return (UserConfig) in.readObject();
    }

    /**
     * Stores the user info from the stored data file
     *
     */
    public void storeConfig() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.config"));
            out.writeObject(userConfig);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR! Unable to store user configuration.");
        }

    }

    /**
     * Refreshes the info in the FitbitInfo object and then refreshes each of
     * the displays
     */
    private void refreshInfo() {
        if (fitbitInfo.isTestMode()) {
            fitbitInfo.testModeData();
        } else {
            try {
                fitbitInfo.refreshInfo(Calendar.getInstance());
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Unable to refresh. Please try again later.");
                return;
            } catch (RefreshTokenException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "RefreshTokenException - tokens out of date");
                return;
            }
        }

        Date date = fitbitInfo.getLastRefreshTime().getTime();
        lastRefresh.setText("last synced: " + new SimpleDateFormat("dd MMM yyyy").format(date)
                + " at " + new SimpleDateFormat("h:mm:ss a z").format(date));
        this.refreshPanels();
    }

    private void refreshPanels() {
        dashboard.refresh();
        dailyGoals.refresh();
        accolades.refresh();
    }

    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboardButton) {
            this.setTitle("FitByte - Dashboard");
            cardLayout.show(cardPane, "Dashboard");
            dashboard.showToday();
        } else if (e.getSource() == dailyGoalsButton) {
            this.setTitle("FitByte - Daily Goals");
            cardLayout.show(cardPane, "Daily Goals");
        } else if (e.getSource() == heartRateButton) {
            this.setTitle("FitByte - Heart Rate Zones");
            //cardLayout.show(cardPane, "Heart Rate");
        } else if (e.getSource() == accoladesButton) {
            this.setTitle("FitByte - Accolades");
            cardLayout.show(cardPane, "Accolades");
        } else if (e.getSource() == refreshButton) {
            this.refreshInfo();
        } else if (e.getSource() == settingsButton) {
            this.viewSettings();
        } else if (e.getSource() == exitButton) {
            if (!testMode) {
                this.storeInfo();
                this.storeConfig();
            }
            this.dispose();
            System.exit(0);
        }
    }

    private void viewSettings() {
        SettingsWindow settingsWindow = new SettingsWindow(userConfig);
        int n = JOptionPane.showOptionDialog(this, settingsWindow,
                "User Settings", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (n == JOptionPane.OK_OPTION) {
            settingsWindow.saveSettings();
            this.refreshPanels();
        }
    }

}
