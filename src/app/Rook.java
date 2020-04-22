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

    public Rook(String i, String p, int c) {
        setId(i);
        setPath(p);
        setColor(c);
        this.possiblemoves = generatePossibleMoves();
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
        g.setColor(Color.red);
        // the "* 75" is to scale the board position to the pixel
        // it should not be hard coded like this
        g.fillOval(this.getlocation().x * 75, this.getlocation().y * 75, 75, 75);
    }
}
