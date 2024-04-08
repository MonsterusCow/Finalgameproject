import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class TextBox {

    Color bc, tc;
    int[] x, y;
    int x1, y1;
    String text;
    Graphics g;
    int length;
    int center;
    BufferedImage image;
    String direct;

    public TextBox(Color bc, Color tc, int[] x, int[] y, String text, Graphics g){
        this.bc = bc;
        this.tc = tc;
        this.x = x;
        this.y = y;
        this.text = text;
        this.g = g;
        length = text.length()*10;
    }

    public TextBox(BufferedImage image, String direct, int x, int y, Graphics g){
        this.image = image;
        this.direct = direct;
        this.x1 = x;
        this.y1 = y;
        this.g = g;
    }

    public void draw(){
        g.setColor(bc);
        g.fillPolygon(x, y, 4);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(Color.black);
        center = ((x[1]-x[0])-length)/2;
        if(center < 0){
            center = 0;
        }
        g.drawString(text, x[0]+center, y[0]+((y[3]-y[0])/2));
    }

    public void drawImgBox(ImageObserver thi, int x, int y){
        try { image = ImageIO.read(new File(direct)); } catch (IOException e) { e.printStackTrace(); }
        image = SlotsPanel.resize(image, x, y);
        g.drawImage(image, x1, y1, thi);

    }

    public void erase(){
        x = new int[] {0,0,0,0};
        y = new int[] {0,0,0,0};
    }

    public boolean slotsClicked(){
        if (MyMouseListener.clickedx >= x[0] && MyMouseListener.clickedx <= x[1]){
            if (MyMouseListener.clickedy >= y[0]+30 && MyMouseListener.clickedy <= y[3]+30){
                return true;
            }
        }
        return false;
    }

    public boolean upgrClicked(){
        if (UpgradesMouseListener.clickedx >= x[0] && UpgradesMouseListener.clickedx <= x[1]){
            if (UpgradesMouseListener.clickedy >= y[0]+30 && UpgradesMouseListener.clickedy <= y[3]+30){
                return true;
            }
        }
        return false;
    }
}