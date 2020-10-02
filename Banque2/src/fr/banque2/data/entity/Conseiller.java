package fr.banque2.data.entity;

import java.util.ArrayList;

public class Conseiller extends Utilisateurs {
    private static ArrayList<Conseiller> listeDesClients = new ArrayList<>();

    public Conseiller(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur, Boolean compteValide) {
        super(id, nom, prenom, motDePasse, typeUtilisateur, compteValide);
        listeDesClients.add(this);
    }

    public static ArrayList<Conseiller> getListeDesClients() {
        return listeDesClients;
    }

    public static void setListeDesClients(ArrayList<Conseiller> listeDesClients) {
        Conseiller.listeDesClients = listeDesClients;
    }
}
