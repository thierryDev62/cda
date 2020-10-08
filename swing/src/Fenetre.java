import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    public Fenetre() {
        this.setTitle("Ma belle fenêtre"); // Titre de la fenêtre
        this.setSize(640, 480); // Taille de la fenêtre
        this.setLocationRelativeTo(null); // La centre au milieu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenêtre quand on clique sur la croix
        this.setVisible(true); // Affiche la fenêtre

        /* Fond orange
        JPanel pan = new JPanel();
        pan.setBackground(Color.ORANGE);
        this.setContentPane(pan);
        */
         /* Affiche un cercle
        this.setContentPane(new Cercle());
          */
    }
}
