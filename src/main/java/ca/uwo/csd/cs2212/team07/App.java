package ca.uwo.csd.cs2212.team07;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main class for the FitBit Program
 *
 * @author team07
 */
public class App {

    /**
     * Runs the MainWindow class with given arguments
     *
     * @param args checks to see if the command line argument given is "test" to
     * enable test mode
     */
    public static void main(String[] args) {
        
        try {
            // Set cross-platform Java L&F (basic look and feel)
            UIManager.setLookAndFeel("javax.swing.plaf.basic");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        final int mode;
        if (args.length > 0 && args[0].equals("test")) {
            mode = 1; //test mode
        } else {
            mode = 0; //normal mode
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow window = new MainWindow(mode);
                window.setVisible(true);
            }
        });

    }
}
