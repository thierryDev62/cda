package templates.conseiller;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class ListeClients extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public ListeClients() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheListeClients());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Liste des clients de la banque");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheListeClients() {
        JPanel conteneurListeClients = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera la liste de tous les clients de la banque");

        conteneurListeClients.add(texte);
        conteneurListeClients.add(BOUTON_RETOUR_MENU);

        return conteneurListeClients;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
