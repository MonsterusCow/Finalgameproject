import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

public class MyPanel extends JPanel implements ImageObserver{

    static double size = 50.0;
    BufferedImage arrow;
    static double arrowDirection;
    int amoooo = 10;
    int updownAmo = 0;
    int lefrigAmo = amoooo;
    int add1 = -1;
    int add2 = 1;
    int wait = 0;
    double angle = 0.0;


    static ArrayList<Block> blocks = new ArrayList<>(1);
    static ArrayList<Double> accel = new ArrayList<>(1);

    public static BufferedImage rotate(Image image, double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);
        // Create a BufferedImage to hold the rotated image
        BufferedImage rotatedImage = new BufferedImage(originalWidth, originalHeight, BufferedImage.TYPE_INT_ARGB);
        // Get the Graphics2D object to draw on the rotated image
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.fillRect(0, 0, originalWidth, originalHeight);
        AffineTransform rotationTransform = new AffineTransform();
        rotationTransform.rotate(angleRadians, originalWidth / 2.0, originalHeight / 2.0);
        g2d.setTransform(rotationTransform);
        g2d.drawImage(image, 0, 0, null);
        // Dispose the Graphics2D object
        g2d.dispose();
        // Return the rotated image
        return rotatedImage;
    }

    public MyPanel() {
        setBackground(new Color(29, 102, 16));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //when click--------------------------------------------------------------------------

        if (MyMouseListener.isdown) {
            if (wait == 0) {
                blocks.add(new Block(updownAmo, lefrigAmo));
            }
            wait++;
            if (wait == 10){
                wait = 0;
            }
        }

        //Deletion--------------------------------------------------------------------------

        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).y[0] >= Main.frame.getHeight() + 100) {
                blocks.remove(i);
                System.out.println("removed");
            } else {
                if (blocks.get(i).y[1] >= Main.frame.getHeight() + 100) {
                    blocks.remove(i);
                    System.out.println("removed");
                    break;
                } else {
                    if (blocks.get(i).y[2] >= Main.frame.getHeight() + 100) {
                        blocks.remove(i);
                        System.out.println("removed");
                        break;
                    } else {
                        if (blocks.get(i).y[3] >= Main.frame.getHeight() + 100) {
                            blocks.remove(i);
                            System.out.println("removed");
                            break;
                        }
                    }
                }
            }
        }

        //Drawing--------------------------------------------------------------------------

        for (int i = 0; i < blocks.size(); i++) {
            g.setColor(Color.BLACK);
            g.fillPolygon(blocks.get(i).getXArray(), blocks.get(i).getYArray(), 4);

        }

        //Putting frame back--------------------------------------------------------------------------

//            if (Main.frame.getX() != 0 || Main.frame.getY() != 0) {
//                Main.frame.setBounds(Main.startcordx, Main.startcordy, 600, 600);
//            }

        //gravity--------------------------------------------------------------------------

        for (int i = 0; i<blocks.size(); i++){
            blocks.get(i).gravity();
        }

        //arrow--------------------------------------------------------------------------

        try {
            arrow = ImageIO.read(new File("Images/arrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(arrow, (MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX()) - arrow.getWidth() / 2, (MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY()) - (arrow.getHeight() / 2 + 20), this);

        //keypresses--------------------------------------------------------------------------

        if (MyKeyListener.keydown1) {
//            MyKeyListener.keydown1 = false;
//            MyKeyListener.keydown2 = false;
            if (updownAmo >= amoooo){
                add1 = -1;
            }
            if (lefrigAmo >= amoooo){
                add2 = -1;
            }
            if (updownAmo <= -amoooo){
                add1 = 1;
            }
            if (lefrigAmo <= -amoooo){
                add2 = 1;
            }
            updownAmo += add1;
            lefrigAmo += add2;
            arrow = rotate(arrow, angle);
        }
//        if (MyKeyListener.keydown2) {
//            MyKeyListener.keydown2 = false;
//            if (updownAmo >= 10){
//                add1 = -1;
//            }
//            if (lefrigAmo >= 10){
//                add2 = -1;
//            }
//            if (updownAmo <= -10){
//                add1 = 1;
//            }
//            if (lefrigAmo <= -10){
//                add2 = 1;
//            }
//            updownAmo += add1;
//            lefrigAmo -= add2;
//        }


        //Trywait (end)--------------------------------------------------------------------------

        try {
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println(e);
        }

       //repaint--------------------------------------------------------------------------
        repaint();
    }
}

