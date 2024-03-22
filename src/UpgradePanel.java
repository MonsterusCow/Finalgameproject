import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class UpgradePanel extends JPanel implements ImageObserver {

    static boolean autoo = false;
    boolean autoBought = false;
    TextBox auto;
    TextBox stop;
    Color autc = new Color(102, 110, 102);
    Color stoc = new Color(17, 48, 182);


    public UpgradePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        TextBox box = new TextBox(Color.black, Color.black, new int[]{300, 600, 600, 300}, new int[]{50, 50, 425, 425}, "", g);
        box.draw();

        if (!autoBought) {
                auto = new TextBox(Color.blue, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "1000 Points = Auto Puller", g);
                auto.draw();
            } else {
            stop = new TextBox(stoc, Color.black, new int[]{320, 420, 420, 320}, new int[]{70, 70, 145, 145}, "Stop auto", g);
            auto = new TextBox(autc, Color.black, new int[]{480, 580, 580, 480}, new int[]{70, 70, 145, 145}, "Start auto", g);
            auto.draw();
            stop.draw();
        }



            if (UpgradesMouseListener.clicked) {
                if (autoBought) {
                    if (stop.upgrClicked()) {
                        autoo = false;
                        stoc = new Color(102, 110, 102);
                        autc = new Color(17, 48, 182);
                    }
                }
                if (auto.upgrClicked()) {
                        if (autoBought){
                            autoo = true;
                            stoc = new Color(17, 48, 182);
                            autc = new Color(102, 110, 102);
                        } else if (SlotsPanel.points >= 1000) {
                            autoo = true;
                            autoBought = true;
                            SlotsPanel.points -= 1000;
                            System.out.println("dasd");
                        }
                }

            }


        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


