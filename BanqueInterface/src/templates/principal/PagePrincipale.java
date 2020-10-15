package templates.principal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PagePrincipale extends JPanel {
    private BufferedImage fond = ImageIO.read(new File("images/fond-page-principale.png"));
    private final JButton AUTHENTIFICATION = new JButton("S'authentifier");
    private final JButton BOUTON_CREER_COMPTE_UTIL = new JButton("Créer un compte utilisateur");

    public PagePrincipale() throws IOException {
        this.setLayout(new BorderLayout());
        this.add(titre(), BorderLayout.NORTH);
        this.add(choix(), BorderLayout.CENTER);
        this.add(imageDeFond(), BorderLayout.SOUTH);
    }

    private JPanel imageDeFond() {
        JPanel imageDeFond = new JPanel();
        imageDeFond.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        JLabel imageFond = new JLabel(new ImageIcon(fond));
        imageDeFond.add(imageFond);
        return imageDeFond;
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
        contenuChoix.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
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
