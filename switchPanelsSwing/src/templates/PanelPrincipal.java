package templates;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private final JLabel titre = new JLabel("Switch entre deux panels");
    private final JButton retourMenu = new JButton("Retour au menu principal");

    public PanelPrincipal() {
        this.add(titre);
        this.add(retourMenu);
    }

    public JLabel getTitre() {
        return titre;
    }

    public JButton getRetourMenu() {
        return retourMenu;
    }
}
