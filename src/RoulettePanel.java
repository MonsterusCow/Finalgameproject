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

    public RoulettePanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        TextBox roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R0.png", new int[] {Main.rouletteFrame.getWidth()/2-200, Main.rouletteFrame.getWidth()/2+200, Main.rouletteFrame.getWidth()/2+200, Main.rouletteFrame.getWidth()/2-200}, new int[] {Main.rouletteFrame.getHeight()/2-200, Main.rouletteFrame.getHeight()/2-200, Main.rouletteFrame.getHeight()/2+200, Main.rouletteFrame.getHeight()/2+200}, g);
        roulette.drawImgBox(this);

        if (RouletteMouseListener.clicked) {
            try {R0 = ImageIO.read(new File("Images/Routlette/R0.png"));} catch (IOException e) {e.printStackTrace();}
            try {R1 = ImageIO.read(new File("Images/Routlette/R1.png"));} catch (IOException e) {e.printStackTrace();}
            try {R2 = ImageIO.read(new File("Images/Routlette/R2.png"));} catch (IOException e) {e.printStackTrace();}
            try {R3 = ImageIO.read(new File("Images/Routlette/R3.png"));} catch (IOException e) {e.printStackTrace();}
            try {R4 = ImageIO.read(new File("Images/Routlette/R4.png"));} catch (IOException e) {e.printStackTrace();}
            try {R5 = ImageIO.read(new File("Images/Routlette/R5.png"));} catch (IOException e) {e.printStackTrace();}
            try {R6 = ImageIO.read(new File("Images/Routlette/R6png"));} catch (IOException e) {e.printStackTrace();}
            try {R7 = ImageIO.read(new File("Images/Routlette/R7.png"));} catch (IOException e) {e.printStackTrace();}
            try {R8 = ImageIO.read(new File("Images/Routlette/R8.png"));} catch (IOException e) {e.printStackTrace();}
            try {R9 = ImageIO.read(new File("Images/Routlette/R9.png"));} catch (IOException e) {e.printStackTrace();}
            try {R10 = ImageIO.read(new File("Images/Routlette/R10.png"));} catch (IOException e) {e.printStackTrace();}
            try {R11 = ImageIO.read(new File("Images/Routlette/R11.png"));} catch (IOException e) {e.printStackTrace();}
            try {R12 = ImageIO.read(new File("Images/Routlette/R12.png"));} catch (IOException e) {e.printStackTrace();}
            try {R13 = ImageIO.read(new File("Images/Routlette/R13.png"));} catch (IOException e) {e.printStackTrace();}
            try {R14 = ImageIO.read(new File("Images/Routlette/R14.png"));} catch (IOException e) {e.printStackTrace();}
            try {R15 = ImageIO.read(new File("Images/Routlette/R15.png"));} catch (IOException e) {e.printStackTrace();}
            for (int i = 0; i < 16; i++) {
                roulette = new TextBox(UpgradePanel.Ximg, "Images/Routlette/R"+i+".png", new int[] {Main.rouletteFrame.getWidth()/2-200, Main.rouletteFrame.getWidth()/2+200, Main.rouletteFrame.getWidth()/2+200, Main.rouletteFrame.getWidth()/2-200}, new int[] {Main.rouletteFrame.getHeight()/2-200, Main.rouletteFrame.getHeight()/2-200, Main.rouletteFrame.getHeight()/2+200, Main.rouletteFrame.getHeight()/2+200}, g);
                roulette.drawImgBox(this);
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


