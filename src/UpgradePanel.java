import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class UpgradePanel extends JPanel implements ImageObserver {

    static boolean autoo = false;
    static boolean autoBought = false;
    static TextBox buyAuto, auto, reduceTime;
    Color active = new Color(17, 48, 182);
    Color down =new Color(102, 110, 102);

    static int xframe =Toolkit.getDefaultToolkit().getScreenSize().width/7;
    static int yframe = 130;

    BufferedImage Ximg;

    public UpgradePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        xframe = Main.upgradeFrame.getX();
        yframe = Main .upgradeFrame.getY();

        TextBox box = new TextBox(Color.black, Color.black, new int[]{300, 600, 600, 300}, new int[]{50, 50, 425, 425}, "", g);
        box.draw();

        TextBox exit = new TextBox(Ximg, "Images/Upgrade Stuff/X.png", 0, 0, g);
        exit.drawImgBox(this, 30, 30);

            if (!autoBought) {
                buyAuto = new TextBox(active, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "1000 Points = Auto Puller", g);
            } else {
                if (autoo) {
                    buyAuto.erase();
                    auto = new TextBox(active, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "Stop auto", g);
                } else {
                    buyAuto.erase();
                    auto = new TextBox(down, Color.black, new int[]{320, 580, 580, 320}, new int[]{70, 70, 145, 145}, "Start auto", g);
                }
            }
            if (buyAuto != null) {
                buyAuto.draw();
            }
            if (auto != null) {
                auto.draw();
            }


            if (autoBought){
                if (SlotsPanel.timerWait > 8) {
                    reduceTime = new TextBox(active, Color.black, new int[]{320, 580, 580, 320}, new int[]{170, 170, 245, 245}, "100 Points = -2 Timer Wait", g);
                    reduceTime.draw();
                } else {
                    reduceTime = new TextBox(down, Color.black, new int[]{320, 580, 580, 320}, new int[]{170, 170, 245, 245}, "100 Points = -2 Timer Wait", g);
                    reduceTime.draw();
                }
            }



        if (UpgradesMouseListener.clicked) {
            if (autoBought) {
                if (reduceTime.upgrClicked()) {
                    if (SlotsPanel.points >= 100) {
                        SlotsPanel.points -= 100;
                        SlotsPanel.timerWait -= 2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Not enough points to buy");
                    }
                }
            }

            if (autoBought) {
                if (auto.upgrClicked()) {
                    if (autoBought) {
                        if (!autoo) {
                            autoo = true;
                        } else {
                            autoo = false;
                        }
                    }
                }
            } else if (buyAuto.upgrClicked()){
                if (SlotsPanel.points >= 1000) {
                    repaint();
                    autoo = true;
                    autoBought = true;
                    SlotsPanel.points -= 1000;
                    System.out.println("dasd");
                }
            }

            if (exit.upgrClicked()){
                Main.upgradeFrame.dispose();
            }

            UpgradesMouseListener.clicked = false;
        }

        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


