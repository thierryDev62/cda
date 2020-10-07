package fr.banque2.data.controller;

import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.Menus;
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

            try {
                FileInputStream fis = new FileInputStream("src/fr/banque2/data/donnees/clients.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Client> listeDesClients = (ArrayList<Client>) ois.readObject();
                ois.close();

                listeDesClients.add(new Client(id, nom, prenom, mdp, typeUtilisateur, false)); // TODO : mettre à true pour les tests

                try {
                    FileOutputStream fos = new FileOutputStream("src/fr/banque2/data/donnees/clients.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(listeDesClients);
                    oos.close();
                    System.out.println("Les données utilisateur ont bien été sauvegardé !");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else if(typeUtilisateur == 2) {
            ArrayList<Conseiller> nouveauConseiller = Conseiller.getListeDesConseillers();

            nouveauConseiller.add(new Conseiller(id, nom, prenom, mdp, typeUtilisateur, true));

            try {
                FileOutputStream fos = new FileOutputStream("src/fr/banque2/data/donnees/conseillers.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(nouveauConseiller);
                oos.close();
                System.out.println("Les données utilisateur ont bien été sauvegardé !");

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        Menus.menuAuthOuCreer(typeUtilisateur);
    }
}
