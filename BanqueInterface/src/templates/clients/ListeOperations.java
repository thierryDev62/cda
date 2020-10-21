package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class ListeOperations extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public ListeOperations() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheListeOperations());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Liste de toutes les opérations");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheListeOperations() {
        JPanel contenuListeOperations = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera la liste des toutes les opérations effectuées");

        contenuListeOperations.add(texte);
        contenuListeOperations.add(BOUTON_RETOUR_MENU);

        return contenuListeOperations;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
