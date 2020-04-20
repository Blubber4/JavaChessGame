package app;

import java.util.ArrayList;

/**
 * This is the Rook class inherited from abstract Piece class
 *
 */

public class Rook extends ChessPiece{

  public Rook(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
  }

  //Move function defined
  public ArrayList<Board> move(Board state[][],int x,int y){
    //Rook can move only horizontally or vertically
    possiblemoves.clear();
  }
}
