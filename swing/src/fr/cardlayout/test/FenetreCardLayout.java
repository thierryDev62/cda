package fr.cardlayout.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreCardLayout extends JFrame {

    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();

    // Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
    int indice = 0;

    public FenetreCardLayout() {
        this.setTitle("CardLayout");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // On crée trois conteneurs de couleur différentes
        JPanel card1 = new JPanel();
        card1.setBackground(Color.BLUE);
        JPanel card2 = new JPanel();
        card2.setBackground(Color.RED);
        JPanel card3 = new JPanel();
        card3.setBackground(Color.ORANGE);

        JPanel boutonPane = new JPanel();
        JButton bouton = new JButton("Contenu suivant");
        // Définition de l'action du bouton
        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Via cette instruction, on passe au prochain conteneur de la pile
                cl.next(content);
            }
        });

        JButton bouton2 = new JButton("Contenu par indice");
        // Définition de l'action du bouton 2
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(++indice > 2)
                    indice = 0;

                // Via cette instruction, on passera au conteneur correspondant au nom fourni en paramètre
                cl.show(content, listContent[indice]);
            }
        });

        boutonPane.add(bouton);
        boutonPane.add(bouton2);
        // On définit le layout
        content.setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);
        content.add(card3, listContent[2]);

        this.getContentPane().add(boutonPane, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setVisible(true);

    }
}
