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
    }

    public void addOperation(){
        listeOperations.add(this);
    }

    public static String dateDuJour(){
        // Récupère la date du jour
        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateInstance(
                DateFormat.SHORT);
        String dateAujourdhui = shortDateFormat.format(aujourdhui);
        return dateAujourdhui;
    }
    /**
     * Versement sur un compte
     */
    public static void versementSurUnCompte() {

        //TConsole.toprintln(dateDuJour());

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
        for(CompteCourant compte : Compte.getListeCompteCourant()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant versé : " + montantVersement + "€" +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                Integer soldeFinal = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinal);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€"
                );
                TConsole.toprintln(
                        "*******************************************************************************" +
                                "\nLe versement de " + montantVersement + "€ à bien été effectué !" +
                                "\n*******************************************************************************"
                );

                /**
                 * Résumé de l'opération
                 */
                Integer numeroCompteOperation = compte.getCode();
                Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard
                Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), "Versement", montantVersement);
                operation.addOperation();
                System.out.println("Récapitulatif de l'opération :" +
                        "\nNuméro de compte : " + operation.numeroCompteOperation +
                        "\nDate d'opération : " + operation.dateOperation +
                        "\nNuméro d'opération : " + operation.numeroOperation +
                        "\nLibellé de l'opération : " + operation.libelleOperation +
                        "\nMontant : " + montantVersement + "€" +
                        "\n*******************************************************************************"
                );

                return;
            }
        }
        /**
         * Versement sur un compte épargne
         */
        for(CompteEpargne compte : Compte.getListeCompteEpargne()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant versé : " + montantVersement + "€" +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                Integer soldeFinal = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinal);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€" +
                        "\n*********************************************************"
                );
                TConsole.toprintln(
                        "*******************************************************************************" +
                                "\nLe versement de " + montantVersement + "€ à bien été effectué !" +
                                "\n*******************************************************************************"
                );

                /**
                 * Résumé de l'opération
                 */
                Integer numeroCompteOperation = compte.getCode();
                Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard
                Operation operation = new Operation(numeroCompteOperation, resultRandom, dateDuJour(), "Versement", montantVersement);
                operation.addOperation();
                System.out.println("Récapitulatif de l'opération :" +
                        "\nNuméro de compte : " + operation.numeroCompteOperation +
                        "\nDate d'opération : " + operation.dateOperation +
                        "\nNuméro d'opération : " + operation.numeroOperation +
                        "\nLibellé de l'opération : " + operation.libelleOperation +
                        "\nMontant : " + montantVersement + "€" +
                        "\n*******************************************************************************"
                );
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

        for (CompteCourant compte : Compte.getListeCompteCourant()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant demandé : " + montantRetrait + "€" +
                        "\nSolde du compte avant le retrait : " + compte.getSolde() + "€" +
                        "\nDécouvert autorisé : " + compte.getDecouvert() + "€"
                );
                Integer soldeFinal = (compte.getSolde() + compte.getDecouvert()) - montantRetrait;

                if(soldeFinal < 0) {
                    TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde + le découvert autorisé");
                    return;
                } else {
                    compte.setSolde(soldeFinal);
                    System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€" +
                            "\n*********************************************************"
                    );
                    TConsole.toprintln("*******************************************************************************" +
                            "\nLe retrait de " + montantRetrait + "€ à bien été effectué !" +
                            "\n*******************************************************************************"
                    );
                    return;
                }
            }
        }
        for (CompteEpargne compte : Compte.getListeCompteEpargne()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("*********************************************************" +
                        "\nNuméro de compte : " +
                        compte.getCode() +
                        "\nMontant demandé : " + montantRetrait + "€" +
                        "\nSolde du compte avant le retrait : " + compte.getSolde() + "€"
                );
                Integer soldeFinal = compte.getSolde() - montantRetrait;

                if(soldeFinal < 0) {
                    TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde + le découvert autorisé");
                    return;
                } else {
                    compte.setSolde(soldeFinal);
                    System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€" +
                            "\n*********************************************************"
                    );
                    TConsole.toprintln("\n*******************************************************************************" +
                            "\nLe retrait de " + montantRetrait + "€ à bien été effectué !" +
                            "\n*******************************************************************************"
                    );
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
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null, soldeFinalCompteDebiteur = null, soldeFinalCompteCrediteur = null, montantDebit = null;
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
            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()){
            if(compteDebit.equals(compte.getCode())){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
                soldeFinalCompteDebiteur = soldeCompteDebiteur - montantDebit;
                compte.setSolde(soldeFinalCompteDebiteur);
                soldeFinalCompteDebiteur = compte.getSolde();
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
            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()){
            if(compteCredit.equals(compte.getCode())){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();
                soldeFinalCompteCrediteur = soldeCompteCrediteur + montantDebit;
                compte.setSolde(soldeFinalCompteCrediteur);
                soldeFinalCompteCrediteur = compte.getSolde();
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

    public void setNumeroCompteOperation(Integer numeroCompteOperation) {
        this.numeroCompteOperation = numeroCompteOperation;
    }

    public Integer getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(Integer numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getLibelleOperation() {
        return libelleOperation;
    }

    public Integer getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(Integer montantOperation) {
        this.montantOperation = montantOperation;
    }

    public void setLibelleOperation(String libelleOperation) {
        this.libelleOperation = libelleOperation;
    }

    public static ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public static void setListeOperations(ArrayList<Operation> listeOperations) {
        Operation.listeOperations = listeOperations;
    }
}
