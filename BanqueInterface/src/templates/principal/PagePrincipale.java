package templates.principal;

import javax.swing.*;
import java.awt.*;

public class PagePrincipale extends JPanel {

    private final JButton AUTHENTIFICATION = new JButton("S'authentifier");
    private final JButton BOUTON_CREER_COMPTE_UTIL = new JButton("Créer un compte utilisateur");

    public PagePrincipale() {
        this.setLayout(new GridLayout(2,1));
        this.add(titre());
        this.add(choix());
    }
    private JPanel titre() {
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("<html><u style=\"color:orange\">Page principale</u></html>");
        titre.setFont(new Init().getTitreFont());
        titrePanel.add(titre);
        return titrePanel;
    }

    private JPanel choix() {
        // En dessous
        JPanel contenuChoix = new JPanel();

        // Combobox de choix de client ou conseiller
        JComboBox choix = new JComboBox();
        choix.setFont(new Init().getDefaultFont());
        choix.addItem("Client");
        choix.addItem("Conseiller");

        // Bouton Créer un compte utilisateur
        AUTHENTIFICATION.setFont(new Init().getDefaultFont());
        BOUTON_CREER_COMPTE_UTIL.setFont(new Init().getDefaultFont());
        contenuChoix.add(choix);
        contenuChoix.add(AUTHENTIFICATION);
        contenuChoix.add(BOUTON_CREER_COMPTE_UTIL);
        return contenuChoix;
    }

    public JButton getAUTHENTIFICATION() {
        return AUTHENTIFICATION;
    }

    public JButton getBOUTON_CREER_COMPTE_UTIL() {
        return BOUTON_CREER_COMPTE_UTIL;
    }
}
