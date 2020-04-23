package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Rook class inherited from abstract Piece class
 *
 */

public class Rook extends ChessPiece {
    // config params
    protected final int width = 75;
    protected final int height = 75;

    public Rook(String id, String filename, PieceColor color) {
        super(id, filename, color);
        this.possiblemoves = generatePossibleMoves();
        this.image = scaleImage(image, width, height);
    }

    private ArrayList<Point> generatePossibleMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();
        for (int i = 1; i < 8; i++) {
            moves.add(new Point(0, i));
            moves.add(new Point(i, 0));
            moves.add(new Point(-1 * i, 0));
            moves.add(new Point(0, -1 * i));
        }
        return moves;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, getlocation().x, getlocation().y, null);
    }
}
