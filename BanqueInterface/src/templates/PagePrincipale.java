package templates;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PagePrincipale extends JPanel {

    //private BufferedImage logo = ImageIO.read(new File("images/logo-bank.png"));

    public PagePrincipale() throws IOException {
        this.setLayout(new GridLayout(2,1));
        //this.add(affichageLogoEtTitre());
        this.add(choix());
    }

    /*private JPanel affichageLogoEtTitre(){
        // Conteneur logo et titre
        JPanel contenuAffichage =  new JPanel();
        // Un peut d'espace avec le haut
        contenuAffichage.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        JLabel afficheLogo = new JLabel(new ImageIcon(logo));
        contenuAffichage.add(afficheLogo);
        Font fontTitre = new Font("Verdana", Font.BOLD, 30);
        JLabel titre = new JLabel("Banque de Diplo");
        titre.setFont(fontTitre);
        contenuAffichage.add(titre);
        return contenuAffichage;
    }*/

    private JPanel choix() {
        // En dessous
        JPanel contenuChoix = new JPanel();

        // Combobox de choix de client ou conseiller
        JComboBox choix = new JComboBox();
        choix.setFont(new Init().getDefaultFont());
        choix.addItem("Client");
        choix.addItem("Conseiller");

        // Bouton s'authentifier
        JButton boutonAuthentifier = new JButton("S'authentifier");
        boutonAuthentifier.setFont(new Init().getDefaultFont());

        // Bouton Créer un compte utilisateur
        JButton boutonCreerCompteUtil = new JButton("Créer un compte utilisateur");
        boutonCreerCompteUtil.setFont(new Init().getDefaultFont());

        contenuChoix.add(choix);
        contenuChoix.add(boutonAuthentifier);
        contenuChoix.add(boutonCreerCompteUtil);
        return contenuChoix;
    }
}
