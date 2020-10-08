import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    public Fenetre() {
        this.setTitle("Ma belle fenêtre"); // Titre de la fenêtre
        this.setSize(640, 480); // Taille de la fenêtre
        this.setLocationRelativeTo(null); // La positionne au milieu de l'écran
        this.setVisible(true); // La rend visible

        // Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        pan.setBackground(Color.ORANGE); // Un fond orange

        this.setContentPane(pan);
    }
}
