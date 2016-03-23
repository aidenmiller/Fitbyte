package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import org.json.JSONException;
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
    private JToggleButton graphButton;
    private Calendar currDayView;
    private JLabel date, date2;
    private JLabel col1, col2, col3, col4;
    private JLabel col5, col6, col7, col8;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, px;
    private final Image heartBackground;

    /**
     * Constructor for the class HeartRate
     *
     * @param fitbitInfo
     */
    public HeartRate(FitbitInfo fitbitInfo, UserConfig userConfig) {
        super();
        heartBackground = new ImageIcon(FileReader.getImage("iconmafia/heartbackground.png")).getImage();
        this.fitbitInfo = fitbitInfo;
        this.userConfig = userConfig;
        renderingGUI();
        this.refresh();
    }

    @Override

    /**
     * draws the background of the HeartRate Page
     */
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

        px.setBackground(new Color(0, 0, 0, 220));
        p1.setBackground(new Color(0, 0, 0, 200));
        p2.setBackground(new Color(0, 0, 0, 200));
        p3.setBackground(new Color(0, 0, 0, 170));
        p4.setBackground(new Color(0, 0, 0, 170));
        p5.setBackground(new Color(0, 0, 0, 140));
        p6.setBackground(new Color(0, 0, 0, 140));
        p7.setBackground(new Color(0, 0, 0, 110));
        p8.setBackground(new Color(0, 0, 0, 110));

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

        graphButton = new JToggleButton();
        graphButton.addActionListener(this);
        graphButton.setToolTipText("Click here to view your own personal heartrate graph");
        ImageIcon icon = new ImageIcon(FileReader.getImage("iconmafia/graph3.png"));
        graphButton.setIcon(icon);
        px.add(graphButton);
        graphButton.setRolloverIcon(new ImageIcon(FileReader.getImage("iconmafia/graph2.png")));

        p1.add(iconLabel1);
        p2.add(iconLabel2);
        p3.add(iconLabel3);
        p4.add(iconLabel4);
        p5.add(iconLabel5);
        p6.add(iconLabel6);
        p7.add(iconLabel7);
        p8.add(iconLabel8);

        JLabel a1 = new JLabel("Peak Zone: ");
        JLabel a2 = new JLabel("Calories Burnt: ");
        JLabel a3 = new JLabel("Cardio Zone: ");
        JLabel a4 = new JLabel("Calories Burnt: ");
        JLabel a5 = new JLabel("Fat Zone: ");
        JLabel a6 = new JLabel("Calories Burnt: ");
        JLabel a7 = new JLabel("OOR Zone: ");
        JLabel a8 = new JLabel("Calories Burnt: ");

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

        px.add(Box.createHorizontalStrut(200));
        p1.add(Box.createHorizontalStrut(135));
        p2.add(Box.createHorizontalStrut(135));
        p3.add(Box.createHorizontalStrut(135));
        p4.add(Box.createHorizontalStrut(135));
        p5.add(Box.createHorizontalStrut(135));
        p6.add(Box.createHorizontalStrut(135));
        p7.add(Box.createHorizontalStrut(135));
        p8.add(Box.createHorizontalStrut(135));

        date = new JLabel(new SimpleDateFormat("MMMM d").format(fitbitInfo.getLastRefreshTime().getTime()));
        date2 = new JLabel("Resting Heart Rate: " + fitbitInfo.getHeart().getRestingHeartRate());
        col1 = new JLabel("" + fitbitInfo.getHeart().getPeakMins() + " mins");
        col2 = new JLabel("" + fitbitInfo.getHeart().getPeakCalsOut() + " cal");
        col3 = new JLabel("" + fitbitInfo.getHeart().getCardioMins() + " mins");
        col4 = new JLabel("" + fitbitInfo.getHeart().getCardioCalsOut() + " cal");
        col5 = new JLabel("" + fitbitInfo.getHeart().getFatBurnMins() + " mins");
        col6 = new JLabel("" + fitbitInfo.getHeart().getFatBurnCalsOut() + " cal");
        col7 = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeMins() + " mins");
        col8 = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeCalsOut() + " cal");

        date.setToolTipText("today's date");
        date2.setToolTipText("current resting heart rate");
        col1.setToolTipText("minutes spent in this zone");
        col2.setToolTipText("1 cal = 4.184 J");
        col3.setToolTipText("minutes spent in this zone");
        col4.setToolTipText("1 cal = 4.184 J");
        col5.setToolTipText("minutes spent in this zone");
        col6.setToolTipText("1 cal = 4.184 J");
        col7.setToolTipText("minutes spent in this zone");
        col8.setToolTipText("1 cal = 4.184 J");

        date.setFont(new Font("Arial", Font.BOLD, 14));
        date2.setFont(new Font("Arial", Font.BOLD, 14));
        col1.setFont(new Font("Arial", Font.BOLD, 14));
        col2.setFont(new Font("Arial", Font.BOLD, 14));
        col3.setFont(new Font("Arial", Font.BOLD, 14));
        col4.setFont(new Font("Arial", Font.BOLD, 14));
        col5.setFont(new Font("Arial", Font.BOLD, 14));
        col6.setFont(new Font("Arial", Font.BOLD, 14));
        col7.setFont(new Font("Arial", Font.BOLD, 14));
        col8.setFont(new Font("Arial", Font.BOLD, 14));

        date.setForeground(Color.white);
        date2.setForeground(Color.white);
        col1.setForeground(Color.white);
        col2.setForeground(Color.white);
        col3.setForeground(Color.white);
        col4.setForeground(Color.white);
        col5.setForeground(Color.white);
        col6.setForeground(Color.white);
        col7.setForeground(Color.white);
        col8.setForeground(Color.white);

        px.add(date2);
        px.add(Box.createHorizontalStrut(200));
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

        setSize(600, 400);
        setVisible(true);
    }

    /**
     * Refreshes the Heart Rate data of an individual
     */
    public void refresh() {
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date.setText(new SimpleDateFormat("MMMM d").format(fitbitInfo.getLastRefreshTime().getTime()));
        date2.setText("" + fitbitInfo.getHeart().getRestingHeartRate());
        col1.setText("" + fitbitInfo.getHeart().getPeakMins());
        col2.setText("" + fitbitInfo.getHeart().getCardioMins());
        col3.setText("" + fitbitInfo.getHeart().getFatBurnMins());
        col4.setText("" + fitbitInfo.getHeart().getOutOfRangeMins());
        col5.setText("" + fitbitInfo.getHeart().getPeakCalsOut());
        col6.setText("" + fitbitInfo.getHeart().getCardioCalsOut());
        col7.setText("" + fitbitInfo.getHeart().getFatBurnCalsOut());
        col8.setText("" + fitbitInfo.getHeart().getOutOfRangeCalsOut());
        
        p1.setVisible(userConfig.isPeakVisible());
        p2.setVisible(userConfig.isPeakVisible());
        p3.setVisible(userConfig.isCardioVisible());
        p4.setVisible(userConfig.isCardioVisible());
        p5.setVisible(userConfig.isFatVisible());
        p6.setVisible(userConfig.isFatVisible());
        p7.setVisible(userConfig.isOutVisible());
        p8.setVisible(userConfig.isOutVisible());
    }

    /**
     * Performs an action when the graph button is clicked
     *
     * @param e an event representing an action being performed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == graphButton) {
            //    JFrame ViewGraphGUI = new JFrame();
            //    new ViewGraphGUI();
        }
    }

    /**
     * Shows today's date to the user
     *
     * @param dayToShow today's date that the user is seeing
     */
    private void showDay(Calendar dayToShow) {
        Daily dayInfo;
        if (fitbitInfo.getDay().getDate().equals("yyyy-MM-dd")) { //checks if in Test Mode
            FitbitInfo info = new FitbitInfo();
            info.testModeData();
            dayInfo = info.getDay();
        } else {
            try {
                dayInfo = Api.getDailySummary(new SimpleDateFormat("yyyy-MM-dd").format(dayToShow.getTime()));
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Unable to display data.");
                return; //so that the data does not update
            } catch (RefreshTokenException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
                return; //so that the data does not update
            }
        }
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(dayToShow.getTime()));
        date2.setText("" + fitbitInfo.getHeart().getRestingHeartRate());
        col1 = new JLabel("" + fitbitInfo.getHeart().getPeakMins());
        col2 = new JLabel("" + fitbitInfo.getHeart().getPeakCalsOut());
        col3 = new JLabel("" + fitbitInfo.getHeart().getCardioMins());
        col4 = new JLabel("" + fitbitInfo.getHeart().getCardioCalsOut());
        col5 = new JLabel("" + fitbitInfo.getHeart().getFatBurnMins());
        col6 = new JLabel("" + fitbitInfo.getHeart().getFatBurnCalsOut());
        col7 = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeMins());
        col8 = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeCalsOut());
        
     
        
    }
}
