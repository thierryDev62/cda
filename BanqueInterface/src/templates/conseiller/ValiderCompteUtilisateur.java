package templates.conseiller;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class ValiderCompteUtilisateur extends JPanel {
    private final JButton BOUTON_VALIDER = new JButton("Valider");
    private final JButton BOUTON_ANNULER = new JButton("Annuler");

    public ValiderCompteUtilisateur() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre(), BorderLayout.NORTH);
        this.add(validationCompte(), BorderLayout.CENTER);
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Validation d'un compte utilisateur");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel validationCompte() {
        JPanel panelCreation = new JPanel();

        JLabel titreValidation = new JLabel("Numéro de compte utilisateur à valider : ");
        titreValidation.setFont(new Init().getDefaultFont());


        JTextField champsValidation = new JTextField();
        champsValidation.setFont(new Init().getDefaultFont());
        champsValidation.setPreferredSize(new Dimension(200, 30));

        // Bouton valider
        JPanel conteneurBoutonValider = new JPanel();
        BOUTON_VALIDER.setFont(new Init().getDefaultFont());
        conteneurBoutonValider.add(BOUTON_VALIDER);

        // Bouton annuler
        JPanel conteneurBoutonAnnuler = new JPanel();
        BOUTON_ANNULER.setFont(new Init().getDefaultFont());
        conteneurBoutonAnnuler.add(BOUTON_ANNULER);

        panelCreation.add(titreValidation);
        panelCreation.add(champsValidation);
        panelCreation.add(conteneurBoutonValider);
        panelCreation.add(conteneurBoutonAnnuler);

        return panelCreation;
    }

    public JButton getBOUTON_VALIDER() {
        return BOUTON_VALIDER;
    }

    public JButton getBOUTON_ANNULER() {
        return BOUTON_ANNULER;
    }
}
