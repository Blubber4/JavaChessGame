package app;

import java.awt.Graphics;
import java.awt.Image;

abstract class ChessPiece extends GameObject
{
  protected Image image; // might want to move this to chesspiece class, so we can draw board and other things as a bunch of squares instead of having to import an image of a board
  protected String image_filename; //

  public ChessPiece(String image_filename)
  {
    this.image_filename = image_filename;
    this.image = loadImage(image_filename);
    setPosition(0, 0);
  }

  public Image getImage() { return image; }

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

  public void draw(Graphics g) 
  {
    g.drawImage(this.image, getPosX(), getPosY(), null);
  }
}
