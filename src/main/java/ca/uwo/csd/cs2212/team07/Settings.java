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

/**
 * Creates a Settings panel that displays the User Settings to the user
 *
 * @author team07
 */
public class Settings extends JPanel {

    private JToggleButton menuButton;
    private FileReader file;

    /**
     * Constructor for the Settings class
     */
    public Settings() {
        super();
        initPanel();
        initMenuButton();
    }

    /**
     * Creates the panel to display the page to the user with the relevant
     * information.
     */
    private void initPanel() {
        file = new FileReader();
        this.setBackground(Color.CYAN); //Color of the menu bar
        JLabel text = new JLabel("This is a JLabel on the Settings panel");
        this.add(text);
    }

    /**
     * Creates a Menu Button to be displayed on the menu bar of the program
     */
    private void initMenuButton() {
        ImageIcon icon = new ImageIcon(file.getFile("settings.png"));
        ImageIcon iconP = new ImageIcon(file.getFile("settings_pressed.png"));
        menuButton = new JToggleButton();
        menuButton.setToolTipText("Settings");
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

}
