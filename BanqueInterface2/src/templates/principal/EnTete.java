package templates.principal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnTete extends JPanel {
    private BufferedImage logo = ImageIO.read(new File("images/logo-bank.png"));
    private BufferedImage money = ImageIO.read(new File("images/money.png"));

    public EnTete() throws IOException {
        this.add(affichageLogoEtTitre());
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(1920, 250, 0, 250);
        g2.draw(lin);
    }

    private JPanel affichageLogoEtTitre(){
        // Conteneur logo et titre
        JPanel contenuAffichage =  new JPanel();

        contenuAffichage.setLayout(new BorderLayout(50,50));

        // Un peu d'espace avec le haut
        contenuAffichage.setBorder(BorderFactory.createEmptyBorder(50,0,50,0));

        JLabel afficheLogo = new JLabel(new ImageIcon(logo));
        contenuAffichage.add(afficheLogo, BorderLayout.WEST);

        JLabel titre = new JLabel("Banque de Diplo");
        titre.setFont(new Init().getTitreFont());
        contenuAffichage.add(titre, BorderLayout.CENTER);

        JLabel afficheMoney = new JLabel(new ImageIcon(money));
        contenuAffichage.add(afficheMoney, BorderLayout.EAST);

        return contenuAffichage;
    }
}
