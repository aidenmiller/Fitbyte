package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a Daily Goals panel that displays the Daily Goals to the user.
 *
 * @author team07
 */
public class DailyGoals extends JPanel {

    private final FitbitInfo fitbitInfo;

    private JLabel date;

    /**
     * Constructor for the Daily Goals class
     *
     * @param fitbitInfo container for user data
     */
    public DailyGoals(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    /**
     * Initializes the panel to display Daily Goals to the user
     */
    private void initPanel() {

        this.setBackground(Color.CYAN); //Color of the menu bar

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));

        this.add(date);

    }

    /**
     * Refresh the data displayed to the user
     */
    public void refresh() {
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
    }

    void refreshConfig() {
        System.out.println("To Implement");
    }

}
