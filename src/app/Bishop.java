package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Bishop Class. The Move Function defines the basic rules for
 * movement of Bishop on a chess board
 * 
 */
public class Bishop extends ChessPiece {

    public Bishop(PieceColor color) {
        super("Bishop.png", color);
    }

    // Move function is defined. It returns a list of all the possible destinations
    // of a Bishop
    // The basic principle of Bishop Movement on chess board has been implemented
    protected ArrayList<Point> generatePossibleMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();
        for (int i = 1; i < 8; i++) {
            moves.add(new Point(i, i));
            moves.add(new Point(-1 * i, -1 * i));
            moves.add(new Point(i, -1 * i));
            moves.add(new Point(-1 * i, i));
        }
        return moves;
    }
}