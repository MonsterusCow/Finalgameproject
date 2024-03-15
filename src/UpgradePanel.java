import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class UpgradePanel extends JPanel implements ImageObserver {

    static boolean autoo = false;

    public UpgradePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        TextBox box = new TextBox(Color.black, Color.black, new int[]{300, 600, 600, 300}, new int[]{50, 50, 425, 425}, "", g);
        box.draw();
        TextBox auto = new TextBox(Color.blue, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "1000 Points = Auto Puller", g);
        auto.draw();


        if (MyMouseListener.clicked) {
            if(auto.clicked()) {
                autoo = true;
                SlotsPanel.points -= 1000;
                System.out.println("dasd");
            }
    }

        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


