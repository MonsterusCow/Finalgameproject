import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.*;

public class SlotsPanel extends JPanel implements ImageObserver {

    boolean up = true;
    boolean timer = false;
    int wait = 0;
    static int points = 1100;
    int[] lastrolled = new int[3];
    int auto = 0;

    BufferedImage slothandledn, slothandleup, slotmachineful, slotmachineemp;
    BufferedImage[] slots = new BufferedImage[4];
    BufferedImage Cherry, Lemon, Melon, Heart, Bell, Shoe, Diamond, Bar, Seven;
    BufferedImage first, second, third;
    BufferedImage perm1, perm2, perm3;
    BufferedImage Casino;


//Resize Method ------------------------------------------------------------------------------------------------------------
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
//Roll Method ------------------------------------------------------------------------------------------------------------
    public BufferedImage roll(int a) {
        try {
            Cherry = ImageIO.read(new File("Images/Roll parts/Cherry.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Lemon = ImageIO.read(new File("Images/Roll parts/Lemon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Melon = ImageIO.read(new File("Images/Roll parts/Melon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Heart = ImageIO.read(new File("Images/Roll parts/Heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Bell = ImageIO.read(new File("Images/Roll parts/Bell.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Shoe = ImageIO.read(new File("Images/Roll parts/Shoe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Diamond = ImageIO.read(new File("Images/Roll parts/Diamond.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Bar = ImageIO.read(new File("Images/Roll parts/Bar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Seven = ImageIO.read(new File("Images/Roll parts/Seven.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage[] symbols = {Cherry, Lemon, Melon, Heart, Bell, Shoe, Diamond, Bar, Seven};
        for (int i = 0; i < 9; i++) {
            symbols[i] = resize(symbols[i], 63, 89);
        }
        int chosen = -1;
        int number = (int) (Math.random() * 101);
        //cherry
        if (number <= 30) {
            //cherry
            chosen = 0;
        } else if (number <= 45) {
            //lemon
            chosen = 1;
        } else if (number <= 60) {
            //melon
            chosen = 2;
        } else if (number <= 70) {
            //heart
            chosen = 3;
        } else if (number <= 80) {
            //bell
            chosen = 4;
        } else if (number <= 85) {
            //shoe
            chosen = 5;
        } else if (number <= 90) {
            //diamond
            chosen = 6;
        } else if (number <= 96) {
            //bar
            chosen = 7;
        } else if (number <= 100) {
            //seven
            chosen = 8;
        }
        lastrolled[a] = chosen;
        return symbols[chosen];
    }
//Check for points method ------------------------------------------------------------------------------------------------------------
    public void points() {
        if (lastrolled[0] == 0 && lastrolled[1] == 0 && lastrolled[2] == 0){
            points += 100;
        } if ((lastrolled[0] == 0 && (lastrolled[0] == lastrolled[1] || lastrolled[0] == lastrolled[2])) || (lastrolled[1] == 0 && lastrolled[1]==lastrolled[2])) {
            points += 50;
            System.out.println(points);
        } else if (lastrolled[0] == 1 && lastrolled[1] == 1 && lastrolled[2] == 1){
            points += 200;
        } else if (lastrolled[0] == 2 && lastrolled[1] == 2 && lastrolled[2] == 2){
            points += 300;
        } else if (lastrolled[0] == 3 && lastrolled[1] == 3 && lastrolled[2] == 3){
            points += 400;
        } else if (lastrolled[0] == 4 && lastrolled[1] == 4 && lastrolled[2] == 4){
            points += 500;
        } else if (lastrolled[0] == 5 && lastrolled[1] == 5 && lastrolled[2] == 5){
            points += 700;
        } else if (lastrolled[0] == 6 && lastrolled[1] == 6 && lastrolled[2] == 6){
            points += 900;
        } else if (lastrolled[0] == 7 && lastrolled[1] == 7 && lastrolled[2] == 7){
            points += 1000;
        } else if (lastrolled[0] == 8 && lastrolled[1] == 8 && lastrolled[2] == 8){
            points += 2000;
        }
    }
    //Contructor ------------------------------------------------------------------------------------------------------------
    public SlotsPanel() {
        setBackground(new Color(30, 104, 213));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw ----------------------------------------------------------------------------------------------------------------------------------------------------

        try { Casino = ImageIO.read(new File("Images/Casino.png")); } catch (IOException e) { e.printStackTrace(); }
//        g.drawImage( Casino, 0, 0, this);

        try { slothandledn = ImageIO.read(new File("Images/Machine Parts/slothandledn.png")); } catch (IOException e) { e.printStackTrace(); }
        try { slothandleup = ImageIO.read(new File("Images/Machine Parts/slothandleup.png")); } catch (IOException e) { e.printStackTrace(); }
        try { slotmachineful = ImageIO.read(new File("Images/Machine Parts/slotmachineful.png")); } catch (IOException e) { e.printStackTrace(); }
        try { slotmachineemp = ImageIO.read(new File("Images/Machine Parts/slotmachineemp.png")); } catch (IOException e) { e.printStackTrace(); }
        slots[0] = slothandledn; slots[1] = slothandleup; slots[2] = slotmachineful; slots[3] = slotmachineemp;


       if (up) {
           g.drawImage(slothandleup, 640, 89, this);
       } else {
           g.drawImage(slothandledn, 640, 69, this);

       }
        g.drawImage(slotmachineful, 432, 60, this);

        //When click handle ----------------------------------------------------------------------------------------------------------------------------------------------------

        if (MyMouseListener.clicked) {
            if (MyMouseListener.clickedx >= 887 && MyMouseListener.clickedx <= 930) {
                if (MyMouseListener.clickedy >= 237 && MyMouseListener.clickedy <= 402) {
                    up = false;
                    MyMouseListener.clickedx = 0;
                    MyMouseListener.clickedy = 0;
                    timer = true;
                    if (wait == 0){
                        points -= 10;
                    }
                }
            }
        }

        //Timer to spin and put handle up ----------------------------------------------------------------------------------------------------------------------------------------------------
        if (timer){
                if (auto == 0) {
                    wait++;
                    if (wait % 2 == 0) {
                        perm1 = roll(0);
                        perm2 = roll(1);
                        perm3 = roll(2);
                        g.drawImage(perm1, 572, 293, this);
                        g.drawImage(perm2, 658, 293, this);
                        g.drawImage(perm3, 746, 293, this);
                    }
                    if (wait >= 20) {
                        if (!UpgradePanel.autoo) {
                            timer = false;
                        } else {
                            auto = 30;
                        }
                        up = true;
                        wait = 0;
                        points();
                    }
                } else {
                    auto--;
                    if (auto == 1) {
                        up = false;
                        if (wait == 0) {
                            points -= 10;
                        }
                    }
            }
        }
        g.drawImage(perm1, 572, 293, this);
        g.drawImage(perm2, 658, 293, this);
        g.drawImage(perm3, 746, 293, this);

        //Drawing stuff ----------------------------------------------------------------------------------------------------------------------------------------------------

        //main one
        g.fillPolygon(new int[]{75, 425,425, 75}, new int[]{75, 75, 575, 575}, 4);
//        scoresheet
        TextBox scoresheetbox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405,405, 95}, new int[]{100, 100, 170, 170}, "Press for score sheet :)", g);
        scoresheetbox.draw();
//        Points
        TextBox pointsbox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405,405, 95}, new int[]{200, 200, 270, 270}, "Points:"+points, g);
        pointsbox.draw();
//        UpgradesSlotsPanel
        TextBox upgradebox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405,405, 95}, new int[]{300, 300, 370, 370}, "Press for upgrades", g);
        upgradebox.draw();
//        auto timer
        TextBox autoTimer = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405, 405, 95}, new int[]{400, 400, 470, 470}, "Auto Timer:" + auto, g);
        if (UpgradePanel.autoo) {
            autoTimer.draw();
        }


//Clicking info buttons----------------------------------------------------------------------------------------------------------------------------------------------------

        if (MyMouseListener.clicked) {
            if(scoresheetbox.slotsClicked()) {
                Main.scoreFrame.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/7, 130, 900, 525);
                ScorePanel scorepanel = new ScorePanel();
                Main.scoreFrame.add(scorepanel);
                Main.scoreFrame.setVisible(true);
            }
            if(upgradebox.slotsClicked()){
                Main.upgradeFrame.setBounds(UpgradePanel.xframe, UpgradePanel.yframe, 900, 525);
                UpgradePanel upgradePanel = new UpgradePanel();
                Main.upgradeFrame.add(upgradePanel);
                Main.upgradeFrame.setVisible(true);
            }
            MyMouseListener.clicked = false;
        }

// Trywait (end)----------------------------------------------------------------------------------------------------------------------------------------------------



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




