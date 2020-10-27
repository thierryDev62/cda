package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class Informations extends JPanel{
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public Informations() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre(), BorderLayout.NORTH);
        this.add(afficheInformations(), BorderLayout.CENTER);
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Informations");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheInformations() {
        JPanel conteneurInformations = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera les informations");

        conteneurInformations.add(texte);
        conteneurInformations.add(BOUTON_RETOUR_MENU);

        return conteneurInformations;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}