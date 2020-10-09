package fr.banque2.data.controller;

import diplo.tools.Tools;
import fr.banque2.data.Banque;
import fr.banque2.data.Menus;
import fr.banque2.data.entity.*;

public class OperationController {
    /**
     * Liste des opérations sur un compte
     */
    public static void listeOperations() {
        Integer id = Connexion.getId();
        System.out.println("*********************************************************" +
                "\nListe des opérations sur le compte" +
                "\n*********************************************************" +
                "\nSaisir le numéro de compte concerné (0 pour annuler)"
        );
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            System.out.println(".:: Annulation de l'opération ::.");
            return;
        }

        System.out.println("Liste des opérations sur le compte n°" + saisiNumeroCompte +
                "\n*************************************************************************************"
        );

        for (Compte compte : Compte.getListeDesComptes()) {
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                if(!Operation.getListeOperations().isEmpty()) {
                    for (Operation operation : Operation.getListeOperations()) {
                        if (saisiNumeroCompte.equals(operation.getNumeroCompteOperation())) {
                            System.out.println(
                                    " - Numéro d'opération : " + operation.getNumeroOperation() +
                                            " - Date : " + operation.getDateOperation() +
                                            " - Type : " + operation.getLibelleOperation() +
                                            " - Montant : " + operation.getMontantOperation() + "€"
                            );
                        }
                    }
                    System.out.println("*************************************************************************************");
                } else {
                    System.out.println("Aucune opération à afficher" +
                            "\n*************************************************************************************"
                    );
                    return;
                }
            }
        }
    }
    // TODO : faire un premier versement car le solde est à 0
    /**
     * Versement sur un compte (courant ou épargne)
     */
    public static void versementSurUnCompte() {
        Integer id = Connexion.getId();

        System.out.println("*********************************************************" +
                "\nVersement sur un compte" +
                "\n*********************************************************"
        );

        System.out.println("Saisir le numéro de compte concerné (0 pour annuler)");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            System.out.println(".:: Annulation de l'opération ::.");
            return;
        }

        System.out.println("Saisir le montant que vous voulez verser sur le compte");
        Integer montantVersement = Tools.askThing(1);

        for(Compte compte : Compte.getListeDesComptes()) {
            int soldeFinalCompte;
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant versé : " + montantVersement + "€" +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                soldeFinalCompte = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinalCompte);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€"
                );

                Integer numeroCompteOperation = compte.getCode();
                Operation operation = new Operation(numeroCompteOperation, Banque.dateDuJour(), "Versement", montantVersement);
                operation.affichageOperation();
                return;
            }
        }
        System.out.println("Le compte n'a pas été trouvé !");
    }
    /**
     * Retrait sur un compte (courant ou épargne)
     */
    public static void retraitSurUnCompte() {
        Integer id = Connexion.getId();

        System.out.println("*********************************************************" +
                "\nRetrait sur un compte" +
                "\n*********************************************************" +
                "\nSaisir le numéro de compte concerné (0 pour annuler)"
        );

        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            System.out.println(".:: Annulation de l'opération ::.");
            return;
        }

        System.out.println("Saisir le montant que vous voulez retirer du compte");
        Integer montantRetrait = Tools.askThing(1);

        for (Compte compte : Compte.getListeDesComptes()) {
            Integer soldeFinal;
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                soldeFinal = compte.getSolde();

                // Retrait sur un compte courant
                if(compte instanceof CompteCourant) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();

                    if((soldeFinal + decouvert) < montantRetrait) {
                        System.out.println("Retrait impossible car la somme demandée de " + montantRetrait +
                                "€ dépasse le solde(" + compte.getSolde() + "€) + le découvert autorisé("+ decouvert +
                                "€) soit : " + (compte.getSolde() + ((CompteCourant) compte).getDecouvert()) + "€");
                        return;
                    }

                    // Retrait sur un compte épargne
                } else if(compte instanceof CompteEpargne) {
                    if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                        soldeFinal = compte.getSolde();

                        if(soldeFinal < montantRetrait) {
                            System.out.println("Retrait impossible car la somme demandée de " + montantRetrait +
                                    "€ dépasse le solde de votre compte soit : " + compte.getSolde() + "€");
                        }
                    }
                }
                soldeFinal -= montantRetrait;
                compte.setSolde(soldeFinal);
                System.out.println("*********************************************************" +
                        "\nSolde de compte après retrait : " + compte.getSolde() + "€" +
                        "\n*********************************************************"
                );

                Integer numeroCompteOperation = compte.getCode();
                Operation operation = new Operation(numeroCompteOperation, Banque.dateDuJour(), "Retrait", montantRetrait);
                operation.affichageOperation();
                return;
            }
        }
        System.out.println("Le compte n'a pas été trouvé !");
    }

    /**
     * Virement de compte à compte
     */
    public static void virement() {
        Integer id = Connexion.getId();
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null, soldeFinalCompteDebiteur = null, soldeFinalCompteCrediteur = null, montantDebit;

        System.out.println("*********************************************************" +
                "\nVirement de compte à compte" +
                "\n*********************************************************" +
                "\nSaisir le numéro de compte à débiter (0 pour annuler)"
        );

        // Compte débiteur
        Integer compteDebit = Tools.askThing(1);

        if(compteDebit == 0) {
            System.out.println(".:: Annulation de l'opération ::.");
            return;
        }

        System.out.println("Saisir le montant à débiter");
        montantDebit = Tools.askThing(1);

        //TODO : Tester pour ne pas faire un virement sur notre propre compte

        for(Compte compte : Compte.getListeDesComptes()){
            if(compteDebit.equals(compte.getCode()) && compte.getTitulaire().equals(id)){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
                if(compte instanceof CompteCourant) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();
                    if((soldeCompteDebiteur + decouvert) < montantDebit) {
                        System.out.println(
                        "Virement impossible car la somme demandée de " + montantDebit + "€ dépasse le solde(" + soldeCompteDebiteur + "€) + le découvert autorisé("+ decouvert +"€) soit : " + (soldeCompteDebiteur + decouvert + "€"));
                        return;
                    }
                } else if(compte instanceof CompteEpargne) {
                    if(soldeCompteDebiteur < montantDebit) {
                        System.out.println(
                        "Virement impossible car la somme demandée de " + montantDebit + "€ dépasse le solde de votre compte soit : " + soldeCompteDebiteur + "€");
                        return;
                    }
                }
                soldeFinalCompteDebiteur = soldeCompteDebiteur - montantDebit;
                compte.setSolde(soldeFinalCompteDebiteur);

                Operation operation = new Operation(compteDebit, Banque.dateDuJour(), "Virement sur un compte", montantDebit);
                operation.affichageOperation();
            }
        }

        System.out.println(
                "*******************************************************************************" +
                        "\nCompte débiteur : " + compteDebit + " - Solde avant traitement : " + soldeCompteDebiteur + "€" + " - Solde après traitement : " + soldeFinalCompteDebiteur + "€" +
                        "\n*******************************************************************************"
        );

        // Compte créditeur
        System.out.println("Saisir le numéro de compte à créditer");
        Integer compteCredit = Tools.askThing(1);

        for(Compte compte : Compte.getListeDesComptes()) {
            if(compteCredit.equals(compte.getCode()) && !compteCredit.equals(compteDebit)){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();

                soldeFinalCompteCrediteur = soldeCompteCrediteur + montantDebit;

                compte.setSolde(soldeFinalCompteCrediteur);

                Operation operation = new Operation(compteCredit, Banque.dateDuJour(), "Versement", montantDebit);
                operation.affichageOperation();
            } else {
                System.out.println("Vous ne pouvez virer de l'argent sur votre propre compte ! L'opération a été annulé.");
                Menus.menuClient();
            }
        }

        System.out.println(
                "*******************************************************************************" +
                        "\nCompte créditeur : " + compteCredit + " - Solde avant traitement : " + soldeCompteCrediteur + "€" + " - Solde après traitement : " + soldeFinalCompteCrediteur + "€" +
                        "\n*******************************************************************************"
        );
    }
}
