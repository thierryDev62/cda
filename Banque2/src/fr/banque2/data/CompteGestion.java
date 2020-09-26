package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class CompteGestion {
    /**
     * Creation compte
     */
    public static void creationNouveauCompte(){
        Integer id = Connexion.getId();
        for(Utilisateurs utilisateurCourant : Client.getListeDesUtilisateurs()) {
            if(id.equals(utilisateurCourant.getId()) && utilisateurCourant.getCompteValide()) {
                TConsole.toprintln("*********************************************************" +
                        "\nCréation d'un nouveau compte" +
                        "\n*********************************************************"
                );
                TConsole.toprintln("Quel type de compte voulez-vous créer ? \n1 - Compte courant | 2 - Compte épargne");
                TConsole.toprint(">");
                int choix = Tools.askThing(1);

                TConsole.toprintln("*********************************************************" +
                        "\nCréation d'un compte" +
                        "\n*********************************************************"
                );
                TConsole.toprintln("Saisir le numéro de compte");
                TConsole.toprint(">");
                Integer numeroCompte = Tools.askThing(1);

                for (Compte liste : Compte.getListeDesComptes()) {
                    if (numeroCompte.equals(liste.getCode())) {
                        TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                        CompteGestion.creationNouveauCompte();
                        return;
                    }
                }
                TConsole.toprintln("Saisir le solde du compte");
                TConsole.toprint(">");
                Integer solde = Tools.askThing(1);

                Compte nouveauCompte = null;

                if (choix == 1) {
                    nouveauCompte = new CompteCourant(numeroCompte, solde,1, id);
                } else if (choix == 2) {
                    nouveauCompte = new CompteEpargne(numeroCompte, solde,2, id);
                }

                assert nouveauCompte != null;
                TConsole.toprintln("*********************************************************" +
                        "\nRécapitulatif de la création du compte :" +
                        "\nNuméro de compte : " + nouveauCompte.getCode() +
                        "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                        "\n*********************************************************" +
                        "\n*       Le nouveau compte a bien été créé !     *" +
                        "\n*********************************************************"
                );
                return;
            } else {
                Conseiller.pasMoyen();
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
