package templates.principal;

import config.ConfigDatabase;
import controller.CompteController;
import entity.Utilisateur;
import templates.clients.*;
import templates.conseiller.ConseillerPrincipal;
import templates.conseiller.ListeClients;
import templates.conseiller.ValiderCompteUtilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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
            "VALIDATION_COMPTE",
            "INFORMATIONS",
            "LISTE_DES_COMPTES",
            "CONSULTATION_SOLDE",
            "VERSEMENTS",
            "RETRAITS",
            "VIREMENTS",
            "LISTE_OPERATIONS",
            "TOTAL_VERSEMENTS",
            "TOTAL_RETRAITS",
            "LISTE_CLIENTS"
    };

    public App() throws IOException {

        super("Banque Diplo");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        // On se connecte à la base de données
        ConfigDatabase.getInstance();

        /*******************************************************
         * Principal
         ******************************************************/
        // En-tête
        EnTete entete = new EnTete();

        // Page principale
        PagePrincipale pagePrincipale = new PagePrincipale();
        pagePrincipale.getAUTHENTIFICATION().addActionListener(e -> {
            if(PagePrincipale.isChoixClientOuConseiller()) {
                Auth auth = null;
                try {
                    auth = new Auth();

                    /**
                     * Test de lecture dans la base de données
                     */
                    Statement state = ConfigDatabase.getInstance().createStatement();

                    ResultSet result = state.executeQuery("SELECT * FROM public.t_utilisateur_utl AS utl INNER JOIN t_type_utilisateur_tut AS tut ON tut.tut_id = utl.tut_id");

                    ResultSetMetaData resultSetMetaData = result.getMetaData();

                    while(result.next()) {
                        for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                            System.out.print(result.getObject(i).toString() + " ");
                        }
                    }

                    auth.getBOUTON_RETOUR_MENU().addActionListener(this::goMenuPrincipal);

                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
                getContent().add(auth, listContent[1]);
                cl.show(getContent(), listContent[1]);
            } else {
                JOptionPane.showMessageDialog(null, "Vous devez faire un choix entre client ou conseiller !");
            }
        });
        pagePrincipale.getBOUTON_CREER_COMPTE_UTIL().addActionListener(this::goCreationUtilisateur);

        // Va dans l'espace dédié en fonction du type d'utilisateur
        Auth.getBOUTON_CONNEXION().addActionListener(e -> {
            if(Utilisateur.getTypeUtilisateur() == 1) {
                ClientPrincipal espaceClient = null;
                try {
                    espaceClient = new ClientPrincipal();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                getContent().add(espaceClient, listContent[3]);
                cl.show(getContent(), listContent[3]);
            } else if(Utilisateur.getTypeUtilisateur() == 2) {
                ConseillerPrincipal espaceConseiller = null;
                try {
                    espaceConseiller = new ConseillerPrincipal();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                getContent().add(espaceConseiller, listContent[5]);
                cl.show(getContent(), listContent[5]);
            }
        });

        // Création d'un compte utilisateur
        CreationCompteUtilisateur creationCompteUtilisateur = null;
        try {
            creationCompteUtilisateur = new CreationCompteUtilisateur();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        creationCompteUtilisateur.getBOUTON_RETOUR_MENU().addActionListener(this::goMenuPrincipal);
        creationCompteUtilisateur.getBOUTON_VALIDER().addActionListener(this::okUtilisateurCree);

        /*******************************************************
         * Espace Clients
         ******************************************************/
        // Page principale espace client
        ClientPrincipal espaceClient = new ClientPrincipal();

        // Déconnexion
        ClientPrincipal.getDeconnexion().addActionListener(e -> {
            int clicDeconnexion = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de voulair vous déconnecter ?", "Confirmation de déconnexion", JOptionPane.YES_NO_OPTION);
            if(clicDeconnexion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Vous êtes déconnecté !");
                getContent().add(pagePrincipale, listContent[0]);
                cl.show(getContent(), listContent[0]);
            }
        });

        espaceClient.getMesInformations().addActionListener(this::goInformations);

        espaceClient.getConsultationSolde().addActionListener(this::goConsultationSolde);
        espaceClient.getVersement().addActionListener(this::goVersements);
        espaceClient.getRetrait().addActionListener(this::goRetraits);
        espaceClient.getVirement().addActionListener(this::goVirements);
        espaceClient.getListeOperations().addActionListener(this::goListeOperations);
        espaceClient.getTotalVersement().addActionListener(this::goTotalVersements);
        espaceClient.getTotalRetrait().addActionListener(this::goTotalRetraits);

        // Client va à la page de création compte bancaire
        ClientPrincipal.getCreerUnCompte().addActionListener(e -> {
            getContent().add(new CreationCompteBancaire(), listContent[4]);
            cl.show(getContent(), listContent[4]);
        });

        // Création compte bancaire
        CreationCompteBancaire creationCompteBancaire = new CreationCompteBancaire();

        CreationCompteBancaire.getBOUTON_VALIDER().addActionListener(e ->{
            CompteController.nouveauCompteBancaire();
            try {
                getContent().add(new ClientPrincipal(), listContent[3]);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            cl.show(getContent(), listContent[3]);
        });

        creationCompteBancaire.getBOUTON_ANNULER().addActionListener(this::confirmAnnulationCompteBancaire);

        // Va à la page liste des comptes
        ClientPrincipal.getListeDesComptes().addActionListener(e -> {
            getContent().add(new ListeDesComptes(), listContent[8]);
            cl.show(getContent(), listContent[8]);
        });

        // Affichage des informations
        Informations informations = new Informations();
        informations.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Affichage de la liste des comptes
        ListeDesComptes listeDesComptes = new ListeDesComptes();
        listeDesComptes.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Consultation du solde d'un compte
        ConsultationSolde consultationSolde = new ConsultationSolde();
        consultationSolde.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Effectuer un versement sur un comtpe
        Versements versements = new Versements();
        versements.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Effectuer un retrait sur un compte
        Retraits retraits = new Retraits();
        retraits.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Effectuer un virement de compte à comtpe
        Virements virements = new Virements();
        virements.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Liste de toutes les opérations effectuées sur les comptes
        ListeOperations listeOperations = new ListeOperations();
        listeOperations.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Total des versements
        TotalVersements totalVersements = new TotalVersements();
        totalVersements.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        // Total des retraits
        TotalRetraits totalRetraits = new TotalRetraits();
        totalRetraits.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceClient);

        /*******************************************************
         * Espace Conseiller
         ******************************************************/
        // Page principale espace conseiller
        ConseillerPrincipal.getDeconnexion().addActionListener(e -> {
            int clicAnnuler = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de voulair vous déconnecter ?", "Confirmation de déconnexion", JOptionPane.YES_NO_OPTION);
            if(clicAnnuler == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(this, "Vous êtes déconnecté !");
                getContent().add(pagePrincipale, listContent[0]);
                cl.show(getContent(), listContent[0]);
            }
        });
        ConseillerPrincipal.getValidationCompteUtil().addActionListener(this::goValidationCompteUtilisateur);
        ConseillerPrincipal.getListeDesComptes().addActionListener(this::goListeDesComptes); // TODO : Voir pour le retour au menu en fonction du type d'utilisateur
        ConseillerPrincipal.getListeDesClients().addActionListener((this::goListeClients));

        // Validation d'un compte utilisateur
        ValiderCompteUtilisateur validerCompteUtilisateur = new ValiderCompteUtilisateur();
        validerCompteUtilisateur.getBOUTON_VALIDER().addActionListener(this::okCompteUtilisateurValide);
        validerCompteUtilisateur.getBOUTON_ANNULER().addActionListener(this::confirmAnnulationValidationCompteUtil);

        // Affiche la liste des clients de la banque
        ListeClients listeClients = new ListeClients();
        listeClients.getBOUTON_RETOUR_MENU().addActionListener(this::goEspaceConseiller);

        // On définit le layout
        getContent().setLayout(cl);

        // On ajoute les cartes à la pile avec un nom pour les retrouver
        getContent().add(pagePrincipale, listContent[0]);
        getContent().add(creationCompteUtilisateur, listContent[2]);
        getContent().add(validerCompteUtilisateur, listContent[6]);
        getContent().add(informations, listContent[7]);
        getContent().add(listeDesComptes, listContent[8]);
        getContent().add(consultationSolde, listContent[9]);
        getContent().add(versements, listContent[10]);
        getContent().add(retraits, listContent[11]);
        getContent().add(virements, listContent[12]);
        getContent().add(listeOperations, listContent[13]);
        getContent().add(totalVersements, listContent[14]);
        getContent().add(totalRetraits, listContent[15]);
        getContent().add(listeClients, listContent[16]);

        this.getContentPane().add(entete, BorderLayout.NORTH);
        this.getContentPane().add(getContent(), BorderLayout.CENTER);
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

    // Liste des clients de la banque
    private void goListeClients(ActionEvent e) {
        cl.show(getContent(), listContent[16]);
    }

    /***************
     *  METHODES
     ***************/

    // Espace client
    private void goEspaceClient(ActionEvent e) {
        cl.show(getContent(), listContent[3]);
    }

    // Demande d'annulation de la création d'un compte bancaire
    private void confirmAnnulationCompteBancaire (ActionEvent e) {
        int clicAnnuler = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de voulair annuler la création d'un compte bancaire ?", "Confirmation d'annulation", JOptionPane.YES_NO_OPTION);
        if(clicAnnuler == JOptionPane.YES_OPTION) {
            cl.show(getContent(), listContent[3]);
        }
    }

    // Affichage des informations
    private void goInformations(ActionEvent e) {
        cl.show(getContent(), listContent[7]);
    }

    // Affichage de la liste des comptes
    private void goListeDesComptes(ActionEvent e) {
        cl.show(getContent(), listContent[8]);
    }

    // Consultation solde
    private void goConsultationSolde(ActionEvent e) {
        cl.show(getContent(), listContent[9]);
    }

    // Versements
    private void goVersements(ActionEvent e) {
        cl.show(getContent(), listContent[10]);
    }

    // Retraits
    private void goRetraits(ActionEvent e) {
        cl.show(getContent(), listContent[11]);
    }

    // Virements
    private void goVirements(ActionEvent e) {
        cl.show(getContent(), listContent[12]);
    }

    // Liste des opérations
    private void goListeOperations(ActionEvent e) {
        cl.show(getContent(), listContent[13]);
    }

    // Total des versements
    private void goTotalVersements(ActionEvent e) {
        cl.show(getContent(), listContent[14]);
    }

    // Total des retraits
    private void goTotalRetraits(ActionEvent e) {
        cl.show(getContent(), listContent[15]);
    }

    private JPanel getContent() {
        return content;
    }

}