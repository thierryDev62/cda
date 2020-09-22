package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Utilisateurs {
    private Integer id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private static ArrayList<Utilisateurs> listeDesUtilisateurs = new ArrayList<>();

    public Utilisateurs(Integer id, String nom, String prenom, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        listeDesUtilisateurs.add(this);
    }

    public static void creationUtilisateur() {
        TConsole.toprintln("Création d'un compte utilisateur");

        TConsole.toprintln("Saisir le numéro d'identifiant : ");
        Integer id = Tools.askThing(1);
        for(Utilisateurs chercherId : Utilisateurs.getListeDesUtilisateurs()) {
            if(id.equals(chercherId.getId())){
                TConsole.toprintln("Ce numéro d'identifiant existe déjà, veuillez en saisir un autre !!!");
                creationUtilisateur();
            }
        }
        TConsole.toprintln("Saisir le nom :");
        String nom = Tools.askThing();
        TConsole.toprintln("Saisir le prénom");
        String prenom = Tools.askThing();
        TConsole.toprintln("Saisir le mot de passe");
        String mdp = Tools.askThing();

        Utilisateurs nouvelUtilisateur = new Utilisateurs(id, nom, prenom, mdp);




        TConsole.toprintln("L'utilisateur a bien été créé !");
        Menus.menuAuthOuCreer();
    }
    public static void login() {
        TConsole.toprintln("Connexion");
        TConsole.toprintln("Saisir votre identifiant :");
        Integer identifiant = Tools.askThing(1);
        TConsole.toprintln("Saisir votre mot de passe :");
        String motdepasse = Tools.askThing();


        //TODO : ici
        Connexion login = new Connexion(identifiant, motdepasse );
        TConsole.toprintln("Vous êtes connecté !");

        Menus.menuClient();

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public static void setListeDesUtilisateurs(ArrayList<Utilisateurs> listeDesUtilisateurs) {
        Utilisateurs.listeDesUtilisateurs = listeDesUtilisateurs;
    }
}
