package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class Menus {
    private static Integer choixTypeUtilisateur;

    public static void menuClient() {
        TConsole.toprintln("Faites votre choix :" +
                "\n1 - Créer un compte | " +
                "2 - Versement | " +
                "3 - Retrait | " +
                "4 - Virement de compte à compte | " +
                "5 - Consultation solde | " +
                "6 - Liste des opérations effectuées | " +
                "7 - Total des versements | " +
                "8 - Total des retraits | " +
                "9 - Liste de tous les comptes | " +
                "0 - Se déconnecter"
        );
        TConsole.toprint(">");
        int choix = Tools.askThing(1);

        switch(choix) {
            case 1:
                Compte.creationNouveauCompte();
                menuClient();
                break;
            case 2:
                Operation.versementSurUnCompte();
                menuClient();
                break;
            case 3:
                Operation.retraitSurUnCompte();
                menuClient();
                break;
            case 4:
                Operation.virement();
                menuClient();
                break;
            case 5:
                Compte.consultationSolde();
                menuClient();
                break;
            case 6:
                Compte.listeOperations();
                menuClient();
                break;
            case 7:
                Compte.totalVersements();
                menuClient();
                break;
            case 8:
                Compte.totalRetraits();
                menuClient();
                break;
            case 9:
                Compte.listeTousLesComptes(1);
                menuClient();
                break;
            case 0:
                menuTypeUtilisateur();
            default:
                TConsole.toprintln("Veuillez saisir un chiffre de 1 à 10");
                menuClient();
                break;
        }
    }
    public static void menuConseiller(){
        TConsole.toprintln("Faites votre choix :" +
                " | 1 - Valider un compte utilisateur" +
                " | 2 - Voir la liste des comptes" +
                " | 3 - Voir la liste des comptes utilisateur" +
                " | 0 - Se déconnecter"
        );
        Integer choixMenuConseiller = Tools.askThing(1);
        switch(choixMenuConseiller) {
            case 1:
                Conseiller.validationCompteUtilisateur();
                break;
            case 2:
                Compte.listeTousLesComptes(2);
                break;
            case 3:
                Conseiller.listeDesClients();
                break;
            case 0:
                menuTypeUtilisateur();
                break;
            default:
                TConsole.toprintln("Vous n'avez pas saisi le bon numéro !");
                menuConseiller();
                break;
        }
    }

    public static void menuTypeUtilisateur() {
        TConsole.toprintln("Êtes-vous : 1 - Client | 2 - Conseiller");
        Integer type = Tools.askThing(1);
        switch(type){
            case 1:
                menuAuthOuCreer(1);
                break;
            case 2:
                menuAuthOuCreer(2);
                break;
            default:
                TConsole.toprintln("Vous devez saisir 1 ou 2");
                menuTypeUtilisateur();
                break;
        }
    }
    public static void menuAuthOuCreer(Integer type) {
        TConsole.toprintln("Voulez-vous : 1 - Vous authentifier | 2 - Créer un compte utilisateur | 0 - Se déconnecter");
        Integer choix = Tools.askThing(1);
        switch (choix) {
            case 1:
                Connexion.login(type);
                break;
            case 2:
                Utilisateurs.creationUtilisateur(type);
                break;
            case 0:
                menuTypeUtilisateur();
                break;
            default:
                TConsole.toprintln("Vous devez saisir 1, 2 ou 0");
                menuAuthOuCreer(type);
                break;
        }
    }

    public static Integer getChoixTypeUtilisateur() {
        return choixTypeUtilisateur;
    }

    public static void setChoixTypeUtilisateur(Integer choixTypeUtilisateur) {
        Menus.choixTypeUtilisateur = choixTypeUtilisateur;
    }
}
