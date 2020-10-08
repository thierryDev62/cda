package fr.gridlayout.test;

import javax.swing.*;
import java.awt.*;

public class FenetreGridLayout extends JFrame {
    public FenetreGridLayout() {
        this.setTitle("GridLayout");
        this.setSize(640,480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // On définit le layout à utiliser sur le content pane
        // Trois lignes sur deux colonnes

        /* Première façon d'initialiser la gridLayout
        this.setLayout(new GridLayout(3,2));
         */

        /* Deuxième façon d'initialiser la gridlayout avec en plus des espaces entre les colonnes et les lignes */
        GridLayout gl = new GridLayout();
        gl.setColumns(2); // Deux colonnes
        gl.setRows(3); // 3 lignes
        gl.setHgap(5); // Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        gl.setVgap(5); // Cinq pixels d'espace entre les lignes (V comme Vertical)
        this.setLayout(gl);

        // On ajoute le bouton dans le content pane de la JFrame
        this.getContentPane().add(new JButton("1"));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));

        this.setVisible(true);
    }
}
