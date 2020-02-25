package app;

import java.awt.Graphics;

public class Rook extends ChessPiece
{
  public Rook()
  {
    super("Rook.png");
  }

  public Rook(int x, int y)
  {
    super("Rook.png");
    setPosition(x, y);
  }
}
