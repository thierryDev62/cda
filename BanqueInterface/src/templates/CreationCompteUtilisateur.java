package templates;

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

        return panelCreation;
    }

    public JButton getBOUTON_VALIDER() {
        return BOUTON_VALIDER;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
