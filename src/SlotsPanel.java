import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;

public class SlotsPanel extends JPanel implements ImageObserver {

    boolean up = true;
    boolean timer = false;
    int wait = 0;
    static int points = 1100;
    int[] lastrolled = new int[3];
    int auto = 0;
    static int timerWait = 30;

    BufferedImage slothandledn, slothandleup, slotmachineful, slotmachineemp;
    BufferedImage[] slots = new BufferedImage[4];
    BufferedImage Cherry, Lemon, Melon, Heart, Bell, Shoe, Diamond, Bar, Seven;
    int[] scores = new int[] {100,200,300,400,500,700,900,1000,2000};
    BufferedImage first, second, third;
    BufferedImage perm1, perm2, perm3;
    BufferedImage Casino;

//reset Method ------------------------------------------------------------------------------------------------------------

    public void reset() {
    up =true;
    timer =false;
    wait =0;
    points =500;
    lastrolled =new int[3];
    auto =0;
    timerWait =30;
    UpgradePanel.autoo = false;
    UpgradePanel.autoBought = false;
}

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
        boolean returned = false;
        for (int i = 0; i < 9; i++) {
            if (lastrolled[0] == i && lastrolled[1] == i && lastrolled[2] == i){
                points += scores[i];
                returned = true;
            }
        }
        if (!returned){
            for (int j= 0; j < 9; j++) {
                if ((lastrolled[0] == j && (lastrolled[0] == lastrolled[1] || lastrolled[0] == lastrolled[2])) || (lastrolled[1] == j && lastrolled[1] == lastrolled[2])) {
                    points += scores[j] / 2;
                }
            }
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

        if (SlotsMouseListener.clicked) {
            if (SlotsMouseListener.clickedx >= 887 && SlotsMouseListener.clickedx <= 930) {
                if (SlotsMouseListener.clickedy >= 237 && SlotsMouseListener.clickedy <= 402) {
                    up = false;
                    SlotsMouseListener.clickedx = 0;
                    SlotsMouseListener.clickedy = 0;
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
                            auto = timerWait;
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
//        exit X
        TextBox exit = new TextBox(UpgradePanel.Ximg, "Images/Upgrade Stuff/X.png", new int[] {5, 40, 40, 5}, new int[] {5, 5, 40, 40}, g);
        exit.drawImgBox(this);


//Clicking info buttons----------------------------------------------------------------------------------------------------------------------------------------------------

        if (SlotsMouseListener.clicked) {
            if(scoresheetbox.Clicked(SlotsMouseListener.clickedx, SlotsMouseListener.clickedy)) {
                Main.scorePanel.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/7, 130, 900, 525);
                ScorePanel scorepanel = new ScorePanel();
                Main.scorePanel.add(scorepanel);
                Main.scorePanel.setVisible(true);
            }
            if(upgradebox.Clicked(SlotsMouseListener.clickedx, SlotsMouseListener.clickedy)){
                Main.upgradePanel.setBounds(UpgradePanel.xframe, UpgradePanel.yframe, 900, 525);
                UpgradePanel upgradePanel = new UpgradePanel();
                Main.upgradePanel.add(upgradePanel);
                Main.upgradePanel.setVisible(true);
            }
            if (exit.Clicked(SlotsMouseListener.clickedx, SlotsMouseListener.clickedy)){
                Main.frame.dispose();
            }
            SlotsMouseListener.clicked = false;
        }

// If points = 0 (end)----------------------------------------------------------------------------------------------------------------------------------------------------

        if (points == 0){
            int response = JOptionPane.showConfirmDialog(null,"Womp Womp you lost everything and you are now homeless. Restart?", "You Lost", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == response) {
                reset();
            } else if (JOptionPane.NO_OPTION == response) {
//                Main.frame.dispatchEvent(new WindowEvent(Main.frame, Main.WindowEvent.WINDOW_CLOSING));
                Main.frame.dispose();
                Main.scorePanel.dispose();
                Main.upgradePanel.dispose();
            }
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




