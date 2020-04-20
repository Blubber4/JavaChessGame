package app;

import java.util.ArrayList;

/**
 * This is the Queen Class inherited from the abstract Piece class
 *
 */

public class Queen extends ChessPiece{

    public Queen(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}

    //Move Function Defined
	public ArrayList<Board> move(Board state[][],int x,int y)
	{
		//Queen has most number of possible moves
		//Queen can move any number of steps in all 8 direction
		//The possible moves of queen is a combination of Rook and Bishop
		possiblemoves.clear();
		
		//Have to check for possible moves in vertical direction

		
		//Have to check for possible moves in horizontal Direction
		
		
		//Have to check for possible moves in diagonal direction
	}
}