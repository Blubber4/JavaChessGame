package app;

import java.util.ArrayList;

/**
 * This is the Bishop Class.
 * The Move Function defines the basic rules for movement of Bishop on a chess board
 * 
 */
public class Bishop extends ChessPiece {

    public Bishop(final String i, final String p, final int c) {
		setId(i);
		setPath(p);
		setColor(c);
    }
    
    //Move function is defined. It returns a list of all the possible destinations of a Bishop
	//The basic principle of Bishop Movement on chess board has been implemented
    public ArrayList<Board> move(final Board state[][], final int x, final int y)
	{
		//Bishop can Move diagonally in all 4 direction (NW,NE,SW,SE)
		//This function defines that logic
		possiblemoves.clear();
		//add Bishop moves here
		
	}

}