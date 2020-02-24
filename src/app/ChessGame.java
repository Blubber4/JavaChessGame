package app;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;

// Rook extends ChessPiece extends GameObject

public class ChessGame
{
  private JFrame window;
  private JPanel pane;
  private Rook rook;
  private State state;
  List<GameObject> gameObjects = new ArrayList<GameObject>();

  public enum State {
    EXITING,
    PAUSED,
    PLAYING
  }

  public ChessGame()
  {
    initPieces();
    initPane();
    initWindow(500, 500);
    //initTimer();
  }

  private void initWindow(int width, int height)
  {
    this.window = new JFrame("Chess Game");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(width, height);
    window.add(pane);
    window.setContentPane(pane);
    window.pack();
    window.setVisible(true);
  }

  private void initPane()
  {
    this.pane = new JPanel()
    {
      @Override
      protected void paintComponent(Graphics g)
      {
        super.paintComponent(g);
        Image image = rook.getImage();
        g.drawImage(image, rook.getPosX(), rook.getPosY(), null); // rook hard coded for now, draw from list of gameobjects later
      }
    };
  }

  /* private void initTimer()
  {
    this.timer = new Timer(400, new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          repaint();
      }
    });
    timer.start();
  } */

  /* @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    for (GameObject gameObject : this.gameObjects)
    {
      g.drawImage(gameObject.getImage(), gameObject.getPositionX(), gameObject.getPositionY(), null);
    }
  } */

  private void initPieces()
  {
    this.rook = new Rook("Rook.png");
    rook.start();
  }

  public void gameLoop()
  {
    for (GameObject gameObject : this.gameObjects)
    {
      gameObject.start();
    }
    while (state != State.EXITING)
    {
      for (GameObject gameObject : this.gameObjects)
      {
        gameObject.update();
      }
      // repaint();
    }
  }
}