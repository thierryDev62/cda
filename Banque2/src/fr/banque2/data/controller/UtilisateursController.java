package fr.banque2.data.controller;

import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.Menus;
import fr.banque2.data.entity.Utilisateurs;
import fr.banque2.data.entity.Client;
import fr.banque2.data.entity.Conseiller;

public class UtilisateursController {
    public static void creationUtilisateur(Integer typeUtilisateur) {
        TConsole.toprintln("*********************************************************" +
                "\nCréation d'un compte utilisateur" +
                "\n*********************************************************");

        TConsole.toprintln("Saisir le numéro d'identifiant : ");
        Integer id = Tools.askThing(1);
        for(Utilisateurs chercherId : Utilisateurs.getListeDesUtilisateurs()) {
            if(id.equals(chercherId.getId())){
                TConsole.toprintln("Ce numéro d'identifiant existe déjà, veuillez en saisir un autre !!!");
                creationUtilisateur(typeUtilisateur);
            }
        }
        TConsole.toprintln("Saisir le nom");
        String nom = Tools.askThing();
        TConsole.toprintln("Saisir le prénom");
        String prenom = Tools.askThing();
        TConsole.toprintln("Saisir le mot de passe");
        String mdp = Tools.askThing();

        if(typeUtilisateur == 1) {
            Utilisateurs nouveauUtilisateur = new Client(id, nom, prenom, mdp, typeUtilisateur, false); // TODO : mettre à true pour les tests
            nouveauUtilisateur.afficheRecapCreationUtilisateur();

        } else if(typeUtilisateur == 2) {
            Utilisateurs nouveauUtilisateur = new Conseiller(id, nom, prenom, mdp, typeUtilisateur, true);
            nouveauUtilisateur.afficheRecapCreationUtilisateur();

        }

        /*TConsole.toprintln("Récapitulatif de la création de l'utilisateur :" +
                "\n-----------------------------------------------" +
                "\nIdentifiant : " + nouveauUtilisateur.getId() +
                "\nNom : " + nouveauUtilisateur.getNom() +
                "\nPrénom : " + nouveauUtilisateur.getPrenom() +
                "\nMot de passe : " + nouveauUtilisateur.getMotDePasse().substring(0, 2) + "***" +
                "\nType d'utilisateur : " + nomDuTypeUtilisateur
        );
        TConsole.toprintln("*********************************************************" +
                "\nL'utilisateur a bien été créé !" +
                "\n*********************************************************");*/
        Menus.menuAuthOuCreer(typeUtilisateur);

    }
}
