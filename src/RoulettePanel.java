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
    int draw = 0;
    static boolean spin = false;
    TextBox store;

    public RoulettePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        TextBox roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R0.png", new int[] {Main.rouletteFrame.getWidth()/2-200, Main.rouletteFrame.getWidth()/2+200, Main.rouletteFrame.getWidth()/2+200, Main.rouletteFrame.getWidth()/2-200}, new int[] {Main.rouletteFrame.getHeight()/2-200, Main.rouletteFrame.getHeight()/2-200, Main.rouletteFrame.getHeight()/2+200, Main.rouletteFrame.getHeight()/2+200}, g);
        roulette.drawImgBox(this);

        if (RouletteMouseListener.clicked) {
            if (roulette.Clicked(RouletteMouseListener.clickedx, RouletteMouseListener.clickedy)){
                spin = true;
            }
        }

        if (spin){
            if (draw%4==0) {
                roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R" + (draw/4) + ".png", new int[]{Main.rouletteFrame.getWidth() / 2 - 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 + 200, Main.rouletteFrame.getWidth() / 2 - 200}, new int[]{Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 - 200, Main.rouletteFrame.getHeight() / 2 + 200, Main.rouletteFrame.getHeight() / 2 + 200}, g);
                store = roulette;
            } else {
                roulette = store;

            roulette.drawImgBox(this);
            if (draw < 64) {
                draw++;
            } else {
                draw = 0;
                spin = false;
            }
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


