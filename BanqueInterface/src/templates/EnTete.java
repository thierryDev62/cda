package templates;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnTete extends JPanel {
    private BufferedImage logo = ImageIO.read(new File("images/logo-bank.png"));

    public EnTete() throws IOException {
        this.add(affichageLogoEtTitre());
    }

    private JPanel affichageLogoEtTitre(){
        // Conteneur logo et titre
        JPanel contenuAffichage =  new JPanel();

        // Un peut d'espace avec le haut
        contenuAffichage.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JLabel afficheLogo = new JLabel(new ImageIcon(logo));
        contenuAffichage.add(afficheLogo);
        JLabel titre = new JLabel("Banque de Diplo");
        titre.setFont(new Init().getTitreFont());
        contenuAffichage.add(titre);
        return contenuAffichage;
    }
}
