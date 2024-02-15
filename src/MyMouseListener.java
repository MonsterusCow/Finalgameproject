import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    int count = 0;
    static boolean isdown = false;
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        isdown = true;
        count++;
//        System.out.println("clicked " + count + isdown);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        isdown = false;
//        System.out.println("released " + count + isdown);
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
