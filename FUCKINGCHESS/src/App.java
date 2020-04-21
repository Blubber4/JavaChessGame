
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * This is the Main Class of our project.
 * All GUI Elements are declared, initialized and used in this class itself.
 * It is inherited from the JFrame Class of Java's Swing Library. 
 */

public class App {
    private static final long serialVersionUID = 1L;
	JFrame frame;
    //config params for window 
    private final int HEIGHT = 1080;
	private final int WIDTH = 720;
    //private static Rook wr01,wr02,br01,br02;
	//private static Knight wk01,wk02,bk01,bk02;
	//private static Bishop wb01,wb02,bb01,bb02;
	//private static Pawn wp[],bp[];
	//private static Queen wq,bq;
    //private static King wk,bk;
    //private ArrayList<Board> destinationlist = new ArrayList<Board>();
	//private JLabel label,mov;
	//private Container content;

    //private JPanel board = new JPanel(new GridLayout(8,8));
    public static App Mainboard;
    static String move;


    public static void main(String[] args) {
/*
		//variable initialization for each chess piece
		//We can change this if necessary
	    wr01 = new Rook("WR01","White_Rook.png",0);
	    wr02 = new Rook("WR02","White_Rook.png",0);
	    br01 = new Rook("BR01","Black_Rook.png",1);
	    br02 = new Rook("BR02","Black_Rook.png",1);
	    wk01 = new Knight("WK01","White_Knight.png",0);
	    wk02 = new Knight("WK02","White_Knight.png",0);
	    bk01 = new Knight("BK01","Black_Knight.png",1);
	    bk02 = new Knight("BK02","Black_Knight.png",1);
	    wb01 = new Bishop("WB01","White_Bishop.png",0);
	    wb02 = new Bishop("WB02","White_Bishop.png",0);
	    bb01 = new Bishop("BB01","Black_Bishop.png",1);
	    bb02 = new Bishop("BB02","Black_Bishop.png",1);
	    wq = new Queen("WQ","White_Queen.png",0);
	    bq = new Queen("BQ","Black_Queen.png",1);
	    wk = new King("WK","White_King.png",0,7,3);
	    bk = new King("BK","Black_King.png",1,0,3);
	    wp = new Pawn[8];
	    bp = new Pawn[8];
	    for(int i = 0; i < 8; i++){
		    wp[i] = new Pawn("WP0" + (i + 1), "White_Pawn.png", 0);
		    bp[i] = new Pawn("BP0" + (i + 1), "Black_Pawn.png", 1);
		}
		
		*/

	    //Setting up the board
        new App();
	    //Mainboard.setVisible(true);	
    }

    public App(){

		JButton button = new JButton("exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocation(200,200);
		frame.setVisible(true);
		
		/*
		JFrame board = new JFrame("Chess");
        board.setMinimumSize(new Dimension(720,480));
		//board.setBorder(BorderFactory.createLoweredBevelBorder());
		//content = getContentPane();
		board.setSize(WIDTH, HEIGHT);
		//content.setBackground(Color.black);
		*/


	}
	


}
