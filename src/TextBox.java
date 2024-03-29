import java.awt.*;

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