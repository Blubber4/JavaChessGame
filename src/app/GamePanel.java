package app;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    // cached references
    private Timer timer;

  // config params
  private final int DEF_WIDTH = 600; // default panel width
  private final int DEF_HEIGHT = 600; // default panel height
  private final int REFRESH_RATE = 10; // how often update and redraw will be called in ms

  private Board board = new Board();

  public GamePanel(int width, int height)
  {
    initPanel(width, height);
  }

  public GamePanel()
  {
    initPanel(DEF_WIDTH, DEF_HEIGHT);
  }

  private void initPanel(int width, int height)
  {
	this.board.createPieces();
    setPreferredSize(new Dimension(width, height));
    timer = new Timer(REFRESH_RATE, new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        //updateAll();
        repaint();
      }
    });
    //timer.start();
  }

  public void startAll()
  {
    
  }

  private void drawBoard(Graphics g)
  {
	  board.draw(g);
  }

    // override of JPanel drawing
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }
}
