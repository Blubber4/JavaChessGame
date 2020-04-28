package app;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel {
    private static final long serialVersionUID = 1L;

    // config params
    private final int HEIGHT = 650;
    private final int WIDTH = 1000;
    private final int REFRESH_RATE = 10;

    // cached references
    private JFrame manuMenuFrame, gameFrame;
    private GamePanel gamePanel;
    private Board board;
    private JLabel currentTurn;
    private Timer timer;

    private boolean check = true;

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

    //winning a game notification
    private void showWinnerScreen() {
        JFrame winningFrame = new JFrame("WINNER!");
        JPanel winningPanel = new JPanel();
        JLabel winningLabel = new JLabel("CheckMate!");
        winningPanel.add(winningLabel);
        winningFrame.add(winningPanel);
        winningPanel.setBackground(Color.GREEN);
        winningFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winningFrame.setLocationRelativeTo(null);
        winningFrame.setVisible(true);
    }
    
    //losing a game notification
    private void showLoserScreen() {
        JFrame losingFrame = new JFrame("LOSER!");
        JPanel losingPanel = new JPanel();
        JLabel losingLabel = new JLabel("Better luck next time!");
        losingPanel.add(losingLabel);
        losingFrame.add(losingPanel);
        losingPanel.setBackground(Color.WHITE);
        losingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        losingFrame.setLocationRelativeTo(null);
        losingFrame.setVisible(true);
    }
    
    //notify player; king in check
    private void kingCheck() {
        JFrame checkFrame = new JFrame();
        JPanel checkPanel = new JPanel();
        JLabel kingCheckLabel = new JLabel("King is in Check!");
        kingCheckLabel.setSize(20, 20); //you can delete this if u want
        checkFrame.setSize(200, 100);
        checkPanel.add(kingCheckLabel);
        checkFrame.add(checkPanel);
        checkPanel.setBackground(Color.RED);
        checkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkFrame.setLocationRelativeTo(null);
        checkFrame.setVisible(true);
    }

    private void setTurn(String turn) {
        this.currentTurn.setText(turn);
    }

    // function to initialize game, host all board properties and control panel subclasses
    public void initChessGame() {
        // initilize main chess game frame
        gameFrame = new JFrame("Chess Game");
        gameFrame.setSize(new DimensionUIResource(WIDTH, HEIGHT));

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new RESTART());

        JButton popupButton = new JButton("Exit");
        popupButton.addActionListener(new EXITPOPUP());

        JPanel topMenuPanel = new JPanel();
        topMenuPanel.setBackground(Color.YELLOW);

        JPanel bottomMenuPanel = new JPanel();
        bottomMenuPanel.setBackground(Color.YELLOW);

        JPanel showPlayerPanel = new JPanel();
        this.currentTurn = new JLabel("White's turn");
        currentTurn.setFont(new Font("Verdana",    1 , 20));
        showPlayerPanel.add(currentTurn);

        topMenuPanel.add(showPlayerPanel);
        JSplitPane controlSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topMenuPanel, bottomMenuPanel);
        controlSplit.setOneTouchExpandable(true);
        controlSplit.setDividerLocation(550);

        bottomMenuPanel.add(restartButton);
        bottomMenuPanel.add(popupButton);

        this.gamePanel = new GamePanel();
        this.board = gamePanel.getBoard();
        JSplitPane gameSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gamePanel, controlSplit);
        gameFrame.add(gameSplit);
        gameFrame.setContentPane(gameSplit);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(true);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // timer for updating player turn on GUI- 
        timer = new Timer(REFRESH_RATE, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if (board.isBlackTurn()) {
                    setTurn("Black's Turn");
                } else {
                    setTurn("White's Turn");
                }

                if (board.check && check) {
                    kingCheck();
                }

                if (board.winner != null) {
                    showWinnerScreen();
                }
            }
        });
        timer.start();
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