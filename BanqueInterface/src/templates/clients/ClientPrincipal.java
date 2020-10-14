package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClientPrincipal extends JPanel {
    //private JMenuBar menuBar = new JMenuBar();
    private JMenuItem creerUnCompte = new JMenuItem("Création d'un compte bancaire");

    public ClientPrincipal() {
        this.add(panelEspaceClient());
        this.add(afficheMenuBar());
    }
    private JPanel panelEspaceClient() {
        JPanel espaceClient = new JPanel();

        return espaceClient;
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
