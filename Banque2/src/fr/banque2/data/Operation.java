package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operation {
    private Integer numeroCompteOperation;
    private Integer numeroOperation;
    private String dateOperation;
    private String libelleOperation;
    private Integer montantOperation;
    private static ArrayList<Operation> listeOperations = new ArrayList<>();

    public Operation(Integer numeroCompteOperation, Integer numeroOperation, String dateOperation, String libelleOperation, Integer montantOperation) {
        this.numeroCompteOperation = numeroCompteOperation;
        this.numeroOperation = numeroOperation;
        this.dateOperation = dateOperation;
        this.libelleOperation = libelleOperation;
        this.montantOperation = montantOperation;
        listeOperations.add(this);
    }

    /**
     * Récupère la date du jour
     * @return la date du jour au format jj/mm/AAAA
     */
    public static String dateDuJour(){
        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateInstance(
                DateFormat.SHORT);
        return shortDateFormat.format(aujourdhui);
    }

    /**
     * Ajout d'une nouvelle opération
     * @param numeroCompteOperation Numéro de compte
     * @param typeOperation Type d'opération
     * @param montant Montant du versement
     */
    public static void nouvelleOperation(Integer numeroCompteOperation, String typeOperation, Integer montant){
        Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard

        Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), typeOperation, montant);
        System.out.println("*******************************************************************************" +
                "\nRécapitulatif de l'opération :" +
                "\nDate d'opération : " + operation.dateOperation +
                "\nNuméro d'opération : " + operation.numeroOperation +
                "\nLibellé de l'opération : " + operation.libelleOperation +
                "\nMontant : " + montant + "€" +
                "\n*******************************************************************************"
        );
        TConsole.toprintln(
                "Le "+ typeOperation + " de " + montant + "€ à bien été effectué !" +
                        "\n*******************************************************************************"
        );
    }
    /**
     * Versement sur un compte
     */
    public static void versementSurUnCompte() {

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

        /**
         * Versement sur un compte courant
         */
//TODO : Voir pour factoriser les versements
        for(Compte compte : Compte.getListeDesComptes()) {
            Integer soldeFinalCompteCourant;

            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant versé : " + montantVersement + "€" +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                soldeFinalCompteCourant = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinalCompteCourant);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€"
                );

                /**
                 * Résumé de l'opération (appel de la méthode nouvelleOperation())
                 */
                Integer numeroCompteOperation = compte.getCode();
                nouvelleOperation(numeroCompteOperation, "Versement", montantVersement);

                return;
            }
        }
        /**
         * Versement sur un compte épargne
         */
        for(Compte compte : Compte.getListeDesComptes()) {
            Integer soldeFinalCompteEpargne;
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant versé : " + montantVersement + "€" +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                soldeFinalCompteEpargne = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinalCompteEpargne);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€" +
                        "\n*********************************************************"
                );

                /**
                 * Résumé de l'opération (appel de la méthode nouvelleOperation())
                 */
                Integer numeroCompteOperation = compte.getCode();
                nouvelleOperation(numeroCompteOperation, "Versement", montantVersement);
                return;
            }
        }
        TConsole.toprintln("Le compte n'a pas été trouvé !");
    }
    /**
     * Retrait sur un compte
     */
    public static void retraitSurUnCompte() {
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

            if (saisiNumeroCompte.equals(compte.getCode())) {
                Integer typeDeCompte = compte.getTypeDeCompte();

                /**
                 * Retrait sur un compte courant
                 */
                if(typeDeCompte == 1) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();
                    System.out.println("*********************************************************" +
                            "\nNuméro de compte : " +
                            compte.getCode() +
                            "\nMontant demandé : " + montantRetrait + "€" +
                            "\nSolde du compte avant le retrait : " + compte.getSolde() + "€" +
                            "\nDécouvert autorisé : " + decouvert + "€"
                    );
                    soldeFinalCompteCourant = compte.getSolde() - montantRetrait;

                    if(soldeFinalCompteCourant < (compte.getCode() + decouvert)) {
                        TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde + le découvert autorisé soit : " + (compte.getSolde() + ((CompteCourant) compte).getDecouvert()) + "€");
                        return;
                    } else {
                        compte.setSolde(soldeFinalCompteCourant);
                        System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€"
                        );

                        /**
                         * Résumé de l'opération
                         */
                        Integer numeroCompteOperation = compte.getCode();
                        nouvelleOperation(numeroCompteOperation, "Retrait", montantRetrait);
                        return;
                    }
                    /**
                     * Retrait sur un compte épargne
                     */
                } else if(typeDeCompte == 2) {
                    Integer soldeFinalCompteEpargne;
                    if (saisiNumeroCompte.equals(compte.getCode())) {
                        System.out.println("*********************************************************" +
                                "\nNuméro de compte : " +
                                compte.getCode() +
                                "\nMontant demandé : " + montantRetrait + "€" +
                                "\nSolde du compte avant le retrait : " + compte.getSolde() + "€"
                        );
                        soldeFinalCompteEpargne = compte.getSolde() - montantRetrait;

                        if(soldeFinalCompteEpargne < 0) {
                            TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde de votre compte soit : " + compte.getSolde() + "€");
                            return;
                        } else {
                            compte.setSolde(soldeFinalCompteEpargne);
                            System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€"
                            );
                            /**
                             * Résumé de l'opération
                             */
                            Integer numeroCompteOperation = compte.getCode();
                            nouvelleOperation(numeroCompteOperation, "Retrait", montantRetrait);

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

    //TODO : faire les virements

    public static void virement() {
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null, soldeFinalCompteDebiteur = null, soldeFinalCompteCrediteur = null, montantDebit;
        TConsole.toprintln("*********************************************************" +
                "\nVirement de compte à compte" +
                "\n*********************************************************"
        );
//TODO : pour le compte débiteur voir si dépasse découvert
        /**
         * Compte débiteur
         */
        TConsole.toprintln("Saisir le numéro de compte à débiter");
        TConsole.toprint(">");
        Integer compteDebit = Tools.askThing(1);

        TConsole.toprintln("Saisir le montant à débiter");
        TConsole.toprint(">");
        montantDebit = Tools.askThing(1);

        for(Compte compte : Compte.getListeDesComptes()){

            if(compteDebit.equals(compte.getCode())){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
                Integer typeDeCompte = compte.getTypeDeCompte();
                if(typeDeCompte == 1) {
                    CompteCourant compteCourant = (CompteCourant) compte;
                    Integer decouvert = compteCourant.getDecouvert();
                } else if(typeDeCompte == 2) {
                    CompteEpargne compteEpargne = (CompteEpargne) compte;
                }
                soldeFinalCompteDebiteur = soldeCompteDebiteur - montantDebit;
                compte.setSolde(soldeFinalCompteDebiteur);
                soldeFinalCompteDebiteur = compte.getSolde();

                Integer numeroCompteOperation = compteDebit;
                nouvelleOperation(numeroCompteOperation, "Virement envoyé", montantDebit);
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
                soldeFinalCompteCrediteur = compte.getSolde();

                Integer numeroCompteOperation = compteCredit;
                nouvelleOperation(numeroCompteOperation, "Virement reçu", montantDebit);
            }
        }

        System.out.println("*******************************************************************************" +
                "\nCompte créditeur : " + compteCredit + " - Solde avant traitement : " + soldeCompteCrediteur + "€" + " - Solde après traitement : " + soldeFinalCompteCrediteur + "€" +
                "\n*******************************************************************************"
        );
    }

    public Integer getNumeroCompteOperation() {
        return numeroCompteOperation;
    }

    public Integer getNumeroOperation() {
        return numeroOperation;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public String getLibelleOperation() {
        return libelleOperation;
    }

    public Integer getMontantOperation() {
        return montantOperation;
    }

    public static ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }
}
