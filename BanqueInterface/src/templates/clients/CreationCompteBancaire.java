package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class CreationCompteBancaire extends JPanel {

    public CreationCompteBancaire() {
        this.add(afficheTitreEtMenuBar());

    }

    private JPanel afficheTitreEtMenuBar() {
        JPanel espaceClient = new JPanel();
        espaceClient.setLayout(new BorderLayout());
        espaceClient.add(titreCreationCompteBancaire(), BorderLayout.NORTH);
        espaceClient.add(afficheMenuBar(), BorderLayout.CENTER);
        return espaceClient;
    }

    private JPanel titreCreationCompteBancaire() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Création d'un compte bancaire");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }
    private JPanel afficheMenuBar() {
        JPanel conteneurMenuBar = new JPanel();
        ClientPrincipal test = new ClientPrincipal();
        conteneurMenuBar.add(test.afficheMenuBar(), BorderLayout.SOUTH);
        return conteneurMenuBar;
    }

}
