package app;

import java.util.ArrayList;

/**
 * This is the Pawn Class inherited from the piece
 *
 */

public class Pawn extends ChessPiece{

    public Pawn(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
    }

    //Move Function Overridden
	public ArrayList<Board> move(Board state[][],int x,int y)
	{
		//Pawn can move only one step except the first chance when it may move 2 steps
		//It can move in a diagonal fashion only for attacking a piece of opposite color
		//It cannot move backward or move forward to attact a piece
		
		possiblemoves.clear();
    }
}