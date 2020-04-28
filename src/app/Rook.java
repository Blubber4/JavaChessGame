package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Rook class inherited from abstract Piece class
 */

public class Rook extends ChessPiece {
    public Rook(PieceColor color) {
        super("Rook.png", color);
    }

    public ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        boolean upBlocked = false;
        boolean downBlocked = false;
        boolean rightBlocked = false;
        boolean leftBlocked = false;
        Point currentLoc = this.getlocation();
        for (int i = 1; i < 8; i++) {
            if (!downBlocked) {
                Point down = new Point(currentLoc.x, currentLoc.y + i);
                ChessPiece tmp = super.getPiece(down, board);
                if (tmp == null) {
                    moves.add(down);
                } else if (tmp.getColor() != this.getColor()) {
                    downBlocked = true;
                    moves.add(down);
                } else {
                    downBlocked = true;
                }
            }
            if (!upBlocked) {
                Point up = new Point(currentLoc.x, currentLoc.y - i);
                ChessPiece tmp = super.getPiece(up, board);
                if (tmp == null) {
                    moves.add(up);
                } else if (tmp.getColor() != this.getColor()) {
                    upBlocked = true;
                    moves.add(up);
                } else {
                    upBlocked = true;
                }
            }
            if (!leftBlocked) {
                Point left = new Point(currentLoc.x - i, currentLoc.y);
                ChessPiece tmp = super.getPiece(left, board);
                if (tmp == null) {
                    moves.add(left);
                } else if (tmp.getColor() != this.getColor()) {
                    leftBlocked = true;
                    moves.add(left);
                } else {
                    leftBlocked = true;
                }
            }
            if (!rightBlocked) {
                Point right = new Point(currentLoc.x + i, currentLoc.y);
                ChessPiece tmp = super.getPiece(right, board);
                if (tmp == null) {
                    moves.add(right);
                } else if (tmp.getColor() != this.getColor()) {
                    rightBlocked = true;
                    moves.add(right);
                } else {
                    rightBlocked = true;
                }
            }
        }
        ArrayList<Point> movesOnBoard = new ArrayList<Point>();
        for (Point p : moves) {
            if (this.onBoard(p)) {
                movesOnBoard.add(p);
            }
        }
        this.possiblemoves = movesOnBoard;
        return movesOnBoard;
    }
}
