//import Window;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g;

    Image img1 = Toolkit.getDefaultToolkit().getImage("./Resources/Rook.png");
    g2.drawImage(img1, 10, 10, this);
    g2.finalize();
  }
}

public class ChessGame
{
    public static void main(String args[])
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
        //startGame();
    }

    private static void startGame()
    {
        Window window = new Window(1000, 1000);
    }
}
