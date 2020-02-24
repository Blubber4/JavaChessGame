package app;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g;

    Image img1 = Toolkit.getDefaultToolkit().getImage("resources/Rook.png");
    g2.drawImage(img1, 10, 10, this);
    g2.finalize();
  }
}

public class ChessGame
{
    JFrame window;
    public ChessGame()
    {
        this.window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
    }
}
