package ca.uwo.csd.cs2212.team07;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import org.json.JSONException;

/**
 * Creates a Main Window frame that displays the program.
 *
 * @author team07
 */
public class MainWindow extends JFrame {

    private final int mode;
    // Container used to store the different panels (dashboard, daily goals, etc)
    private JPanel cards;
    // Containers for each of the pages
    private Dashboard dashboard;
    private DailyGoals dailyGoals;
    private Accolades accolades;
    private HeartRate heartRate;
    private Settings settings;
    // Object that groups together buttons like Radio Buttons, allowing only one to be selected at a time
    private ButtonGroup buttonGroup;
    // Object that stores user FitBit data (such as calories burned, etc.) - should be Serialized class
    private FitbitInfo fitbitInfo;
    private JLabel lastSync;

    /**
     * Constructs a new MainWindow in either normal mode or test mode
     *
     * @param mode whether or not the user is on normal mode (0) or test mode
     * (1)
     */
    public MainWindow(int mode) {
        this.mode = mode;
        /*calls initUI method below which does most of the work */
        this.initUI();
    }

    /**
     * Constructs the UI to be displayed in the window
     */
    private void initUI() {
        this.setTitle("FitBit Program - CS2212 Team07");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false); //disables resizing

        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //change this at some point

        try {
            fitbitInfo = FileReader.loadInfo(mode); //try to load user info from stored file
            System.out.println("LOAD INFO SUCCESS");
        } catch (Exception e) { //thrown if no user data is found
            System.out.println("LOAD INFO FAIL");
            fitbitInfo = new FitbitInfo();
            System.out.println("REDIRECT TO USER LOGIN"); //user will need to authenticate
            //USER LOGIN HERE
            try {
                fitbitInfo.refreshInfo(Calendar.getInstance()); //tries to refresh user data
            } catch (JSONException ex) {
                System.err.println("Error Accessing API");
            } catch (RefreshTokenException ex) {
                System.err.println("Error Accessing API");
            }

        }

        // Initialization of each of the panels
        dashboard = new Dashboard(fitbitInfo, mode);
        dailyGoals = new DailyGoals(fitbitInfo);
        accolades = new Accolades(fitbitInfo);
        heartRate = new HeartRate(fitbitInfo);
        settings = new Settings();

        // BorderLayout allows positions through NORTH, EAST, SOUTH, WEST, etc.*/
        this.setLayout(new BorderLayout());

        // creates the top menu bar and adds it to the window
        this.add(this.createMenu(), BorderLayout.NORTH);

        // Adding the menu panels to the cards pane
        cards = new JPanel(new CardLayout());
        cards.add(dashboard, "");
        cards.add(dailyGoals, "");
        cards.add(accolades, "");
        cards.add(heartRate, "");
        cards.add(settings, "");

        // adds cards pane to the window
        this.add(cards, BorderLayout.CENTER);

    }

    /**
     * Creates the top menu bar to allow user to switch between pages, exit, and
     * refresh data
     *
     * @return the menu bar created
     */
    private JPanel createMenu() {
        JPanel panel = new JPanel();
        buttonGroup = new ButtonGroup();

        //adds the menu buttons to the button group
        buttonGroup.add(dashboard.getMenuButton());
        buttonGroup.add(dailyGoals.getMenuButton());
        buttonGroup.add(accolades.getMenuButton());
        buttonGroup.add(heartRate.getMenuButton());
        buttonGroup.add(settings.getMenuButton());
        //does a mouse click for dashboard to set it as the current page
        dashboard.getMenuButton().doClick();

        // REFRESHING - plan to make this it's own class hopefully
        JButton refreshButton = new JButton(new ImageIcon(FileReader.getImage("refresh.png")));
        refreshButton.setBorderPainted(false);
        refreshButton.setRolloverIcon(new ImageIcon(FileReader.getImage("refresh_pressed.png")));
        // JLabel to display the last refreshed time, initially will be never but should pull from stored data...
        lastSync = new JLabel("last synced: " + fitbitInfo.getLastRefreshTime().getTime());
        // Literally just to make the font smaller, but allows font change if we want to 
        lastSync.setFont(new Font(lastSync.getFont().getName(), Font.PLAIN, 10));
        //MouseListener for Refresh
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (mode == 0) {
                        fitbitInfo.refreshInfo(Calendar.getInstance());
                        dashboard.update(fitbitInfo);
                        dailyGoals.refreshInfo(fitbitInfo);
                        accolades.refreshInfo(fitbitInfo);
                        heartRate.refreshInfo(fitbitInfo);

                        // Sets the label to display the new last synced time
                        lastSync.setText("last synced: " + fitbitInfo.getLastRefreshTime().getTime());
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "ERROR! Unable to refresh in TEST MODE.");
                    }
                } catch (JSONException ex) {
                    System.err.println("Error Accessing API");
                } catch (RefreshTokenException ex) {
                    System.err.println("Error Accessing API");
                }
            }
        });

        // EXITING PROGRAM 
        JButton exitButton = new JButton(new ImageIcon(FileReader.getImage("exit.png")));
        exitButton.setBorderPainted(false);
        exitButton.setRolloverIcon(new ImageIcon(FileReader.getImage("exit_pressed.png")));
        //MouseListener for Exit
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (mode == 0) {
                        FileReader.storeInfo(fitbitInfo);
                        System.out.println("STORE FILE SUCCESS");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Thanks for trying Test Mode!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "ERROR! Unable to store user data.");
                }
                System.exit(0); //exit the program
            }
        });

        // Adding the buttons to the menu panel
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(dashboard.getMenuButton());
        panel.add(dailyGoals.getMenuButton());
        panel.add(accolades.getMenuButton());
        panel.add(heartRate.getMenuButton());
        panel.add(settings.getMenuButton());
        panel.add(Box.createHorizontalGlue()); //puts space between the first few menu items and the rest
        panel.add(lastSync);
        panel.add(refreshButton);
        panel.add(exitButton);

        panel.setBackground(Color.ORANGE); //color of menu bar

        return panel;
    }

}
