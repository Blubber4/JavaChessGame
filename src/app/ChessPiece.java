package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
    private int color;
    private String id = null;
    private String path;
    protected ArrayList<Point> possiblemoves = new ArrayList<Point>(); // Protected (access from child classes)
    private Point location = null;

    // Id Setter for each piece
    public void setId(String id) {
        this.id = id;
    }

    public Point getlocation() {
        return location;
    }

    public void setlocation(Point p) {
        this.location = p;
    }

    // Path Setter
    public void setPath(String path) {
        this.path = path;
    }

    // Color Setter
    public void setColor(int c) {
        this.color = c;
    }

    // Path getter
    public String getPath() {
        return path;
    }

    // Id getter
    public String getId() {
        return id;
    }

    // Color Getter
    public int getcolor() {
        return this.color;
    }

    // Function to return the a "shallow" copy of the object. The copy has exact
    // same variable value but different reference
    public ChessPiece getcopy() throws CloneNotSupportedException {
        return (ChessPiece) this.clone();
    }

    public abstract void draw(Graphics g);
}
