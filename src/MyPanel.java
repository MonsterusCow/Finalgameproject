import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

public class MyPanel extends JPanel implements ImageObserver{

    static double size = 50.0;
    BufferedImage arrow;
    static double arrowDirection;

    static ArrayList<Block> blocks = new ArrayList<>(1);
    static ArrayList<Double> accel = new ArrayList<>(1);

    public MyPanel() {
        setBackground(new Color(29, 102, 16));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //when click--------------------------------------------------------------------------

        if (MyMouseListener.isdown) {
            MyMouseListener.isdown = false;
            blocks.add(new Block());
            accel.add(.2);
        } // end of while down

        //Deletion--------------------------------------------------------------------------

        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).y[0] >= Main.frame.getHeight() + 100) {
                blocks.remove(i);
                System.out.println("removed");
            } else {
                if (blocks.get(i).y[1] >= Main.frame.getHeight() + 100) {
                    blocks.remove(i);
                    System.out.println("removed");
                    break;
                } else {
                    if (blocks.get(i).y[2] >= Main.frame.getHeight() + 100) {
                        blocks.remove(i);
                        System.out.println("removed");
                        break;
                    } else {
                        if (blocks.get(i).y[3] >= Main.frame.getHeight() + 100) {
                            blocks.remove(i);
                            System.out.println("removed");
                            break;
                        }
                    }
                }
            }
        }

        //Drawing--------------------------------------------------------------------------

        for (int i = 0; i < blocks.size(); i++) {
            g.setColor(Color.BLACK);
            g.fillPolygon(blocks.get(i).getXArray(), blocks.get(i).getYArray(), 4);
        }

        //Putting frame back--------------------------------------------------------------------------

//            if (Main.frame.getX() != 0 || Main.frame.getY() != 0) {
//                Main.frame.setBounds(Main.startcordx, Main.startcordy, 600, 600);
//            }

        //gravity--------------------------------------------------------------------------

        for (int i = 0; i<blocks.size(); i++){
            blocks.get(i).gravity();
        }

        //arrow--------------------------------------------------------------------------

        try {
            arrow = ImageIO.read(new File("Images/arrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(arrow, (MouseInfo.getPointerInfo().getLocation().x - Main.frame.getX()) - arrow.getWidth() / 2, (MouseInfo.getPointerInfo().getLocation().y - Main.frame.getY()) - (arrow.getHeight() / 2 + 20), this);

        //keypresses--------------------------------------------------------------------------

        if (MyKeyListener.keydown) {
            MyKeyListener.keydown = false;
            for (int i = 0; i<blocks.size(); i++) {
                if (blocks.get(i).getDown() <= -1) {
                    blocks.get(i).setA(0);
                }
                if (blocks.get(i).getDown() >= 1) {
                    blocks.get(i).setA(1);
                }
                if (blocks.get(i).getA() == 1) {
                    blocks.get(i).setDown(-1);
                } else {
                    blocks.get(i).setDown(1);
                }

                if (blocks.get(i).getLeft() <= -1) {
                    blocks.get(i).setB(0);
                }
                if (blocks.get(i).getLeft() >= 1) {
                    blocks.get(i).setB(1);
                }
                if (blocks.get(i).getB() == 1) {
                    blocks.get(i).setLeft(-1);
                } else {
                    blocks.get(i).setLeft(1);
                }
            }
        }

        //Trywait (end)--------------------------------------------------------------------------

        try {
            Thread.sleep(3);
        } catch (Exception e) {
            System.out.println(e);
        }

       //repaint--------------------------------------------------------------------------
        repaint();
    }
}

