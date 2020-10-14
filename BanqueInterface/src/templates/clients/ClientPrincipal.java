package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class ClientPrincipal extends JPanel {
    private JMenuItem creerUnCompte = new JMenuItem("Création d'un compte bancaire");

    public ClientPrincipal() {
        this.add(afficheTitreEtMenuBar());
    }
    private JPanel afficheTitreEtMenuBar() {
        JPanel espaceClient = new JPanel();
        espaceClient.setLayout(new BorderLayout());
        espaceClient.add(titreEspaceClient(), BorderLayout.NORTH);
        espaceClient.add(afficheMenuBar(), BorderLayout.CENTER);
        return espaceClient;
    }

    private JPanel titreEspaceClient() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Espace client");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }
    public JMenuBar afficheMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        // Menu "Mon compte"
        JMenu monCompte = new JMenu("Mon compte");

        creerUnCompte.setIcon(new ImageIcon("icones/bank.png"));
        monCompte.add(creerUnCompte);

        // Ajoute "Mon compte" à la barre de menu
        menuBar.add(monCompte);

        return menuBar;
    }

    public JMenuItem getCreerUnCompte() {
        return creerUnCompte;
    }
}
