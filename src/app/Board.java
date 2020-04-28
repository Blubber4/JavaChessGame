package app;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import app.ChessPiece.PieceColor;

public class Board extends JComponent {
    private static final long serialVersionUID = 1L;

    ArrayList<ChessPiece> allPieces = new ArrayList<ChessPiece>(); // all chess pieces on the board
    ArrayList<Point> possibleMoves = new ArrayList<Point>(); // possible moves to be highlighted
    ChessPiece selected; // null if no piece is selected
    boolean blackTurn = false;
    boolean checkmate = false;

    public Board() {
        // initialize a new board
        super();
        this.setSize(600, 600); // I don't think this is drawing right (It isnt't but please dont change it, it
                                // will ruin the Main GUI - Tony)
        this.initPieces();
    }

    public void initPieces() { // clears the board and creates pieces for a new game
        deselect();
        // delete all pieces currently on the board
        allPieces.clear();

        ChessPiece chessPiece = new Rook(PieceColor.WHITE);
        chessPiece.setlocation(new Point(0, 0));
        allPieces.add(chessPiece);

        chessPiece = new Rook(PieceColor.WHITE);
        chessPiece.setlocation(new Point(7, 0));
        allPieces.add(chessPiece);

        chessPiece = new King(PieceColor.WHITE);
        chessPiece.setlocation(new Point(3, 0));
        allPieces.add(chessPiece);

        chessPiece = new Queen(PieceColor.WHITE);
        chessPiece.setlocation(new Point(4, 0));
        allPieces.add(chessPiece);

        chessPiece = new Knight(PieceColor.WHITE);
        chessPiece.setlocation(new Point(1, 0));
        allPieces.add(chessPiece);

        chessPiece = new Knight(PieceColor.WHITE);
        chessPiece.setlocation(new Point(6, 0));
        allPieces.add(chessPiece);

        chessPiece = new Bishop(PieceColor.WHITE);
        chessPiece.setlocation(new Point(2, 0));
        allPieces.add(chessPiece);

        chessPiece = new Bishop(PieceColor.WHITE);
        chessPiece.setlocation(new Point(5, 0));
        allPieces.add(chessPiece);

        for (int i = 0; i < 8; i++) {
            chessPiece = new Pawn(PieceColor.WHITE);
            chessPiece.setlocation(new Point(i, 1));
            allPieces.add(chessPiece);
        }

        chessPiece = new Rook(PieceColor.BLACK);
        chessPiece.setlocation(new Point(0, 7));
        allPieces.add(chessPiece);

        chessPiece = new Rook(PieceColor.BLACK);
        chessPiece.setlocation(new Point(7, 7));
        allPieces.add(chessPiece);

        chessPiece = new King(PieceColor.BLACK);
        chessPiece.setlocation(new Point(3, 7));
        allPieces.add(chessPiece);

        chessPiece = new Queen(PieceColor.BLACK);
        chessPiece.setlocation(new Point(4, 7));
        allPieces.add(chessPiece);

        chessPiece = new Knight(PieceColor.BLACK);
        chessPiece.setlocation(new Point(1, 7));
        allPieces.add(chessPiece);

        chessPiece = new Knight(PieceColor.BLACK);
        chessPiece.setlocation(new Point(6, 7));
        allPieces.add(chessPiece);

        chessPiece = new Bishop(PieceColor.BLACK);
        chessPiece.setlocation(new Point(2, 7));
        allPieces.add(chessPiece);

        chessPiece = new Bishop(PieceColor.BLACK);
        chessPiece.setlocation(new Point(5, 7));
        allPieces.add(chessPiece);

        for (int i = 0; i < 8; i++) {
            chessPiece = new Pawn(PieceColor.BLACK);
            chessPiece.setlocation(new Point(i, 6));
            allPieces.add(chessPiece);
        }

        for (ChessPiece t : allPieces) {
            t.generatePossibleMoves(this.allPieces);
        }
    }

    public ChessPiece getpiece(int x, int y) // Function to access piece of a particular cell, return null if no piece
    {
        Point loc = new Point(x, y);
        for (int i = 0; i < allPieces.size(); i++) {
            Point iLoc = allPieces.get(i).getlocation();
            if (iLoc.x == loc.x && iLoc.y == loc.y) {
                return allPieces.get(i);
            }
        }
        return null;
    }

    public void select(int x, int y) // Function to mark a cell indicating it's selection
    {
        deselect();
        ChessPiece clicked = getpiece(x, y);
        if (clicked != null && (PieceColor.BLACK == clicked.getColor()) == blackTurn) {
            this.selected = clicked;
            this.setPossibleMoves(clicked);
        }
    }

    public void deselect() // Function to delselect the cell
    {
        removepossibledestination();
        this.selected = null;
    }

    public void removepossibledestination() // clear the possible destinations
    {
        this.possibleMoves = new ArrayList<Point>();
    }

    public boolean isBlackTurn() {
        return blackTurn;
    }

    private void setPossibleMoves(ChessPiece p) {
        this.possibleMoves = p.getPossibleMoves();
        /*
         * if(p instanceof Pawn) { setPossibleMovesPawn(p); // pawns are weird return; }
         * // fills the possibleMoves array for the selected piece ArrayList<Point>
         * pMoves = p.possiblemoves; Point pLoc = p.getlocation();
         */
    }

    

    private boolean isCheck(ChessPiece.PieceColor color) {
        Point locOfKing = new Point();
        for (ChessPiece p : this.allPieces) {
            if (p instanceof King && p.getColor() == color) {
                locOfKing = p.getlocation();
                break;
            }
        }

        for (ChessPiece p : this.allPieces) {
            if (p.getColor() != color) {
                ArrayList<Point> possibleMoves = p.getPossibleMoves();
                for (Point j : possibleMoves) {
                    if (j.x == locOfKing.x && j.y == locOfKing.y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isCheckmate() {
        PieceColor color;
        if (blackTurn) {
            color = PieceColor.WHITE;
        } else {
            color = PieceColor.BLACK;
        }

        for (ChessPiece p : this.allPieces) {
            if (p.getColor() != color) {
                continue;
            }
            if (!p.getPossibleMoves().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void checkPawnPromotion() {
        if (selected instanceof Pawn) {
            Point loc = selected.getlocation();
            int y_coord = loc.y;
            if (y_coord == 0 || y_coord == 7) {
                allPieces.remove(selected);
                Queen queen = new Queen(selected.getColor());
                queen.setlocation(loc);
                allPieces.add(queen);
            }
        }
    }

    /**
     * updates possible moves for all pieces on the board, removing those moves that
     * would put the player in check. If all possible moves are empty after this
     * function, then it is checkmate
     */

    private void updatePossibleMoves() {
        for (ChessPiece piece : this.allPieces) {
            piece.generatePossibleMoves(this.allPieces);
        }
    }

    private void newTurn() {
        this.blackTurn = !this.blackTurn;
        updatePossibleMoves();

        PieceColor color;
        if (blackTurn) {
            color = PieceColor.BLACK;
        } else {
            color = PieceColor.WHITE;
        }
        
        for (int i = 0; i < this.allPieces.size(); i++) {
            ChessPiece piece = allPieces.get(i);
            if (piece.getColor() != color) {
                continue;
            }

            ArrayList<Point> moves = piece.getPossibleMoves();
            for (int j = 0; j < moves.size(); j++) {
                Point loc = piece.getlocation();
                Point move = moves.get(j);
                piece.setlocation(move);
                if (isCheck(color)) {
                    piece.deleteMove(move);
                    System.out.println("check");
                }
                piece.setlocation(loc);
            }
        }
    }

    private void moveSelected(Point p) {
        // move the selected piece to point p
        ChessPiece capture = getpiece(p.x, p.y);
        if (capture != null) {
            allPieces.remove(capture);
        }
        selected.setlocation(p);
        checkPawnPromotion();
        deselect();
        newTurn();
        this.checkmate = isCheckmate();
    }

    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        Point scaledP = new Point(p.x / 75, p.y / 75); // this is scaled to board position
        if (selected == null) {
            select(scaledP.x, scaledP.y);
        }
        // if not selected and there is a piece there
        // select that piece
        else {
            if (possibleMoves.contains(scaledP)) {
                moveSelected(scaledP);
                deselect();
            } else {
                deselect();
            }
        }
        // if selected and scaledP is a possibleMove
        // move piece
        // if selected and scaledP is not a possibleMove
        // deselect
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        int blockSizeX = this.getSize().width / 8;
        int blockSizeY = this.getSize().height / 8;
        for (int pos = 0; pos < 8 * 8; pos++) {
            int x = (pos % 8) * blockSizeX;
            int y = (pos / 8) * blockSizeY;
            int offset = (pos % 16) < 8 ? 0 : 1;
            Color color = (pos + offset) % 2 == 0 ? Color.WHITE : Color.BLACK;
            g.setColor(color);
            g.fillRect(x, y, blockSizeX, blockSizeY);
        }
        // highlight the selected piece
        if (this.selected != null) {
            g.setColor(Color.yellow);
            g.fillRect(selected.getlocation().x * 75, selected.getlocation().y * 75, 75, 75);
        }
        // highlight possible moves in blue
        g.setColor(Color.blue);
        for (int i = 0; i < possibleMoves.size(); i++) {
            g.fillRect(possibleMoves.get(i).x * 75, possibleMoves.get(i).y * 75, 75, 75);
        }
        // draw all pieces
        for (int i = 0; i < allPieces.size(); i++) {
            allPieces.get(i).draw(g);
        }
    }
}
