package ca.uwo.csd.cs2212.team07;

import java.awt.Graphics;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import org.json.JSONException;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;

/**
 * Heart rate panel that displays information pertaining to each individual's
 * heart rate
 *
 * @author bowenjiang - Team 07
 */
public class HeartRate extends JPanel implements ActionListener {

    private final FitbitInfo fitbitInfo;
    private final UserConfig userConfig;
    private JButton graphButton, prevButton, nextButton;
    private Calendar currDayView;
    private JLabel date, restingRate;
    private JLabel col1, col2, col3, col4;
    private JLabel col5, col6, col7, col8;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, px;
    private final Image heartBackground;

    /**
     * Constructor for the class HeartRate
     *
     * @param fitbitInfo container for user data
     * @param userConfig container for user configuration
     */
    public HeartRate(FitbitInfo fitbitInfo, UserConfig userConfig) {
        super();
        heartBackground = new ImageIcon(FileReader.getImage("iconmafia/heartbackground.png")).getImage();
        this.fitbitInfo = fitbitInfo;
        this.userConfig = userConfig;
        renderingGUI();
    }

    /**
     * Repaint the background of the JPanel
     *
     * @param g graphics component
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(heartBackground, 0, 0, getWidth(), getHeight(), this);
    }

    /**
     * Initializes HeartRate panel
     */
    private void renderingGUI() {

        px = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel();

        
        px.setBackground(new Color(0, 0, 0, 175));
        
        p1.setBackground(new Color(0, 0, 0, 175));
        p2.setBackground(new Color(0, 0, 0, 175));
        p3.setBackground(new Color(0, 0, 0, 175));
        p4.setBackground(new Color(0, 0, 0, 175));
        p5.setBackground(new Color(0, 0, 0, 175));
        p6.setBackground(new Color(0, 0, 0, 175));
        p7.setBackground(new Color(0, 0, 0, 175));
        p8.setBackground(new Color(0, 0, 0, 175));
        

        px.setLayout(new BoxLayout(px, BoxLayout.X_AXIS));
        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
        p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
        p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
        p5.setLayout(new BoxLayout(p5, BoxLayout.X_AXIS));
        p6.setLayout(new BoxLayout(p6, BoxLayout.X_AXIS));
        p7.setLayout(new BoxLayout(p7, BoxLayout.X_AXIS));
        p8.setLayout(new BoxLayout(p8, BoxLayout.X_AXIS));

        ImageIcon iconImage1 = new ImageIcon(FileReader.getImage("iconmafia/peak.png"));
        ImageIcon iconImage2 = new ImageIcon(FileReader.getImage("iconmafia/flame4.png"));
        ImageIcon iconImage3 = new ImageIcon(FileReader.getImage("iconmafia/cardio.png"));
        ImageIcon iconImage4 = new ImageIcon(FileReader.getImage("iconmafia/flame3.png"));
        ImageIcon iconImage5 = new ImageIcon(FileReader.getImage("iconmafia/fat.png"));
        ImageIcon iconImage6 = new ImageIcon(FileReader.getImage("iconmafia/flame2.png"));
        ImageIcon iconImage7 = new ImageIcon(FileReader.getImage("iconmafia/outofrange.png"));
        ImageIcon iconImage8 = new ImageIcon(FileReader.getImage("iconmafia/flame1.png"));

        JLabel iconLabel1 = new JLabel(iconImage1);
        JLabel iconLabel2 = new JLabel(iconImage2);
        JLabel iconLabel3 = new JLabel(iconImage3);
        JLabel iconLabel4 = new JLabel(iconImage4);
        JLabel iconLabel5 = new JLabel(iconImage5);
        JLabel iconLabel6 = new JLabel(iconImage6);
        JLabel iconLabel7 = new JLabel(iconImage7);
        JLabel iconLabel8 = new JLabel(iconImage8);

        px.add(Box.createHorizontalGlue());
        p1.add(Box.createHorizontalGlue());
        p2.add(Box.createHorizontalGlue());
        p3.add(Box.createHorizontalGlue());
        p4.add(Box.createHorizontalGlue());
        p5.add(Box.createHorizontalGlue());
        p6.add(Box.createHorizontalGlue());
        p7.add(Box.createHorizontalGlue());
        p8.add(Box.createHorizontalGlue());

        graphButton = new JButton();
        graphButton.addActionListener(this);
        graphButton.setToolTipText("Click here to view your own personal heartrate graph");
        ImageIcon icon = new ImageIcon(FileReader.getImage("iconmafia/graph3.png"));
        graphButton.setIcon(icon);
        px.add(graphButton);
        graphButton.setRolloverIcon(new ImageIcon(FileReader.getImage("iconmafia/graph2.png")));

        prevButton = new JButton(new ImageIcon(FileReader.getImage("iconmafia/previous2.png")));
        prevButton.addActionListener(this);
        prevButton.setRolloverIcon(new ImageIcon(FileReader.getImage("iconmafia/previous.png")));
        nextButton = new JButton(new ImageIcon(FileReader.getImage("iconmafia/next2.png")));
        nextButton.addActionListener(this);
        nextButton.setRolloverIcon(new ImageIcon(FileReader.getImage("iconmafia/next.png")));
        nextButton.setVisible(false); //visiblity initially false

        p1.add(iconLabel1);
        p2.add(iconLabel2);
        p3.add(iconLabel3);
        p4.add(iconLabel4);
        p5.add(iconLabel5);
        p6.add(iconLabel6);
        p7.add(iconLabel7);
        p8.add(iconLabel8);

        JLabel a1 = new JLabel("Peak Zone: ");
        JLabel a2 = new JLabel("Calories Burned: ");
        JLabel a3 = new JLabel("Cardio Zone: ");
        JLabel a4 = new JLabel("Calories Burned: ");
        JLabel a5 = new JLabel("Fat Zone: ");
        JLabel a6 = new JLabel("Calories Burned: ");
        JLabel a7 = new JLabel("OOR Zone: ");
        JLabel a8 = new JLabel("Calories Burned: ");

        a1.setFont(new Font("Arial", Font.BOLD, 14));
        a2.setFont(new Font("Arial", Font.BOLD, 14));
        a3.setFont(new Font("Arial", Font.BOLD, 14));
        a4.setFont(new Font("Arial", Font.BOLD, 14));
        a5.setFont(new Font("Arial", Font.BOLD, 14));
        a6.setFont(new Font("Arial", Font.BOLD, 14));
        a7.setFont(new Font("Arial", Font.BOLD, 14));
        a8.setFont(new Font("Arial", Font.BOLD, 14));

        a1.setForeground(Color.white);
        a2.setForeground(Color.white);
        a3.setForeground(Color.white);
        a4.setForeground(Color.white);
        a5.setForeground(Color.white);
        a6.setForeground(Color.white);
        a7.setForeground(Color.white);
        a8.setForeground(Color.white);

        p1.add(a1);
        p2.add(a2);
        p3.add(a3);
        p4.add(a4);
        p5.add(a5);
        p6.add(a6);
        p7.add(a7);
        p8.add(a8);

        px.add(Box.createHorizontalStrut(100));
        p1.add(Box.createHorizontalStrut(95));
        p2.add(Box.createHorizontalStrut(95));
        p3.add(Box.createHorizontalStrut(95));
        p4.add(Box.createHorizontalStrut(95));
        p5.add(Box.createHorizontalStrut(95));
        p6.add(Box.createHorizontalStrut(95));
        p7.add(Box.createHorizontalStrut(95));
        p8.add(Box.createHorizontalStrut(95));

        date = new JLabel(new SimpleDateFormat("MMMM d").format(fitbitInfo.getLastRefreshTime().getTime()));
        restingRate = new JLabel("Resting Heart Rate: " + fitbitInfo.getHeart().getRestingHeartRate());
        col1 = new JLabel("" + fitbitInfo.getHeart().getPeakMins() + " mins");
        col2 = new JLabel("" + fitbitInfo.getHeart().getPeakCalsOut() + " cal");
        col3 = new JLabel("" + fitbitInfo.getHeart().getCardioMins() + " mins");
        col4 = new JLabel("" + fitbitInfo.getHeart().getCardioCalsOut() + " cal");
        col5 = new JLabel("" + fitbitInfo.getHeart().getFatBurnMins() + " mins");
        col6 = new JLabel("" + fitbitInfo.getHeart().getFatBurnCalsOut() + " cal");
        col7 = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeMins() + " mins");
        col8 = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeCalsOut() + " cal");

        restingRate.setToolTipText("current resting heart rate");
        col1.setToolTipText("minutes spent in this zone");
        col2.setToolTipText("1 cal = 4.184 J");
        col3.setToolTipText("minutes spent in this zone");
        col4.setToolTipText("1 cal = 4.184 J");
        col5.setToolTipText("minutes spent in this zone");
        col6.setToolTipText("1 cal = 4.184 J");
        col7.setToolTipText("minutes spent in this zone");
        col8.setToolTipText("1 cal = 4.184 J");

        date.setFont(new Font("Arial", Font.BOLD, 14));
        restingRate.setFont(new Font("Arial", Font.BOLD, 14));
        col1.setFont(new Font("Arial", Font.BOLD, 14));
        col2.setFont(new Font("Arial", Font.BOLD, 14));
        col3.setFont(new Font("Arial", Font.BOLD, 14));
        col4.setFont(new Font("Arial", Font.BOLD, 14));
        col5.setFont(new Font("Arial", Font.BOLD, 14));
        col6.setFont(new Font("Arial", Font.BOLD, 14));
        col7.setFont(new Font("Arial", Font.BOLD, 14));
        col8.setFont(new Font("Arial", Font.BOLD, 14));

        date.setForeground(Color.white);
        restingRate.setForeground(Color.white);
        col1.setForeground(Color.white);
        col2.setForeground(Color.white);
        col3.setForeground(Color.white);
        col4.setForeground(Color.white);
        col5.setForeground(Color.white);
        col6.setForeground(Color.white);
        col7.setForeground(Color.white);
        col8.setForeground(Color.white);
        px.add(prevButton);
        px.add(restingRate);
        px.add(nextButton);
        px.add(Box.createHorizontalStrut(100));
        px.add(date);
        p1.add(col1);
        p2.add(col2);
        p3.add(col3);
        p4.add(col4);
        p5.add(col5);
        p6.add(col6);
        p7.add(col7);
        p8.add(col8);

        px.add(Box.createHorizontalGlue());
        p1.add(Box.createHorizontalGlue());
        p2.add(Box.createHorizontalGlue());
        p3.add(Box.createHorizontalGlue());
        p4.add(Box.createHorizontalGlue());
        p5.add(Box.createHorizontalGlue());
        p6.add(Box.createHorizontalGlue());
        p7.add(Box.createHorizontalGlue());
        p8.add(Box.createHorizontalGlue());

        px.setPreferredSize(new Dimension(755, 60));
        p1.setPreferredSize(new Dimension(375, 100));
        p2.setPreferredSize(new Dimension(375, 100));
        p3.setPreferredSize(new Dimension(375, 100));
        p4.setPreferredSize(new Dimension(375, 100));
        p5.setPreferredSize(new Dimension(375, 100));
        p6.setPreferredSize(new Dimension(375, 100));
        p7.setPreferredSize(new Dimension(375, 100));
        p8.setPreferredSize(new Dimension(375, 100));

        add(px);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);

        //tooltip texts for each heart zone
        px.setToolTipText("Average heart rate on this day");
        p1.setToolTipText("Heart rate between 160 - 220 bpm");
        p3.setToolTipText("Heart rate between 132 - 160 bpm");
        p5.setToolTipText("Heart rate between 94 - 132 bpm");
        p7.setToolTipText("Heart rate between 30 - 94 bpm");

        this.refresh();
    }

    /**
     * Refreshes the Heart Rate data of an individual
     */
    public void refresh() {

        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        restingRate.setText("\t Resting Heart Rate: \t" + fitbitInfo.getHeart().getRestingHeartRate() + " bpm");

        double roundedPeakCal = Math.round(fitbitInfo.getHeart().getPeakCalsOut() * 100.0) / 100.0;
        double roundedCardioCal = Math.round(fitbitInfo.getHeart().getCardioCalsOut() * 100.0) / 100.0;
        double roundedFatCal = Math.round(fitbitInfo.getHeart().getFatBurnCalsOut() * 100.0) / 100.0;
        double roundedOutCal = Math.round(fitbitInfo.getHeart().getOutOfRangeCalsOut() * 100.0) / 100.0;

        col1.setText("" + fitbitInfo.getHeart().getPeakMins() + " mins");
        col2.setText("" + roundedPeakCal + " cal");
        col3.setText("" + fitbitInfo.getHeart().getCardioMins() + " mins");
        col4.setText("" + roundedCardioCal + " cal");
        col5.setText("" + fitbitInfo.getHeart().getFatBurnMins() + " mins");
        col6.setText("" + roundedFatCal + " cal");
        col7.setText("" + fitbitInfo.getHeart().getOutOfRangeMins() + " mins");
        col8.setText("" + roundedOutCal + " cal");

        p1.setVisible(userConfig.isPeakVisible());
        p2.setVisible(userConfig.isPeakVisible());
        p3.setVisible(userConfig.isCardioVisible());
        p4.setVisible(userConfig.isCardioVisible());
        p5.setVisible(userConfig.isFatVisible());
        p6.setVisible(userConfig.isFatVisible());
        p7.setVisible(userConfig.isOutVisible());
        p8.setVisible(userConfig.isOutVisible());
       
        nextButton.setVisible(false);
        this.repaint();
        
        
    }

    /**
     * Performs an action when the graph button is clicked
     *
     * @param e an event representing an action being performed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == graphButton) {
            this.displayHeartGraph("Heart Rate Data", "Heart Rate");
        } else if (e.getSource() == prevButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, -1);
            showDay(currDayView);
            nextButton.setVisible(true);
        } else if (e.getSource() == nextButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, 1);
            if (currDayView.equals(fitbitInfo.getLastRefreshTime())
                    || currDayView.after(fitbitInfo.getLastRefreshTime())) {
                this.refresh(); //use refresh and not showDay so fitbitInfo is shown instead of newly pulled data
                nextButton.setVisible(false);
            } else {
                showDay(currDayView);
            }
        }
    }

    /**
     * Shows a set date to the user
     *
     * @param dayToShow the date that the user is changing to
     */
    private void showDay(Calendar dayToShow) {
        HeartData heartInfo;

        if (fitbitInfo.isTestMode()) { //checks if in Test Mode
            FitbitInfo info = new FitbitInfo();
            info.testModeData();
            heartInfo = info.getHeart();
        } else {
            try {
                heartInfo = Api.getHeartSummary(new SimpleDateFormat("yyyy-MM-dd").format(dayToShow.getTime()));
            } catch (JSONException ex) {
                heartInfo = new HeartData(new SimpleDateFormat("yyyy-MM-dd").format(dayToShow.getTime()), 0, 0, 0, 0, 0, 0, 0, 0, 0);
                System.out.println("Due to API Restrictions, Heart Rate Data not available for " + heartInfo.getDate());
            } catch (RefreshTokenException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
                return; //so that the data does not update
            }
        }

        double roundedPeakCal = Math.round(heartInfo.getPeakCalsOut() * 100.0) / 100.0;
        double roundedCardioCal = Math.round(heartInfo.getCardioCalsOut() * 100.0) / 100.0;
        double roundedFatCal = Math.round(heartInfo.getFatBurnCalsOut() * 100.0) / 100.0;
        double roundedOutCal = Math.round(heartInfo.getOutOfRangeCalsOut() * 100.0) / 100.0;

        date.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(dayToShow.getTime()));
        restingRate.setText("\t Resting Heart Rate: \t" + heartInfo.getRestingHeartRate() + " bpm");
        col1.setText("" + heartInfo.getPeakMins() + " mins");
        col2.setText("" + roundedPeakCal + " cals");
        col3.setText("" + heartInfo.getCardioMins() + " mins");
        col4.setText("" + roundedCardioCal + " cals");
        col5.setText("" + heartInfo.getFatBurnMins() + " mins");
        col6.setText("" + roundedFatCal + " cals");
        col7.setText("" + heartInfo.getOutOfRangeMins() + " mins");
        col8.setText("" + roundedOutCal + " cals");
    
        this.repaint();
    }

    /**
     * displayHeartGraph() method, loads time series data from the api, and
     * displays a graph based on data
     *
     * @param title Title of graph String
     * @param yAxisTitle Title of y axis String
     */
    private void displayHeartGraph(String title, String yAxisTitle) {
        if (fitbitInfo.isTestMode()) {
            JOptionPane.showMessageDialog(new JFrame(), "Heart Rate Graph not available in test mode");
        } else {
            try {
                TimeGraph graph = new TimeGraph(title, yAxisTitle, Api.getTimeSeriesData(new SimpleDateFormat("yyyy-MM-dd").format(currDayView.getTime()), "heart", 1));
                graph.showGraph();
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "There was an error accessing heart rate data on this day, try again later");
            } catch (RefreshTokenException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Unable to open Heart Rate graph, outdated tokens file");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "An unexpected error occured");
            }
        }
    }
}
