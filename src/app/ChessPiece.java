package app;

import java.awt.Graphics;
import java.awt.Image;

abstract class ChessPiece extends GameObject
{
  // cached references
  protected Image image;
  protected String image_filename;

  public ChessPiece(String image_filename, int x, int y)
  {
    this.image_filename = image_filename;
    this.image = loadImage(image_filename);
    setPosition(x, y);
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
