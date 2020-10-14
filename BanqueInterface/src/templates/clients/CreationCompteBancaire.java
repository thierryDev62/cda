package templates.clients;

import templates.principal.Init;

import javax.swing.*;

public class CreationCompteBancaire extends JPanel {

    public CreationCompteBancaire() {
        this.add(afficheTitre());

    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Création d'un compte bancaire");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

}
