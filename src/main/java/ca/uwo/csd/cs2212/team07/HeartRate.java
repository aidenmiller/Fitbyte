package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class HeartRate extends JPanel {

    private JToggleButton menuButton;
    private FitbitInfo fitbitInfo;
    private FileReader file;

    /**
     * Constructor for the HeartRate class
     *
     * @param info FitBit data for the user to display
     */
    public HeartRate(FitbitInfo info) {
        super();
        fitbitInfo = info;
        initPanel();
        initMenuButton();
    }

    /**
     * Creates the panel to display the page to the user with the relevant
     * information.
     */
    private void initPanel() {
        file = new FileReader();
        this.setBackground(Color.MAGENTA); //Color of the menu bar
        JLabel text = new JLabel("This is a JLabel on the Heart Rate Zones panel");
        this.add(text);
    }

    /**
     * Creates a Menu Button to be displayed on the menu bar of the program
     */
    private void initMenuButton() {
        ImageIcon icon = new ImageIcon(file.getFile("heartrate.png"));
        ImageIcon iconP = new ImageIcon(file.getFile("heartrate_pressed.png"));
        menuButton = new JToggleButton();
        menuButton.setToolTipText("Heart Rate Zones");
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

    /**
     * Returns the Menu Button for this page
     *
     * @return a JToggleButton for this page
     */
    public JToggleButton getMenuButton() {
        return this.menuButton;
    }

    /**
     * Refreshes the info on this page with the info contained in the FitbitInfo
     * provided
     *
     * @param info the FitbitInfo provided with new data
     */
    public void refreshInfo(FitbitInfo info) {
        System.out.println("Heart Rate Refreshing");
    }

}
