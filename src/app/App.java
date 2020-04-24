package app;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

/**
 * This is the Main Class of our project. All GUI Elements are declared,
 * initialized and used in this class itself. It is inherited from the JFrame
 * Class of Java's Swing Library.
 */

public class App extends JPanel {
	private static final long serialVersionUID = 1L;

	//config params for window
	private final int HEIGHT = 650;
	private final int WIDTH = 1000;

	private JFrame mainFrame, gameFrame, exitFrame, winningFrame, losingFrame, restartFrame;
	private JPanel titlePanel, bottomMenuPanel, topMenuPanel, showPlayerPanel, exitPanel, winningPanel, losingPanel, restartPanel;
	private GamePanel gamePanel = new GamePanel(); //function to call the board
	private JButton startButton, cancelButton, restartButton, yesButton, noButton, popupButton;
	private JSplitPane gameSplit, controlSplit;
	private JLabel titleLabel, whitePlayer, blackPlayer;
	// private ArrayList<Board> destinationlist = new ArrayList<Board>();

	public static void main(String[] args) {
		new App();
	}

	public App() {
		//MAIN CONTENT FRAME
		mainFrame = new JFrame("Chess Game");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300,200);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);

		titlePanel = new JPanel();
		titleLabel = new JLabel("Welcome to Chess!");
			titleLabel.setFont(new Font("SERIF", Font.BOLD, 30));
		titlePanel.setBorder(new LineBorder(Color.BLACK, 3));
		titlePanel.setBackground(Color.YELLOW);
		titlePanel.add(titleLabel);
		mainFrame.add(titlePanel, BorderLayout.NORTH);

		cancelButton = new JButton("Exit");
		startButton = new JButton("New Game"); 
		bottomMenuPanel = new JPanel(new GridLayout(1,2)); 
		bottomMenuPanel.setBackground(Color.WHITE);
		bottomMenuPanel.add(startButton);
		bottomMenuPanel.add(cancelButton);
		startButton.addActionListener(new START());
		cancelButton.addActionListener(new CANCEL());
		mainFrame.add(bottomMenuPanel); 
	}

	//Cancel Button Action
	private class CANCEL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	//New game button Action
	private class START implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		mainFrame.dispose();
		chessGameGUI();
		}
	}
	//Restart game button Action
	private class RESTART implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		restartFrame = new JFrame("Restart?");  
		restartPanel = new JPanel(); 
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		restartFrame.add(restartPanel);
		restartPanel.setBackground(Color.RED);
		restartPanel.add(yesButton); 
		restartPanel.add(noButton);

		//restart 
		yesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				restartFrame.dispose();
				chessGameGUI();
				restartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}});

		//close frame
		noButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				restartFrame.dispose();
				restartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}});
			restartFrame.setLocationRelativeTo(null);
			restartFrame.setSize(250,75);  
			restartFrame.setVisible(true); 
		}
	}

	private class EXITPOPUP implements ActionListener{
		public void actionPerformed(ActionEvent e){
		exitFrame = new JFrame("Exit?");  
		exitPanel = new JPanel(); 
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		exitFrame.add(exitPanel);
		exitPanel.setBackground(Color.RED);
		exitPanel.add(yesButton); 
		exitPanel.add(noButton);
		yesButton.addActionListener(new CANCEL());
		noButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			exitFrame.dispose();
			exitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}});
		exitFrame.setLocationRelativeTo(null);
		exitFrame.setSize(250,75);  
		exitFrame.setVisible(true); 
		}
	} 

	private void winningScreen(){
		winningFrame = new JFrame("WINNDER!");
		winningPanel = new JPanel();
		winningFrame.add(winningPanel);
		winningPanel.setBackground(Color.GREEN);

	}

	private void losingScreen(){
		losingFrame = new JFrame("LOSER!");
		losingPanel = new JPanel();
		losingFrame.add(losingPanel);

	}

	//placeholder, might or might not need this
	private void gameOver(){

	}

	//function to host all board properties and control panel subclasses
	public void chessGameGUI() {
		//Main chess game frame
		gameFrame = new JFrame("Chess Game");
		gameFrame.setSize(new DimensionUIResource(WIDTH, HEIGHT));
		//gameFrame.setMinimumSize(new DimensionUIResource(WIDTH, HEIGHT));
		//gameFrame.setMaximumSize(new DimensionUIResource(WIDTH, HEIGHT));

		whitePlayer = new JLabel("White's Turn");
		blackPlayer = new JLabel("Black's Turn");

		restartButton = new JButton("Restart");
		popupButton = new JButton("Exit");

		restartButton.addActionListener(new RESTART());
		popupButton.addActionListener(new EXITPOPUP());
		

		topMenuPanel = new JPanel();
		bottomMenuPanel = new JPanel();
		showPlayerPanel  = new JPanel();
		topMenuPanel.setBackground(Color.YELLOW);
		bottomMenuPanel.setBackground(Color.YELLOW);
		showPlayerPanel.add(whitePlayer);//testing player placement
		topMenuPanel.add(showPlayerPanel);
		topMenuPanel.add(blackPlayer); //testing, time placement holder
		controlSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topMenuPanel, bottomMenuPanel);
		controlSplit.setOneTouchExpandable(true);
		controlSplit.setDividerLocation(550);

		bottomMenuPanel.add(restartButton);
		bottomMenuPanel.add(popupButton);


		gameSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gamePanel, controlSplit);
		gameFrame.add(gameSplit);
		gameFrame.setContentPane(gameSplit);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(true);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
