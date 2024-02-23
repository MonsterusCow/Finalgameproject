import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyKeyListener extends KeyAdapter implements KeyListener {
    static boolean keydown1 = false;
    static boolean keydown2 = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keydown1 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keydown2 = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keydown1 = false;
        keydown2 = false;

    }
}

