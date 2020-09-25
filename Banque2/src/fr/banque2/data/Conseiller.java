package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Conseiller extends Utilisateurs{
    private static ArrayList<Conseiller> listeDesClients = new ArrayList<>();

    public Conseiller(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur, Boolean compteValide) {
        super(id, nom, prenom, motDePasse, typeUtilisateur, compteValide);
        listeDesClients.add(this);
    }

    /**
     * Validation d'un compte utilisateur pas un conseiller
     */
    public static void validationCompteUtilisateur() {
        TConsole.toprintln("*********************************************************" +
                "\nValidation d'un compte" +
                "\n*********************************************************");
        TConsole.toprintln("Numéro d'utilisateur à valider : ");
        Integer numeroUtilisateur = Tools.askThing(1);
        for(Utilisateurs compteUtilisateur : Client.getListeDesUtilisateurs()) {
            if(numeroUtilisateur.equals(compteUtilisateur.getId()) && !compteUtilisateur.getCompteValide()){
                compteUtilisateur.setCompteValide(true);
                TConsole.toprintln("Le compte utilisateur n°" + compteUtilisateur.getId() + " a bien été validé !");
            } else {
                TConsole.toprintln("Aucun compte à valider ou inexistant");
            }
            Menus.menuConseiller();
        }
    }

    /**
     * Liste des clients de la banque
     */
    public static void listeDesClients() {
        for(Utilisateurs client : Utilisateurs.getListeDesUtilisateurs()) {
            if(client instanceof Client) {
                TConsole.toprintln("Id : " + client.getId() +
                        " | Nom : " + client.getNom() +
                        " | Prenom : " + client.getPrenom() +
                        " | Status du compte : " + (client.getCompteValide() ? "Validé" : "En attente de validation")
                );
            }
        }
        Menus.menuConseiller();
    }

    /**
     * Opération impossible tant que le client n'a pas son compte de validé
     */
    public static void pasMoyen() {
        TConsole.toprintln(
                "**********************************************************************" +
                        "\nVous n'êtes pas autorisé à créer un compte (ou faire une opération) " +
                        "\ncar celui-ci n'a pas été validé par un conseiller !" +
                        "\n**********************************************************************"
        );
    }

    public static ArrayList<Conseiller> getListeDesClients() {
        return listeDesClients;
    }

    public static void setListeDesClients(ArrayList<Conseiller> listeDesClients) {
        Conseiller.listeDesClients = listeDesClients;
    }

}
