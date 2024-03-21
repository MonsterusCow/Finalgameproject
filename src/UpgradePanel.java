import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class UpgradePanel extends JPanel implements ImageObserver {

    static boolean autoo = false;
    boolean autoBought = false;
    TextBox auto;

    public UpgradePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        TextBox box = new TextBox(Color.black, Color.black, new int[]{300, 600, 600, 300}, new int[]{50, 50, 425, 425}, "", g);
        box.draw();
        if (!autoo) {
            if (!autoBought) {
                auto = new TextBox(Color.blue, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "1000 Points = Auto Puller", g);
            } else {
                auto = new TextBox(Color.blue, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "Press to start auto puller", g);
            }
        } else {
            auto = new TextBox(Color.blue, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "Press to stop auto puller", g);
        }
        auto.draw();



            if (UpgradesMouseListener.clicked) {
                if (auto.upgrClicked()) {
                    if (!autoo) {
                        if (autoBought){
                            autoo = true;
                        } else if (SlotsPanel.points >= 1000) {
                            autoo = true;
                            autoBought = true;
                            SlotsPanel.points -= 1000;
                            System.out.println("dasd");
                        }
                    } else {
                        autoo = false;
                    }
                }
            }


        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


