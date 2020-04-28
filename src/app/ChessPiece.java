package app;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Image;
import java.awt.Toolkit;

import java.util.ArrayList;

/**
 * This is the ChessPiece Class. It is an abstract class from which all the
 * actual pieces are inherited. It defines all the function common to all the
 * pieces The move() function an abstract function that has to be overridden in
 * all the inherited class
 */

abstract class ChessPiece {

    // Member Variables
    private Point location;
    private PieceColor color;
    protected Image image;
    protected ArrayList<Point> possiblemoves = new ArrayList<Point>();

    // config params
    protected final int SCALE = 75;
    protected int width = 75;
    protected int height = 75;

    public enum PieceColor {
        WHITE, BLACK
    }

    public ChessPiece(String filename, PieceColor color) {
        setColor(color);
        if (color == PieceColor.BLACK) {
            filename = "Black" + filename;
        } else {
            filename = "White" + filename;
        }
        this.image = scaleImage(loadImage(filename), height, width);
        // this.possiblemoves = generatePossibleMoves();
    }

    protected ChessPiece getPiece(Point loc, ArrayList<ChessPiece> allPieces) // Function to access piece of a
                                                                              // particular cell, return null if no piece
    {
        for (int i = 0; i < allPieces.size(); i++) {
            Point iLoc = allPieces.get(i).getlocation();
            if (iLoc.x == loc.x && iLoc.y == loc.y) {
                return allPieces.get(i);
            }
        }
        return null;
    }

    protected boolean onBoard(Point p) {
        if (p.x < 0 || p.y < 0 || p.x > 7 || p.y > 7) {
            return false;
        }
        return true;
    }

    public void setlocation(Point p) {
        this.location = p;
    }

    // Color Setter
    public void setColor(PieceColor color) {
        this.color = color;
    }

    public Point getlocation() {
        return location;
    }

    // Color Getter
    public PieceColor getColor() {
        return this.color;
    }

    // possible moves must first be populated by generatePossibleMoves() method
    public ArrayList<Point> getPossibleMoves() {
        return this.possiblemoves;
    }

    public void deleteMove(Point p) {
        possiblemoves.remove(p);
    }

    /* loads image with filename in the project's resources folder */
    public Image loadImage(String filename) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/" + filename);
        return image;
    }

    public Image scaleImage(Image image, int width, int height) {
        this.width = width;
        this.height = height;
        return image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, getlocation().x * SCALE, getlocation().y * SCALE, null);
    }

    public abstract ArrayList<Point> generatePossibleMoves(ArrayList<ChessPiece> board);
}
