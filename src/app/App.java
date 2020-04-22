package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * This is the Main Class of our project. All GUI Elements are declared,
 * initialized and used in this class itself. It is inherited from the JFrame
 * Class of Java's Swing Library.
 */

public class App extends JPanel {
	private static final long serialVersionUID = 1L;

	//config params for window
	private final int HEIGHT = 800;
	private final int WIDTH = 1000;

	private JFrame mainFrame, gameFrame;
	private GamePanel gamePanel = new GamePanel();


	// private ArrayList<Board> destinationlist = new ArrayList<Board>();

	public static void main(String[] args) {
		new App();
	}


	public App() {

		//MAIN CONTENT FRAME
		mainFrame = new JFrame("Chess Game");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
		mainFrame.setMinimumSize(new DimensionUIResource(WIDTH, HEIGHT));
		mainFrame.setMaximumSize(new DimensionUIResource(WIDTH, HEIGHT));

		//GAME CONTENT FRAME
		gameFrame = new JFrame("Chess Game");

		JButton startButton = new JButton("New Game");
		mainFrame.add(startButton);
		startButton.setBounds(100,100,100,50);


		startButton.addActionListener(new START());

		mainFrame.setVisible(true);
		mainFrame.setResizable(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}

	class START implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		mainFrame.dispose();
		gameFrame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
		gameFrame.setMinimumSize(new DimensionUIResource(WIDTH, HEIGHT));
		gameFrame.setMaximumSize(new DimensionUIResource(WIDTH, HEIGHT));
		gameFrame.add(gamePanel);
		gameFrame.setContentPane(gamePanel);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(true);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}
}
