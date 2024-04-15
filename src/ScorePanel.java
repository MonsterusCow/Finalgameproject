import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class ScorePanel extends JPanel implements ImageObserver {


    public ScorePanel() {
        setBackground(new Color(55, 208, 30));
    }

    BufferedImage sheet;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Words----------------------------------------------------------------------------------------------------------------------------------------------------
        try { sheet = ImageIO.read(new File("Images/Roll Parts/ScoreSheet.png")); } catch (IOException e) { e.printStackTrace(); }
        sheet = SlotsPanel.resize(sheet, 900, 500);
        g.drawImage(sheet, 0, 0, this);
        TextBox exit = new TextBox(UpgradePanel.Ximg, "Images/Upgrade Stuff/X.png", new int[] {5, 40, 40, 5}, new int[] {5, 5, 40, 40}, g);
        exit.drawImgBox(this);
        //Trywait (end)----------------------------------------------------------------------------------------------------------------------------------------------------

        if (exit.Clicked(ScoresMouseListener.clickedx, ScoresMouseListener.clickedy)){
            Main.scorePanel.dispose();
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


