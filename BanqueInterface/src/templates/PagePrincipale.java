package templates;

import javax.swing.*;
import java.awt.*;

public class PagePrincipale extends JPanel {

    private final JButton AUTHENTIFICATION = new JButton("S'authentifier");

    public PagePrincipale() {
        this.setLayout(new GridLayout(2,1));
        this.add(titre());
        this.add(choix());
    }
    private JPanel titre() {
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("Page principale");
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
        JButton boutonCreerCompteUtil = new JButton("Créer un compte utilisateur");
        boutonCreerCompteUtil.setFont(new Init().getDefaultFont());
        AUTHENTIFICATION.setFont(new Init().getDefaultFont());
        contenuChoix.add(choix);
        contenuChoix.add(AUTHENTIFICATION);
        contenuChoix.add(boutonCreerCompteUtil);
        return contenuChoix;
    }

    public JButton getAUTHENTIFICATION() {
        return AUTHENTIFICATION;
    }
}
