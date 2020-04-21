package app;

import java.util.ArrayList;

public class King extends ChessPiece {

    public King(String i, String p, int c, int x, int y) {
        setx(x);
        sety(y);
        setId(i);
        setPath(p);
        setColor(c);

    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    // Move Function for King Overridden from Pieces
    public ArrayList<Board> move(Board state[][], int x, int y) {

        // King can move only one step. So all the adjacent 8 cells have been
        // considered.

    }

    // Implement a function to check if king is under threat

    // Need to check whether there is any piece of opposite color that can attack
    // king for a given board state

    // Need to check for attack from left,right,up and down

    // Need to check for attack from diagonal direction

    // Need to check for attack from the Knight of opposite color

    // Need to check for attack from the Pawn of opposite color

}
