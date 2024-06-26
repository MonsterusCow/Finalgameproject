import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.*;

public class StartPanel extends JPanel implements ImageObserver {

    BufferedImage Casino;

    public StartPanel() {
        setBackground(new Color(55, 208, 30));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Words----------------------------------------------------------------------------------------------------------------------------------------------------

        try {
            Casino = ImageIO.read(new File("Images/Casino.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage( Casino, 0, 0, this);
        TextBox hi = new TextBox(new Color(17, 48, 182), Color.black, new int[]{Main.getFromLeftSide(Main.startFrame, 100), Main.getFromRighSide(Main.startFrame, 100),Main.getFromRighSide(Main.startFrame, 100), Main.getFromLeftSide(Main.startFrame, 100)}, new int[]{Main.getFromTopSide(Main.startFrame, 100), Main.getFromTopSide(Main.startFrame, 100), Main.getFromTopSide(Main.startFrame, 200), Main.getFromTopSide(Main.startFrame, 200)}, "Welcome to gambling, choose a game :)", g);
        hi.draw(40);
        TextBox slots = new TextBox(new Color(17, 48, 182), Color.black, new int[]{Main.getFromLeftSide(Main.startFrame, 300), Main.getFromRighSide(Main.startFrame, 300),Main.getFromRighSide(Main.startFrame, 300), Main.getFromLeftSide(Main.startFrame, 300)}, new int[]{Main.getFromTopSide(Main.startFrame, 250), Main.getFromTopSide(Main.startFrame, 250), Main.getFromTopSide(Main.startFrame, 350), Main.getFromTopSide(Main.startFrame, 350)}, "Play slots", g);
        slots.draw(20);
        TextBox rout = new TextBox(new Color(17, 48, 182), Color.black, new int[]{Main.getFromLeftSide(Main.startFrame, 300), Main.getFromRighSide(Main.startFrame, 300),Main.getFromRighSide(Main.startFrame, 300), Main.getFromLeftSide(Main.startFrame, 300)}, new int[]{Main.getFromTopSide(Main.startFrame, 400), Main.getFromTopSide(Main.startFrame, 400), Main.getFromTopSide(Main.startFrame, 500), Main.getFromTopSide(Main.startFrame, 500)}, "Play Roulette", g);
        rout.draw(20);
        TextBox exit = new TextBox(UpgradePanel.Ximg, "Images/Upgrade Stuff/X.png", new int[] {5, 40, 40, 5}, new int[] {5, 5, 40, 40}, g);
        exit.drawImgBox(this);

        //Trywait (end)----------------------------------------------------------------------------------------------------------------------------------------------------


        if (StartMouseListener.clicked) {
            if (slots.Clicked(StartMouseListener.clickedx,StartMouseListener.clickedy)){
                Main.slotsFrame.setBounds(Main.slotsFrame.getX(), Main.slotsFrame.getY(), 1000, 750);
                Main.slotsFrame.add(new SlotsPanel());
                if (Main.slotsFrame != null) {
                    Main.slotsFrame.dispose();
                }
                Main.slotsFrame.setVisible(true);
            }
            if (rout.Clicked(StartMouseListener.clickedx,StartMouseListener.clickedy)){
                Main.rouletteFrame.setBounds(Main.rouletteFrame.getX(), Main.rouletteFrame.getY(), 1000, 750);
                Main.rouletteFrame.add(new RoulettePanel());
                if (Main.rouletteFrame != null) {
                    Main.rouletteFrame.dispose();
                }
                Main.rouletteFrame.setVisible(true);
            }
            if (exit.Clicked(StartMouseListener.clickedx, StartMouseListener.clickedy)){
                Main.exitAll();

            }
            StartMouseListener.clicked = false;
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


