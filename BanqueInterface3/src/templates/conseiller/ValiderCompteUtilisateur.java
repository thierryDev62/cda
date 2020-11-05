package templates.conseiller;

import config.ConfigDatabase;
import templates.principal.App;
import templates.principal.Init;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValiderCompteUtilisateur extends JPanel {
    private static final JButton BOUTON_VALIDER = new JButton("Valider");
    private static final JButton BOUTON_ANNULER = new JButton("Annuler");

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
        BOUTON_VALIDER.addActionListener(e -> {
            String champsValidationText = champsValidation.getText();
            int champsValidationParse = 0;
            champsValidationParse = Integer.parseInt(champsValidationText);
            String queryNumeroCompteUtilisateur = "SELECT utl_id FROM public.t_utilisateur_utl WHERE utl_id = " + champsValidationParse;

            try {
                Statement state = ConfigDatabase.getInstance().createStatement();

                ResultSet result = state.executeQuery(queryNumeroCompteUtilisateur);

                while(result.next()) {
                    int idUtilisateur = result.getInt("utl_id");

                    if(idUtilisateur == champsValidationParse) {
                        System.out.println("ok trouvé le numéro d'identifiant !!!");
                        //state.close();
                        //result.close();
                        return;
                    }
                }
                System.out.println("pas trouvé");
                state.close();
                result.close();
            } catch (SQLException event) {
                event.printStackTrace();
            }
        });

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

    public static JButton getBOUTON_VALIDER() {
        return BOUTON_VALIDER;
    }

    public static JButton getBoutonAnnuler() {
        return BOUTON_ANNULER;
    }
}
