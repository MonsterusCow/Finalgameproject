import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;


public class Main {
    static JFrame frame = new JFrame();
    public static void main(String[] args) {

        frame.setBounds(0, 0, 600, 600);
        frame.setResizable(false);
        MyPanel panel = new MyPanel();
        MyMouseListener listen = new MyMouseListener();

        panel.addMouseListener(listen);
        frame.add(panel);

        frame.setVisible(true);



    }
}
