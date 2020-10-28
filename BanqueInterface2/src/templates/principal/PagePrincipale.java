package templates.principal;

import entity.Utilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PagePrincipale extends JPanel {
    private final BufferedImage FOND = ImageIO.read(new File("images/fond-page-principale.png"));
    private final JButton AUTHENTIFICATION = new JButton("S'authentifier");
    private final JButton BOUTON_CREER_COMPTE_UTIL = new JButton("Créer un compte utilisateur");
    private JComboBox choix = new JComboBox<>();
    private static String type = "Client"; //TODO : voir pour transmettre le type
    private static boolean choixClientOuConseiller = false;

    public PagePrincipale() throws IOException {
        this.setLayout(new BorderLayout());
        this.add(titre(), BorderLayout.NORTH);
        this.add(choix(), BorderLayout.CENTER);
        this.add(imageDeFond(), BorderLayout.SOUTH);
    }

    private JPanel imageDeFond() {
        JPanel imageDeFond = new JPanel();
        imageDeFond.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        JLabel imageFond = new JLabel(new ImageIcon(FOND));
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
        contenuChoix.setBorder(BorderFactory.createEmptyBorder(50,0,10,0));

        // Combobox de choix de client ou conseiller
        String[] clientOuConseiller = { "Client", "Conseiller" };
        choix = new JComboBox<>(clientOuConseiller);
        choix.setSelectedItem(null);
        choix.setFont(new Init().getDefaultFont());
        choix.addActionListener(this::typeChoisi);

        // Bouton Créer un compte utilisateur
        AUTHENTIFICATION.setFont(new Init().getDefaultFont());
        BOUTON_CREER_COMPTE_UTIL.setFont(new Init().getDefaultFont());
        contenuChoix.add(choix);
        contenuChoix.add(AUTHENTIFICATION);
        contenuChoix.add(BOUTON_CREER_COMPTE_UTIL);
        return contenuChoix;
    }

    // Méthode de catch du type d'utilisateur
    public void typeChoisi(ActionEvent e) {
        //TODO : test de catch d'une valeur choisi dans un combobox

        if(Objects.equals(choix.getSelectedItem(), "Client")) {
            Utilisateur.setTypeUtilisateur("Client");
            System.out.println("Vous avez choisi le type " + Utilisateur.getTypeUtilisateur());
        } else if (Objects.equals(choix.getSelectedItem(), "Conseiller")) {
            Utilisateur.setTypeUtilisateur("Conseiller");
            System.out.println("Vous avez choisi le type " + Utilisateur.getTypeUtilisateur());
        }
        setChoixClientOuConseiller(true);
    }

    public JButton getAUTHENTIFICATION() {
        return AUTHENTIFICATION;
    }

    public JButton getBOUTON_CREER_COMPTE_UTIL() {
        return BOUTON_CREER_COMPTE_UTIL;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        PagePrincipale.type = type;
    }

    public static boolean isChoixClientOuConseiller() {
        return choixClientOuConseiller;
    }

    public static void setChoixClientOuConseiller(boolean choixClientOuConseiller) {
        PagePrincipale.choixClientOuConseiller = choixClientOuConseiller;
    }
}
