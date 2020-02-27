package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;

abstract class ChessPiece extends GameObject implements IClickable
{
  private final int borderThickness = 6;
  protected String image_filename;
  protected Image image;
  protected Rectangle hitBox; // this may need to be a more complex shape later - hitbox class?
  protected PieceState pieceState;
  protected PieceState mouseState;
  
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
    this.mouseState = PieceState.IDLE;
    this.hitBox = new Rectangle(getPosX(), getPosY(), 100, 120);
    setPosition(x, y);
    scaleImage(100, 120);
  }

  public void start()
  {

  }

  public void update()
  {
    //move(1, 1);
  }

  public Image getImage() { return image; }

  @Override
  public void setPosition(int x, int y)
  {
    this.hitBox.setLocation(x, y);
    super.setPosition(x, y);
  }

  private void scaleImage(int newWidth, int newHeight)
  {
    image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
  }

  public void move(int x, int y)
  {
    setPosition(getPosX() + x, getPosY() + y);
  }

  public void moveTo(Point p)
  {
    int x = (int) p.getX();
    int y = (int) p.getY();
    setPosition(x, y);
  }

  // IClickable implementation here
  public void onClickAway(Point p)
  {
    moveTo(p);
    pieceState = PieceState.IDLE;
  }

  public boolean isHovered()
  {
    if (mouseState == PieceState.HOVERED)
    {
      return true;
    }
    return false;
  }

  public void onHover()
  {
    mouseState = PieceState.HOVERED;
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

  // draw call
  public void draw(Graphics g) 
  {
    int x = getPosX() - borderThickness;
    int y = getPosY() - borderThickness;
    int width = image.getWidth(null) + borderThickness*2;
    int height = image.getHeight(null) + borderThickness*2;

    // draw border first if hovered
    if (mouseState == PieceState.HOVERED)
    {
      g.setColor(Color.RED);
    }

    if (pieceState == PieceState.SELECTED)
    {
      g.setColor(Color.YELLOW);
    }

    if (pieceState == PieceState.SELECTED || mouseState == PieceState.HOVERED)
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
}
