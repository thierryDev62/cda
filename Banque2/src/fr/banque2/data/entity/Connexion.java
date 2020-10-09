package fr.banque2.data.entity;

import diplo.tools.Tools;
import fr.banque2.data.Menus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Connexion {
    private static Integer id;
    private static String motDePasse;

    public Connexion(Integer id, String motDePasse) {
        Connexion.id = id;
        Connexion.motDePasse = motDePasse;
    }

    public static void login(Integer type) {
        System.out.println("*********************************************************" +
                "\nConnexion à votre compte utilisateur (0 pour annuler)" +
                "\n*********************************************************");
        System.out.println("Saisir votre identifiant :");
        Integer identifiant = Tools.askThing(1);
        if(identifiant == 0) {
            System.out.println("Annulation");
            Menus.menuAuthOuCreer(type);
        }
        System.out.println("Saisir votre mot de passe :");
        String motdepasse = Tools.askThing();

        if(type == 1) {
            try {
                FileInputStream fis = new FileInputStream("src/fr/banque2/data/donnees/clients.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Client> listeClients = (ArrayList<Client>) ois.readObject();
                ois.close();

                for (Client client : listeClients) {
                    if (identifiant.equals(client.getId()) && motdepasse.equals(client.getMotDePasse())) {
                        System.out.println("Vous êtes connecté ! \nBienvenue à vous " + client.getPrenom());
                        Connexion login = new Connexion(identifiant, motdepasse);
                        Menus.menuClient();
                    }
                }
                System.out.println("Le mot de passe et/ou l'identifiant ne sont pas bon, veuillez recommencer !");
                login(type);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if(type == 2) {
            try {
                FileInputStream fis = new FileInputStream("src/fr/banque2/data/donnees/conseillers.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Conseiller> listeClients = (ArrayList<Conseiller>) ois.readObject();
                ois.close();

                for (Conseiller conseiller : listeClients) {
                    if (identifiant.equals(conseiller.getId()) && motdepasse.equals(conseiller.getMotDePasse())) {
                        System.out.println("Vous êtes connecté ! \nBienvenue à vous " + conseiller.getPrenom());
                        Connexion login = new Connexion(identifiant, motdepasse);
                        Menus.menuConseiller();
                    }
                }
                System.out.println("Le mot de passe et/ou l'identifiant ne sont pas bon, veuillez recommencer !");
                login(type);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Connexion.id = id;
    }

    public static String getMotDePasse() {
        return motDePasse;
    }

    public static void setMotDePasse(String motDePasse) {
        Connexion.motDePasse = motDePasse;
    }
}
