import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    int count = 0;
    static boolean clicked = false;
    static boolean isdown = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        isdown = true;
        count++;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        isdown = false;
        MyPanel.wait = 1;
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
