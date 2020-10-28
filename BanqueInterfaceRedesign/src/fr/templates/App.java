package fr.templates;

import fr.controller.Utilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class App extends JFrame {
    private BufferedImage logo = ImageIO.read(new File("images/logo-bank.png"));
    private BufferedImage fondPagePrincipale = ImageIO.read(new File("images/fond-page-principale.png"));
    private BufferedImage iconeConnexion = ImageIO.read(new File("icones/bull.png"));
    private CardLayout cardLayout = new CardLayout();
    private JPanel contentPanel = new JPanel();

    private boolean choixClientOuConseiller = false;

    public App() throws IOException {
        super("Banque de Diplo");

        // En-tête /////////////////////////////////////////////////////
        JPanel entete = new JPanel();

        JPanel contenuAffichageEntete = new JPanel();
        contenuAffichageEntete.setBorder(BorderFactory.createEmptyBorder(50,0,50,0));

        // Logo de la banque
        JLabel afficheLogo = new JLabel(new ImageIcon(logo));
        contenuAffichageEntete.add(afficheLogo);

        // Titre de l'en-tête
        JLabel titreEntete = new JLabel("Banque de Diplo");
        titreEntete.setFont(new Init().getTitreFont());
        contenuAffichageEntete.add(titreEntete);

        entete.add(contenuAffichageEntete);

        /////////////////////////////////////////////////////

        // Page principale /////////////////////////////////////////////////////

        JPanel pagePrincipale = new JPanel();
        pagePrincipale.setLayout(new BorderLayout());

        // Titre de la page principale
        JPanel conteneurTitrePagePrincipale = new JPanel();
        JLabel titrePagePrincipale = new JLabel("<html><u style=\"color:orange\">Page principale</u></html>");
        titrePagePrincipale.setFont(new Init().getTitreFont());
        conteneurTitrePagePrincipale.add(titrePagePrincipale);

        // Choix entre client ou conseiller plus 2 boutons
        JPanel conteneurChoixPagePrincipale = new JPanel();
        conteneurChoixPagePrincipale.setBorder(BorderFactory.createEmptyBorder(50,0,10,0));
        String[] clientOuConseiller = { "Client", "Conseiller" };
        JComboBox choix = new JComboBox<>(clientOuConseiller);
        choix.setSelectedItem(null);
        choix.setFont(new Init().getDefaultFont());
        choix.addActionListener(e -> {
            setChoixClientOuConseiller(true);

            Utilisateur.setTypeUtilisateur((String) choix.getSelectedItem());
            //this.setTypeUtilisateur((String) choix.getSelectedItem());

            System.out.println(Utilisateur.getTypeUtilisateur());

        });
        conteneurChoixPagePrincipale.add(choix);

        JButton authentification = new JButton("Authentification");
        authentification.setFont(new Init().getDefaultFont());
        authentification.addActionListener(this::goAuthentification);
        conteneurChoixPagePrincipale.add(authentification);

        JButton boutonCreerCompteUtil = new JButton("Créer un compte utilisateur");
        boutonCreerCompteUtil.setFont(new Init().getDefaultFont());
        conteneurChoixPagePrincipale.add(boutonCreerCompteUtil);

        // Image de fond
        JPanel imageDeFondPagePrincipale = new JPanel();
        imageDeFondPagePrincipale.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        JLabel afficheImageDeFond = new JLabel(new ImageIcon(fondPagePrincipale));
        imageDeFondPagePrincipale.add(afficheImageDeFond);

        // Construction de la page principale
        pagePrincipale.add(conteneurTitrePagePrincipale, BorderLayout.NORTH);
        pagePrincipale.add(conteneurChoixPagePrincipale, BorderLayout.CENTER);
        pagePrincipale.add(imageDeFondPagePrincipale, BorderLayout.SOUTH);

        /////////////////////////////////////////////////////

        // Authentification /////////////////////////////////////////////////////
        JPanel pageAuthentification = new JPanel();
        pageAuthentification.setLayout(new BorderLayout(5,5));

        // Affiche l'icone et le titre
        JPanel conteneurIconeEtTitre = new JPanel();
        conteneurIconeEtTitre.setLayout(new BorderLayout());

        JPanel conteneurIcone = new JPanel();
        JLabel affichageIcone = new JLabel(new ImageIcon(iconeConnexion));
        conteneurIcone.add(affichageIcone);

        JPanel conteneurTitreAuth = new JPanel();
        JLabel titreAuth = new JLabel("<html><u style=\"color:orange\">Authentification</u></html>");
        titreAuth.setFont(new Init().getTitreFont());
        conteneurTitreAuth.add(titreAuth);

        JLabel bienvenueClientOuConseiller = new JLabel("Bienvenue " + Utilisateur.getTypeUtilisateur());
        conteneurTitreAuth.add(titreAuth);
        conteneurTitreAuth.add(bienvenueClientOuConseiller);

        conteneurIconeEtTitre.add(conteneurTitreAuth, BorderLayout.NORTH);
        conteneurIconeEtTitre.add(conteneurIcone, BorderLayout.CENTER);

        // Connexion
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
        JButton boutonConnexion = new JButton("Connexion");
        boutonConnexion.setFont(new Init().getDefaultFont());
        conteneurBoutonConnexion.add(boutonConnexion);

        // Bouton Retour au menu
        JPanel conteneurRetourAuMenu = new JPanel();
        JButton boutonRetourMenu = new JButton("Retour au menu");
        boutonRetourMenu.setFont(new Init().getDefaultFont());
        conteneurRetourAuMenu.add(boutonRetourMenu);

        panelConnexion.add(conteneurIdentifiant);
        panelConnexion.add(conteneurMotDePasse);
        panelConnexion.add(conteneurBoutonConnexion);
        panelConnexion.add(conteneurRetourAuMenu);


        pageAuthentification.add(conteneurIconeEtTitre, BorderLayout.NORTH);
        pageAuthentification.add(panelConnexion, BorderLayout.CENTER);

        /////////////////////////////////////////////////////

        contentPanel.setLayout(cardLayout);

        contentPanel.add(pagePrincipale, "pagePrincipale");
        contentPanel.add(pageAuthentification, "pageAuthentification");

        this.getContentPane().add(entete, BorderLayout.NORTH);
        this.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    // Envoi sur le page d'authentification
    public void goAuthentification(ActionEvent e) {
        if(isChoixClientOuConseiller()) {
            cardLayout.show(contentPanel, "pageAuthentification");
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez faire un choix entre client ou conseiller !");
        }
    }

    // Getters et Setters

    public boolean isChoixClientOuConseiller() {
        return choixClientOuConseiller;
    }

    public void setChoixClientOuConseiller(boolean choixClientOuConseiller) {
        this.choixClientOuConseiller = choixClientOuConseiller;
    }

}
