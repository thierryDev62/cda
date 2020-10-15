import templates.clients.ClientPrincipal;
import templates.clients.CreationCompteBancaire;
import templates.conseiller.ConseillerPrincipal;
import templates.conseiller.ValiderCompteUtilisateur;
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
            "CREATION_COMPTE_BANCAIRE",
            "ESPACE_CONSEILLER",
            "VALIDATION_COMPTE"
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
        auth.getBOUTON_CONNEXION().addActionListener(this::goEspaceConseiller);
        // TODO: rediriger en fonction du type d'utilisateur : 1 - Client goEspaceClient | 2 -  Conseiller goEspaceConseiller

        // Création d'un compte utilisateur
        CreationCompteUtilisateur creationCompteUtilisateur = new CreationCompteUtilisateur();
        creationCompteUtilisateur.getBOUTON_RETOUR_MENU().addActionListener(this::goMenuPrincipal);
        creationCompteUtilisateur.getBOUTON_VALIDER().addActionListener(this::okUtilisateurCree);

        /*******************************************************
         * Espace Clients
         ******************************************************/
        // Page principale espace client
        ClientPrincipal espaceClient = new ClientPrincipal();
        espaceClient.getCreerUnCompte().addActionListener(this::goCreationCompteBancaire);
        espaceClient.getDeconnexion().addActionListener(this::confirmDeconnexion);

        // Création compte bancaire
        CreationCompteBancaire creationCompteBancaire = new CreationCompteBancaire();
        creationCompteBancaire.getBOUTON_VALIDER().addActionListener(this::okCompteBancaireCree);
        creationCompteBancaire.getBOUTON_ANNULER().addActionListener(this::confirmAnnulationCompteBancaire);

        /*******************************************************
         * Espace Conseiller
         ******************************************************/
        // Page principale espace conseiller
        ConseillerPrincipal espaceConseiller = new ConseillerPrincipal();
        espaceConseiller.getDeconnexion().addActionListener(this::confirmDeconnexion);
        espaceConseiller.getValidationCompteUtil().addActionListener(this::goValidationCompteUtilisateur);

        // Validation d'un compte utilisateur
        ValiderCompteUtilisateur validerCompteUtilisateur = new ValiderCompteUtilisateur();
        validerCompteUtilisateur.getBOUTON_VALIDER().addActionListener(this::okCompteUtilisateurValide);
        validerCompteUtilisateur.getBOUTON_ANNULER().addActionListener(this::confirmAnnulationValidationCompteUtil);

        // On définit le layout
        getContent().setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        getContent().add(pagePrincipale, listContent[0]);
        getContent().add(auth, listContent[1]);
        getContent().add(creationCompteUtilisateur, listContent[2]);
        getContent().add(espaceClient, listContent[3]);
        getContent().add(creationCompteBancaire, listContent[4]);
        getContent().add(espaceConseiller, listContent[5]);
        getContent().add(validerCompteUtilisateur, listContent[6]);

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

    // Réponse après validation de création d'un compte utilisateur
    private void okUtilisateurCree(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Compte utilisateur créé !");
        cl.show(getContent(), listContent[0]);
    }

    // Renvoi au menu principal
    private void goMenuPrincipal(ActionEvent e) {
        cl.show(getContent(), listContent[0]);
    }

    // Espace conseiller
    private void goEspaceConseiller(ActionEvent e) {
        cl.show(getContent(), listContent[5]);
    }

    // Validation d'un compte utilisateur par le conseiller
    private void goValidationCompteUtilisateur(ActionEvent e) {
        cl.show(getContent(), listContent[6]);
    }

    // Réponse après validation d'un compte utilisateur
    private void okCompteUtilisateurValide(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Compte utilisateur validé !");
        cl.show(getContent(), listContent[5]);
    }

    // Demande d'annulation de la validation d'un compte utilisateur
    private void confirmAnnulationValidationCompteUtil (ActionEvent e) {
        int clicAnnuler = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de voulair annuler la validation de ce compte utilisateur ?", "Confirmation d'annulation", JOptionPane.YES_NO_OPTION);
        if(clicAnnuler == JOptionPane.YES_OPTION) {
            cl.show(getContent(), listContent[5]);
        }
    }

    // Espace client
    private void goEspaceClient(ActionEvent e) {
        cl.show(getContent(), listContent[3]);
    }

    // Confirmation de déconnexion de l'espace client
    private void  confirmDeconnexion (ActionEvent e) {
        int clicAnnuler = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de voulair vous déconnecter ?", "Confirmation de déconnexion", JOptionPane.YES_NO_OPTION);
        if(clicAnnuler == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Vous êtes déconnecté !");
            cl.show(getContent(), listContent[0]);
        }
    }

    // Créer un compte bancaire
    private void goCreationCompteBancaire(ActionEvent e) {
        cl.show(getContent(), listContent[4]);
    }

    // Réponse après création d'un compte bancaire
    private void okCompteBancaireCree(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Le compte bancaire a bien été créé !");
        cl.show(getContent(), listContent[3]);
    }

    // Demande d'annulation de la création d'un compte bancaire
    private void confirmAnnulationCompteBancaire (ActionEvent e) {
        int clicAnnuler = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de voulair annuler la création d'un compte bancaire ?", "Confirmation d'annulation", JOptionPane.YES_NO_OPTION);
        if(clicAnnuler == JOptionPane.YES_OPTION) {
            cl.show(getContent(), listContent[3]);
        }
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