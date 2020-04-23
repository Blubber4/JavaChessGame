package app;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

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
        Rook whiteRook = new Rook("a", "b", 1);
        whiteRook.setlocation(new Point(1, 0));
        allPieces.add(whiteRook);
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
        // call deselect
        // if there is a piece at point x,y
        // select that piece
        // call setPossibleMoves
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
    }

    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        Point scaledP = new Point(p.x / 75, p.y / 75); // this is scaled to board position
        if(selected == null) {
        	ChessPiece clicked = getpiece(scaledP.x, scaledP.y);
        	if(clicked != null) {
        		this.selected = clicked;
        	}
        }
        // if not selected and there is a piece there
        	// select that piece
        // if selected and scaledP is a possibleMove
        	// move piece
        // if selected and scaledP is not a possibleMove
        	// deselect
        this.repaint(); // this is not working
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
            g.drawRect(selected.getlocation().x * 75, selected.getlocation().y * 75, 75, 75);
        }
        // highlight possible moves in blue
        g.setColor(Color.blue);
        for (int i = 0; i < possibleMoves.size(); i++) {
            g.drawRect(possibleMoves.get(i).x * 75, possibleMoves.get(i).y, 75, 75);
        }
        // draw all pieces
        for (int i = 0; i < allPieces.size(); i++) {
            allPieces.get(i).draw(g);
        }
    }
}
