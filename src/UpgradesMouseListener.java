import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpgradesMouseListener implements MouseListener {
    static int clickedx, clickedy;
    static boolean clicked;
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x:" + (MouseInfo.getPointerInfo().getLocation().x - Main.upgradePanel.getX()) + " y:" + (MouseInfo.getPointerInfo().getLocation().y - (Main.upgradePanel.getY()+30)));
    }
    @Override
    public void mousePressed(MouseEvent e) {
        clickedx = MouseInfo.getPointerInfo().getLocation().x - Main.upgradePanel.getX();
        clickedy = MouseInfo.getPointerInfo().getLocation().y - Main.upgradePanel.getY();
        clicked = true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}



