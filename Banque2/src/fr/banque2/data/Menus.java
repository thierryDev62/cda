package fr.banque2.data;

import fr.banque2.data.controller.CompteController;
import fr.banque2.data.controller.ConseillerController;
import fr.banque2.data.controller.OperationController;
import fr.banque2.data.controller.UtilisateursController;
import fr.banque2.data.entity.Connexion;

import java.util.Scanner;

public class Menus {

    public static void menuClient() {
        System.out.println("*********************************************************" +
                "\nMenu client" +
                "\n*********************************************************");
        System.out.println("Faites votre choix :" +
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
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();

        switch(choix) {
            case 1:
                CompteController.nouveauCompte();
                menuClient();
                break;
            case 2:
                OperationController.versementSurUnCompte();
                menuClient();
                break;
            case 3:
                OperationController.retraitSurUnCompte();
                menuClient();
                break;
            case 4:
                OperationController.virement();
                menuClient();
                break;
            case 5:
                CompteController.consultationSolde();
                menuClient();
                break;
            case 6:
                OperationController.listeOperations();
                menuClient();
                break;
            case 7:
                CompteController.totalVersements();
                menuClient();
                break;
            case 8:
                CompteController.totalRetraits();
                menuClient();
                break;
            case 9:
                CompteController.listeTousLesComptes(1);
                menuClient();
                break;
            case 0:
                menuTypeUtilisateur();
            default:
                System.out.println("Veuillez saisir un chiffre de 1 à 9 ou 0");
                menuClient();
                break;
        }
    }
    public static void menuConseiller(){
        System.out.println("*********************************************************" +
                "\nMenu conseiller" +
                "\n*********************************************************");
        System.out.println(
                "Faites votre choix :" +
                " | 1 - Valider un compte utilisateur" +
                " | 2 - Voir la liste des comptes" +
                " | 3 - Voir la liste des clients" +
                " | 0 - Se déconnecter"
        );
        Scanner sc = new Scanner(System.in);
        int choixMenuConseiller = sc.nextInt();
        switch(choixMenuConseiller) {
            case 1:
                ConseillerController.validationCompteUtilisateur();
                break;
            case 2:
                CompteController.listeTousLesComptes(2);
                break;
            case 3:
                ConseillerController.listeDesClients();
                break;
            case 0:
                menuTypeUtilisateur();
                break;
            default:
                System.out.println("Vous n'avez pas saisi le bon numéro !");
                menuConseiller();
                break;
        }
    }

    public static void menuTypeUtilisateur() {
        System.out.println("*********************************************************" +
                "\nMenu utilisateur" +
                "\n*********************************************************");
        System.out.println("Êtes-vous : 1 - Client | 2 - Conseiller");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        switch(type){
            case 1:
                menuAuthOuCreer(1);
                break;
            case 2:
                menuAuthOuCreer(2);
                break;
            default:
                System.out.println("Vous devez saisir 1 ou 2");
                menuTypeUtilisateur();
                break;
        }
    }
    public static void menuAuthOuCreer(Integer type) {
        System.out.println("Voulez-vous : 1 - Vous authentifier | 2 - Créer un compte utilisateur | 0 - Se déconnecter");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                Connexion.login(type);
                break;
            case 2:
                UtilisateursController.creationUtilisateur(type);
                break;
            case 0:
                menuTypeUtilisateur();
                break;
            default:
                System.out.println("Vous devez saisir 1, 2 ou 0");
                menuAuthOuCreer(type);
                break;
        }
    }
}
