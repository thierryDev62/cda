package templates.principal;

import config.ConfigDatabase;
import config.ConfigDb;
import entity.Utilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

public class CreationCompteUtilisateur extends JPanel {

    private final static JButton BOUTON_VALIDER = new JButton("Valider");
    private final static JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu principal");
    private BufferedImage iconeCreationCompteUtil = ImageIO.read(new File("icones/man-coin.png"));

    private static boolean isOkCreation = false;

    public CreationCompteUtilisateur() throws IOException, SQLException {
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
        champsNom.setText("");
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
        BOUTON_VALIDER.addActionListener(e ->{

            String nomUtilisateur = Utilisateur.setUtilisateurNom(champsNom.getText());
            String prenomUtilisateur = Utilisateur.setUtilisateurPrenom(champsPrenom.getText());
            String mdpUtilisateur = Utilisateur.setUtilisateurMdp(new String(champsMotDePasse.getPassword()));

            int typeUtilisateur = Utilisateur.getTypeUtilisateur();
            try{
                if(!nomUtilisateur.equals("") || !prenomUtilisateur.equals("") || !mdpUtilisateur.equals("")) {
                    System.out.println("C'est rempli !");
                    /**
                     * Test si c'est un conseiller ou un client :
                     * true : Conseiller
                     * false : Client
                     */

                    Utilisateur.setCompteActif(typeUtilisateur == 2);
                    boolean compteActif = Utilisateur.getCompteActif();

                    System.out.println(nomUtilisateur +
                            " - " + prenomUtilisateur +
                            " - " + mdpUtilisateur +
                            " - " + compteActif +
                            " - " + typeUtilisateur
                    );

                    // Enregistrement du compte utilisateur dans la base de données
                    String querySaveUser = "INSERT INTO public.t_utilisateur_utl(" +
                            "utl_nom, utl_prenom, utl_mot_de_passe, utl_compte_actif, tut_id)" +
                            "VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = ConfigDatabase.getInstance().prepareStatement(querySaveUser);
                    preparedStatement.setString(1, nomUtilisateur);
                    preparedStatement.setString(2, prenomUtilisateur);
                    preparedStatement.setString(3, mdpUtilisateur);
                    preparedStatement.setBoolean(4, compteActif);
                    preparedStatement.setInt(5, typeUtilisateur);

                    // TODO : décommenter pour enregistrer dans la base de données
                    //preparedStatement.executeUpdate();

                    setIsOkCreation(true);
                    preparedStatement.close();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs, veuillez recommencer");
                }
            } catch(SQLException event) {
                event.printStackTrace();
            }

        });

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

    public static JButton getBOUTON_VALIDER() {
        return BOUTON_VALIDER;
    }

    public static JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }

    public static boolean isIsOkCreation() {
        return isOkCreation;
    }

    public static void setIsOkCreation(boolean isOkCreation) {
        CreationCompteUtilisateur.isOkCreation = isOkCreation;
    }
}
