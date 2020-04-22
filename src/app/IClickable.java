package app;

import java.awt.Point;

/* IClickable interface should be used to show that a GameObject can be interacted with via mouse */
public interface IClickable {
    /*
     * intersects() should return true if the point p is contained within an object
     */
    public boolean intersects(Point p);

    /*
     * isHovered() should return true if the mouse is currently over the IClickable
     * object
     */
    public boolean isHovered();

    public void onHover();

    public void onUnhover();

    public void onClick();

    public void onClickAway(Point p);
}
