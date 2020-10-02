package fr.banque2.data.controller;

import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.*;
import fr.banque2.data.entity.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CompteController {
    /**
     * Creation compte
     */
    public static void nouveauCompte(){
        Integer id = Connexion.getId();
        for(Utilisateurs utilisateurCourant : Client.getListeDesUtilisateurs()) {
            if(id.equals(utilisateurCourant.getId()) && utilisateurCourant.getCompteValide()) {
                System.out.println("*********************************************************" +
                        "\nMenu de création d'un nouveau compte bancaire" +
                        "\n*********************************************************" +
                        "\nQuel type de compte voulez-vous créer ? \n1 - Compte courant | 2 - Compte épargne" +
                        "\n>"
                );
                Scanner sc = new Scanner(System.in);
                int choix = sc.nextInt();
                System.out.println("*********************************************************" +
                        "\nCréation d'un compte bancaire" +
                        "\n*********************************************************" +
                        "\nSaisir le numéro de compte" +
                        "\n>"
                );
                Integer numeroCompte = Tools.askThing(1);

                for (Compte liste : Compte.getListeDesComptes()) {
                    if (numeroCompte.equals(liste.getCode())) {
                        TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                        nouveauCompte();
                        return;
                    }
                }
                if (choix == 1) {
                   Compte nouveauCompte = new CompteCourant(numeroCompte, 1, id);
                    nouveauCompte.afficheCreationCompte();
                } else if (choix == 2) {
                    Compte nouveauCompte = new CompteEpargne(numeroCompte, 2, id);
                    nouveauCompte.afficheCreationCompte();
                }
            } else {
                ConseillerController.pasMoyen();
            }
        }
    }
    /**
     * Liste de tous les comptes d'un client connecté ou vu par le conseiller
     */
    public static void listeTousLesComptes(Integer type) {
        Integer id = Connexion.getId();
        String typeCompte = "", afficheDecouvertOuTaux = "";
        Integer decouvert, tauxInteret;
        ArrayList<Compte> listeTousLesCompte = new ArrayList<>();
        TConsole.toprintln("*********************************************************" +
                "\nListe des tous les comptes" +
                "\n*********************************************************"
        );
        if(!Compte.getListeDesComptes().isEmpty()) {
            for (Compte compte : Compte.getListeDesComptes()) {
                if (compte.getTitulaire().equals(id)) {
                    listeTousLesCompte.add(compte);
                } else if (type == 2) {
                    listeTousLesCompte.add(compte);
                }
            }
            for(Compte listeFinale : listeTousLesCompte) {
                if (listeFinale instanceof CompteCourant) {
                    decouvert = ((CompteCourant) listeFinale).getDecouvert();
                    typeCompte = "Compte courant : ";
                    afficheDecouvertOuTaux = "€ | Découvert autorisé : " + decouvert + "€";

                } else if (listeFinale instanceof CompteEpargne) {
                    tauxInteret = ((CompteEpargne) listeFinale).getTauxInteret();
                    typeCompte = "Compte épargne : ";
                    afficheDecouvertOuTaux = "€ | Taux d'interêt : " + tauxInteret + "%";
                }
                System.out.println(typeCompte +
                        "- Numéro de compte : " + listeFinale.getCode() +
                        " | Solde : " + listeFinale.getSolde() +
                        afficheDecouvertOuTaux +
                        "\n*********************************************************"
                );
            }
            if(type == 2) {
                Menus.menuConseiller();
            }
        } else {
            TConsole.toprintln("Aucun compte de créé !");
            if(type == 2) {
                Menus.menuConseiller();
            } else if(type == 1) {
                Menus.menuClient();
            }
        }
    }
    /**
     * Consultation du solde d'un compte
     */
    public static void consultationSolde() {
        Integer id = Connexion.getId();
        TConsole.toprintln("*********************************************************" +
                "\nConsultation du solde d'un compte" +
                "\n*********************************************************"
        );

        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
        }

        for (Compte compte : Compte.getListeDesComptes()) {
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                if(!Compte.getListeDesComptes().isEmpty()) {
                    System.out.println("Numéro de compte : " +
                            compte.getCode() +
                            "\n*********************************************************" +
                            "\nSolde du compte : " + compte.getSolde() + "€" +
                            "\n*********************************************************"
                    );
                    return;
                } else {
                    TConsole.toprintln("Aucun compte a afficher");
                }
            } else {
                TConsole.toprintln("Aucun compte avec ce numéro");
            }
        }
    }
    /**
     * Total des versements
     */
    public static void totalVersements() {
        Integer id = Connexion.getId();
        TConsole.toprintln("*********************************************************" +
                "\nTotal des versements" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalVersement = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for (Compte compte : Compte.getListeDesComptes()) {
            for (Operation versement : Operation.getListeOperations()) {
                if (saisiNumeroCompte.equals(compte.getCode()) && saisiNumeroCompte.equals(versement.getNumeroCompteOperation()) && versement.getLibelleOperation().equals("Versement") && compte.getTitulaire().equals(id)) {
                    totalVersement += versement.getMontantOperation();
                }
            }
        }
        TConsole.toprintln("Montant total des versements : " + totalVersement + "€");
    }
    /**
     * Total des retraits
     */
    public static void totalRetraits() {
        Integer id = Connexion.getId();
        TConsole.toprintln("*********************************************************" +
                "\nTotal des retraits" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalRetrait = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for (Compte compte : Compte.getListeDesComptes()) {
            for (Operation retrait : Operation.getListeOperations()) {
                if (saisiNumeroCompte.equals(compte.getCode()) && saisiNumeroCompte.equals(retrait.getNumeroCompteOperation()) && retrait.getLibelleOperation().equals("Retrait") && compte.getTitulaire().equals(id)){
                    totalRetrait += retrait.getMontantOperation();
                }
            }
        }
        TConsole.toprintln("Montant total des retraits : " + totalRetrait + "€");
    }
}
