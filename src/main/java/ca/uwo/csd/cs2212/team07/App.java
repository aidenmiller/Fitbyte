package ca.uwo.csd.cs2212.team07;

import javax.swing.SwingUtilities;

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
