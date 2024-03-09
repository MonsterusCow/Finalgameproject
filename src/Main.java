import javax.swing.*;
import java.awt.*;


public class Main {
    static JFrame frame = new JFrame();
    static JFrame startframe = new JFrame();
    static int startcordx = Toolkit.getDefaultToolkit().getScreenSize().width/7;
    static int startcordy = 50;
    public static void main(String[] args) {

//Main Frame ----------------------------------------------------------------------------------------------------
        frame.setBounds(startcordx, startcordy, 1350, 800);
        frame.setResizable(false);
        SlotsPanel panel = new SlotsPanel();
        MyMouseListener listen = new MyMouseListener();
        MyKeyListener keylisten = new MyKeyListener();

        panel.setFocusable(true);
        panel.addMouseListener(listen);
        panel.addKeyListener(keylisten);

        frame.add(panel);

        frame.setVisible(true);

//Starting Frame ----------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Hi, welcome to gambling. You can press the lever to start spinning.\nPress the point list to see the spins you can get");




    }
}
