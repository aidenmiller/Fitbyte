package ca.uwo.csd.cs2212.team07;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 * Creates a Settings Panel to be displayed in the JOptionPane.
 *
 * @author team07
 */
public class SettingsWindow extends JPanel {

    private UserConfig userConfig;
    private JRadioButton caloriesOn;
    private JRadioButton caloriesOff;
    private JRadioButton distanceOn;
    private JRadioButton distanceOff;
    private JRadioButton floorsOn;
    private JRadioButton floorsOff;
    private JRadioButton stepsOn;
    private JRadioButton stepsOff;
    private JRadioButton activeOn;
    private JRadioButton activeOff;
    private JRadioButton sedentaryOn;
    private JRadioButton sedentaryOff;

    private JRadioButton fatOn, fatOff;
    private JRadioButton peakOn, peakOff;
    private JRadioButton cardioOn, cardioOff;
    private JRadioButton outOn, outOff;
    private JToggleButton resetButton;

    /**
     * Constructs a new Main Window
     *
     * @param userConfig the user configuration
     */
    public SettingsWindow(UserConfig userConfig) {
        this.userConfig = userConfig;
        this.init();
    }

    private void init() {
        this.setSize(300, 400);

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        caloriesOn = new JRadioButton("Show");
        caloriesOff = new JRadioButton("Hide");
        JLabel calText = new JLabel("Calories Burned");
        this.add(this.makeField(calText, caloriesOn, caloriesOff, userConfig.isCaloriesData()));
        this.add(Box.createVerticalStrut(5));
        distanceOn = new JRadioButton("Show");
        distanceOff = new JRadioButton("Hide");
        JLabel distText = new JLabel("Distance Travelled");
        this.add(this.makeField(distText, distanceOn, distanceOff, userConfig.isDistanceData()));
        this.add(Box.createVerticalStrut(5));
        floorsOn = new JRadioButton("Show");
        floorsOff = new JRadioButton("Hide");
        JLabel floorsText = new JLabel("Floors Climbed");
        this.add(this.makeField(floorsText, floorsOn, floorsOff, userConfig.isFloorsData()));
        this.add(Box.createVerticalStrut(5));
        stepsOn = new JRadioButton("Show");
        stepsOff = new JRadioButton("Hide");
        JLabel stepsText = new JLabel("Steps Taken");
        this.add(this.makeField(stepsText, stepsOn, stepsOff, userConfig.isStepsData()));
        this.add(Box.createVerticalStrut(5));
        activeOn = new JRadioButton("Show");
        activeOff = new JRadioButton("Hide");
        JLabel activeText = new JLabel("Active Minutes");
        this.add(this.makeField(activeText, activeOn, activeOff, userConfig.isActiveData()));
        this.add(Box.createVerticalStrut(5));
        sedentaryOn = new JRadioButton("Show");
        sedentaryOff = new JRadioButton("Hide");
        JLabel sedentaryText = new JLabel("Sedentary Minutes");
        this.add(this.makeField(sedentaryText, sedentaryOn, sedentaryOff, userConfig.isSedentaryData()));

        this.add(Box.createVerticalStrut(15));
        JLabel fatText = new JLabel("Fat Zone");
        fatOn = new JRadioButton("Show");
        fatOff = new JRadioButton("Hide");
        this.add(this.makeField(fatText, fatOn, fatOff, userConfig.isFatVisible()));
        this.add(Box.createVerticalStrut(5));
        JLabel peakText = new JLabel("Peak Zone");
        peakOn = new JRadioButton("Show");
        peakOff = new JRadioButton("Hide");
        this.add(this.makeField(peakText, peakOn, peakOff, userConfig.isPeakVisible()));
        this.add(Box.createVerticalStrut(5));
        JLabel cardioText = new JLabel("Cardio Zone");
        cardioOn = new JRadioButton("Show");
        cardioOff = new JRadioButton("Hide");
        this.add(this.makeField(cardioText, cardioOn, cardioOff, userConfig.isCardioVisible()));
        this.add(Box.createVerticalStrut(5));
        JLabel outText = new JLabel("Out Of Range Zone");
        outOn = new JRadioButton("Show");
        outOff = new JRadioButton("Hide");
        this.add(this.makeField(outText, outOn, outOff, userConfig.isOutVisible()));

        this.setVisible(true);
    }

    private JPanel makeField(JLabel text, JRadioButton onButton, JRadioButton offButton, boolean storedBool) {
        ButtonGroup grpCalories = new ButtonGroup();
        grpCalories.add(onButton);
        grpCalories.add(offButton);
        onButton.setSelected(storedBool);
        offButton.setSelected(!storedBool);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setOpaque(false);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.X_AXIS));
        fieldPanel.add(Box.createHorizontalStrut(10));
        fieldPanel.add(text);
        fieldPanel.add(Box.createHorizontalGlue());
        fieldPanel.add(Box.createHorizontalStrut(30));
        fieldPanel.add(onButton);
        fieldPanel.add(offButton);
        fieldPanel.add(Box.createHorizontalStrut(10));

        return fieldPanel;
    }

    public void saveSettings() {
        userConfig.setCaloriesData(caloriesOn.isSelected());
        userConfig.setDistanceData(distanceOn.isSelected());
        userConfig.setFloorsData(floorsOn.isSelected());
        userConfig.setStepsData(stepsOn.isSelected());
        userConfig.setActiveData(activeOn.isSelected());
        userConfig.setSedentaryData(sedentaryOn.isSelected());
        userConfig.setFatVisible(fatOn.isSelected());
        userConfig.setPeakVisible(peakOn.isSelected());
        userConfig.setCardioVisible(cardioOn.isSelected());
        userConfig.setOutVisible(outOn.isSelected());
    }

}
