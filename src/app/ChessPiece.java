package app;

import java.awt.Color;
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
 *
 */

abstract class ChessPiece implements Cloneable {

    // Member Variables
    private String id;
    private Point location;
    private PieceColor color;
    protected Image image;
    protected ArrayList<Point> possiblemoves = new ArrayList<Point>();
    
    // config params
    protected final int width = 75;
    protected final int height = 75;

    public enum PieceColor {
        WHITE, BLACK
    }

    public ChessPiece(String id, String filename, PieceColor color)
    {
        setId(id);
        setColor(color);
        this.image = loadImage(filename);
    }

    // Id Setter for each piece
    public void setId(String id) {
        this.id = id;
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

    // Id getter
    public String getId() {
        return id;
    }

    // Color Getter
    public PieceColor getColor() {
        return this.color;
    }

    // Function to return the a "shallow" copy of the object. The copy has exact
    // same variable value but different reference
    public ChessPiece getcopy() throws CloneNotSupportedException {
        return (ChessPiece) this.clone();
    }

    /* loads image with filename in the project's resources folder */
    public Image loadImage(String filename) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/" + filename);
        return image;
    }

    public Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public abstract void draw(Graphics g);
}
