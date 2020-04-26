package app;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Pawn Class inherited from the piece
 */

public class Pawn extends ChessPiece {

    public Pawn(PieceColor color) {
        super("Pawn.png", color);
    }

    private ArrayList<Point> getBlackMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        Point loc = this.getlocation();
        if (loc.y == 6) {
            // first move
            Point p1 = new Point(loc.x, loc.y - 1); // up
            Point p2 = new Point(loc.x, loc.y - 2); // up-up
            Point p3 = new Point(loc.x - 1, loc.y - 1); // up-left
            Point p4 = new Point(loc.x + 1, loc.y - 1); // up-right
            ChessPiece tmp;
            // up-left
            tmp = this.getPiece(p3, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p3);
            }
            // up-right
            tmp = this.getPiece(p4, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p4);
            }
            // up
            tmp = this.getPiece(p1, board);
            if (tmp == null) {
                moves.add(p1);
            }
            // down-down
            tmp = this.getPiece(p2, board);
            if (tmp == null) {
                moves.add(p2);
            }
        } else {
            Point p1 = new Point(loc.x, loc.y - 1); // up
            Point p3 = new Point(loc.x - 1, loc.y - 1); // up-left
            Point p4 = new Point(loc.x + 1, loc.y - 1); // up-right
            ChessPiece tmp;
            // up-left
            tmp = this.getPiece(p3, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p3);
            }
            // up-right
            tmp = this.getPiece(p4, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p4);
            }
            // up
            tmp = this.getPiece(p1, board);
            if (tmp == null) {
                moves.add(p1);
            }
        }
        return moves;
    }

    private ArrayList<Point> getWhiteMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        Point loc = this.getlocation();
        if (loc.y == 1) {
            // first move
            Point p1 = new Point(loc.x, loc.y + 1); // down
            Point p2 = new Point(loc.x, loc.y + 2); // down-down
            Point p3 = new Point(loc.x - 1, loc.y + 1); // down-left
            Point p4 = new Point(loc.x + 1, loc.y + 1); // down-right
            ChessPiece tmp;
            // down-left
            tmp = this.getPiece(p3, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p3);
            }
            // down-right
            tmp = this.getPiece(p4, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p4);
            }
            // down
            tmp = this.getPiece(p1, board);
            if (tmp == null) {
                moves.add(p1);
            }
            // down-down
            tmp = this.getPiece(p2, board);
            if (tmp == null) {
                moves.add(p2);
            }
        } else {
            Point p1 = new Point(loc.x, loc.y + 1); // down
            Point p3 = new Point(loc.x - 1, loc.y + 1); // down-left
            Point p4 = new Point(loc.x + 1, loc.y + 1); // down-right
            ChessPiece tmp;
            // down-left
            tmp = this.getPiece(p3, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p3);
            }
            // down-right
            tmp = this.getPiece(p4, board);
            if (tmp != null && tmp.getColor() != this.getColor()) {
                moves.add(p4);
            }
            // down
            tmp = this.getPiece(p1, board);
            if (tmp == null) {
                moves.add(p1);
            }
        }
        return moves;
    }

    // Move Function Overridden
    public ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board) {
        ArrayList<Point> moves = new ArrayList<Point>();
        if (this.getColor() == PieceColor.BLACK) {
            moves = this.getBlackMoves(board);
        } else {
            moves = this.getWhiteMoves(board);
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