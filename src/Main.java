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


        frame.setBounds(startcordx, startcordy, 600, 500);
        frame.setResizable(false);
        MyPanel panel = new MyPanel();
        MyMouseListener listen = new MyMouseListener();

        panel.addMouseListener(listen);
        frame.add(panel);

        frame.setVisible(true);



    }
}
