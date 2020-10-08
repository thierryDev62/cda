package fr.borderlayout.test;

import javax.swing.*;
import java.awt.*;

public class FenetreBorderLayout extends JFrame {
    public FenetreBorderLayout() {
        this.setTitle("BorderLayout");
        this.setSize(640,480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());

        // Ajout le bouton au content pane de la JFrame
        // Au centre
        this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
        // Au nord
        this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
        // Au sud
        this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
        // A l'ouest
        this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
        // A l'est
        this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
        this.setVisible(true);
    }
}
