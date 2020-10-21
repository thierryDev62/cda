package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class TotalRetraits extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public TotalRetraits() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheTotalRetraits());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Total des retraits");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheTotalRetraits() {
        JPanel conteneurTotalRetrait = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera le total des retraits");

        conteneurTotalRetrait.add(texte);
        conteneurTotalRetrait.add(BOUTON_RETOUR_MENU);

        return conteneurTotalRetrait;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
