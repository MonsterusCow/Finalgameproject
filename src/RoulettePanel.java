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

    BufferedImage R0,R1,R2,R3,R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,R14,R15;
    BufferedImage[] symbols = {R0,R1,R2,R3,R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,R14,R15};
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
    BufferedImage Ximg;

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


