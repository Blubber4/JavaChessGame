package app;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
  private List<GameObject> gameObjects;
  private Timer timer;

  public GamePanel(int width, int height)
  {
    initPanel(width, height);
  }

  public GamePanel()
  {
    initPanel(600, 00); // default pane size here
  }

  private void initPanel(int width, int height)
  {
    gameObjects = new ArrayList<>();
    setPreferredSize(new Dimension(width, height));

    timer = new Timer(40, new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        repaint(); // THIS IS NOT MOVING PROPERLY
      }
    });
    timer.start();
  }

  public void add(GameObject gameObject)
  {
    gameObjects.add(gameObject);
  }

  public void startAll()
  {
    for (GameObject gameObject : gameObjects)
    {
      gameObject.start();
    }
  }

  public void updateAll()
  {
    for (GameObject gameObject : gameObjects)
    {
      gameObject.update();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (GameObject gameObject : gameObjects) {
          gameObject.draw(g);
      }
  }
}
