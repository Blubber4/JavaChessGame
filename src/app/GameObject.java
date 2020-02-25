package app;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

abstract class GameObject extends JPanel // should this be a jcomponent or something else instead of a jpanel?
{
  // instance vars
  private int x_pos;
  private int y_pos;
  protected Image image; // might want to move this to chesspiece class, so we can draw board and other things as a bunch of squares instead of having to import an image of a board
  protected String image_filename; //
  
  abstract public void start(); // called first time the object is instantiated
  abstract public void update(); // called each loop

  public GameObject(String image_filename)
  {
    this.image_filename = image_filename;
  }

  public int getPosX() { return x_pos; }
  public int getPosY() { return y_pos; }
  public Image getImage() { return image; }

  public void setPosition(int x, int y)
  {
    x_pos = x;
    y_pos = y;
  }

  protected Image loadImage(String filename)
  {   
    Image image = Toolkit.getDefaultToolkit().getImage("resources/" + filename);
    return image;
  }

  /* should be called every time paintComponent() or repaint() is called by timer. INDEPENDENT OF UPDATE LOOP */
  public void draw(Graphics g) 
  {
    g.drawImage(this.image, getPosX(), getPosY(), null);
  }
}
