import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class TextBox {

    Color bc, tc;
    int[] x, y;
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

    public TextBox(int[] x, int[] y, Graphics g){
        this.x = x;
        this.y = y;
        this.g = g;
    }

    public TextBox(BufferedImage image, String direct, int[] x, int[] y, Graphics g){
        this.image = image;
        this.direct = direct;
        this.x = x;
        this.y = y;
        this.g = g;
    }

    public void draw(int size){
        g.setColor(bc);
        g.fillPolygon(x, y, 4);
        g.setFont(new Font("Arial", Font.PLAIN, size));
        g.setColor(Color.black);
        center = (((x[1]-x[0])-length)/2)/((int)((size/20.0)*1.5));
        if(center < 0){
            center = 0;
        }
        g.drawString(text, x[0]+center, y[0]+((y[3]-y[0])/2));
    }

    public void drawImgBox(ImageObserver thi){
        try { image = ImageIO.read(new File(direct)); } catch (IOException e) { e.printStackTrace(); }
        image = SlotsPanel.resize(image, (this.x[1]-this.x[0]), (this.y[2]-this.y[0]));
        g.drawImage(image, this.x[0], this.y[0], thi);
    }

    public void drawClickBox(){
        g.drawPolygon(x, y, 4);
    }

    public void erase(){
        x = new int[] {0,0,0,0};
        y = new int[] {0,0,0,0};
    }

    public boolean Clicked(int x, int y){
        if (x >= this.x[0] && x <= this.x[1]){
            if (y >= this.y[0]+30 && y <= this.y[3]+30){
                return true;
            }
        }
        return false;
    }

    public int getxTLBL(){
        return x[0];
    }
    public int getxTRBR(){
        return x[1];
    }
    public int getyT(){
        return y[0];
    }
    public int getyB(){
        return y[2];
    }


}