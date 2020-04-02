package app;

public final class MoveSet {
  private String name; // the name of this moveset
  private int x; // the number of squares left/right the piece can move per "tick"
  private int y; // the number of squares up/down the piece can move per "tick"
  private boolean reversible; // if this is true, the moveset can be used backwards as well as forwards. For a pawn for example, this will be false.
  /*
  This represents the number of "ticks" the piece is allowed to make per move.
  I.e a knight can move 2 vertical from itself, and 1 horizontal from that, once per move, so it only gets one tick.
  A knight can also move 2 horizontal and 1 vertical with one tick, so a knight will need 2 movesets.
  But a bishop can move 1 horizontal and 1 vertical indefinitely (diagonally), so it gets a single, reversible moveset with up to 8 ticks if it moves
  across the whole board. It will be up to the board to manage if there are less than 8 ticks available (off the board, block by another piece, etc)
  A queen can move any direction indefinitely, so it will need multiple movesets each with up to 8 ticks.
  Pawns will need multiple movesets situationally, so on so forth.
  */
  private int numTicks;

  MoveSet(String name, int x, int y, boolean reversible, int numTicks)
  {
    this.name = name;
    this.x = x;
    this.y = y;
    this.numTicks = numTicks;
    this.reversible = reversible;
  }

  MoveSet(String name, int x, int y)
  {
    this.name = name;
    this.x = x;
    this.y = y;
    this.numTicks = 8;
    this.reversible = true;
  }

  public String getName() {
    return name;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getNumTicks() {
    return numTicks;
  }

  public boolean isReversible() {
    return reversible;
  }
}
