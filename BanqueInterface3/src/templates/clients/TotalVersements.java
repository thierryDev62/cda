package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class TotalVersements extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public TotalVersements() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheTotalVersements());
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Total des versements");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheTotalVersements() {
        JPanel conteneurTotalVersements = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera le total des versements");

        conteneurTotalVersements.add(texte);
        conteneurTotalVersements.add(BOUTON_RETOUR_MENU);

        return conteneurTotalVersements;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
