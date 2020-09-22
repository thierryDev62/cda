package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.Scanner;

public class Menus {
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
                "10 - Se déconnecter"
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
                Compte.listeTousLesComptes();
                menuClient();
                break;
            case 10:
                menuTypeUtilisateur();
            default:
                TConsole.toprintln("Veuillez saisir un chiffre de 1 à 10");
                menuClient();
                break;
        }
    }
    public static void menuConseiller(){
        TConsole.toprintln("Faites votre choix :" +
                "\n1 - Valider un compte" +
                "\n2 - Voir la liste des clients" +
                "\n3 - Se déconnecter"
        );
        Integer choixMenuConseiller = Tools.askThing(1);
        switch(choixMenuConseiller) {
            case 1:
                break;
            case 2:
                Conseiller.listeDesClients();
                break;
            case 3:
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
        int type = Tools.askThing(1);
        if (type == 1) {
            menuAuthOuCreer();
        } else if (type == 2){
            Utilisateurs.login();
            menuConseiller();
        }
    }
    public static void menuAuthOuCreer() {
        TConsole.toprintln("Voulez-vous : 1 - Vous authentifier | 2 - Créer un compte utilisateur | 3 - Se déconnecter");
        int choix = Tools.askThing(1);
        if(choix == 1) {
            Utilisateurs.login();
        } else if(choix == 2) {
            Utilisateurs.creationUtilisateur();
        } else if(choix == 3) {
            menuTypeUtilisateur();
        }
    }
}
