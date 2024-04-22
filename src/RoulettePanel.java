import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class RoulettePanel extends JPanel implements ImageObserver {


    public RoulettePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 16; i++){

        }


        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


