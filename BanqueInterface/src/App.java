import templates.Auth;
import templates.EnTete;
import templates.PagePrincipale;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {
    private final CardLayout cl = new CardLayout();
    private final JPanel content = new JPanel();

    // Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = { "PAGE_PRINCIPALE", "AUTH" };

    public App() throws IOException {
        super("Banque Diplo");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        // En-tête
        EnTete entete = new EnTete();

        // Authentification
        Auth auth = new Auth();

        // Page principale
        PagePrincipale pagePrincipale = new PagePrincipale();
        pagePrincipale.getAUTHENTIFICATION().addActionListener(this::goAuthentification);

        // On définit le layout
        content.setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(pagePrincipale, listContent[0]);
        content.add(auth, listContent[1]);

        this.getContentPane().add(entete, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);
    }

    // Envoi sur le panel de l'authentification
    private void goAuthentification(ActionEvent e) {
        cl.show(content, listContent[1]);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        App myWindow = new App();
        myWindow.setVisible(true);
    }
}