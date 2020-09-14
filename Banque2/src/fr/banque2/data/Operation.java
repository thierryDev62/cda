package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class Operation {
    /**
     * Versement sur un compte
     */
    public static void versementSurUnCompte() {
        TConsole.toprintln("Versement sur un compte" +
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


        for(CompteCourant compte : Compte.getListeCompteCourant()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("Numéro de compte : " +
                        compte.getCode() +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                Integer soldeFinal = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinal);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€");
                TConsole.toprintln("Le versement de " + montantVersement + "€ à bien été effectué !");
                return;
            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("Numéro de compte : " +
                        compte.getCode() +
                        "\nSolde du compte avant versement : " + compte.getSolde() + "€"
                );
                Integer soldeFinal = montantVersement + compte.getSolde();
                compte.setSolde(soldeFinal);
                System.out.println("Solde de compte après versement : " + compte.getSolde() + "€");
                TConsole.toprintln("Le versement de " + montantVersement + "€ à bien été effectué !");
                return;
            }
        }


        TConsole.toprintln("Le compte n'a pas été trouvé !");

    }
    /**
     * Retrait sur un compte
     */
    public static void retraitSurUnCompte() {
        TConsole.toprintln("Retrait sur un compte" +
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
                System.out.println("Numéro de compte : " +
                        compte.getCode() +
                        "\nMontant demandé : " + saisiNumeroCompte +
                        "\nSolde du compte avant le retrait : " + compte.getSolde() + "€" +
                        "\nDécouvert autorisé : " + compte.getDecouvert() + "€"
                );
                Integer soldeFinal = (compte.getSolde() + compte.getDecouvert()) - montantRetrait;

                if(soldeFinal < 0) {
                    TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde + le découvert autorisé");
                    return;
                } else {
                    compte.setSolde(soldeFinal);
                    System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€");
                    TConsole.toprintln("Le retrait de " + montantRetrait + "€ à bien été effectué !");
                    return;
                }
            }
        }
        for (CompteEpargne compte : Compte.getListeCompteEpargne()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("Numéro de compte : " +
                        compte.getCode() +
                        "\nSolde du compte avant le retrait : " + compte.getSolde() + "€"
                );
                Integer soldeFinal = compte.getSolde() - montantRetrait;

                if(soldeFinal < 0) {
                    TConsole.toprintln("Retrait impossible car la somme demandée de " + montantRetrait + "€ dépasse le solde + le découvert autorisé");
                    return;
                } else {
                    compte.setSolde(soldeFinal);
                    System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€");
                    TConsole.toprintln("Le retrait de " + montantRetrait + "€ à bien été effectué !");
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
        Integer soldeCompteDebiteur = null, soldeCompteCrediteur = null;
        TConsole.toprintln("Virement de compte à compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte à débiter");
        Integer compteDebit = Tools.askThing(1);
        for(CompteCourant compte : Compte.getListeCompteCourant()){
            if(compteDebit.equals(compte.getCode())){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()){
            if(compteDebit.equals(compte.getCode())){
                soldeCompteDebiteur = compte.getSolde();
                compteDebit = compte.getCode();
            }
        }

        System.out.println("Compte débiteur : " + compteDebit + " - Solde : " + soldeCompteDebiteur + "€");

        TConsole.toprintln("Saisir le numéro de compte à créditer");
        Integer compteCredit = Tools.askThing(1);
        for(CompteCourant compte : Compte.getListeCompteCourant()){
            if(compteCredit.equals(compte.getCode())){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();
            }
        }
        for(CompteEpargne compte : Compte.getListeCompteEpargne()){
            if(compteCredit.equals(compte.getCode())){
                soldeCompteCrediteur = compte.getSolde();
                compteCredit = compte.getCode();
            }
        }
        System.out.println("Compte créditeur : " + compteCredit + " - Solde : " + soldeCompteCrediteur + "€");

        Integer montantDebit = Tools.askThing(1);


    }
}
