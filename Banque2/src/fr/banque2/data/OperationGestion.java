package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class OperationGestion {
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
            Integer soldeFinalCompte;

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

                /**
                 * Résumé de l'opération (appel de la méthode nouvelleOperation())
                 */
                Integer numeroCompteOperation = compte.getCode();
                Operation.nouvelleOperation(numeroCompteOperation, "Versement", montantVersement);
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
            Integer soldeFinalCompteCourant;

            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
//TODO : factoriser
                /**
                 * Retrait sur un compte courant
                 */
                if(compte instanceof  CompteCourant) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();
                    System.out.println("*********************************************************" +
                            "\nNuméro de compte : " +
                            compte.getCode() +
                            "\nMontant demandé : " + montantRetrait + "€" +
                            "\nSolde du compte avant le retrait : " + compte.getSolde() + "€" +
                            "\nDécouvert autorisé : " + decouvert + "€"
                    );
                    soldeFinalCompteCourant = compte.getSolde();

                    if((soldeFinalCompteCourant + decouvert) < montantRetrait) {
                        TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde(" + compte.getSolde() + "€) + le découvert autorisé("+ decouvert +"€) soit : " + (compte.getSolde() + ((CompteCourant) compte).getDecouvert()) + "€");
                        return;
                    } else {
                        soldeFinalCompteCourant -= montantRetrait;
                        compte.setSolde(soldeFinalCompteCourant);
                        System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€"
                        );

                        /**
                         * Résumé de l'opération
                         */
                        Integer numeroCompteOperation = compte.getCode();
                        Operation.nouvelleOperation(numeroCompteOperation, "Retrait", montantRetrait);
                        return;
                    }
                    /**
                     * Retrait sur un compte épargne
                     */
                } else if(compte instanceof CompteEpargne) {
                    Integer soldeFinalCompteEpargne;
                    if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
                        System.out.println("*********************************************************" +
                                "\nNuméro de compte : " +
                                compte.getCode() +
                                "\nMontant demandé : " + montantRetrait + "€" +
                                "\nSolde du compte avant le retrait : " + compte.getSolde() + "€"
                        );
                        soldeFinalCompteEpargne = compte.getSolde();

                        if(soldeFinalCompteEpargne < montantRetrait) {
                            TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde de votre compte soit : " + compte.getSolde() + "€");
                            return;
                        } else {
                            soldeFinalCompteEpargne = compte.getSolde() - montantRetrait;
                            compte.setSolde(soldeFinalCompteEpargne);
                            System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€"
                            );
                            /**
                             * Résumé de l'opération
                             */
                            Integer numeroCompteOperation = compte.getCode();
                            Operation.nouvelleOperation(numeroCompteOperation, "Retrait", montantRetrait);
                            return;
                        }
                    }
                }
            }
        }
        TConsole.toprintln("Le compte n'a pas été trouvé !");
    }
    /**
     * Virement de compte à compte
     * @return
     */

    public static void virement() {
        Integer id = Connexion.getId();
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null, soldeFinalCompteDebiteur = null, soldeFinalCompteCrediteur = null, montantDebit;
        TConsole.toprintln("*********************************************************" +
                "\nVirement de compte à compte" +
                "\n*********************************************************"
        );
        /**
         * Compte débiteur
         */
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

                Operation.nouvelleOperation(compteDebit, "Virement envoyé", montantDebit);
            }
        }

        System.out.println("*******************************************************************************" +
                "\nCompte débiteur : " + compteDebit + " - Solde avant traitement : " + soldeCompteDebiteur + "€" + " - Solde après traitement : " + soldeFinalCompteDebiteur + "€" +
                "\n*******************************************************************************"
        );

        /**
         * Compte créditeur
         */
        TConsole.toprintln("Saisir le numéro de compte à créditer");
        TConsole.toprint(">");
        Integer compteCredit = Tools.askThing(1);

        for(Compte compte : Compte.getListeDesComptes()) {
            if(compteCredit.equals(compte.getCode())){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();

                soldeFinalCompteCrediteur = soldeCompteCrediteur + montantDebit;

                compte.setSolde(soldeFinalCompteCrediteur);

                Operation.nouvelleOperation(compteCredit, "Virement reçu", montantDebit);
            }
        }

        System.out.println("*******************************************************************************" +
                "\nCompte créditeur : " + compteCredit + " - Solde avant traitement : " + soldeCompteCrediteur + "€" + " - Solde après traitement : " + soldeFinalCompteCrediteur + "€" +
                "\n*******************************************************************************"
        );
    }
}
