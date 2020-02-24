import Window;

public class ChessGame
{
    public static void main(String args[])
    {
        startGame();        
    }

    private static void startGame()
    {
        Window window = new Window(1000, 1000);
    }

    /*
    private static startGame() throws IOException
    {
        JFrame frame = buildFrame();
        final BufferedImage image = ImageIO.read(new File("src/resources/Rook.png"));

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

    } */
}