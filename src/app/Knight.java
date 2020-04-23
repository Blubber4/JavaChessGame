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
    protected ArrayList<Point> generatePossibleMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();
        moves.add(new Point(-2, 1));
        moves.add(new Point(-2, -1));
        moves.add(new Point(-1, 2));
        moves.add(new Point(-1, -2));
        moves.add(new Point(1, 2));
        moves.add(new Point(1, -2));
        moves.add(new Point(2, 1));
        moves.add(new Point(2, -1));
        return moves;
    }
}