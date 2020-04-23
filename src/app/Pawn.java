package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Pawn Class inherited from the piece
 *
 */

public class Pawn extends ChessPiece {

    public Pawn(PieceColor color) {
        super("Pawn.png", color);
    }

    // Move Function Overridden
    protected ArrayList<Point> generatePossibleMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();

        return moves;
    }
}