import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;


public class Main {
    static JFrame frame = new JFrame();
    static int startcordx = 0;
    static int startcordy = 0;
    public static void main(String[] args) {


        frame.setBounds(startcordx, startcordy, 1500, 1000);
        frame.setResizable(true);
        MyPanel panel = new MyPanel();
        MyMouseListener listen = new MyMouseListener();
        MyKeyListener keylisten = new MyKeyListener();

        panel.setFocusable(true);
        panel.addMouseListener(listen);
        panel.addKeyListener(keylisten);

        frame.add(panel);

        frame.setVisible(true);



    }
}
