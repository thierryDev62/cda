package fr.banque2.data.controller;

import fr.banque2.data.*;
import fr.banque2.data.entity.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CompteController {
    /**
     * Creation compte
     */
    public static void nouveauCompte(){
        Integer id = Connexion.getId();

        try
        {
            FileInputStream fis = new FileInputStream("src/fr/banque2/data/donnees/clients.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Client> listeClients = (ArrayList<Client>) ois.readObject();
            ois.close();

            for(Client utilisateurCourant : listeClients) {
                if(id.equals(utilisateurCourant.getId()) && utilisateurCourant.getCompteValide()) {
                    System.out.println("*********************************************************" +
                            "\nMenu de création d'un nouveau compte bancaire" +
                            "\n*********************************************************" +
                            "\nQuel type de compte voulez-vous créer ? \n1 - Compte courant | 2 - Compte épargne"
                    );
                    Scanner scanChoix = new Scanner(System.in);
                    int choix = scanChoix.nextInt();
                    System.out.println("*********************************************************" +
                            "\nCréation d'un compte bancaire" +
                            "\n*********************************************************" +
                            "\nSaisir le numéro de compte"
                    );
                    Scanner scanNumeroCompte = new Scanner(System.in);
                    int numeroCompte = scanNumeroCompte.nextInt();

                    for (Compte liste : Compte.getListeDesComptes()) {
                        if (numeroCompte == liste.getCode()) {
                            System.out.println("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                            nouveauCompte();
                            return;
                        }
                    }
                    if (choix == 1) {
                        Compte nouveauCompte = new CompteCourant(numeroCompte, 1, id);
                        nouveauCompte.afficheCreationCompte();
                        return;
                    } else if (choix == 2) {
                        Compte nouveauCompte = new CompteEpargne(numeroCompte, 2, id);
                        nouveauCompte.afficheCreationCompte();
                        return;
                    }
                }
            }
            ConseillerController.pasMoyen();
            Menus.menuClient();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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

        System.out.println("*********************************************************" +
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
            System.out.println("Aucun compte de créé !");
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
        System.out.println("*********************************************************" +
                "\nConsultation du solde d'un compte" +
                "\n*********************************************************" +
                "\nSaisir le numéro de compte concerné (0 pour annuler)"
        );
        Scanner scanSaisiNumeroCompte = new Scanner(System.in);
        int saisiNumeroCompte = scanSaisiNumeroCompte.nextInt();

        if(saisiNumeroCompte == 0) {
            System.out.println(".:: Annulation de l'opération ::.");
        }

        for (Compte compte : Compte.getListeDesComptes()) {
            if (saisiNumeroCompte == (compte.getCode()) && compte.getTitulaire().equals(id)) {
                if(!Compte.getListeDesComptes().isEmpty()) {
                    System.out.println("Numéro de compte : " +
                            compte.getCode() +
                            "\n*********************************************************" +
                            "\nSolde du compte : " + compte.getSolde() + "€" +
                            "\n*********************************************************"
                    );
                    return;
                } else {
                    System.out.println("Aucun compte a afficher");
                }
            } else {
                System.out.println("Aucun compte avec ce numéro");
            }
        }
    }
    /**
     * Total des versements
     */
    public static void totalVersements() {
        Integer id = Connexion.getId();
        System.out.println("*********************************************************" +
                "\nTotal des versements" +
                "\n*********************************************************" +
                "\nSaisir le numéro de compte concerné (0 pour annuler)"
        );
        Scanner scanSaisiNumeroCompte = new Scanner(System.in);
        int saisiNumeroCompte = scanSaisiNumeroCompte.nextInt();
        Integer totalVersement = 0;
        System.out.println("Total des versements pour le compte n°" + saisiNumeroCompte);
        for (Compte compte : Compte.getListeDesComptes()) {
            for (Operation versement : Operation.getListeOperations()) {
                if (saisiNumeroCompte == (compte.getCode()) && saisiNumeroCompte == (versement.getNumeroCompteOperation()) && versement.getLibelleOperation().equals("Versement") && compte.getTitulaire().equals(id)) {
                    totalVersement += versement.getMontantOperation();
                }
            }
        }
        System.out.println("Montant total des versements : " + totalVersement + "€");
    }
    /**
     * Total des retraits
     */
    public static void totalRetraits() {
        Integer id = Connexion.getId();
        System.out.println("*********************************************************" +
                "\nTotal des retraits" +
                "\n*********************************************************" +
                "\nSaisir le numéro de compte concerné (0 pour annuler)"
        );
        Scanner scanSaisiNumeroCompte = new Scanner(System.in);
        int saisiNumeroCompte = scanSaisiNumeroCompte.nextInt();
        Integer totalRetrait = 0;
        System.out.println();
        System.out.println("Total des retraits sur le compte n°" + saisiNumeroCompte);
        for (Compte compte : Compte.getListeDesComptes()) {
            for (Operation retrait : Operation.getListeOperations()) {
                if (saisiNumeroCompte == (compte.getCode()) && saisiNumeroCompte == (retrait.getNumeroCompteOperation()) && retrait.getLibelleOperation().equals("Retrait") && compte.getTitulaire().equals(id)){
                    totalRetrait += retrait.getMontantOperation();
                }
            }
        }
        System.out.println("Total des retraits sur le compte n°" + saisiNumeroCompte);
    }
}
