package app;

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Point;

abstract class GameObject extends JComponent
{
  // instance vars
  private int x_pos;
  private int y_pos;
  
  /* start is called the first time the main loop runs, and should be used for any initialization
  that can't be done in the constructor. an empty start method is perfectly fine */
  abstract public void start();

  /* update is called by timer before each draw call, and is where most animation logic should go
   ideally update will be called independent of draw call, but thats not working yet */
  abstract public void update();

  public int getPosX() { return x_pos; }
  public int getPosY() { return y_pos; }
  
  /* sets the gameobject's position relative to top left corner of the content pane */
  public void setPosition(int x, int y)
  {
    x_pos = x;
    y_pos = y;
  }

  /* loads image with filename in the project's resources folder */
  protected Image loadImage(String filename)
  {   
    Image image = Toolkit.getDefaultToolkit().getImage("resources/" + filename);
    return image;
  }

  /* should be called every time paintComponent() or repaint() is called by game timer. */
  public abstract void draw(Graphics g);
}
