package app;

import java.util.ArrayList;

public class King extends ChessPiece {
    // config params
    protected final int width = 75;
    protected final int height = 75;

    public King(String id, String filename, PieceColor color) {
        super(id, filename, color);
        this.image = scaleImage(image, width, height);

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
