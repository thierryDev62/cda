package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class Virements extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public Virements() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheVirements());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Effectuer un virement de compte à compte");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheVirements() {
        JPanel conteneurVirements = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera les virements");

        conteneurVirements.add(texte);
        conteneurVirements.add(BOUTON_RETOUR_MENU);

        return conteneurVirements;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
