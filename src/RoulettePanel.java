import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    static boolean spin = false;
    static TextBox store, roulette;

    public RoulettePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dra) {
            roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R0.png", new int[]{Main.rouletteFrame.getWidth() / 2 - 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 - 200}, new int[]{Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 + 200, Main.rouletteFrame.getHeight() / 2 + 200}, g);
            roulette.drawImgBox(this);
        }

        if (RouletteMouseListener.clicked) {
            if (roulette.Clicked(RouletteMouseListener.clickedx, RouletteMouseListener.clickedy)){
                spin = true;
                System.out.println(spin +"spin");
            }
        }

        if (spin) {
            dra = false;
            if (ticks >= (0+((int)(Math.random()*10)-5))) {
                roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R" + (draw) + ".png", new int[]{Main.rouletteFrame.getWidth() / 2 - 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 - 200}, new int[]{Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 + 200, Main.rouletteFrame.getHeight() / 2 + 200}, g);
                roulette.drawImgBox(this);
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
            roulette = store;
        }

        try {
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println(e);
        }

        //repaint--------------------------------------------------------------------------
        repaint();
    }
}


