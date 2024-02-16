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
    static boolean keydown = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keydown = true;

        }
        System.out.println("work");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keydown = false;
    }
}

