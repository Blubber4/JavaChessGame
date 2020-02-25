package app;

abstract class ChessPiece extends GameObject
{
  public ChessPiece(String image_filename)
  {
    super(image_filename);
    super.image = loadImage(image_filename);
    setPosition(0, 0);
  }

  public void start()
  {

  }

  public void update()
  {
    
  }

  public void move(int x, int y)
  {
    setPosition(getPosX() + x, getPosY() + y);
  }
}
