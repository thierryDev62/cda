package templates.principal;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreationCompteUtilisateur extends JPanel {

    private final JButton BOUTON_VALIDER = new JButton("Valider");
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu principal");
    private BufferedImage iconeCreationCompteUtil = ImageIO.read(new File("icones/man-coin.png"));

    public CreationCompteUtilisateur() throws IOException {
        this.setLayout(new BorderLayout(5,5));
        this.add(iconeCreationEtTitre(), BorderLayout.NORTH);
        this.add(creation(), BorderLayout.CENTER);

    }
    private JPanel iconeCreationEtTitre() {
        // Conteneur de l'icone et du titre
        JPanel conteneurIconeEtTitre = new JPanel();
        conteneurIconeEtTitre.setLayout(new BorderLayout());

        // Conteneur de l'icone
        JPanel conteneurIcone = new JPanel();
        JLabel affichageIcone = new JLabel(new ImageIcon(iconeCreationCompteUtil));
        conteneurIcone.add(affichageIcone);

        // Conteneur du titre
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("<html><u style=\"color:orange\">Création d'un compte utilisateur</u></html>");
        titre.setFont(new Init().getTitreFont());
        titrePanel.add(titre);

        conteneurIconeEtTitre.add(titrePanel, BorderLayout.NORTH);
        conteneurIconeEtTitre.add(conteneurIcone, BorderLayout.CENTER);

        return conteneurIconeEtTitre;
    }

    private JPanel creation() {
        JPanel panelCreation = new JPanel();
        panelCreation.setLayout(new GridLayout(5,1));
        panelCreation.setBorder( new EmptyBorder(100, 0, 0, 0) );

        // Demande du nom
        JPanel conteneurNom = new JPanel();
        JLabel nom = new JLabel("Nom : ");
        nom.setFont(new Init().getDefaultFont());
        JTextField champsNom = new JTextField();
        champsNom.setPreferredSize(new Dimension(200, 30));
        conteneurNom.add(nom);
        conteneurNom.add(champsNom);

        // Demande du prénom
        JPanel conteneurPrenom = new JPanel();
        JLabel prenom = new JLabel("Prénom : ");
        prenom.setFont(new Init().getDefaultFont());
        JTextField champsPrenom = new JTextField();
        champsPrenom.setPreferredSize(new Dimension(200, 30));
        conteneurPrenom.add(prenom);
        conteneurPrenom.add(champsPrenom);

        // Demande du mot de passe
        JPanel conteneurMdp = new JPanel();
        JLabel motDePasse = new JLabel("Mot de passe : ");
        motDePasse.setFont(new Init().getDefaultFont());
        JPasswordField champsMotDePasse = new JPasswordField();
        champsMotDePasse.setPreferredSize(new Dimension(200, 30));
        conteneurMdp.add(motDePasse);
        conteneurMdp.add(champsMotDePasse);

        // Bouton valider
        JPanel conteneurBoutonValider = new JPanel();
        BOUTON_VALIDER.setFont(new Init().getDefaultFont());
        conteneurBoutonValider.add(BOUTON_VALIDER);

        // Bouton retour au menu
        JPanel conteneurRetourAuMenu = new JPanel();
        BOUTON_RETOUR_MENU.setFont(new Init().getDefaultFont());
        conteneurRetourAuMenu.add(BOUTON_RETOUR_MENU);

        panelCreation.add(conteneurNom);
        panelCreation.add(conteneurPrenom);
        panelCreation.add(conteneurMdp);
        panelCreation.add(conteneurBoutonValider);
        panelCreation.add(conteneurRetourAuMenu);

        return panelCreation;
    }

    public JButton getBOUTON_VALIDER() {
        return BOUTON_VALIDER;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
