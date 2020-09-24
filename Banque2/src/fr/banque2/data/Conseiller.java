package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Conseiller extends Utilisateurs{
    private static ArrayList<Conseiller> listeDesClients = new ArrayList<>();

    public Conseiller(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur) {
        super(id, nom, prenom, motDePasse, typeUtilisateur);
        listeDesClients.add(this);
    }

    public static void validationCompte() {
        TConsole.toprintln("*********************************************************" +
                "\nValidation d'un compte" +
                "\n*********************************************************");
        TConsole.toprintln("Numéro de compte à valider : ");
        Integer numeroDeCompteAValider = Tools.askThing(1);
        for(Compte compte : Compte.getListeDesComptes()) {
            if(numeroDeCompteAValider.equals(compte.getCode()) && !compte.getCompteValide()){
                if (compte instanceof CompteCourant) {
                    TConsole.toprintln("Saisir le découvert autorisé : ");
                    Integer decouvert = Tools.askThing(1);
                    ((CompteCourant) compte).setDecouvert(decouvert);

                } else if (compte instanceof CompteEpargne) {
                    TConsole.toprintln("Saisir le taux d'interêt : ");
                    Integer tauxInteret = Tools.askThing(1);
                    ((CompteEpargne) compte).setTauxInteret(tauxInteret);
                }
                compte.setCompteValide(true);
                TConsole.toprintln("Le compte n°" + compte.getCode() + " a bien été validé !");
            } else {
                TConsole.toprintln("Aucun compte à valider ou inexistant");
            }
        }
        Menus.menuConseiller();

    }
    public static void listeDesClients() {
        for(Utilisateurs client : Utilisateurs.getListeDesUtilisateurs()) {
            if(client instanceof Client) {
                TConsole.toprintln("Id : " + client.getId() +
                        " | Nom : " + client.getNom() +
                        " | Prenom : " + client.getPrenom()
                );
            }
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
