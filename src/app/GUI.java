package app;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel {
    private static final long serialVersionUID = 1L;

    // config params for window
    private final int HEIGHT = 650;
    private final int WIDTH = 1000;

    // cached references
    private JFrame manuMenuFrame, gameFrame;
    private Board board;

    public GUI() {
        initMainWindow();
        initMainMenu();
    }
    
    // INITIALIZES MAIN CONTENT FRAME
    private void initMainWindow() {
        this.manuMenuFrame = new JFrame("Chess Game");
        manuMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        manuMenuFrame.setSize(300, 200);

        // mainFrame.setVisible(true);
        manuMenuFrame.setResizable(false);
        manuMenuFrame.setLocationRelativeTo(null);
    }

    private void initMainMenu() {
        // initialize title pane
        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new LineBorder(Color.BLACK, 3));
        titlePanel.setBackground(Color.YELLOW);
        manuMenuFrame.add(titlePanel, BorderLayout.NORTH);

        // add new title to title pane
        JLabel titleLabel = new JLabel("Welcome to Chess!");
        titleLabel.setFont(new Font("SERIF", Font.BOLD, 30));
        titlePanel.add(titleLabel);
        

        // initialize bottom main menu panel
        JPanel bottomMenuPanel = new JPanel(new GridLayout(1, 2));
        bottomMenuPanel.setBackground(Color.WHITE);
        manuMenuFrame.add(bottomMenuPanel);

        // initialize bottom menu buttons
        JButton cancelButton = new JButton("Exit");
        cancelButton.addActionListener(new CANCEL());
        bottomMenuPanel.add(cancelButton);

        JButton startButton = new JButton("New Game");
        startButton.addActionListener(new START());
        bottomMenuPanel.add(startButton);

        // make menu frame visible
        manuMenuFrame.setVisible(true);
    }

    private class EXITPOPUP implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // init exit frame
            JFrame exitFrame = new JFrame("Exit?");
            exitFrame.setLocationRelativeTo(null);
            exitFrame.setSize(250, 75);

            // init exit panel
            JPanel exitPanel = new JPanel();
            exitPanel.setBackground(Color.RED);
            exitFrame.add(exitPanel);

            // init buttons and content
            JButton yesButton = new JButton("Yes");
            yesButton.addActionListener(new CANCEL());
            exitPanel.add(yesButton);

            JButton noButton = new JButton("No");
            noButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exitFrame.dispose();
                    exitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });
            exitPanel.add(noButton);

            // make exit frame visible
            exitFrame.setVisible(true);
        }
    }

    private void showWinScreen() {
        JFrame winningFrame = new JFrame("WINNER!");
        JPanel winningPanel = new JPanel();
        winningFrame.add(winningPanel);
        winningPanel.setBackground(Color.GREEN);
    }

    private void showLossScreen() {
        JFrame losingFrame = new JFrame("LOSER!");
        JPanel losingPanel = new JPanel();
        losingFrame.add(losingPanel);
    }

    // placeholder, might or might not need this
    private void gameOver() {

    }

    private void updateTurn() {

    }

    // function to initialize game, host all board properties and control panel subclasses
    public void initChessGame() {
        // initilize main chess game frame
        gameFrame = new JFrame("Chess Game");
        gameFrame.setSize(new DimensionUIResource(WIDTH, HEIGHT));

        JLabel whitePlayer = new JLabel("White's Turn");
        JLabel blackPlayer = new JLabel("Black's Turn");

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new RESTART());

        JButton popupButton = new JButton("Exit");
        popupButton.addActionListener(new EXITPOPUP());

        JPanel topMenuPanel = new JPanel();
        topMenuPanel.setBackground(Color.YELLOW);

        JPanel bottomMenuPanel = new JPanel();
        bottomMenuPanel.setBackground(Color.YELLOW);

        JPanel showPlayerPanel = new JPanel();
        
        // showPlayerPanel.add(whitePlayer);//testing player placement
        // showPlayerPanel.add(blackPlayer); //testing, time placement holder

        this.board = new Board();

        if (board.isBlackTurn() == false) {
            showPlayerPanel.add(whitePlayer);
            showPlayerPanel.remove(blackPlayer);
            showPlayerPanel.repaint();
        } else {
            showPlayerPanel.remove(whitePlayer);
            showPlayerPanel.add(blackPlayer);
            showPlayerPanel.repaint();

        }

        topMenuPanel.add(showPlayerPanel);
        JSplitPane controlSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topMenuPanel, bottomMenuPanel);
        controlSplit.setOneTouchExpandable(true);
        controlSplit.setDividerLocation(550);

        bottomMenuPanel.add(restartButton);
        bottomMenuPanel.add(popupButton);

        GamePanel gamePanel = new GamePanel();
        JSplitPane gameSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gamePanel, controlSplit);
        gameFrame.add(gameSplit);
        gameFrame.setContentPane(gameSplit);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(true);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* BUTTON ACTIONS BELOW */

    // Cancel Button Action
    private class CANCEL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // New game button Action
    private class START implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            manuMenuFrame.dispose();
            initChessGame();
        }
    }

    // Restart game button Action
    private class RESTART implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame restartFrame = new JFrame("Restart?");
            JPanel restartPanel = new JPanel();
            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");
            restartFrame.add(restartPanel);
            restartPanel.setBackground(Color.RED);
            restartPanel.add(yesButton);
            restartPanel.add(noButton);

            // restart
            yesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restartFrame.dispose();
                    gameFrame.dispose();
                    initChessGame();
                    restartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });

            // close frame
            noButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restartFrame.dispose();
                    restartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });
            restartFrame.setLocationRelativeTo(null);
            restartFrame.setSize(250, 75);
            restartFrame.setVisible(true);
        }
    }
}