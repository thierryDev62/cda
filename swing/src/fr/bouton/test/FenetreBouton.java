package fr.bouton.test;

import javax.swing.*;

public class FenetreBouton extends JFrame {
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Mon bouton");

    public FenetreBouton() {
        this.setTitle("Les boutons");
        this.setSize(640,480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Ajout du bouton à notre content pane
        pan.add(bouton);
        this.setContentPane(pan);
        this.setVisible(true);
    }
}
