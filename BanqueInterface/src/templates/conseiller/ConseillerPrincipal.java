package templates.conseiller;

import templates.principal.Init;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConseillerPrincipal extends JPanel {
    private BufferedImage fond = ImageIO.read(new File("images/espaceConseiller.jpg"));

    public ConseillerPrincipal() throws IOException {
        this.add(afficheTitreEtMenuBar());
    }
    private JPanel afficheTitreEtMenuBar() {
        JPanel espaceConseiller = new JPanel();
        espaceConseiller.setLayout(new BorderLayout());
        espaceConseiller.add(titreEspaceConseiller(), BorderLayout.NORTH);
        espaceConseiller.add(afficheMenuBarConseiller(), BorderLayout.CENTER);
        espaceConseiller.add(imageDeFond(), BorderLayout.SOUTH);

        return espaceConseiller;
    }

    private JPanel titreEspaceConseiller() {
        JPanel conteneurTitre = new JPanel();
        conteneurTitre.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));
        JLabel titre = new JLabel("Espace conseiller");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel imageDeFond () {
        JPanel imageDeFond = new JPanel();
        JLabel imageFond = new JLabel(new ImageIcon(fond));
        imageDeFond.add(imageFond);

        return imageDeFond;
    }
    public JMenuBar afficheMenuBarConseiller() {

        JMenuBar menuBar = new JMenuBar();

        return menuBar;
    }


}
