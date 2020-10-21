package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class Retraits extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public Retraits() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheRetraits());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Effectuer un retrait sur un compte");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheRetraits() {
        JPanel conteneurRetraits = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera les retraits");

        conteneurRetraits.add(texte);
        conteneurRetraits.add(BOUTON_RETOUR_MENU);

        return conteneurRetraits;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
