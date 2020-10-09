package fr.banque2.data.entity;

import fr.banque2.data.Menus;

import java.io.Serializable;
import java.util.ArrayList;

public class Utilisateurs implements Serializable {
    private Integer id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Integer typeUtilisateur;
    private Boolean compteValide;
    private static ArrayList<Utilisateurs> listeDesUtilisateurs = new ArrayList<>();

    public Utilisateurs(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur, Boolean compteValide) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.typeUtilisateur = typeUtilisateur;
        this.compteValide = compteValide;
        listeDesUtilisateurs.add(this);
    }

    public void afficheRecapCreationUtilisateur() {
        System.out.println(
        "Récapitulatif de la création de l'utilisateur :" +
                "\n-----------------------------------------------" +
                "\nIdentifiant : " + this.getId() +
                "\nNom : " + this.getNom() +
                "\nPrénom : " + this.getPrenom() +
                "\nMot de passe : " + this.getMotDePasse().substring(0, 2) + "***" +
                "\nType d'utilisateur : " + (this.typeUtilisateur == 1 ? "Client" : "Conseiller")
        );
        System.out.println(
        "*********************************************************" +
                "\nL'utilisateur a bien été créé !" +
                "\n*********************************************************");
        Menus.menuAuthOuCreer(typeUtilisateur);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public static ArrayList<Utilisateurs> getListeDesUtilisateurs() {
        return listeDesUtilisateurs;
    }

    public Boolean getCompteValide() {
        return compteValide;
    }

    public void setCompteValide(Boolean compteValide) {
        this.compteValide = compteValide;
    }
}
