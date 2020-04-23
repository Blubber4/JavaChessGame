package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Queen Class inherited from the abstract Piece class
 *
 */

public class Queen extends ChessPiece {

    public Queen(PieceColor color) {
        super("Queen.png", color);
    }

    // Move Function Defined
    protected ArrayList<Point> generatePossibleMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();
        for (int i = 1; i < 8; i++) {
            moves.add(new Point(0, i));
            moves.add(new Point(i, 0));
            moves.add(new Point(-1 * i, 0));
            moves.add(new Point(0, -1 * i));
        }
        for (int i = 1; i < 8; i++) {
            moves.add(new Point(i, i));
            moves.add(new Point(-1 * i, -1 * i));
            moves.add(new Point(i, -1 * i));
            moves.add(new Point(-1 * i, i));
        }
        return moves;
    }
}