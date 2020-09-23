package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Utilisateurs {
    private Integer id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Integer typeUtilisateur; // 1 - Client | 2 - Conseiller
    private static ArrayList<Utilisateurs> listeDesUtilisateurs = new ArrayList<>();

    public Utilisateurs(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.typeUtilisateur = typeUtilisateur;
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

        //Utilisateurs nouvelUtilisateur = new Utilisateurs(id, nom, prenom, mdp, typeUtilisateur);
        String nomDuTypeUtilisateur = "";

        if(typeUtilisateur == 1) {
            Utilisateurs nouveauClient = new Client(id, nom, prenom, mdp, typeUtilisateur);
            nomDuTypeUtilisateur = "Client";
            TConsole.toprintln("Récapitulatif de la création de l'utilisateur :" +
                    "\nIdentifiant : " + nouveauClient.getId() +
                    "\nNom : " + nouveauClient.getNom() +
                    "\nPrénom : " + nouveauClient.getPrenom() +
                    "\nMot de passe : " + nouveauClient.getMotDePasse().substring(0, 2) + "***" +
                    "\nType d'utilisateur : " + nomDuTypeUtilisateur
            );
            TConsole.toprintln("*********************************************************" +
                    "\nL'utilisateur a bien été créé !" +
                    "\n*********************************************************");
            Menus.menuAuthOuCreer(typeUtilisateur);
        } else if(typeUtilisateur == 2) {
            Utilisateurs nouveauConseiller = new Conseiller(id, nom, prenom, mdp, typeUtilisateur);
            nomDuTypeUtilisateur = "Conseiller";
            TConsole.toprintln("Récapitulatif de la création de l'utilisateur :" +
                    "\nIdentifiant : " + nouveauConseiller.getId() +
                    "\nNom : " + nouveauConseiller.getNom() +
                    "\nPrénom : " + nouveauConseiller.getPrenom() +
                    "\nMot de passe : " + nouveauConseiller.getMotDePasse().substring(0, 2) + "***" +
                    "\nType d'utilisateur : " + nomDuTypeUtilisateur
            );
            TConsole.toprintln("*********************************************************" +
                    "\nL'utilisateur a bien été créé !" +
                    "\n*********************************************************");
            Menus.menuAuthOuCreer(typeUtilisateur);
        }
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

    public Integer getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(Integer typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public static ArrayList<Utilisateurs> getListeDesUtilisateurs() {
        return listeDesUtilisateurs;
    }

    public static void setListeDesUtilisateurs(ArrayList<Utilisateurs> listeDesUtilisateurs) {
        Utilisateurs.listeDesUtilisateurs = listeDesUtilisateurs;
    }
}
