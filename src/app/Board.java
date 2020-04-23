package app;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import app.ChessPiece.PieceColor;

public class Board extends JComponent {
    ArrayList<ChessPiece> allPieces = new ArrayList<ChessPiece>(); // all chess pieces on the board
    ArrayList<Point> possibleMoves = new ArrayList<Point>(); // possible moves to be highlighted
    ChessPiece selected; // null if no piece is selected

    // instance vars

    public Board() {
        // initialize a new board
        super();
        this.setSize(600, 600); // I don't think this is drawing right
    }

    public void createPieces() { // clears the board and creates pieces for a new game
        deselect();
        
        ChessPiece chessPiece = new Rook(PieceColor.WHITE);
        chessPiece.setlocation(new Point(0, 0));
        allPieces.add(chessPiece);

        chessPiece = new Rook(PieceColor.WHITE);
        chessPiece.setlocation(new Point(7,0));
        allPieces.add(chessPiece);

        chessPiece = new King(PieceColor.WHITE);
        chessPiece.setlocation(new Point(4, 0));
        allPieces.add(chessPiece);

        chessPiece = new Queen(PieceColor.WHITE);
        chessPiece.setlocation(new Point(3, 0));
        allPieces.add(chessPiece);

        chessPiece = new Knight(PieceColor.WHITE);
        chessPiece.setlocation(new Point(1, 0));
        allPieces.add(chessPiece);

        chessPiece = new Knight(PieceColor.WHITE);
        chessPiece.setlocation(new Point(6, 0));
        allPieces.add(chessPiece);

        chessPiece = new Bishop(PieceColor.WHITE);
        chessPiece.setlocation(new Point(2, 0));
        allPieces.add(chessPiece);

        chessPiece = new Bishop(PieceColor.WHITE);
        chessPiece.setlocation(new Point(5, 0));
        allPieces.add(chessPiece);

        for (int i = 0; i < 8; i++) {
            chessPiece = new Pawn(PieceColor.WHITE);
            chessPiece.setlocation(new Point(i, 1));
            allPieces.add(chessPiece);
        }

        chessPiece = new King(PieceColor.BLACK);
        chessPiece.setlocation(new Point(3, 7));
        allPieces.add(chessPiece);
    }

    public void setPiece(ChessPiece p) // add a piece to the board
    {
        allPieces.add(p);
    }

    public ChessPiece getpiece(int x, int y) // Function to access piece of a particular cell, return null if no piece
    {
        Point loc = new Point(x, y);
        for (int i = 0; i < allPieces.size(); i++) {
        	Point iLoc = allPieces.get(i).getlocation();
            if (iLoc.x == loc.x && iLoc.y == loc.y) {
                return allPieces.get(i);
            }
        }
        return null;
    }

    public void select(int x, int y) // Function to mark a cell indicating it's selection
    {
    	deselect();
    	ChessPiece clicked = getpiece(x, y);
    	if(clicked != null) {
    		this.selected = clicked;
    		this.setPossibleMoves(clicked);
    	}
    }

    public void deselect() // Function to delselect the cell
    {
        removepossibledestination();
        this.selected = null;
    }

    public void setpossibledestination(int x, int y) // Function to highlight a cell to indicate that it is a possible
                                                     // valid move
    {
        this.possibleMoves.add(new Point(x, y));
    }

    public void removepossibledestination() // clear the possible destinations
    {
        this.possibleMoves = new ArrayList<Point>();
    }

    private void setPossibleMoves(ChessPiece p) {
        // fills the possibleMoves array for the selected piece
    	ArrayList<Point> pMoves = p.possiblemoves;
    	Point pLoc = p.getlocation();
    	for(Point move : pMoves) {
    		Point attemptedMove = new Point(move.x + pLoc.x, move.y + pLoc.y);
    		if(onBoard(attemptedMove)) {
    			this.possibleMoves.add(attemptedMove);
    		}
    	}
    }
    
    private boolean onBoard(Point p) {
    	if(p.x < 0 || p.y < 0 || p.x > 7|| p.y > 7) {
    		return false;
    	}
    	return true;
    }
    
    private void moveSelected(Point p) {
    	// move the selected piece to point p
    	ChessPiece capture = getpiece(p.x, p.y);
    	if(capture != null) {
    		allPieces.remove(capture);
    	}
    	selected.setlocation(p);
    	deselect();
    }

    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        Point scaledP = new Point(p.x / 75, p.y / 75); // this is scaled to board position
        if(selected == null) {
        	select(scaledP.x, scaledP.y);
        }
        // if not selected and there is a piece there
        	// select that piece
        else {
        	if(possibleMoves.contains(scaledP)) {
        		moveSelected(scaledP);
        		deselect();
        	} else {
        		deselect();
        	}
        }
        // if selected and scaledP is a possibleMove
        	// move piece
        // if selected and scaledP is not a possibleMove
        	// deselect
        this.callRepaint();
    }
    
    private void callRepaint() {
    	SwingUtilities.invokeLater(new Runnable()
    	{
    	    public void run()
    	    {
    	        repaint();
    	    }
    	}); 
    }

    public void update() {
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        int blockSizeX = this.getSize().width / 8;
        int blockSizeY = this.getSize().height / 8;
        for (int pos = 0; pos < 8 * 8; pos++) {
            int x = (pos % 8) * blockSizeX;
            int y = (pos / 8) * blockSizeY;
            int offset = (pos % 16) < 8 ? 0 : 1;
            Color color = (pos + offset) % 2 == 0 ? Color.WHITE : Color.BLACK;
            g.setColor(color);
            g.fillRect(x, y, blockSizeX, blockSizeY);
        }
        // highlight the selected piece
        if (this.selected != null) {
            g.setColor(Color.yellow);
            g.fillRect(selected.getlocation().x * 75, selected.getlocation().y * 75, 75, 75);
        }
        // highlight possible moves in blue
        g.setColor(Color.blue);
        for (int i = 0; i < possibleMoves.size(); i++) {
            g.fillRect(possibleMoves.get(i).x * 75, possibleMoves.get(i).y * 75, 75, 75);
        }
        // draw all pieces
        for (int i = 0; i < allPieces.size(); i++) {
            allPieces.get(i).draw(g);
        }
    }
}
