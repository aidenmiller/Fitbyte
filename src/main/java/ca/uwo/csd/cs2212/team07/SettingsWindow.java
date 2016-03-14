package ca.uwo.csd.cs2212.team07;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Creates a Main Window that displays the program to the user.
 *
 * @author team07
 */
public class SettingsWindow extends JFrame implements ActionListener {

    private final UserConfig userConfig;
    private JButton cancelButton;
    private JButton saveButton;
    private JRadioButton caloriesOn;
    private JRadioButton caloriesOff;
    private JRadioButton distanceOn;
    private JRadioButton distanceOff;
    private JRadioButton floorsOn;
    private JRadioButton floorsOff;

    /**
     * Constructs a new Main Window
     *
     * @param userConfig the user configuration
     */
    public SettingsWindow(UserConfig userConfig) {
        this.userConfig = userConfig;
        this.initUI();
    }

    private void initUI() {
        this.setTitle("Settings");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));

        caloriesOn = new JRadioButton("Yes");
        caloriesOff = new JRadioButton("No");
        JLabel calText = new JLabel("Show Calories: ");
        settingsPanel.add(this.makeField(calText, caloriesOn, caloriesOff, userConfig.isCaloriesData()));
        
        distanceOn = new JRadioButton("Yes");
        distanceOff = new JRadioButton("No");
        JLabel distText = new JLabel("Show Distance: ");
        settingsPanel.add(this.makeField(distText, distanceOn, distanceOff, userConfig.isDistanceData()));
        
        floorsOn = new JRadioButton("Yes");
        floorsOff = new JRadioButton("No");
        JLabel floorsText = new JLabel("Show Calories: ");
        settingsPanel.add(this.makeField(floorsText, floorsOn, floorsOff, userConfig.isFloorsData()));

        JPanel savecancelPanel = new JPanel();
        savecancelPanel.setLayout(new BoxLayout(savecancelPanel, BoxLayout.X_AXIS));
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        savecancelPanel.add(saveButton);
        savecancelPanel.add(cancelButton);
        settingsPanel.add(savecancelPanel);

        this.add(settingsPanel);
    }

    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            System.out.println("CANCEL");
            this.dispose();
            this.setVisible(false);
        }
    }

    private JPanel makeField(JLabel text, JRadioButton onButton, JRadioButton offButton, boolean storedBool) {
        ButtonGroup grpCalories = new ButtonGroup();
        grpCalories.add(onButton);
        grpCalories.add(offButton);
        onButton.setSelected(storedBool);
        offButton.setSelected(!storedBool);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.X_AXIS));
        fieldPanel.add(text);
        fieldPanel.add(onButton);
        fieldPanel.add(offButton);
        
        return fieldPanel;
    }
}
