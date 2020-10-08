package fr.base.test;

import javax.swing.*;

public class FenetreBase extends JFrame {
    public FenetreBase() {
        this.setTitle("Ma belle fenêtre"); // Titre de la fenêtre
        this.setSize(640, 480); // Taille de la fenêtre
        this.setLocationRelativeTo(null); // La centre au milieu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenêtre quand on clique sur la croix
        this.setVisible(true); // Affiche la fenêtre

        /* Affiche un cercle
        this.setContentPane(new fr.base.test.Cercle());
*/
        /* Affiche du texte
        this.setContentPane(new fr.base.test.Texte());
        */
        /* Affiche un logo */
        //this.setContentPane(new fr.base.test.Logo());
        /* Affiche une image de fond
        this.setContentPane(new Fond());
         */
    }
}
