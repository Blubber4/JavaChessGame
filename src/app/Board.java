package app;

import java.awt.*;
import javax.swing.*;

/**
 * This is the Board Class. 
 * There are total of 64 cells that together makes up the Chess Board
 * This sets up the grid and allows each cell to have a chess piece.
 */

abstract class Board extends GameObject implements Cloneable{

    private static final long serialVersionUID = 1L;
    private boolean ispossibledestination;
	private JLabel content;
	private ChessPiece piece;
	int x,y; //is public because this is to be accessed by all the other class
	private boolean isSelected=false;
    private boolean ischeck=false;
    
    //instance vars
    protected String image_filename;
    protected Image image;

    public Board( int x, int y, ChessPiece p)
	{		
		this.x = x;
		this.y = y;
		
		setLayout(new BorderLayout());
	
	    if(( x + y ) % 2 == 0)
	        setBackground(new Color(113,198,113));
	    else
	     setBackground(Color.white);
	    if( p != null)
		    setPiece( p );
	}

    public void setPiece(ChessPiece p) //Function to inflate a box with a piece
	{
		piece = p;
		ImageIcon img = new javax.swing.ImageIcon( this.getClass().getResource(p.getPath()));
		content = new JLabel( img );
		this.add( content );
    }
    
    public void removePiece() //Function to remove a piece from the cell
	{
		if ( piece instanceof King )
		{
			piece = null;
			this.remove(content);
		}
		else
		{
			piece = null;
			this.remove( content );
		}
    }
    
    public ChessPiece getpiece() //Function to access piece of a particular cell
	{
		return this.piece;
	}
	
	public void select() //Function to mark a cell indicating it's selection
	{
		this.setBorder( BorderFactory.createLineBorder(Color.red,6));
		this.isSelected = true;
	}
	
	public boolean isselected() //Function to return if the cell is under selection
	{
		return this.isSelected;
	}
	
	public void deselect() //Function to delselect the cell
	{
		this.setBorder(null);
		this.isSelected = false;
	}
	
	public void setpossibledestination() //Function to highlight a cell to indicate that it is a possible valid move
	{
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.ispossibledestination = true;
	}
	
	public void removepossibledestination() //Remove the cell from the list of possible moves
	{
		this.setBorder(null);
		this.ispossibledestination = false;
	}
	
	public boolean ispossibledestination()    //Function to check if the cell is a possible destination 
	{
		return this.ispossibledestination;
	}
	
	public void setcheck() //Function to highlight the current cell as checked (For King)
	{
		this.setBackground(Color.RED);
		this.ischeck = true;
	}
	
	public void removecheck() //Function to deselect check
	{
		this.setBorder(null);
		if( ( x + y ) % 2 == 0)
			setBackground( new Color(113,198,113));
		else
			setBackground(Color.white);
		this.ischeck = false;
	}
	
	public boolean ischeck() //Function to check if the current cell is in check
	{
		return ischeck;
	}
}
