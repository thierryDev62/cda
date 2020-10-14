import templates.clients.ClientPrincipal;
import templates.clients.CreationCompteBancaire;
import templates.principal.Auth;
import templates.principal.CreationCompteUtilisateur;
import templates.principal.EnTete;
import templates.principal.PagePrincipale;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class App extends JFrame {
    private final CardLayout cl = new CardLayout();
    private final JPanel content = new JPanel();

    // Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {
            "PAGE_PRINCIPALE",
            "AUTH",
            "CREATION_COMPTE_UTIL",
            "ESPACE_CLIENT",
            "CREATION_COMPTE_BANCAIRE"
    };

    public App() throws IOException {
        super("Banque Diplo");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        /*******************************************************
         * Principal
         ******************************************************/
        // En-tête
        EnTete entete = new EnTete();

        // Page principale
        PagePrincipale pagePrincipale = new PagePrincipale();
        pagePrincipale.getAUTHENTIFICATION().addActionListener(this::goAuthentification);
        pagePrincipale.getBOUTON_CREER_COMPTE_UTIL().addActionListener(this::goCreationUtilisateur);

        // Authentification
        Auth auth = new Auth();
        auth.getBOUTON_RETOUR_MENU().addActionListener(this::goMenuPrincipal);
        auth.getBOUTON_CONNEXION().addActionListener(this::goEspaceClient);

        // Création d'un compte utilisateur
        CreationCompteUtilisateur creationCompteUtilisateur = new CreationCompteUtilisateur();
        creationCompteUtilisateur.getBOUTON_RETOUR_MENU().addActionListener(this::goMenuPrincipal);

        /*******************************************************
         * Espace Clients
         ******************************************************/
        // Page principale espace client
        ClientPrincipal espaceClient = new ClientPrincipal();
        espaceClient.getCreerUnCompte().addActionListener(this::goCreationCompteBancaire);

        // Création compte bancaire
        CreationCompteBancaire creationCompteBancaire = new CreationCompteBancaire();


        // On définit le layout
        getContent().setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        getContent().add(pagePrincipale, listContent[0]);
        getContent().add(auth, listContent[1]);
        getContent().add(creationCompteUtilisateur, listContent[2]);
        getContent().add(espaceClient, listContent[3]);
        getContent().add(creationCompteBancaire, listContent[4]);

        this.getContentPane().add(entete, BorderLayout.NORTH);
        this.getContentPane().add(getContent(), BorderLayout.CENTER);
    }

    // Envoi sur le panel de l'authentification
    private void goAuthentification(ActionEvent e) {
        cl.show(getContent(), listContent[1]);
    }

    // Envoi sur le panel de création d'un utilisateur
    private void goCreationUtilisateur(ActionEvent e) {
        cl.show(getContent(), listContent[2]);
    }

    // Renvoi au menu principal
    private void goMenuPrincipal(ActionEvent e) {
        cl.show(getContent(), listContent[0]);
    }

    // Espace client
    private void goEspaceClient(ActionEvent e) {
        cl.show(getContent(), listContent[3]);
    }

    // Créer un compte
    private void goCreationCompteBancaire(ActionEvent e) {
        cl.show(getContent(), listContent[4]);
    }

    private JPanel getContent() {
        return content;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        App myWindow = new App();
        myWindow.setVisible(true);
    }
}