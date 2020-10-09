package fr.banque2.data.controller;

import diplo.tools.Tools;
import fr.banque2.data.Banque;
import fr.banque2.data.entity.Client;
import fr.banque2.data.Menus;

import java.io.*;
import java.util.ArrayList;

public class ConseillerController {
    /**
     * Validation d'un compte utilisateur pas un conseiller
     */

    public static void validationCompteUtilisateur() {
        System.out.println("*********************************************************" +
                "\nValidation d'un compte" +
                "\n*********************************************************");
        try
        {
            FileInputStream fis = new FileInputStream("src/fr/banque2/data/donnees/clients.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Client> listeClients = (ArrayList<Client>) ois.readObject();
            ois.close();

            System.out.println("Liste des clients en attente de validation :" +
                    "\n*********************************************************");
            for(Client clientAttenteValidation : listeClients) {
                if(!clientAttenteValidation.getCompteValide()) {
                    System.out.println(
                            "ID : " + clientAttenteValidation.getId() +
                                    " - Nom : " + clientAttenteValidation.getNom() +
                                    " - Prenom : " + clientAttenteValidation.getPrenom()
                    );
                }
            }
            System.out.println("Numéro d'utilisateur à valider : ");
            Integer numeroUtilisateur = Tools.askThing(1);

            for(Client client : listeClients) {
                if(numeroUtilisateur.equals(client.getId()) && !client.getCompteValide()){ // !client.getCompteValide() pour de vrai
                    client.setCompteValide(true); // true pour de vrai
                    System.out.println("Le compte utilisateur n°" + client.getId() + " de " + client.getNom() + " " + client.getPrenom() + " a bien été validé !");
                    Banque.sauvegardeClient(listeClients);
                    Menus.menuConseiller();
                }
            }
            System.out.println("Pas de compte à valider avec ce numéro");
            Menus.menuConseiller();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Liste des clients de la banque
     */
    public static void listeDesClients() {
        System.out.println("*********************************************************" +
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
                                " - Mot de passe (juste pour mémoire) : " + client.getMotDePasse() +
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
        System.out.println(
                "**********************************************************************" +
                        "\nVous n'êtes pas autorisé à créer un compte (ou faire une opération) " +
                        "\ncar celui-ci n'a pas été validé par un conseiller !" +
                        "\n**********************************************************************"
        );
    }
}
