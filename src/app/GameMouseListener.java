package app;

import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.event.MouseInputAdapter;

/* this class was a failed idea, but I'm leaving it here for later reference/to maybe fix it, and for the isClickable() function. */
public class GameMouseListener extends MouseInputAdapter {
  @Override
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
  }

  public static boolean isClickable(Object object)
  {
    if (object instanceof IClickable)
    {
      return true;
    }
    return false;
  }
}
