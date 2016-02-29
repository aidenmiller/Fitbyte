package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Creates an Accolades panel that displays the Accolades to the user
 *
 * @author team07
 */
public class Accolades extends JPanel {

    private JToggleButton menuButton;
    private FitbitInfo fitbitInfo;

    /**
     * Constructor for the Accolades class
     *
     * @param info FitBit data for the user to display
     */
    public Accolades(FitbitInfo info) {
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
        this.setBackground(Color.BLUE); //Color of the menu bar
        JLabel text = new JLabel("This is a JLabel on the Accolades panel");
        this.add(text);
    }

    /**
     * Creates a Menu Button to be displayed on the menu bar of the program
     */
    private void initMenuButton() {
        ImageIcon icon = new ImageIcon(FileReader.getImage("accolades.png"));
        ImageIcon iconP = new ImageIcon(FileReader.getImage("accolades_pressed.png"));
        menuButton = new JToggleButton();
        menuButton.setToolTipText("Accolades");
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
        System.out.println("Accolades Refreshing");
    }

}
