package app;

import java.awt.Point;
import java.util.ArrayList;

public class King extends ChessPiece {
    public King(PieceColor color) {
        super("King.png", color);
    }

    public ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        Point loc = this.getlocation();
        moves.add(new Point(loc.x, loc.y + 1));
        moves.add(new Point(loc.x + 1, loc.y));
        moves.add(new Point(loc.x + 1, loc.y + 1));
        moves.add(new Point(loc.x, loc.y - 1));
        moves.add(new Point(loc.x - 1, loc.y));
        moves.add(new Point(loc.x - 1, loc.y - 1));
        moves.add(new Point(loc.x + 1, loc.y - 1));
        moves.add(new Point(loc.x - 1, loc.y + 1));
        ArrayList<Point> movesOnBoard = new ArrayList<Point>();
        for (Point p : moves) {
            ChessPiece tmp = this.getPiece(p, board);
            if (this.onBoard(p) && (tmp == null || tmp.getColor() != this.getColor())) {
                movesOnBoard.add(p);
            }
        }
        this.possiblemoves = movesOnBoard;
        return movesOnBoard;
    }

    // Implement a function to check if king is under threat

    // Need to check whether there is any piece of opposite color that can attack
    // king for a given board state

    // Need to check for attack from left,right,up and down

    // Need to check for attack from diagonal direction

    // Need to check for attack from the Knight of opposite color

    // Need to check for attack from the Pawn of opposite color

}
