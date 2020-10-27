package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class Versements extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public Versements() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheVersements());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Effectuer un versement sur un compte");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheVersements() {
        JPanel conteneurVersements = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera les versements");

        conteneurVersements.add(texte);
        conteneurVersements.add(BOUTON_RETOUR_MENU);

        return conteneurVersements;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
