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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Auth extends JPanel {

    private final static JButton BOUTON_CONNEXION = new JButton("Connexion");
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu principal");
    private final BufferedImage ICONE_CONNEXION = ImageIO.read(new File("icones/bull.png"));
    private static boolean okAuth = false;

    public Auth() throws IOException, SQLException {
        this.setLayout(new BorderLayout(5,5));
        this.add(iconeConnexionEtTitre(), BorderLayout.NORTH);
        this.add(connexion(), BorderLayout.CENTER);
    }
    private JPanel iconeConnexionEtTitre() {

        System.out.println("L'utilisateur actuel est : " + Utilisateur.getTypeUtilisateur());

        // Conteneur de l'icone et du titre
        JPanel conteneurIconeEtTitre = new JPanel();
        conteneurIconeEtTitre.setLayout(new BorderLayout());

        // Conteneur de l'icone
        JPanel conteneurIcone = new JPanel();
        JLabel affichageIcone = new JLabel(new ImageIcon(ICONE_CONNEXION));
        conteneurIcone.add(affichageIcone);

        // Conteneur du titre
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("<html><u style=\"color:orange\">Authentification</u></html>");
        titre.setFont(new Init().getTitreFont());
        titrePanel.add(titre);

        conteneurIconeEtTitre.add(titrePanel, BorderLayout.NORTH);
        conteneurIconeEtTitre.add(conteneurIcone, BorderLayout.CENTER);

        return conteneurIconeEtTitre;
    }

    private JPanel connexion() {
        JPanel panelConnexion = new JPanel();
        panelConnexion.setLayout(new GridLayout(4,1));
        panelConnexion.setBorder( new EmptyBorder(100, 0, 0, 0) );

        // Demande de saisi de l'identifiant
        JPanel conteneurIdentifiant = new JPanel();
        JLabel identifiant = new JLabel("Identifiant : ");
        identifiant.setFont(new Init().getDefaultFont());
        JTextField champsIdentifiant = new JTextField();
        champsIdentifiant.setPreferredSize(new Dimension(200, 30));
        conteneurIdentifiant.add(identifiant);
        conteneurIdentifiant.add(champsIdentifiant);

        // Demande de saisi du mot de passe
        JPanel conteneurMotDePasse = new JPanel();
        JLabel motDePasse = new JLabel("Mot de passe : ");
        motDePasse.setFont(new Init().getDefaultFont());
        JTextField champsMotDePasse = new JTextField();
        champsMotDePasse.setPreferredSize(new Dimension(200, 30));
        conteneurMotDePasse.add(motDePasse);
        conteneurMotDePasse.add(champsMotDePasse);

        // Bouton Connexion
        JPanel conteneurBoutonConnexion = new JPanel();
        BOUTON_CONNEXION.setFont(new Init().getDefaultFont());
        conteneurBoutonConnexion.add(BOUTON_CONNEXION);
        BOUTON_CONNEXION.addActionListener(e -> {
            /**
             * Test de lecture dans la base de données
             */
            String queryUserIdPassword = "SELECT utl_id, utl_mot_de_passe FROM public.t_utilisateur_utl";
            try {
                Statement state = ConfigDatabase.getInstance().createStatement();

                ResultSet result = state.executeQuery(queryUserIdPassword);

                while (result.next()) {
                    if(!champsIdentifiant.getText().equals("") || !champsMotDePasse.getText().equals("")) {
                        int id = result.getInt("utl_id");
                        String mdp = result.getString("utl_mot_de_passe");

                        String identifiantText = champsIdentifiant.getText();
                        int identifiantParse = 0;
                        identifiantParse = Integer.parseInt(identifiantText);

                        if (id == identifiantParse && mdp.equals(champsMotDePasse.getText())) {
                            System.out.println("Trouvé : " + identifiantParse);
                            setOkAuth(true);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "L'identifiant et/ou le mot de passe sont incorrects, veuillez recommencer");
                result.close();
            } catch (SQLException event) {
                event.printStackTrace();
            }
        });

        // Bouton Retour au menu
        JPanel conteneurRetourAuMenu = new JPanel();
        BOUTON_RETOUR_MENU.setFont(new Init().getDefaultFont());
        conteneurRetourAuMenu.add(BOUTON_RETOUR_MENU);

        panelConnexion.add(conteneurIdentifiant);
        panelConnexion.add(conteneurMotDePasse);
        panelConnexion.add(conteneurBoutonConnexion);
        panelConnexion.add(conteneurRetourAuMenu);

        return panelConnexion;
    }

    public static JButton getBOUTON_CONNEXION() {
        return BOUTON_CONNEXION;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }

    public static boolean isOkAuth() {
        return okAuth;
    }

    public static void setOkAuth(boolean okAuth) {
        Auth.okAuth = okAuth;
    }
}
