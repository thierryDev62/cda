package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPrincipal extends JPanel {
    private JMenuItem creerUnCompte = new JMenuItem("Création d'un compte bancaire");
    private JMenuItem deconnexion = new JMenuItem("Déconnexion");

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
        monCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        monCompte.addSeparator();

        deconnexion.setIcon(new ImageIcon("icones/exit.png"));
        monCompte.add(deconnexion);

        // Ajoute "Mon compte" à la barre de menu
        menuBar.add(monCompte);

        return menuBar;
    }

    public JMenuItem getCreerUnCompte() {
        return creerUnCompte;
    }

    public JMenuItem getDeconnexion() {
        return deconnexion;
    }
}
