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
        //listeOperations.add(this);
    }

    public void addOperation(){
        listeOperations.add(this);
    }

    public static String dateDuJour(){
        // Récupère la date du jour
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
        operation.addOperation();
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
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            return;
        }

        TConsole.toprintln("Saisir le montant que vous voulez verser sur le compte");
        Integer montantVersement = Tools.askThing(1);

        /**
         * Versement sur un compte courant
         */

        /*Compte test = new Compte(123,500);
        CompteCourant compteCourant = (CompteCourant) test;*/


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
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            return;
        }

        TConsole.toprintln("Saisir le montant que vous voulez retirer du compte");
        Integer montantRetrait = Tools.askThing(1);

        for (Compte compteCourant : Compte.getListeDesComptes()) {
            Integer soldeFinalCompteCourant;

            if (saisiNumeroCompte.equals(compteCourant.getCode())) {
                //TODO : Rajouter un type de compte sinon il cast qd même pour n'importe quel compte

                Integer decouvert = ((CompteCourant) compteCourant).getDecouvert();
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compteCourant.getCode() +
                        "\nMontant demandé : " + montantRetrait + "€" +
                        "\nSolde du compte avant le retrait : " + compteCourant.getSolde() + "€" +
                        "\nDécouvert autorisé : " + decouvert + "€"
                );
                soldeFinalCompteCourant = compteCourant.getSolde() - montantRetrait;


                if(soldeFinalCompteCourant < (compteCourant.getCode() + decouvert)) {
                    TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde + le découvert autorisé soit : " + (compteCourant.getSolde() + ((CompteCourant) compteCourant).getDecouvert()) + "€");
                    return;
                } else {
                    compteCourant.setSolde(soldeFinalCompteCourant);
                    System.out.println("Solde de compte après retrait : " + compteCourant.getSolde() + "€"
                    );

                    /**
                     * Résumé de l'opération
                     */
                    Integer numeroCompteOperation = compteCourant.getCode();
                    nouvelleOperation(numeroCompteOperation, "Retrait", montantRetrait);
                    return;
                }
            }
        }
        for (Compte compteEpargne : Compte.getListeDesComptes()) {
            Integer soldeFinalCompteEpargne;
            if (saisiNumeroCompte.equals(compteEpargne.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compteEpargne.getCode() +
                        "\nMontant demandé : " + montantRetrait + "€" +
                        "\nSolde du compte avant le retrait : " + compteEpargne.getSolde() + "€"
                );
                soldeFinalCompteEpargne = compteEpargne.getSolde() - montantRetrait;

                if(soldeFinalCompteEpargne < 0) {
                    TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde de votre compte soit : " + compteEpargne.getSolde() + "€");
                    return;
                } else {
                    compteEpargne.setSolde(soldeFinalCompteEpargne);
                    System.out.println("Solde de compte après retrait : " + compteEpargne.getSolde() + "€"
                    );
                    /**
                     * Résumé de l'opération
                     */
                    Integer numeroCompteOperation = compteEpargne.getCode();
                    nouvelleOperation(numeroCompteOperation, "Retrait", montantRetrait);

                    return;
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
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null, soldeFinalCompteDebiteur = null, soldeFinalCompteCrediteur = null, montantDebit;
        TConsole.toprintln("*********************************************************" +
                "\nVirement de compte à compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte à débiter");
        Integer compteDebit = Tools.askThing(1);

        TConsole.toprintln("Saisir le montant à débiter");
        montantDebit = Tools.askThing(1);

        for(CompteCourant compte : Compte.getListeCompteCourant()){
            if(compteDebit.equals(compte.getCode())){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
                soldeFinalCompteDebiteur = soldeCompteDebiteur - montantDebit;
                compte.setSolde(soldeFinalCompteDebiteur);
                soldeFinalCompteDebiteur = compte.getSolde();
                /**
                 * Résumé de l'opération
                 */
                Integer numeroCompteOperation = compte.getCode();
                Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard
                Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), "Virement envoyé", montantDebit);
                //operation.addOperation();

            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()){
            if(compteDebit.equals(compte.getCode())){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
                soldeFinalCompteDebiteur = soldeCompteDebiteur - montantDebit;
                compte.setSolde(soldeFinalCompteDebiteur);
                soldeFinalCompteDebiteur = compte.getSolde();
                /**
                 * Résumé de l'opération
                 */
                Integer numeroCompteOperation = compte.getCode();
                Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard
                Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), "Virement envoyé", montantDebit);
                //operation.addOperation();
            }
        }

        System.out.println("*******************************************************************************" +
                "\nCompte débiteur : " + compteDebit + " - Solde avant traitement : " + soldeCompteDebiteur + "€" + " - Solde après traitement : " + soldeFinalCompteDebiteur + "€" +
                "\n*******************************************************************************"
        );

        TConsole.toprintln("Saisir le numéro de compte à créditer");
        Integer compteCredit = Tools.askThing(1);
        for(CompteCourant compte : Compte.getListeCompteCourant()){
            if(compteCredit.equals(compte.getCode())){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();
                soldeFinalCompteCrediteur = soldeCompteCrediteur + montantDebit;
                compte.setSolde(soldeFinalCompteCrediteur);
                soldeFinalCompteCrediteur = compte.getSolde();
                /**
                 * Résumé de l'opération
                 */
                Integer numeroCompteOperation = compte.getCode();
                Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard
                Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), "Virement reçu", montantDebit);
                //operation.addOperation();
            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()){
            if(compteCredit.equals(compte.getCode())){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();
                soldeFinalCompteCrediteur = soldeCompteCrediteur + montantDebit;
                compte.setSolde(soldeFinalCompteCrediteur);
                soldeFinalCompteCrediteur = compte.getSolde();
                /**
                 * Résumé de l'opération
                 */
                Integer numeroCompteOperation = compte.getCode();
                Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard
                Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), "Virement reçu", montantDebit);
                //operation.addOperation();
            }
        }
        System.out.println("*******************************************************************************" +
                "\nCompte créditeur : " + compteCredit + " - Solde avant traitement : " + soldeCompteCrediteur + "€" + " - Solde après traitement : " + soldeFinalCompteCrediteur + "€" +
                "\n*******************************************************************************"
        );

        TConsole.toprintln("*********************************************************" +
                "\n*         Le virement a bien été effectué !             *" +
                "\n*********************************************************");
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
