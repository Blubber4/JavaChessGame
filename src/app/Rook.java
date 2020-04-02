package app;

public class Rook extends ChessPiece
{
  public Rook()
  {
    super("Rook.png", 0, 0);
    initMoveSets();
    // NEED A WAY TO HANDLE CASTLING
  }

  public Rook(int x, int y)
  {
    super("Rook.png", x, y);
    initMoveSets();
  }

  private void initMoveSets()
  {
    moveSets.add(new MoveSet("horizontal", 1, 0));
    moveSets.add(new MoveSet("vertical", 0, 1));
  }
}
