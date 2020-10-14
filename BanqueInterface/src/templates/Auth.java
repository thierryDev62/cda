package templates;

import javax.swing.*;
import java.awt.*;

public class Auth extends JPanel {

    private final JButton BOUTON_CONNEXION = new JButton("Connexion");
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu principal");

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
        panelConnexion.setLayout(new GridLayout(4,1));

        // Demande de saisi de l'identifiant
        JPanel conteneurIdentifiant = new JPanel();
        JLabel identifiant = new JLabel("Identifiant : ");
        identifiant.setFont(new Init().getDefaultFont());
        JTextField champsIdentifiant = new JTextField();
        champsIdentifiant.setPreferredSize(new Dimension(200, 30));
        conteneurIdentifiant.add(identifiant);
        conteneurIdentifiant.add(champsIdentifiant);

        // Demande de saisi du mot de passe
        JPanel conteneurMotDePasse = new JPanel();
        JLabel motDePasse = new JLabel("Mot de passe : ");
        motDePasse.setFont(new Init().getDefaultFont());
        JTextField champsMotDePasse = new JTextField();
        champsMotDePasse.setPreferredSize(new Dimension(200, 30));
        conteneurMotDePasse.add(motDePasse);
        conteneurMotDePasse.add(champsMotDePasse);

        // Bouton Connexion
        JPanel conteneurBoutonConnexion = new JPanel();
        BOUTON_CONNEXION.setFont(new Init().getDefaultFont());
        conteneurBoutonConnexion.add(BOUTON_CONNEXION);

        // Bouton Retour au menu
        JPanel conteneurRetourAuMenu = new JPanel();
        BOUTON_RETOUR_MENU.setFont(new Init().getDefaultFont());
        conteneurRetourAuMenu.add(BOUTON_RETOUR_MENU);

        panelConnexion.add(conteneurIdentifiant);
        panelConnexion.add(conteneurMotDePasse);
        panelConnexion.add(conteneurBoutonConnexion);
        panelConnexion.add(conteneurRetourAuMenu);
        return panelConnexion;
    }

}
