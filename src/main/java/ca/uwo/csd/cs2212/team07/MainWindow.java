package ca.uwo.csd.cs2212.team07;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class MainWindow extends JFrame {

	/* Container used to store the different panels (dashboard, daily goals, etc) */
	private JPanel cards;
	/* CardLayout used to switch between the different panels above using cardLayout.show() */
	private CardLayout cardLayout;
	/* Containers for each of the pages, these need to be be designed better (maybe separate classes for each panel) */
	private JPanel dashboard, dailyGoals, accolades, heartRate, settings;
	/* Object that groups together buttons like Radio Buttons, allowing only one to be selected */
	private ButtonGroup buttonGroup = new ButtonGroup(); 

	/* Constructor for this class, called by App*/
	public MainWindow() {
		/*calls initUI method below which does most of the work */
		this.initUI();
	}

	/* Most of the UI generation */
	private void initUI () {
		this.setTitle("FitBit Program - CS2212 Team07");  
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false); //disables resizing
		/* This will need to be removed at some point as only the X button created should close the app and Serialize data */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		/* BorderLayout allows positions through NORTH, EAST, SOUTH, WEST, etc. from the swingTut */
		this.setLayout(new BorderLayout());

		/* Below is the initialization of each of the panes and adding them to the CardLayout */
		cards = new JPanel(new CardLayout());

		dashboard = new JPanel();
		dashboard.setName("Dashboard"); //name required to change between panes using CardLayout... try to find more compact way
		dashboard.add(new JLabel("Dashboard!")); //temporary, used for testing to make sure CardLayout is working

		dailyGoals = new JPanel();
		dailyGoals.setName("Daily Goals");
		dailyGoals.add(new JLabel("Daily Goals!")); 

		accolades = new JPanel();
		accolades.setName("Accolades");
		accolades.add(new JLabel("Accolades!")); 

		heartRate = new JPanel();
		heartRate.setName("Heart Rate");
		heartRate.add(new JLabel("Heart Rate!")); 

		settings = new JPanel();
		settings.setName("Settings");
		settings.add(new JLabel("Settings!")); 

		/* Adding the panels to the cards panel with their names as identifiers */
		cards.add(dashboard,dashboard.getName());
		cards.add(dailyGoals,dailyGoals.getName());
		cards.add(accolades,accolades.getName());
		cards.add(heartRate,heartRate.getName());
		cards.add(settings,settings.getName());
		/* This creates the object that allows us to switch between panes */
		cardLayout = (CardLayout) (cards.getLayout());

		/* Adds the cards pane to the center, with the menu above (see below for menu) */
		this.add(this.createMenu(),BorderLayout.NORTH);
		this.add(cards,BorderLayout.CENTER);
	}

	private JPanel createMenu() {
		JPanel panel = new JPanel();

		/* Creates menu button for dashboard using JToggleButton (I would use JButton but wanted to use ButtonGroup) */
		JToggleButton dashboardButton = this.createMenuButton(getFile("dashboard.png"),getFile("dashboard_pressed.png"));
		buttonGroup.add(dashboardButton);
		/* MouseListeners... I have been trying to find a good way to compact all these into a method */
		//MouseListener for Dashboard
		dashboardButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Dashboard Button Pressed"); //for testing purposes
				cardLayout.show(cards, dashboard.getName());
			}
		});

		JToggleButton dailyGoalsButton = this.createMenuButton(getFile("dailygoals.png"),getFile("dailygoals_pressed.png"));
		buttonGroup.add(dailyGoalsButton);
		//MouseListener for Daily Goals
		dailyGoalsButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Daily Goals Button Pressed"); //for testing purposes
				cardLayout.show(cards, dailyGoals.getName());
			}
		});

		JToggleButton accoladesButton = this.createMenuButton(getFile("accolades.png"),getFile("accolades_pressed.png"));
		buttonGroup.add(accoladesButton);
		//MouseListener for Accolades
		accoladesButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Accolades Button Pressed"); //for testing purposes
				cardLayout.show(cards, accolades.getName());
			}
		});

		JToggleButton heartRateButton = this.createMenuButton(getFile("heartrate.png"),getFile("heartrate_pressed.png"));
		buttonGroup.add(heartRateButton);
		//MouseListener for Heart Rate
		heartRateButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Heart Rate Button Pressed"); //for testing purposes
				cardLayout.show(cards, heartRate.getName());
			}
		});

		JToggleButton settingsButton = this.createMenuButton(getFile("settings.png"),getFile("settings_pressed.png"));
		buttonGroup.add(settingsButton);
		//MouseListener for Settings
		settingsButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Settings Button Pressed"); //for testing purposes
				cardLayout.show(cards, settings.getName());
			}
		});

		JButton refreshButton = new JButton(new ImageIcon(getFile("refresh.png")));
		refreshButton.setBorderPainted(false);
		refreshButton.setRolloverIcon(new ImageIcon(getFile("refresh_pressed.png")));
		/* JLabel to display the last refreshed time, initially will be never but should pull from stored data...*/
		final JLabel refreshLabel = new JLabel("last synced: never");
		/* Literally just to make the font smaller, but allows font change if we want to */
		refreshLabel.setFont(new Font(refreshLabel.getFont().getName(),Font.PLAIN,10));
		//MouseListener for Refresh
		refreshButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Refresh Button Pressed"); //for testing purposes
				Date date = new Date(); //Generates the current date
				/* Formats the date into a readable format */
				SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss aa zzz");
				/* Sets the label to display the new last synced time */
				refreshLabel.setText("last synced: " + sdf.format(date));
			}
		});

		JButton exitButton = new JButton(new ImageIcon(getFile("exit.png")));
		exitButton.setBorderPainted(false);
		exitButton.setRolloverIcon(new ImageIcon(getFile("exit_pressed.png")));
		//MouseListener for Exit
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Exit Button Pressed"); //for testing purposes
				System.exit(0); //this needs to be handle serialization of data and make sure program closes properly
			}
		});

		/* All of the below is for layout purposes (from swingTut)... might choose a different layout option if I find one */
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(dashboardButton)
								.addComponent(dailyGoalsButton)
								.addComponent(accoladesButton)
								.addComponent(heartRateButton)
								.addComponent(settingsButton)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(refreshLabel)
								.addComponent(refreshButton)
								.addComponent(exitButton)
								)
						)
				);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(dashboardButton)
						.addComponent(dailyGoalsButton)
						.addComponent(accoladesButton)
						.addComponent(heartRateButton)
						.addComponent(settingsButton)
						.addComponent(refreshButton)
						.addComponent(exitButton)
						.addComponent(refreshLabel)
						)
				);

		panel.setLayout(layout);
		panel.setBackground(Color.ORANGE); //Color of the menu bar

		return panel;
	}

	/* Used to compact the creation of the menu buttons Dashboard, Daily Goals, etc. */
	/* Hoping to be able to move mouseListener into here, but we will see... */
	private JToggleButton createMenuButton(BufferedImage icon, BufferedImage iconPressed) {
		JToggleButton button = new JToggleButton(new ImageIcon(icon));
		button.setBorderPainted(false);
		ImageIcon iconP = new ImageIcon(iconPressed);
		button.setRolloverIcon(iconP);
		button.setSelectedIcon(iconP);
		button.setRolloverSelectedIcon(iconP);

		return button;
	}

	private BufferedImage getFile(String fileName) {

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(fileName);

		BufferedImage image = null;
		
		try {
			image = ImageIO.read(is);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return image;

	}

}