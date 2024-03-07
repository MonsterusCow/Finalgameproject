import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class MyPanel extends JPanel implements ImageObserver {

    boolean up = true;
    boolean timer = false;
    int wait = 0;

    BufferedImage slothandledn, slothandleup, slotmachineful, slotmachineemp;
    BufferedImage[] slots = new BufferedImage[4];
    public MyPanel() {
        setBackground(new Color(29, 102, 16));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        try { slothandledn = ImageIO.read(new File("Images/Machine Parts/slothandledn.png")); } catch (IOException e) { e.printStackTrace(); }
        try { slothandleup = ImageIO.read(new File("Images/Machine Parts/slothandleup.png")); } catch (IOException e) { e.printStackTrace(); }
        try { slotmachineful = ImageIO.read(new File("Images/Machine Parts/slotmachineful.png")); } catch (IOException e) { e.printStackTrace(); }
        try { slotmachineemp = ImageIO.read(new File("Images/Machine Parts/slotmachineemp.png")); } catch (IOException e) { e.printStackTrace(); }
        slots[0] = slothandledn; slots[1] = slothandleup; slots[2] = slotmachineful; slots[3] = slotmachineemp;

//        g.drawImage(slotmachineful, (MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX()), (MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY()), this);


       if (up) {
           g.drawImage(slothandleup, 640, 89, this);
       } else {
           g.drawImage(slothandledn, 640, 69, this);

       }
        g.drawImage(slotmachineful, 432, 60, this);

        //check click--------------------------------------------------------------------------

        if (MyMouseListener.clicked) {
            MyMouseListener.clicked = false;
            if (MyMouseListener.clickedx >= 887 && MyMouseListener.clickedx <= 930) {
                if (MyMouseListener.clickedy >= 237 && MyMouseListener.clickedy <= 402) {
                    if (up) {
                        up = false;
                    } else {
                        up = true;
                    }
                    MyMouseListener.clickedx = 0;
                    MyMouseListener.clickedy = 0;
                    timer = true;
                }
            }
        }

        if (timer){
            wait++;
            if (wait >= 20){
                timer = false;
                up = true;
                wait = 0;
            }
        }

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










//    static double size = 50.0;
//    BufferedImage arrow1, arrow2, arrow3, arrow4, arrow5, arrow6, arrow7, arrow8, arrow9, arrow10, arrow11, arrow12, arrow13, arrow14, arrow15, arrow16;
//    int updownAmo = 0;
//    int lefrigAmo = 8;
//    int add1;
//    int add2;
//    static int wait = 1;
//    int angle = 1;
//    BufferedImage[] arrows = new BufferedImage[16];

//    static ArrayList<Block> blocks = new ArrayList<>(1);

//        public void count(){
//            if (angle==1){ add1 = 0; add2 = 8; }
//            if (angle==2){ add1 = 3; add2 = 8; }
//            if (angle==3){ add1 = 5; add2 = 5; }
//            if (angle==4){ add1 = 8; add2 = 3; }
//            if (angle==5){ add1 = 8; add2 = 0; }
//            if (angle==6){ add1 = 8; add2 = -3; }
//            if (angle==7){ add1 = 5; add2 = -5; }
//            if (angle==8){ add1 = 3; add2 = -8; }
//            if (angle==9){ add1 = 0; add2 = -8; }
//            if (angle==10){ add1 = -3; add2 = -8; }
//            if (angle==11){ add1 = -5; add2 = -5; }
//            if (angle==12){ add1 = -8; add2 = -3; }
//            if (angle==13){ add1 = -8; add2 = 0; }
//            if (angle==14){ add1 = -8; add2 = 3; }
//            if (angle==15){ add1 = -5; add2 = 5; }
//            if (angle==16){ add1 = -3; add2 = 8; }
//            updownAmo = add1;
//            lefrigAmo = add2;
//        }
//



//        //make cooldown--------------------------------------------------------------------------
//
////        if (MyMouseListener.clicked) {
////                blocks.add(new Block(updownAmo, lefrigAmo));
////                MyMouseListener.clicked = false;
////        }
//        if (MyMouseListener.isdown) {
//            if (wait == 0) {
//            blocks.add(new Block(updownAmo, lefrigAmo));
//            }
//            wait++;
//            if (wait == 10){
//                wait = 0;
//            }
//        }
//
//        //Deletion--------------------------------------------------------------------------
//
//        for (int i = 0; i < blocks.size(); i++) {
//            if (blocks.get(i).y[0] >= Main.frame.getHeight() + 100) {
//                blocks.remove(i);
//                System.out.println("removed");
//            } else {
//                if (blocks.get(i).y[1] >= Main.frame.getHeight() + 100) {
//                    blocks.remove(i);
//                    System.out.println("removed");
//                    break;
//                } else {
//                    if (blocks.get(i).y[2] >= Main.frame.getHeight() + 100) {
//                        blocks.remove(i);
//                        System.out.println("removed");
//                        break;
//                    } else {
//                        if (blocks.get(i).y[3] >= Main.frame.getHeight() + 100) {
//                            blocks.remove(i);
//                            System.out.println("removed");
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        //Drawing--------------------------------------------------------------------------
//
//        for (int i = 0; i < blocks.size(); i++) {
//            g.setColor(Color.BLACK);
//            g.fillPolygon(blocks.get(i).getXArray(), blocks.get(i).getYArray(), 4);
//
//        }
//
//        //Putting frame back--------------------------------------------------------------------------
//
////            if (Main.frame.getX() != 0 || Main.frame.getY() != 0) {
////                Main.frame.setBounds(Main.startcordx, Main.startcordy, 600, 600);
////            }
//
//        //gravity--------------------------------------------------------------------------
////
////        for (int i = 0; i<blocks.size(); i++){
////            blocks.get(i).gravity();
////        }
//
//        //arrow--------------------------------------------------------------------------
//
//        try { arrow1 = ImageIO.read(new File("Images/arrow1.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow2 = ImageIO.read(new File("Images/arrow2.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow3 = ImageIO.read(new File("Images/arrow3.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow4 = ImageIO.read(new File("Images/arrow4.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow5 = ImageIO.read(new File("Images/arrow5.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow6 = ImageIO.read(new File("Images/arrow6.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow7 = ImageIO.read(new File("Images/arrow7.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow8 = ImageIO.read(new File("Images/arrow8.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow9 = ImageIO.read(new File("Images/arrow9.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow10 = ImageIO.read(new File("Images/arrow10.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow11 = ImageIO.read(new File("Images/arrow11.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow12 = ImageIO.read(new File("Images/arrow12.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow13 = ImageIO.read(new File("Images/arrow13.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow14 = ImageIO.read(new File("Images/arrow14.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow15 = ImageIO.read(new File("Images/arrow15.png")); } catch (IOException e) { e.printStackTrace(); }
//        try { arrow16 = ImageIO.read(new File("Images/arrow16.png")); } catch (IOException e) { e.printStackTrace(); }
//
//        for(int i = 1; i < 17; i++){
//            try { arrows[i-1] = ImageIO.read(new File("Images/arrow" + i + ".png")); } catch (Exception e){}
//        }
//
//        g.drawImage(arrows[angle-1], (MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX()) - arrow1.getWidth() / 2, (MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY()) - (arrow1.getHeight() / 2 + 20), this);
//
//        //keypresses--------------------------------------------------------------------------
//
//        if (MyKeyListener.keydown1) {
//            MyKeyListener.keydown1 = false;
//            if (angle==1) {
//                angle = 16;
//            } else {
//                angle--;
//            }
//            count();
//        }
//        if (MyKeyListener.keydown2) {
//            MyKeyListener.keydown2 = false;
//            if (angle==16){
//                angle = 1;
//            } else {
//                angle++;
//            }
//            count();
//        }




