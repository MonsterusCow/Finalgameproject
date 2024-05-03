import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class RoulettePanel extends JPanel implements ImageObserver {

    static int draw = 0;
    static int ticks = 64;
    static boolean dra = true;
    static boolean active = false;
    static boolean spin = false;

    WindowListener winlis = new WindowListener() {
        @Override public void windowOpened(WindowEvent e) {}
        @Override public void windowClosing(WindowEvent e) {}
        @Override public void windowClosed(WindowEvent e) {}
        @Override public void windowIconified(WindowEvent e) {}
        @Override public void windowDeiconified(WindowEvent e) {}
        @Override public void windowActivated(WindowEvent e) {
            active = true;
            repaint();
//            System.out.println("asdassazasfsvsdwe");
        }
        @Override public void windowDeactivated(WindowEvent e) {
            active = false;
//            System.out.println("falsseee");
        }
    };

    static TextBox store, roulette;
    BufferedImage Ximg, scores;

    public RoulettePanel() {
        setBackground(new Color(32, 94, 16));
        Main.rouletteFrame.addWindowListener(winlis);
    }

    @Override
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            TextBox exit = new TextBox(Ximg, "Images/Upgrade Stuff/X.png", new int[]{5, 40, 40, 5}, new int[]{5, 5, 40, 40}, g);
            exit.drawImgBox(this);

            if (dra) {
                roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R0.png", new int[]{Main.rouletteFrame.getWidth() / 2 - 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 - 200}, new int[]{Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 + 200, Main.rouletteFrame.getHeight() / 2 + 200}, g);
                roulette.drawImgBox(this);
            }

        TextBox pointsbox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{roulette.getxTLBL(), roulette.getxTLBL()+150, roulette.getxTLBL()+150, roulette.getxTLBL()}, new int[]{roulette.getyT()-120, roulette.getyT()-120, roulette.getyT()-20, roulette.getyT()-20}, "Points:" + SlotsPanel.points, g);
        pointsbox.draw(20);
        TextBox betbox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{roulette.getxTRBR()-150, roulette.getxTRBR(), roulette.getxTRBR(), roulette.getxTRBR()-150}, new int[]{roulette.getyT()-120, roulette.getyT()-120, roulette.getyT()-20, roulette.getyT()-20}, "Click to bet", g);
        betbox.draw(20);
        try {
            scores = ImageIO.read(new File("Images/Routlette/scores.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scores = SlotsPanel.resize(scores, 150, 500);
        g.drawImage(scores, roulette.getxTLBL() - 200, roulette.getyB()-roulette.getyT()-250, this);




            if (RouletteMouseListener.clicked) {
                System.out.println("clicked");
                if (roulette.Clicked(RouletteMouseListener.clickedx, RouletteMouseListener.clickedy)) {
                    spin = true;
                    System.out.println(spin + "spin");
                }
                if (exit.Clicked(RouletteMouseListener.clickedx, RouletteMouseListener.clickedy)) {
                    Main.rouletteFrame.setVisible(false);
                }
                RouletteMouseListener.clicked = false;
            }

            if (!spin) {
                if (ticks != 64) {
                    ticks = 64;
                }
            }
            if (spin) {
                dra = false;
                if (ticks >= ((int) (Math.random() * 21) - 10)) {
                    roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R" + (draw) + ".png", new int[]{Main.rouletteFrame.getWidth() / 2 - 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 - 200}, new int[]{Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 + 200, Main.rouletteFrame.getHeight() / 2 + 200}, g);
                    store = roulette;
                    if (draw < 15) {
                        draw++;
                        ticks--;
                    } else {
                        draw = 0;
                    }
                } else {
                    spin = false;
                    SlotsPanel.points += 100;
                }
            } else {
                roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R" + (draw) + ".png", new int[]{Main.rouletteFrame.getWidth() / 2 - 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 - 200}, new int[]{Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 + 200, Main.rouletteFrame.getHeight() / 2 + 200}, g);
            }
            roulette.drawImgBox(this);

        if (active) {

            try {
                Thread.sleep(20);
            } catch (Exception e) {
                System.out.println(e);
            }
            //repaint--------------------------------------------------------------------------
            repaint();
        }
    }
}


