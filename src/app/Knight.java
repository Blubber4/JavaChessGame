package app;

import java.util.ArrayList;

/**
 * This is the Knight Class inherited from the Piece abstract class
 * 
 *
 */

public class Knight extends ChessPiece {
    public Knight(String i, String p, int c) {
        setId(i); // id of king
        setPath(p);
        setColor(c);
    }

    // Move Function overridden
    // There are at max 8 possible moves for a knight at any point of time.
    // Knight moves only 2(1/2) steps
    public ArrayList<Board> move(Board state[][], int x, int y) {
        possiblemoves.clear();
        // add King moves here
    }
}