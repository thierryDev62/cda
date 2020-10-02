package fr.banque2.data.controller;

import diplo.tools.TConsole;
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
        TConsole.toprintln("*********************************************************" +
                "\nListe des opérations sur le compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        TConsole.toprintln("Liste des opérations sur le compte n°" + saisiNumeroCompte);
        TConsole.toprintln("*************************************************************************************");
        for (Compte compte : Compte.getListeDesComptes()) {
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
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
                TConsole.toprintln("*************************************************************************************");
            }
        }
    }
    // TODO : faire un premier versement car le solde est à 0
    /**
     * Versement sur un compte (courant ou épargne)
     */
    public static void versementSurUnCompte() {
        Integer id = Connexion.getId();

        TConsole.toprintln("*********************************************************" +
                "\nVersement sur un compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            return;
        }

        TConsole.toprintln("Saisir le montant que vous voulez verser sur le compte");
        TConsole.toprint(">");
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
        TConsole.toprintln("Le compte n'a pas été trouvé !");
    }
    /**
     * Retrait sur un compte (courant ou épargne)
     */
    public static void retraitSurUnCompte() {
        Integer id = Connexion.getId();

        TConsole.toprintln("*********************************************************" +
                "\nRetrait sur un compte" +
                "\n*********************************************************"
        );

        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            return;
        }

        TConsole.toprintln("Saisir le montant que vous voulez retirer du compte");
        TConsole.toprint(">");
        Integer montantRetrait = Tools.askThing(1);

        for (Compte compte : Compte.getListeDesComptes()) {
            Integer soldeFinal;

            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                soldeFinal = compte.getSolde();

                // Retrait sur un compte courant
                if(compte instanceof CompteCourant) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();

                    if((soldeFinal + decouvert) < montantRetrait) {
                        TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde(" + compte.getSolde() + "€) + le découvert autorisé("+ decouvert +"€) soit : " + (compte.getSolde() + ((CompteCourant) compte).getDecouvert()) + "€");
                    }

                    // Retrait sur un compte épargne
                } else if(compte instanceof CompteEpargne) {
                    if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                        soldeFinal = compte.getSolde();

                        if(soldeFinal < montantRetrait) {
                            TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde de votre compte soit : " + compte.getSolde() + "€");
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
        TConsole.toprintln("Le compte n'a pas été trouvé !");
    }

    /**
     * Virement de compte à compte
     */
    public static void virement() {
        Integer id = Connexion.getId();
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null, soldeFinalCompteDebiteur = null, soldeFinalCompteCrediteur = null, montantDebit;
        TConsole.toprintln("*********************************************************" +
                "\nVirement de compte à compte" +
                "\n*********************************************************"
        );

        // Compte débiteur
        TConsole.toprintln("Saisir le numéro de compte à débiter");
        TConsole.toprint(">");
        Integer compteDebit = Tools.askThing(1);

        TConsole.toprintln("Saisir le montant à débiter");
        TConsole.toprint(">");
        montantDebit = Tools.askThing(1);

        //TODO : Tester pour ne pas faire un virement sur notre propre compte

        for(Compte compte : Compte.getListeDesComptes()){
            if(compteDebit.equals(compte.getCode()) && compte.getTitulaire().equals(id)){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
                if(compte instanceof CompteCourant) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();
                    if((soldeCompteDebiteur + decouvert) < montantDebit) {
                        TConsole.toprintln("Virement impossible car la somme demandée de " + montantDebit + "€ dépasse le solde(" + soldeCompteDebiteur + "€) + le découvert autorisé("+ decouvert +"€) soit : " + (soldeCompteDebiteur + decouvert + "€"));
                        return;
                    }
                } else if(compte instanceof CompteEpargne) {
                    if(soldeCompteDebiteur < montantDebit) {
                        TConsole.toprintln("Virement impossible car la somme demandée de " + montantDebit + "€ dépasse le solde de votre compte soit : " + soldeCompteDebiteur + "€");
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
        TConsole.toprintln("Saisir le numéro de compte à créditer");
        TConsole.toprint(">");
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
