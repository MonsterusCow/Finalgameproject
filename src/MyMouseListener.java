import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    static boolean isdown = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        isdown = true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        isdown = false;
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
