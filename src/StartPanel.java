import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.*;

public class StartPanel extends JPanel implements ImageObserver {


    public StartPanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Words----------------------------------------------------------------------------------------------------------------------------------------------------

        String welcome = new String();
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Hi, welcome to gambling. You can press the lever to start spinning.", 100, Main.scoreFrame.getHeight()/2);
        g.drawString("Press the point list to see the prizes you can get", Main.scoreFrame.getWidth()/2-250, Main.scoreFrame.getHeight()/2+30);
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


