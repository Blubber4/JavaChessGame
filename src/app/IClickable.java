package app;

import java.awt.Point;

/* IClickable interface should be used to show that a GameObject can be interacted with via mouse */
public interface IClickable {
  /* isHovered() should return true if the mouse is currently over the IClickable object */
  public boolean intersects(Point p);
  public void onHover();
  public void onUnhover();
  public void onClick();
}
