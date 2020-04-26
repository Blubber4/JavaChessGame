package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Bishop Class. The Move Function defines the basic rules for
 * movement of Bishop on a chess board
 */
public class Bishop extends ChessPiece {

    public Bishop(PieceColor color) {
        super("Bishop.png", color);
    }

    // Move function is defined. It returns a list of all the possible destinations
    // of a Bishop
    // The basic principle of Bishop Movement on chess board has been implemented
    public ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        Point loc = this.getlocation();
        boolean upRightBlocked = false;
        boolean downRightBlocked = false;
        boolean upLeftBlocked = false;
        boolean downleftBlocked = false;
        for (int i = 1; i < 8; i++) {
            if (!downRightBlocked) {
                Point downRight = new Point(loc.x + i, loc.y + i);
                ChessPiece tmp = this.getPiece(downRight, board);
                if (tmp == null) {
                    moves.add(downRight);
                } else if (tmp.getColor() != this.getColor()) {
                    downRightBlocked = true;
                    moves.add(downRight);
                } else {
                    downRightBlocked = true;
                }
            }
            if (!upRightBlocked) {
                Point upRight = new Point(loc.x + i, loc.y - i);
                ChessPiece tmp = this.getPiece(upRight, board);
                if (tmp == null) {
                    moves.add(upRight);
                } else if (tmp.getColor() != this.getColor()) {
                    upRightBlocked = true;
                    moves.add(upRight);
                } else {
                    upRightBlocked = true;
                }
            }
            if (!upLeftBlocked) {
                Point upLeft = new Point(loc.x - i, loc.y - i);
                ChessPiece tmp = this.getPiece(upLeft, board);
                if (tmp == null) {
                    moves.add(upLeft);
                } else if (tmp.getColor() != this.getColor()) {
                    upLeftBlocked = true;
                    moves.add(upLeft);
                } else {
                    upLeftBlocked = true;
                }
            }
            if (!downleftBlocked) {
                Point downLeft = new Point(loc.x - i, loc.y + i);
                ChessPiece tmp = this.getPiece(downLeft, board);
                if (tmp == null) {
                    moves.add(downLeft);
                } else if (tmp.getColor() != this.getColor()) {
                    downleftBlocked = true;
                    moves.add(downLeft);
                } else {
                    downleftBlocked = true;
                }
            }
        }
        ArrayList<Point> movesOnBoard = new ArrayList<Point>();
        for (Point p : moves) {
            if (this.onBoard(p)) {
                movesOnBoard.add(p);
            }
        }
        return movesOnBoard;
    }
}