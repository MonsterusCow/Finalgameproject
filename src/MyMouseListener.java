import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    static int clickedx, clickedy;
    static boolean clicked;
    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("x:" + (MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX()) + " y:" + (MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY()));
//        clickedx = MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX();
//        clickedy = MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        clickedx = MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX();
        clickedy = MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY();
        clicked = true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}








//public class MyMouseListener implements MouseListener {
//    int count = 0;
//    static boolean clicked = false;
//    static boolean isdown = false;
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        clicked = true;
//    }
//    @Override
//    public void mousePressed(MouseEvent e) {
//        isdown = true;
//        count++;
//    }
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        isdown = false;
//        MyPanel.wait = 1;
//    }
//    @Override
//    public void mouseEntered(MouseEvent e) {}
//    @Override
//    public void mouseExited(MouseEvent e) {}
//}
