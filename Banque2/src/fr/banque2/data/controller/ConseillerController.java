package fr.banque2.data.controller;

import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.entity.Client;
import fr.banque2.data.Menus;
import fr.banque2.data.entity.Utilisateurs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ConseillerController {
    /**
     * Validation d'un compte utilisateur pas un conseiller
     */

    public static void validationCompteUtilisateur() {
        TConsole.toprintln("*********************************************************" +
                "\nValidation d'un compte" +
                "\n*********************************************************");
        TConsole.toprintln("Numéro d'utilisateur à valider : ");
        Integer numeroUtilisateur = Tools.askThing(1);
        for(Utilisateurs compteUtilisateur : Client.getListeDesUtilisateurs()) {
            if(numeroUtilisateur.equals(compteUtilisateur.getId()) && !compteUtilisateur.getCompteValide()){
                compteUtilisateur.setCompteValide(true);
                TConsole.toprintln("Le compte utilisateur n°" + compteUtilisateur.getId() + " a bien été validé !");
            } else {
                TConsole.toprintln("Aucun compte à valider ou inexistant");
            }
            Menus.menuConseiller();
        }
    }

    /**
     * Liste des clients de la banque
     */
    public static void listeDesClients() {
        TConsole.toprintln("*********************************************************" +
                "\nListe des clients de la banque" +
                "\n*********************************************************"
        );
        try
        {
            FileInputStream fis = new FileInputStream("src/fr/banque2/data/donnees/clients.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Client> listeClients = (ArrayList<Client>) ois.readObject();
            ois.close();

            for (Client client : listeClients) {
                System.out.println(
                        "ID : " + client.getId() +
                                " - Nom : " + client.getNom() +
                                " - Prenom : " + client.getPrenom() +
                                " - Mot de passe : " + client.getMotDePasse() +
                                " - Compte valide : " + client.getCompteValide()
                );
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("*********************************************************");
        Menus.menuConseiller();
    }

    /**
     * Opération impossible tant que le client n'a pas son compte de validé
     */
    public static void pasMoyen() {
        TConsole.toprintln(
                "**********************************************************************" +
                        "\nVous n'êtes pas autorisé à créer un compte (ou faire une opération) " +
                        "\ncar celui-ci n'a pas été validé par un conseiller !" +
                        "\n**********************************************************************"
        );
    }
}
