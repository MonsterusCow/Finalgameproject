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

        TextBox hi = new TextBox()

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


