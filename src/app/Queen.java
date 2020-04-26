package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Queen Class inherited from the abstract Piece class
 */

public class Queen extends ChessPiece {

    public Queen(PieceColor color) {
        super("Queen.png", color);
    }

    // Move Function Defined
    public ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        Point loc = this.getlocation();
        boolean upRightBlocked = false;
        boolean downRightBlocked = false;
        boolean upLeftBlocked = false;
        boolean downleftBlocked = false;
        boolean upBlocked = false;
        boolean downBlocked = false;
        boolean rightBlocked = false;
        boolean leftBlocked = false;
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
            if (!downBlocked) {
                Point down = new Point(loc.x, loc.y + i);
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
                Point up = new Point(loc.x, loc.y - i);
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
                Point left = new Point(loc.x - i, loc.y);
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
                Point right = new Point(loc.x + i, loc.y);
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
        return movesOnBoard;
    }
}