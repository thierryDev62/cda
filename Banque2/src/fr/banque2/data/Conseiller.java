package fr.banque2.data;

import diplo.tools.TConsole;

import java.util.ArrayList;

public class Conseiller extends Utilisateurs{
    private static ArrayList<Conseiller> listeDesClients = new ArrayList<>();

    public Conseiller(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur) {
        super(id, nom, prenom, motDePasse, typeUtilisateur);
        listeDesClients.add(this);
    }

    public static void listeDesClients() {
        for(Utilisateurs client : Client.getListeDesUtilisateurs()) {
            TConsole.toprintln("Id : " + client.getId() +
                    " | Nom : " + client.getNom() +
                    " | Prenom : " + client.getPrenom()
            );
        }
        Menus.menuConseiller();
    }

    public static ArrayList<Conseiller> getListeDesClients() {
        return listeDesClients;
    }

    public static void setListeDesClients(ArrayList<Conseiller> listeDesClients) {
        Conseiller.listeDesClients = listeDesClients;
    }

}
