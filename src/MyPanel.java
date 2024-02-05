import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.lang.*;

public class MyPanel extends JPanel {

    static int mxp;
    static int myp;
    //constuctor
    static ArrayList xs = new ArrayList(1);
    static ArrayList ys = new ArrayList(1);

    public MyPanel() {
        setBackground(new Color(29, 102, 16));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        while (MyMouseListener.isdown) {
            MyPanel.mxp = MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX();
            MyPanel.myp = MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY();
            MyPanel.xs.add(MyPanel.mxp);
            MyPanel.ys.add(MyPanel.myp);
            if (MyPanel.xs.size() > 200) {
                MyPanel.xs.remove(0);
                MyPanel.ys.remove(0);
            }

//            for (int i = 0; i < xs.size(); i++) {
//                g.drawString("🥹", (int) (xs.get(i)), (int) (ys.get(i)));
//            }

            if (Main.frame.getX() != 0 || Main.frame.getY() != 0) {
                Main.frame.setBounds(0, 0, 600, 600);
            }

            try {
                Thread.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }


            repaint();
//        }
    }
}

