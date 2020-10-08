package fr.base.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Logo extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Image img = ImageIO.read(new File("logo_java.png"));
            g.drawImage(img, 0,0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
