package ca.uwo.csd.cs2212.team07;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        final int mode;
        if (args.length > 0 && args[0].equals("test")) {
            mode = 1;
        } else {
            mode = 0;
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //need to check args to see if to run in test mode or not
                MainWindow window = new MainWindow();
                window.setVisible(true);
            }
        });

    }
}
