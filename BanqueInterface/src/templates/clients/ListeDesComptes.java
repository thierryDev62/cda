package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class ListeDesComptes extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public ListeDesComptes() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheListeDesComptes());
    }
    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Liste des comptes");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheListeDesComptes() {
        JPanel conteneurListe = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera la liste des comptes");

        conteneurListe.add(texte);
        conteneurListe.add(BOUTON_RETOUR_MENU);

        return conteneurListe;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
