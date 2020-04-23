package app;

import java.awt.Point;
import java.util.ArrayList;

public class King extends ChessPiece {
    public King(PieceColor color) {
        super("King.png", color);
    }

    protected ArrayList<Point> generatePossibleMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();
        moves.add(new Point(0, 1));
        moves.add(new Point(1, 0));
        moves.add(new Point(1, 1));
        moves.add(new Point(0, -1));
        moves.add(new Point(-1, 0));
        moves.add(new Point(-1, -1));
        moves.add(new Point(1, -1));
        moves.add(new Point(-1, 1));
        return moves;
    }

    // Implement a function to check if king is under threat

    // Need to check whether there is any piece of opposite color that can attack
    // king for a given board state

    // Need to check for attack from left,right,up and down

    // Need to check for attack from diagonal direction

    // Need to check for attack from the Knight of opposite color

    // Need to check for attack from the Pawn of opposite color

}
