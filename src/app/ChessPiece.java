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

abstract class ChessPiece implements Cloneable {

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

    public ChessPiece(String filename, PieceColor color)
    {
        setColor(color);
        if (color == PieceColor.BLACK) {
            filename = "Black" + filename;
        } else {
            filename = "White" + filename;
        }
        this.image = scaleImage(loadImage(filename), height, width);
        this.possiblemoves = generatePossibleMoves();
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
        this.width = width;
        this.height = height;
        return image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, getlocation().x * SCALE, getlocation().y * SCALE, null);
    }

    protected abstract ArrayList<Point> generatePossibleMoves();
}
