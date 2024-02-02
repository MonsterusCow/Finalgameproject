import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.lang.*;

public class MyPanel extends JPanel {

    static int mxp;
    static int myp;
    //constuctor


    public MyPanel() {
        setBackground(new Color(29, 102, 16));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);



//        g.setColor(Color.CYAN);

        mxp = MouseInfo.getPointerInfo().getLocation().x;
        myp = MouseInfo.getPointerInfo().getLocation().y;
//        System.out.println("x: "+mxp+", y: "+myp);

        g.drawString("🥹", mxp, myp);


        try {
            Thread.sleep(2);
        } catch (Exception e) {
            System.out.println(e);
        }


        repaint();
    }
}

