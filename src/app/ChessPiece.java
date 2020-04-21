package app;

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
    protected ArrayList<Board> possiblemoves = new ArrayList<Board>(); // Protected (access from child classes)

    public abstract ArrayList<Board> move(Board pos[][], int x, int y); // Abstract Function. Must be overridden

    // Id Setter for each piece
    public void setId(String id) {
        this.id = id;
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
}
