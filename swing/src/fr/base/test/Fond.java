package fr.base.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fond extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Image img = ImageIO.read(new File("fond2.jpg"));
            g.drawImage(img,0,0,this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
