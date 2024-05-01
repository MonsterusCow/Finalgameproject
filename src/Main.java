import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Main {
    static JFrame startFrame = new JFrame();
    static JFrame slotsFrame = new JFrame();
    static JFrame scoreFrame = new JFrame();
    static JFrame upgradeFrame = new JFrame();
    static JFrame rouletteFrame = new JFrame();
    static int startcordx = Toolkit.getDefaultToolkit().getScreenSize().width/7;
    static int startcordy = 50;
    public static void main(String[] args) {

//Main Frame ----------------------------------------------------------------------------------------------------
//        frame.setResizable(false);

        StartMouseListener start = new StartMouseListener();
        SlotsMouseListener slots = new SlotsMouseListener();
        ScoresMouseListener score = new ScoresMouseListener();
        UpgradesMouseListener upg = new UpgradesMouseListener();
        RouletteMouseListener rou = new RouletteMouseListener();

        startFrame.addMouseListener(start);
        slotsFrame.addMouseListener(slots);
        scoreFrame.addMouseListener(score);
        upgradeFrame.addMouseListener(upg);
        rouletteFrame.addMouseListener(rou);

        startFrame.setBounds(startcordx, startcordy, 1000, 750);
        StartPanel panel = new StartPanel();
        panel.setFocusable(true);
        panel.addMouseListener(start);
        startFrame.add(panel);
        startFrame.setVisible(true);
//
//        slotsFrame.setBounds(startcordx, startcordy, 1000, 750);
//        SlotsPanel panel = new SlotsPanel();
//        panel.setFocusable(true);
//        panel.addMouseListener(slots);
//        slotsFrame.add(panel);
//        slotsFrame.setVisible(true);



//Starting Frame ----------------------------------------------------------------------------------------------------
        
        JOptionPane.showMessageDialog(null, "Hi, welcome to gambling. You can press the lever to start spinning.\nPress the point list to see the spins you can get");




    }

    static public int getFromLeftSide(JFrame frame, int number){
        return (frame.getWidth())-((frame.getWidth())-number);
    }
    static public int getFromRighSide(JFrame frame, int number){
        return frame.getWidth()-number;
    }
    static public  int getFromTopSide(JFrame frame, int number){
        return (frame.getHeight())-((frame.getHeight())-number);
    }
    static public int getFromBottomSide(JFrame frame, int number){
        return frame.getHeight()-number;
    }

    static public void exitAll() {
        startFrame.dispose();
        rouletteFrame.dispose();
            slotsFrame.dispose();
            scoreFrame.dispose();
            upgradeFrame.dispose();
    }
}
