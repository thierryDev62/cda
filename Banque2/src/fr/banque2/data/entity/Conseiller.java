package fr.banque2.data.entity;

import java.util.ArrayList;

public class Conseiller extends Utilisateurs {
    private static ArrayList<Conseiller> listeDesConseillers = new ArrayList<>();

    public Conseiller(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur, Boolean compteValide) {
        super(id, nom, prenom, motDePasse, typeUtilisateur, compteValide);
    }

    public static ArrayList<Conseiller> getListeDesConseillers() {
        return listeDesConseillers;
    }

    public static void setListeDesConseillers(ArrayList<Conseiller> listeDesConseillers) {
        Conseiller.listeDesConseillers = listeDesConseillers;
    }
}
