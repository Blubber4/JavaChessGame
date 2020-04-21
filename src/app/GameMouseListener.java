package app;

import java.util.List;

import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.event.MouseInputAdapter;

/* mouse listener is attached to main frame, so points will have to be adjusted to consider position relative to the window */
public class GameMouseListener extends MouseInputAdapter {
    // cached references
    GamePanel gamePanel; // to GamePanel for intersection checking - seems messy, better way?
    IClickable hoveredObject;
    IClickable selectedObject;

    public GameMouseListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        List<IClickable> intersections = gamePanel.getIntersections(p);

        if (intersections.size() == 0) {
            if (selectedObject != null) {
                selectedObject.onClickAway(e.getPoint());
                selectedObject = null;
            }
            return;
        } else if (intersections.size() > 1) {
            return;
        }
        if (selectedObject != null) {
            selectedObject.onClick();
        }
        selectedObject = intersections.get(0);
        selectedObject.onClick();
    }

    public static boolean isClickable(Object object) {
        if (object instanceof IClickable) {
            return true;
        }
        return false;
    }
}
