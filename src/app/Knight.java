package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Knight Class inherited from the Piece abstract class
 * 
 *
 */

public class Knight extends ChessPiece {
    public Knight (PieceColor color) {
        super("Knight.png", color);
    }

    // Move Function overridden
    // There are at max 8 possible moves for a knight at any point of time.
    // Knight moves only 2(1/2) steps
    public ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        moves.add(new Point(-2, 1));
        moves.add(new Point(-2, -1));
        moves.add(new Point(-1, 2));
        moves.add(new Point(-1, -2));
        moves.add(new Point(1, 2));
        moves.add(new Point(1, -2));
        moves.add(new Point(2, 1));
        moves.add(new Point(2, -1));
        ArrayList<Point> moves2 = new ArrayList<Point>();
        Point currentLoc = this.getlocation();
        for(Point p : moves) {
        	Point test = new Point(currentLoc.x + p.x, currentLoc.y + p.y);
        	ChessPiece tmp = super.getPiece(test, board);
        	if(this.onBoard(test) && (tmp == null || tmp.getColor() != this.getColor())) {
        		moves2.add(test);
        	}
        }
        return moves2;
    }
}