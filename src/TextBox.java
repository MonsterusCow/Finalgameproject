import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

    public TextBox(Color bc, Color tc, int[] x, int[] y, String text, Graphics g){
        this.bc = bc;
        this.tc = tc;
        this.x = x;
        this.y = y;
        this.text = text;
        this.g = g;
        length = text.length()*10;
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
        g.drawString(text, x[0]+center, y[0] + 45);
    }

    public boolean clicked(){
        if (MyMouseListener.clickedx >= x[0] && MyMouseListener.clickedx <= x[1]){
            if (MyMouseListener.clickedy >= y[0] && MyMouseListener.clickedy <= y[3]){
                return true;
            }
        }
        return false;
    }
}