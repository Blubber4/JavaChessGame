package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

abstract class ChessPiece extends GameObject implements IClickable
{
  private final int borderThickness = 6;
  protected String image_filename;
  protected Image image;
  protected Rectangle hitBox; // this may need to be a more complex shape later - hitbox class?
  protected PieceState pieceState;
  protected PieceState mousedState;
  
  public enum PieceState
  {
    SELECTED,
    IDLE,
    HOVERED
  }

  public ChessPiece(String image_filename, int x, int y)
  {
    this.image_filename = image_filename;
    this.image = loadImage(image_filename);
    this.pieceState = PieceState.IDLE; // default state should be idle
    this.mousedState = PieceState.IDLE;
    setPosition(x, y);
    initMouseListener();
    scaleImage(100, 120);
  }

  /* ideally we move this to its own class that can be shared by all GameObjects,
     but I couldn't really get that working in time for MVP, so this is temp solution */
  private void initMouseListener()
  {
    addMouseListener(new MouseInputAdapter()
    {
      @Override
      public void mousePressed(MouseEvent e)
      {
        onClick();
      }

      @Override
      public void mouseEntered(MouseEvent e)
      {
        onHover();
      }

      @Override
      public void mouseExited(MouseEvent e)
      {
        onUnhover();
      }
    });
  }

  private void scaleImage(int newWidth, int newHeight)
  {
    image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
  }

  public Image getImage() { return image; }

  public void start()
  {

  }

  public void update()
  {
    System.out.println(pieceState + " " + mousedState);
    //move(1, 1);
  }

  public void move(int x, int y)
  {
    setPosition(getPosX() + x, getPosY() + y);
  }

  public void draw(Graphics g) 
  {
    int x = getPosX() - borderThickness;
    int y = getPosY() - borderThickness;
    int width = image.getWidth(null) + borderThickness*2;
    int height = image.getHeight(null) + borderThickness*2;
    // draw border first if hovered
    if (mousedState == PieceState.HOVERED)
    {
      g.setColor(Color.RED);
    }
    if (pieceState == PieceState.SELECTED)
    {
      g.setColor(Color.YELLOW);
    }
    if (pieceState == PieceState.SELECTED || mousedState == PieceState.HOVERED)
    {
      g.drawRect(
        x, // top left corner x pos
        y, // top left corner y pos
        width,
        height );
      g.fillRect(x, y, width, height);
    }
    g.drawImage(this.image, getPosX(), getPosY(), null);
  }

  public void onHover()
  {
    mousedState = PieceState.HOVERED;
    System.out.println("hovering");
  }

  public void onUnhover()
  {
    pieceState = PieceState.IDLE;
  }

  public void onClick()
  {
    if (pieceState == PieceState.SELECTED)
    {
      pieceState = PieceState.IDLE;
    }
    else
    {
      pieceState = PieceState.SELECTED;
    }
  }

  public boolean intersects(Point p)
  {
    if (hitBox.contains(p))
    {
      return true;
    }
    return false;
  }
}
