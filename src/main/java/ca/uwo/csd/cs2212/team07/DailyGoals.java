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

    public DailyGoals(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    private void initPanel() {

        this.setBackground(Color.CYAN); //Color of the menu bar

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));

        this.add(date);

    }

    public void refresh() {
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));
    }

}
