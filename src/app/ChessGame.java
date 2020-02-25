package app;

import javax.swing.JFrame;
import java.awt.Dimension;

// Rook extends ChessPiece extends GameObject
// board should also extend GameObject
public class ChessGame
{
  // cached references
  private JFrame window;
  private State state;
  private GamePanel gamePanel;

  public enum State {
    EXITING,
    PAUSED,
    PLAYING
  }

  public ChessGame()
  {
    this.gamePanel = new GamePanel();
    initPieces();
    initWindow(600, 600);
  }

/* this needs to be called before initWindow() */
  private void initPieces()
  {
    gamePanel.add(new Rook());
    gamePanel.add(new Rook(300, 0));
  }

  private void initWindow(int width, int height)
  {
    this.window = new JFrame("Chess Game");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setPreferredSize(new Dimension(width, height));
    window.add(gamePanel);
    window.setContentPane(gamePanel);
    window.pack();
    window.setVisible(true);
  }

  public void gameLoop()
  {
    gamePanel.startAll();

    while (state != State.EXITING)
    {
      gamePanel.updateAll();
    }
  }
}