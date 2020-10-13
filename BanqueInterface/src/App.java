import templates.PagePrincipale;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class App extends JFrame {
    private final CardLayout cl = new CardLayout();
    private final JPanel content = new JPanel();

    // Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = { "PAGE_PRINCIPALE" };

    public App() throws IOException {
        super("Banque Diplo");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        // Page principale
        PagePrincipale pagePrincipale = new PagePrincipale();

        // On définit le layout
        content.setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(pagePrincipale, listContent[0]);

        this.getContentPane().add(content, BorderLayout.CENTER);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        App myWindow = new App();
        myWindow.setVisible(true);
    }
}