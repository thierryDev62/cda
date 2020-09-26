package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Utilisateurs {
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

        String nomDuTypeUtilisateur = "";
        Utilisateurs nouveauUtilisateur = null;

        if(typeUtilisateur == 1) {
            nouveauUtilisateur = new Client(id, nom, prenom, mdp, typeUtilisateur, true); // TODO : mettre à true pour les tests
            nomDuTypeUtilisateur = "Client";

        } else if(typeUtilisateur == 2) {
            nouveauUtilisateur = new Conseiller(id, nom, prenom, mdp, typeUtilisateur, true);
            nomDuTypeUtilisateur = "Conseiller";

        }
        TConsole.toprintln("Récapitulatif de la création de l'utilisateur :" +
                "\n-----------------------------------------------" +
                "\nIdentifiant : " + nouveauUtilisateur.getId() +
                "\nNom : " + nouveauUtilisateur.getNom() +
                "\nPrénom : " + nouveauUtilisateur.getPrenom() +
                "\nMot de passe : " + nouveauUtilisateur.getMotDePasse().substring(0, 2) + "***" +
                "\nType d'utilisateur : " + nomDuTypeUtilisateur
        );
        TConsole.toprintln("*********************************************************" +
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
