package templates.conseiller;

import config.ConfigDatabase;
import entity.Utilisateur;
import templates.principal.Init;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConseillerPrincipal extends JPanel {
    private BufferedImage fond = ImageIO.read(new File("images/espaceConseiller.jpg"));
    private static JMenuItem deconnexion = new JMenuItem("Quitter");
    private static JMenuItem validationCompteUtil = new JMenuItem("Valider un compte utilisateur");
    private static JMenuItem listeDesComptes = new JMenuItem("Voir la liste des comptes");
    private static JMenuItem listeDesClients = new JMenuItem("Voir la liste des clients");

    public ConseillerPrincipal() throws IOException, SQLException {
        this.add(afficheTitreEtMenuBar());
    }
    private JPanel afficheTitreEtMenuBar() throws SQLException {
        JPanel espaceConseiller = new JPanel();
        espaceConseiller.setLayout(new BorderLayout());
        espaceConseiller.add(titreEspaceConseiller(), BorderLayout.NORTH);
        espaceConseiller.add(afficheMenuBarConseiller(), BorderLayout.CENTER);
        espaceConseiller.add(imageDeFond(), BorderLayout.SOUTH);

        return espaceConseiller;
    }

    private JPanel titreEspaceConseiller() throws SQLException {
        JPanel conteneurTitre = new JPanel();
        conteneurTitre.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));

        JLabel titre = new JLabel("Espace conseiller - ");
        titre.setFont(new Init().getTitreFont());

        System.out.println("Utilisateur numéro : " + Utilisateur.getUtilisateurId());

        String queryNomPrenom = "SELECT utl_id, utl_nom, utl_prenom FROM public.t_utilisateur_utl WHERE utl_id = " + Utilisateur.getUtilisateurId();

        Statement state = ConfigDatabase.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet result = state.executeQuery(queryNomPrenom);

        result.first();

        JLabel bienvenue = new JLabel("Bienvenue ! " +
                result.getString("utl_prenom") + " " +
                result.getString("utl_nom") +
                " - Votre identifiant est le : " + result.getInt("utl_id")
        );
        bienvenue.setFont(new Init().getTitreFont());

        conteneurTitre.add(titre);
        conteneurTitre.add(bienvenue);
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

        /********** Menu "Action" **********/
        JMenu action = new JMenu("Action");
        action.setFont(new Init().getDefaultFont());

        validationCompteUtil.setIcon(new ImageIcon("icones/hammer-mini.png"));
        action.add(validationCompteUtil);

        action.addSeparator();

        deconnexion.setIcon(new ImageIcon("icones/exit.png"));
        action.add(deconnexion);

        /********** Menu "Consultation" **********/
        JMenu consultation = new JMenu("Consultation");
        consultation.setFont(new Init().getDefaultFont());

        listeDesComptes.setIcon(new ImageIcon("icones/document-paper-mini.png"));
        consultation.add(listeDesComptes);

        listeDesClients.setIcon(new ImageIcon("icones/man-coin-mini.png"));
        consultation.add(listeDesClients);

        menuBar.add(action);
        menuBar.add(consultation);

        return menuBar;
    }

    public static JMenuItem getDeconnexion() {
        return deconnexion;
    }

    public static JMenuItem getValidationCompteUtil() {
        return validationCompteUtil;
    }

    public static JMenuItem getListeDesComptes() {
        return listeDesComptes;
    }

    public static JMenuItem getListeDesClients() {
        return listeDesClients;
    }
}
