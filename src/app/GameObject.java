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
  
  abstract public void start(); // called first time the object is instantiated
  abstract public void update(); // called each loop

  public int getPosX() { return x_pos; }
  public int getPosY() { return y_pos; }
  

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
  public abstract void draw(Graphics g);
}
