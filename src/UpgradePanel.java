import org.w3c.dom.Text;

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
    static boolean error = false;
    static TextBox buyAuto, auto, reduceTime;
    TextBox affirm;
    Color active = new Color(17, 48, 182);
    Color down =new Color(102, 110, 102);

    static int xframe =Toolkit.getDefaultToolkit().getScreenSize().width/7;
    static int yframe = 130;

    static BufferedImage Ximg;

    public UpgradePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        xframe = Main.upgradeFrame.getX();
        yframe = Main .upgradeFrame.getY();

        TextBox box = new TextBox(Color.black, Color.black, new int[]{300, 600, 600, 300}, new int[]{50, 50, 425, 425}, "", g);
        box.draw(20);



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
                buyAuto.draw(20);
            }
            if (auto != null) {
                auto.draw(20);
            }


            if (autoBought){
                if (SlotsPanel.timerWait > 0) {
                    reduceTime = new TextBox(active, Color.black, new int[]{320, 580, 580, 320}, new int[]{170, 170, 245, 245}, "300 Points = -2 Timer Wait", g);
                    reduceTime.draw(20);
                } else {
                    reduceTime = new TextBox(down, Color.black, new int[]{320, 580, 580, 320}, new int[]{170, 170, 245, 245}, "300 Points = -2 Timer Wait", g);
                    reduceTime.draw(20);
                }
            }

        if (error) {
            TextBox nuhuh = new TextBox(Color.red, Color.black, new int[]{50, Main.upgradeFrame.getWidth() - 50, Main.upgradeFrame.getWidth() - 50, 50}, new int[]{50, 50, Main.upgradeFrame.getHeight() - 50, Main.upgradeFrame.getHeight() - 50}, "Not enough points to buy", g);
            nuhuh.draw(20);
            affirm = new TextBox(active, Color.black, new int[]{nuhuh.getxTLBL() + 40, nuhuh.getxTRBR() - 40, nuhuh.getxTRBR() - 40, nuhuh.getxTLBL() + 40}, new int[]{nuhuh.getyB() - 50, nuhuh.getyB() - 50, nuhuh.getyB() - 10, nuhuh.getyB() - 10}, "ok", g);
            affirm.draw(20);
        }

        TextBox exit = new TextBox(Ximg, "Images/Upgrade Stuff/X.png", new int[] {5, 40, 40, 5}, new int[] {5, 5, 40, 40}, g);
        exit.drawImgBox(this);

        if (UpgradesMouseListener.clicked) {

            if (error) {
                if (affirm.Clicked(UpgradesMouseListener.clickedx, UpgradesMouseListener.clickedy)) {
                    error = false;
                }
            }

            if (autoBought) {
                if (reduceTime.Clicked(UpgradesMouseListener.clickedx, UpgradesMouseListener.clickedy)) {
                    if (SlotsPanel.points >= 300) {
                        SlotsPanel.points -= 300;
                        SlotsPanel.timerWait -= 2;
                    } else {
                        error = true;
                    }
                }
            }

            if (autoBought) {
                if (auto.Clicked(UpgradesMouseListener.clickedx, UpgradesMouseListener.clickedy)) {
                    if (autoBought) {
                        if (!autoo) {
                            autoo = true;
                        } else {
                            autoo = false;
                        }
                    }
                }
            } else if (buyAuto.Clicked(UpgradesMouseListener.clickedx, UpgradesMouseListener.clickedy)){
                if (SlotsPanel.points >= 1000) {
                    repaint();
                    autoo = true;
                    autoBought = true;
                    SlotsPanel.points -= 1000;
                    System.out.println("dasd");
                } else {
                    error = true;
                }
            }

            if (exit.Clicked(UpgradesMouseListener.clickedx, UpgradesMouseListener.clickedy)){
                Main.upgradeFrame.setVisible(false);
            }

            UpgradesMouseListener.clicked = false;
        }





        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


