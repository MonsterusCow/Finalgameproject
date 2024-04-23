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
        try {Cherry = ImageIO.read(new File("Images/Roll parts/Cherry.png"));} catch (IOException e) {e.printStackTrace();}
        try {Lemon = ImageIO.read(new File("Images/Roll parts/Lemon.png"));} catch (IOException e) {e.printStackTrace();}
        try {Melon = ImageIO.read(new File("Images/Roll parts/Melon.png"));} catch (IOException e) {e.printStackTrace();}
        try {Heart = ImageIO.read(new File("Images/Roll parts/Heart.png"));} catch (IOException e) {e.printStackTrace();}
        try {Bell = ImageIO.read(new File("Images/Roll parts/Bell.png"));} catch (IOException e) {e.printStackTrace();}
        try {Shoe = ImageIO.read(new File("Images/Roll parts/Shoe.png"));} catch (IOException e) {e.printStackTrace();}
        try {Diamond = ImageIO.read(new File("Images/Roll parts/Diamond.png"));} catch (IOException e) {e.printStackTrace();}
        try {Bar = ImageIO.read(new File("Images/Roll parts/Bar.png"));} catch (IOException e) {e.printStackTrace();}
        try {Seven = ImageIO.read(new File("Images/Roll parts/Seven.png"));} catch (IOException e) {e.printStackTrace();}
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
            if (!UpgradePanel.autoo) {
                if (SlotsMouseListener.clickedx >= 887 && SlotsMouseListener.clickedx <= 930) {
                    if (SlotsMouseListener.clickedy >= 237 && SlotsMouseListener.clickedy <= 402) {
                        up = false;
                        SlotsMouseListener.clickedx = 0;
                        SlotsMouseListener.clickedy = 0;
                        timer = true;
                        if (wait == 0) {
                            points -= 10;
                        }
                    }
                }
            }
        }

        //Timer to spin and put handle up ----------------------------------------------------------------------------------------------------------------------------------------------------
        if (timer || UpgradePanel.autoo){
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
        scoresheetbox.draw(20);
//        Points
        TextBox pointsbox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405,405, 95}, new int[]{200, 200, 270, 270}, "Points:"+points, g);
        pointsbox.draw(20);
//        UpgradesSlotsPanel
        TextBox upgradebox = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405,405, 95}, new int[]{300, 300, 370, 370}, "Press for upgrades", g);
        upgradebox.draw(20);
//        auto timer
        TextBox autoTimer = new TextBox(new Color(17, 48, 182), Color.black, new int[]{95, 405, 405, 95}, new int[]{400, 400, 470, 470}, "Auto Timer:" + auto, g);
        if (UpgradePanel.autoo) {
            autoTimer.draw(20);
        }
//        exit X
        TextBox exit = new TextBox(UpgradePanel.Ximg, "Images/Upgrade Stuff/X.png", new int[] {5, 40, 40, 5}, new int[] {5, 5, 40, 40}, g);
        exit.drawImgBox(this);


//Clicking info buttons----------------------------------------------------------------------------------------------------------------------------------------------------

        if (SlotsMouseListener.clicked) {
            if(scoresheetbox.Clicked(SlotsMouseListener.clickedx, SlotsMouseListener.clickedy)) {
                Main.scoreFrame.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/7, 130, 900, 525);
                ScorePanel scorepanel = new ScorePanel();
                Main.scoreFrame.add(scorepanel);
                Main.scoreFrame.setVisible(true);
            }
            if(upgradebox.Clicked(SlotsMouseListener.clickedx, SlotsMouseListener.clickedy)){
                Main.upgradeFrame.setBounds(UpgradePanel.xframe, UpgradePanel.yframe, 900, 525);
                UpgradePanel upgradeFrame = new UpgradePanel();
                Main.upgradeFrame.add(upgradeFrame);
                Main.upgradeFrame.setVisible(true);
            }
            if (exit.Clicked(SlotsMouseListener.clickedx, SlotsMouseListener.clickedy)){
                timer = false;

                Main.slotsFrame.setVisible(false);
            }
            SlotsMouseListener.clicked = false;
        }

// If points = 0 (end)----------------------------------------------------------------------------------------------------------------------------------------------------

        if (points <= -10){
            int response = JOptionPane.showConfirmDialog(null,"Womp Womp you lost everything and you are now homeless. Restart?", "You Lost", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == response) {
                reset();
            } else if (JOptionPane.NO_OPTION == response) {
//                Main.slotsFrame.dispatchEvent(new WindowEvent(Main.slotsFrame, Main.WindowEvent.WINDOW_CLOSING));
                Main.slotsFrame.dispose();
                Main.scoreFrame.dispose();
                Main.upgradeFrame.dispose();
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
