package fr.base.test;

import javax.swing.*;
import java.awt.*;

public class Cercle extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(20,20,50,50);
    }
}
