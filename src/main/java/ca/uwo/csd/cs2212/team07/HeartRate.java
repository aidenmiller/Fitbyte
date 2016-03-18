/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import org.json.JSONException;
/**
 *Create a heartrate panel that displays the heartrate information to the user
 * 
 * @author team07
 */
public class HeartRate extends JPanel implements ActionListener {
    
    private final FitbitInfo fitbitInfo;
    private JToggleButton graphButton;
    
    private JLabel date;
    private JLabel heartRateRestingData;
    private JLabel heartRateFatData;
    private JLabel heartRateCardioData;
    private JLabel heartRatePeakData;
    private JLabel heartrateData;
    private JLabel heartRateOutOfRangeData;
    
    private JPanel heartRestingPanel;
    private JPanel heartFatPanel;
    private JPanel heartCardioPanel;
    private JPanel heartPeakPanel;
    private JPanel heartOutOfRangePanel;
    
    private Calendar currDayView;

    private JButton prevButton, nextButton;

    private ButtonGroup buttonGroup;
    //private JToggleButton todayButton, bestButton, lifetimeButton;
    private JPanel timeData;
    
    public HeartRate(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }
    /**
     * Initializes the panel that displays the Dashboard
     */
    private void initPanel(){
        this.setBackground(Color.darkGray);
        JPanel bar = new JPanel();
        bar.setBackground(new Color(50,50,50));
        bar.setLayout(new GridLayout(3,6));
        //JPanel iconBar = new JPanel();
        //iconBar.setOpaque(false);
      //  iconBar.setLayout(new BoxLayout(iconBar, Box))
        buttonGroup = new ButtonGroup();
        graphButton = makeMenuButton("Graph", "dataicons/graph.png","dataicons/show.png");
        bar.add(graphButton);
        
        
        JPanel displayPanel = new JPanel();
        displayPanel.setOpaque(false);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.add(Box.createHorizontalGlue());
        //displayPanel.add(todayButton);
        //displayPanel.add(Box.createRigidArea(new Dimension(10, 40)));
        //displayPanel.add(bestButton);
        //displayPanel.add(Box.createRigidArea(new Dimension(10, 40)));
        //displayPanel.add(lifetimeButton);
        //displayPanel.add(Box.createHorizontalGlue());
        
        
        //Time data for changing views
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        heartRateRestingData = new JLabel("" + fitbitInfo.getHeart().getRestingHeartRate());
        
        prevButton = new JButton(new ImageIcon(FileReader.getImage("previous.png")));
        prevButton.addActionListener(this);
        prevButton.setBorderPainted(false);
        nextButton = new JButton(new ImageIcon(FileReader.getImage("next.png")));
        nextButton.addActionListener(this);
        nextButton.setBorderPainted(false);

        
     //   timeData = new JPanel();
       // timeData.setOpaque(false);
        //timeData.setLayout(new BoxLayout(timeData, BoxLayout.X_AXIS));
        //timeData.add(Box.createHorizontalGlue());
        //timeData.add(prevButton);
        //timeData.add(Box.createRigidArea(new Dimension(10, 40)));
        //timeData.add(date);
       // timeData.add(Box.createRigidArea(new Dimension(10, 40)));
     //   timeData.add(nextButton);
    //    timeData.add(Box.createHorizontalGlue());
        //timeData.add(heartRestingPanel);
        //start from here
        
      //  heartRateRestingData = new JLabel("" + fitbitInfo.getHeart().getRestingHeartRate());
        heartRestingPanel = this.createHeader(new JLabel("Resting Heart Rate:"), heartRateRestingData,"dataicons/graph.png", Color.cyan);
        heartRestingPanel.setOpaque(false);
        
        heartRateFatData = new JLabel("" + fitbitInfo.getHeart().getFatBurnMins());
        heartFatPanel = this.createDataBox(new JLabel("Fat Burn Minutes"), heartRateFatData,"dataicons/fat.png", Color.PINK);
        
        heartRateCardioData = new JLabel("" + fitbitInfo.getHeart().getCardioMins());
        heartCardioPanel = this.createDataBox(new JLabel("Cardio Minutes"), heartRateCardioData,"dataicons/cardio.png", Color.RED);     
        
        heartRatePeakData = new JLabel("" + fitbitInfo.getHeart().getPeakMins());
        heartPeakPanel = this.createDataBox(new JLabel("Peak Minutes"), heartRatePeakData,"dataicons/peak.png", Color.WHITE);     
        
        heartRateOutOfRangeData = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeMins());
        heartOutOfRangePanel = this.createDataBox(new JLabel("Out Of Range Minutes"), heartRateOutOfRangeData,"dataicons/outofrange.png", Color.blue);     
       
        //heartRateMinuteData = new JLabel("" + fitbitInfo.getDay().getHeartRateMinute());
        //JPanel heartMinuteData = this.createDataBox(new JLabel("Total Distance"), heartRateMinuteData, Color.yellow);
           
        //heartRateThirtyData = new JLabel("" + fitbitInfo.getDay().getHeartRateThirty());
        //JPanel heartThirtyData = this.createDataBox(new JLabel("Total Distance"), heartRateThirtyData, Color.yellow);

        //heartRateMonthData = new JLabel("" + fitbitInfo.getDay().getHeartRateMonth());
        //JPanel heartMonthData = this.createDataBox(new JLabel("Total Distance"), heartRateMonthData, Color.yellow);

        this.setLayout(new BorderLayout());
        //Layout Specifications - Top
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(displayPanel);
        //topPanel.add(timePanel);
        this.add(topPanel, BorderLayout.NORTH);
        //Layout Specifications - WEST and EAST
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        westPanel.setOpaque(false);
        eastPanel.setOpaque(false);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        //Layout Specifications - Center
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        //centerPanel.add(Box.createVerticalStrut(30));
        //centerPanel.add(heartRestingPanel);
        centerPanel.add(heartRestingPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(heartFatPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(heartCardioPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(heartPeakPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(heartOutOfRangePanel);
        this.add(centerPanel, BorderLayout.CENTER);

        //sets the view to Today
        //todayButton.doClick();
    }

    /**
     * Create a data box for one of the data items displayed on the Dashboard
     *
     * @param header name of data item
     * @param data the data to display
     * @param color the color of the data box
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox(JLabel header, JLabel data, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        //ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        //JLabel iconLabel = new JLabel(iconImage);
        panel.add(Box.createHorizontalGlue());
        //panel.add(iconLabel);
        
        panel.add(header);
        panel.add(Box.createHorizontalStrut(150));
        panel.add(data);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }
    
    /**
     * Create a data box for one of the data items displayed on the Dashboard
     *
     * @param header name of data item
     * @param data the data to display
     * @param color the color of the data box
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox(JLabel header, JLabel data,String iconFile, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        JLabel iconLabel = new JLabel(iconImage);
        panel.add(Box.createHorizontalGlue());
        panel.add(iconLabel);
        
        panel.add(header);
        panel.add(Box.createHorizontalStrut(150));
        panel.add(data);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }
    
    private JPanel createHeader(JLabel header, JLabel data, String iconFile, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        JLabel iconLabel = new JLabel(iconImage);
        panel.add(Box.createHorizontalGlue());
        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(header);
        panel.add(Box.createHorizontalStrut(1));
        panel.add(data);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }
    
    /**
     * Refreshes the Dashboard after refreshing the data in FitbitInfo or
     * returning to Today's view
     */
    public void refresh() {
        //todayButton.setSelected(true);
        timeData.setVisible(true);
        currDayView = (Calendar) fitbitInfo.getLastRefreshTime().clone();
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
        //heartMinuteData.setText("" + fitbitInfo.getDay().getSedentaryMins());
        //heartThirtyData.setText("" + fitbitInfo.getDay().getActiveMins());
        //heartHourData.setText("" + fitbitInfo.getDay().getSteps());
        //heartTwelveData.setText("" + fitbitInfo.getDay().getFloors());
        //heartDayData.setText("" + fitbitInfo.getDay().getDistance());
        heartRateRestingData.setText("" + fitbitInfo.getHeart().getRestingHeartRate());
        heartRateRestingData.setText("" + fitbitInfo.getHeart().getFatBurnMins());
        heartRateRestingData.setText("" + fitbitInfo.getHeart().getCardioMins());
        heartRateRestingData.setText("" + fitbitInfo.getHeart().getPeakMins());
        heartRateOutOfRangeData.setText("" + fitbitInfo.getHeart().getOutOfRangeMins());
    }
    
    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            currDayView.add(Calendar.DAY_OF_MONTH, -1);
            showDay(currDayView);
            nextButton.setVisible(true);
        } else if(e.getSource() == graphButton){
            //cardLayout.show(cardPane, "Dashboard");
        }
        else if (e.getSource() == nextButton) {
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
     * Shows the day provided in the parameter to the user.
     *
     * @param dayToShow the day to show to the user
     */
  //  private void showDay(Calendar dayToShow) {
  //      FitbitInfo dayInfo = new FitbitInfo();

//        if (fitbitInfo.getDay().getDate().equals("yyyy-MM-dd")) { //checks if in Test Mode
//            dayInfo.generateTestData();
//            
//        } else {
//            try {
//                dayInfo.refreshInfo(dayToShow);
//            } catch (JSONException ex) {
//                JOptionPane.showMessageDialog(new JFrame(), "Unable to display data.");
//            } catch (RefreshTokenException ex) {
//                JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
//            }
//        }
   /**
     * Shows the day provided in the parameter to the user.
     *
     * @param dayToShow the day to show to the user
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
        
        //heartNowData.setText("" + dayInfo.getDay().getHeartNow());
        //heartHourData.setText("" + dayInfo.getDay().getHeartHour());
        //heartTwelveData.setText("" + dayInfo.getDay().getHeartTwelve());
        //heartDayData.setText("" + dayInfo.getDay().getHeartDay());
        //heartMonthData.setText("" + dayInfo.getDay().getHeartMonth());
        heartRateRestingData.setText("" + fitbitInfo.getHeart().getRestingHeartRate());
        heartRateFatData = new JLabel("" + fitbitInfo.getHeart().getFatBurnMins());
        heartRateCardioData = new JLabel("" + fitbitInfo.getHeart().getCardioMins());
        heartRatePeakData = new JLabel("" + fitbitInfo.getHeart().getPeakMins());
        heartRateOutOfRangeData = new JLabel("" + fitbitInfo.getHeart().getOutOfRangeMins());
        
    }
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
}