import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChessGame
{
    public static void main(String args[])
    {
        try {
            startGame();
        }
        catch (IOException err)
        {
            System.out.println(err.getMessage());
        }
        
    }

    private static void startGame() throws IOException
    {
        JFrame frame = buildFrame();
        final BufferedImage image = ImageIO.read(new File("..\\Rook.png"));

        JPanel pane = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        frame.add(pane);
    }

    private static JFrame buildFrame()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        return frame;
    }
}