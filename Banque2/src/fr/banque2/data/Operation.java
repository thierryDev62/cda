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
        TConsole.toprintln("1 - Compte courant | 2 - Compte épargne | 0 - Annuler");
        Integer reponse = Tools.askThing(1);

        if(reponse == 1) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            TConsole.toprintln("Saisir le montant que vous voulez verser sur le compte");
            Integer montantVersement = Tools.askThing(1);

            for(CompteCourant compte : CompteCourant.getListeCompte()) {
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

        } else if(reponse == 2) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            TConsole.toprintln("Saisir le montant que vous voulez verser sur le compte");
            Integer montantVersement = Tools.askThing(1);

            for(CompteEpargne compte : CompteEpargne.getListeCompte()) {
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

        } else if(reponse == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            return;
        } else {
            TConsole.toprintln("Veuillez saisir 1 ou 2");
            versementSurUnCompte();
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
        TConsole.toprintln("1 - Compte courant | 2 - Compte épargne | 0 - Annuler");
        Integer reponse = Tools.askThing(1);

        if(reponse == 1) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            TConsole.toprintln("Saisir le montant que vous voulez retirer du compte");
            Integer montantRetrait = Tools.askThing(1);

            for(CompteCourant compte : CompteCourant.getListeCompte()) {
                if (saisiNumeroCompte.equals(compte.getCode())) {
                    System.out.println("Numéro de compte : " +
                            compte.getCode() +
                            "\nSolde du compte avant le retrait : " + compte.getSolde() + "€"
                    );
                    Integer soldeFinal = compte.getSolde() - montantRetrait;
                    compte.setSolde(soldeFinal);
                    System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€");
                    TConsole.toprintln("Le retrait de " + montantRetrait + "€ à bien été effectué !");
                    return;
                }
            }

        } else if(reponse == 2) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            TConsole.toprintln("Saisir le montant que vous voulez retirer du compte");
            Integer montantRetrait = Tools.askThing(1);

            for(CompteEpargne compte : CompteEpargne.getListeCompte()) {
                if (saisiNumeroCompte.equals(compte.getCode())) {
                    System.out.println("Numéro de compte : " +
                            compte.getCode() +
                            "\nSolde du compte avant le retrait : " + compte.getSolde() + "€"
                    );
                    Integer soldeFinal = compte.getSolde() - montantRetrait;
                    compte.setSolde(soldeFinal);
                    System.out.println("Solde de compte après retrait : " + compte.getSolde() + "€");
                    TConsole.toprintln("Le retrait de " + montantRetrait + "€ à bien été effectué !");
                    return;
                }
            }

        } else if(reponse == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            return;
        } else {
            TConsole.toprintln("Veuillez saisir 1 ou 2");
            versementSurUnCompte();
        }
        TConsole.toprintln("Le compte n'a pas été trouvé !");
    }
}
