import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class ScorePanel extends JPanel implements ImageObserver {


    public ScorePanel() {
        setBackground(new Color(55, 208, 30));
    }

    BufferedImage sheet;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Words----------------------------------------------------------------------------------------------------------------------------------------------------
        try { sheet = ImageIO.read(new File("Images/Roll Parts/ScoreSheet.png")); } catch (IOException e) { e.printStackTrace(); }
        g.drawImage(sheet, 0, 0, this);
        //Trywait (end)----------------------------------------------------------------------------------------------------------------------------------------------------

        try {
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println(e);
        }

        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


