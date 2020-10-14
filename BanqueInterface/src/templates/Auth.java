package templates;

import javax.swing.*;
import java.awt.*;

public class Auth extends JPanel {

    public Auth() {
        this.setLayout(new GridLayout(2,1));
        this.add(titre());
        this.add(connexion());
    }
    private JPanel titre() {
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("Authentification");
        titre.setFont(new Init().getTitreFont());
        titrePanel.add(titre);
        return titrePanel;
    }
    private JPanel connexion() {
        JPanel panelConnexion = new JPanel();
        
        return panelConnexion;
    }

}
