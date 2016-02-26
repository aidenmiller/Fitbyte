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

public class Accolades extends JPanel {

    private JToggleButton menuButton;

    public Accolades() {
        super();
        initPanel();
        initMenuButton();
    }

    private void initPanel() {
        this.setBackground(Color.BLUE); //Color of the menu bar
        JLabel text = new JLabel("This is a JLabel on the Accolades panel");
        this.add(text);
    }

    private void initMenuButton() {
        ImageIcon icon = new ImageIcon(getFile("accolades.png"));
        ImageIcon iconP = new ImageIcon(getFile("accolades_pressed.png"));
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

    public JToggleButton getMenuButton() {
        return this.menuButton;
    }
    
    public void refresh() {
        System.out.println("Accolades Refreshing");
    }

    /* Found this method online - deals with finding images after packaging */
    private BufferedImage getFile(String fileName) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        BufferedImage image = null;

        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
        }

        return image;

    }
}
