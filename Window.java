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
import java.net.URL;

public class Window extends JPanel
{
    int width;
    int height;
    JFrame frame;

    public Window(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.frame = buildFrame();
        drawRook();
    }

    public Window()
    {
        Window(1920, 1080);
    }
    
    private JFrame buildFrame()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(this.width, this.height);
        frame.setVisible(true);
        return frame;
    }

    private void drawRook()
    {
        URL path = this.getClass().getResource("Rook.png"); // problem begins here?
        BufferedImage image = loadImage(path);
        JPanel pane = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
    }

    private BufferedImage loadImage(URL path)
    {
        
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(path);
        }
        catch (IOException err)
        {
            System.out.println(err.getMessage());
        }

        return image;
    }
}

