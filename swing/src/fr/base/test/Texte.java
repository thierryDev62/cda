package fr.base.test;

import javax.swing.*;
import java.awt.*;

public class Texte extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Verdana", Font.BOLD, 14);
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString("Tiens ! Un petit texte sympa en gras, en couleur et avec une fonte différente", 10, 20);
    }
}
