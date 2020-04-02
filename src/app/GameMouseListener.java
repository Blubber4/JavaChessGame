package app;

import java.util.List;

import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.event.MouseInputAdapter;

/* this class was a failed idea, but I'm leaving it here for later reference/to maybe fix it, and for the isClickable() function. */
public class GameMouseListener extends MouseInputAdapter {
  // cached reference to GamePanel for intersection checking - this is messy, is there a better way to do it?
  GamePanel gamePanel;
  IClickable hoveredObject;
  IClickable selectedObject;

  public GameMouseListener(GamePanel gamePanel)
  {
    this.gamePanel = gamePanel;
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
    Point p = e.getPoint();
    List<IClickable> intersections = gamePanel.getIntersections(p);

    if (intersections.size() == 0)
    {
      if (selectedObject != null)
      {
        selectedObject.onClickAway(e.getPoint());
        selectedObject = null;
      }
      return;
    }
    else if (intersections.size() > 1)
    {
      return; // will have more logic here later, for now return is fine
    }
    selectedObject = intersections.get(0);
    selectedObject.onClick();
  }

  public static boolean isClickable(Object object)
  {
    if (object instanceof IClickable)
    {
      return true;
    }
    return false;
  }

  /* EVERYTHING BELOW THIS POINT NOT IMPLEMENTED PROPERLY YET - IGNORE COMMENTS
  @Override
  public void mouseMoved(MouseEvent e)
  {
    Point p = e.getPoint();
    List<IClickable> intersections = gamePanel.getIntersections(p);
    System.out.println("1");

    if (intersections.size() == 0)
    {
      if (hoveredObject != null)
      {
        hoveredObject.onUnhover();
        hoveredObject = null;
      }
      return;
    }
    else if (intersections.size() > 1)
    {
      return; // will have more logic here later, for now return is fine
    }

    intersections.get(0).onHover();
    if (hoveredObject != null)
    {
      hoveredObject = intersections.get(0);
    }
  } */

  

  /*@Override
  public void mousePressed(MouseEvent e) {
    Object source = e.getSource();
    if (!isClickable(source))
    {
      return;
    }
    
    IClickable clickable = (IClickable) source;
    clickable.onClick();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    Object source = e.getSource();
    if (!isClickable(source))
    {
      return;
    }

    IClickable clickable = (IClickable) source;
    clickable.onHover();
  }

  @Override
  public void mouseExited(MouseEvent e) {
    Object source = e.getSource();
    if (!isClickable(source))
    {
      return;
    }

    IClickable clickable = (IClickable) source;
    clickable.onUnhover();
  }*/

  
}
