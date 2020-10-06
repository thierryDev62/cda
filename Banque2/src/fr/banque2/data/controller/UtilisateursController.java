package fr.banque2.data.controller;

import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.Menus;
import fr.banque2.data.entity.Sauvegarde;
import fr.banque2.data.entity.Utilisateurs;
import fr.banque2.data.entity.Client;
import fr.banque2.data.entity.Conseiller;

import java.io.*;
import java.util.ArrayList;

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

            ArrayList<Client> nouveauClient = Client.getListeDesClients();

            nouveauClient.add(new Client(id, nom, prenom, mdp, typeUtilisateur, true));

            try {
                FileOutputStream fos = new FileOutputStream("src/fr/banque2/data/donnees/clients.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(nouveauClient);
                oos.close();
                System.out.println("Les données utilisateur ont bien été sauvegardé !");

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if(typeUtilisateur == 2) {
            Utilisateurs nouveauUtilisateur = new Conseiller(id, nom, prenom, mdp, typeUtilisateur, true);
            nouveauUtilisateur.afficheRecapCreationUtilisateur();

        }
        Menus.menuAuthOuCreer(typeUtilisateur);
    }
    public static void lire() {
        try {
            FileInputStream fis = new FileInputStream("utilisateurs.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Utilisateurs> listeUtil = (ArrayList<Utilisateurs>) ois.readObject();
            ois.close();

            for (Utilisateurs s : listeUtil) {
                System.out.println(
                        "ID : " + s.getId() +
                                "Nom : " + s.getNom() +
                                "Prenom : " + s.getPrenom() +
                                "Mot de passe : " + s.getMotDePasse() +
                                "Compte valide : " + s.getCompteValide()
                );
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
