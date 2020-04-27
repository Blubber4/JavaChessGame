package app;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
<<<<<<< Updated upstream
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
=======

>>>>>>> Stashed changes

/**
 * This is the Main Class of our project. 
 */

public class App extends JPanel {
	private static final long serialVersionUID = 1L;
<<<<<<< Updated upstream

	//config params for window
	private final int HEIGHT = 800;
	private final int WIDTH = 1000;

	private JFrame mainFrame, gameFrame, titleFrame;
	private JPanel titlePanel, controlPanel, bottomMenuPanel;
	private GamePanel gamePanel = new GamePanel();
	private JButton startButton, cancelButton;
	private JSplitPane split;
	private JLabel titleLabel;
	private Container mainDisplay;


	// private ArrayList<Board> destinationlist = new ArrayList<Board>();

	public static void main(String[] args) {
		new App();
	}


	public App() {

		menuPanel();
		initMainFrame();
		mainTitlePanel();

		gameFrame = new JFrame("Chess Game");
		gameFrame.setSize(WIDTH, HEIGHT);


	}

	public void menuPanel(){


	}

	public void mainTitlePanel(){
		titlePanel = new JPanel();
		titleLabel = new JLabel("Welcome to Chess!");
			titleLabel.setFont(new Font("SERIF", Font.BOLD, 30));
		titlePanel.setBorder(new LineBorder(Color.BLACK, 3));
		titlePanel.setBackground(Color.YELLOW);
		titlePanel.add(titleLabel);
		mainFrame.add(titlePanel, BorderLayout.NORTH);




	}
 
	public void initMainFrame(){
		//MAIN CONTENT FRAME
		mainFrame = new JFrame("Chess Game");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300,200);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);

		cancelButton = new JButton("Cancel");
		startButton = new JButton("New Game"); 
		bottomMenuPanel = new JPanel(new GridLayout(1,2)); 
		bottomMenuPanel.setBackground(Color.WHITE);
		//bottomMenuPanel.setLayout(new BorderLayout());
		bottomMenuPanel.add(startButton);
		bottomMenuPanel.add(cancelButton);
		startButton.addActionListener(new START());
		cancelButton.addActionListener(new CANCEL());

		mainFrame.add(bottomMenuPanel); 



	}

	class CANCEL implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	class START implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		//GAME CONTENT FRAME
		mainFrame.dispose();
		gameFrame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
		gameFrame.setMinimumSize(new DimensionUIResource(WIDTH, HEIGHT));
		gameFrame.setMaximumSize(new DimensionUIResource(WIDTH, HEIGHT));
		gameFrame.add(gamePanel);
		//split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gameFrame, controlPanel);
		gameFrame.setContentPane(gamePanel);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(true);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
=======
	public static void main(String[] args) {
		this.GUI = new GUI();
>>>>>>> Stashed changes
	}
}
