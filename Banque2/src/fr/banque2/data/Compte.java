package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Compte {
    private final Integer code;
    private Integer solde;
    private static ArrayList<CompteCourant> listeCompteCourant = new ArrayList<>();
    private static ArrayList<CompteEpargne> listeCompteEpargne = new ArrayList<>();

    public Compte(Integer code, Integer solde) {
        this.code = code;
        this.solde = solde;
    }

    public void addCompteCourant() {
        listeCompteCourant.add((CompteCourant) this);
    }
    public void addCompteEpargne() {
        listeCompteEpargne.add((CompteEpargne) this);
    }
    /**
     * Creation compte
     */
    public static void creationNouveauCompte(){
        TConsole.toprintln("*********************************************************" +
                "\nCréation d'un nouveau compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Quel type de compte voulez-vous créer ? \n1 - Compte courant | 2 - Compte épargne");
        Integer choix = Tools.askThing(1);

        if(choix == 1) {
            TConsole.toprintln("*********************************************************" +
                    "\nCréation d'un compte courant" +
                    "\n*********************************************************"
            );
            TConsole.toprintln("Saisir le numéro de compte");
            Integer numeroCompte = Tools.askThing(1);

            for(CompteCourant listeCompteCourant : Compte.getListeCompteCourant()) {
                if (numeroCompte.equals(listeCompteCourant.getCode())) {
                    TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                    Compte.creationNouveauCompte();
                    return;
                }
            }
            for (CompteEpargne listeCompteEpargne : Compte.getListeCompteEpargne()) {
                if (numeroCompte.equals(listeCompteEpargne.getCode())) {
                    TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                    Compte.creationNouveauCompte();
                    return;
                }
            }

            //TODO - * Test si le numéro de compte existe déjà

            TConsole.toprintln("Saisir le solde du compte");
            Integer soldeDuCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le découvert autorisé");
            Integer decouvert = Tools.askThing(1);

            CompteCourant nouveauCompte = new CompteCourant(numeroCompte, soldeDuCompte, decouvert);
            nouveauCompte.addCompteCourant();

            TConsole.toprintln("*********************************************************" +
                    "\nRécapitulatif de la création du compte courant :" +
                    "\nNuméro de compte : " + nouveauCompte.getCode() +
                    "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                    "\nDécouvert autorisé : " + nouveauCompte.getDecouvert() + "€" +
                    "\n*********************************************************" +
                    "\n*       Le nouveau compte courant a bien été créé !     *" +
                    "\n*********************************************************"
            );
        } else if(choix == 2) {
            TConsole.toprintln("*********************************************************" +
                    "\nCréation d'un compte épargne" +
                    "\n*********************************************************"
            );
            TConsole.toprintln("Saisir le numéro de compte");
            Integer numeroCompte = Tools.askThing(1);

            for(CompteCourant listeCompteCourant : Compte.getListeCompteCourant()) {
                if (numeroCompte.equals(listeCompteCourant.getCode())) {
                    TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                    Compte.creationNouveauCompte();
                    return;
                }
            }

            for (CompteEpargne listeCompteEpargne : Compte.getListeCompteEpargne()) {
                if (numeroCompte.equals(listeCompteEpargne.getCode())) {
                    TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                    Compte.creationNouveauCompte();
                    return;
                }
            }

            TConsole.toprintln("Saisir le solde du compte");
            Integer soldeDuCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le taux d'intérêt");
            Integer tauxInteret = Tools.askThing(1);

            CompteEpargne nouveauCompte = new CompteEpargne(numeroCompte, soldeDuCompte, tauxInteret);
            nouveauCompte.addCompteEpargne();

            TConsole.toprintln("*********************************************************" +
                    "\nRécapitulatif de la création du compte épargne :" +
                    "\nNuméro de compte : " + nouveauCompte.getCode() +
                    "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                    "\nTaux d'interêt : " + nouveauCompte.getTauxInteret() + "%" +
                    "\n*********************************************************" +
                    "\n*     Le nouveau compte épargne a bien été créé !       *" +
                    "\n*********************************************************"
            );
        } else {
            TConsole.toprintln("Vous devez saisir 1 ou 2");
            Compte.creationNouveauCompte();
        }
    }
    /**
     * Consultation du solde d'un compte
     */
    public static void consultationSolde() {
        TConsole.toprintln("*********************************************************" +
                "\nConsultation du solde d'un compte" +
                "\n*********************************************************"
        );

        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
        }

        CompteCourant.soldeCompteCourant(saisiNumeroCompte);

        CompteEpargne.soldeCompteEpargne(saisiNumeroCompte);

    }

    /**
     * Liste des opérations sur un compte
     */
    public static void listeOperations() {
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        Integer saisiNumeroCompte = Tools.askThing(1);

        TConsole.toprintln("Liste des opérations sur le compte n°" + saisiNumeroCompte);
        TConsole.toprintln("*************************************************************************************");
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
    /**
     * Total des versements
     */
    public static void totalVersements() {
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalVersement = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for(Operation versement : Operation.getListeOperations()) {
            if(saisiNumeroCompte.equals(versement.getNumeroCompteOperation()) && versement.getLibelleOperation().equals("Versement")) {
                totalVersement += versement.getMontantOperation();
            }
        }
        TConsole.toprintln("Montant total : " + totalVersement + "€");
    }
    /**
     * Total des retraits
     */
    public static void totalRetraits() {
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalRetrait = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for(Operation retrait : Operation.getListeOperations()) {
            if(saisiNumeroCompte.equals(retrait.getNumeroCompteOperation()) && retrait.getLibelleOperation().equals("Retrait")) {
                totalRetrait += retrait.getMontantOperation();
            }
        }
        TConsole.toprintln("Montant total : " + totalRetrait + "€");
    }

    /**
     * Liste de tous les comptes
     */
    public static void listeTousLesComptes() {
        TConsole.toprintln("Liste de tous les comptes créés :");
        TConsole.toprintln("Comptes courants :");

        if (Compte.getListeCompteCourant().size() > 0) {
            for (CompteCourant listeComptesCourants : Compte.getListeCompteCourant()) {
                System.out.println("- Numéro de compte : " + listeComptesCourants.getCode() + " - Solde : " + listeComptesCourants.getSolde() + "€ - Découvert autorisé : " + listeComptesCourants.getDecouvert() + "€"
                );
            }
        } else {
            TConsole.toprintln("Aucun");
        }

        TConsole.toprintln("Comptes épargnes :");
        if (Compte.getListeCompteEpargne().size() > 0) {
            for (CompteEpargne listeComptesEpargne : Compte.getListeCompteEpargne()) {
                System.out.println("- Numéro de compte : " + listeComptesEpargne.getCode() + " - Solde : " + listeComptesEpargne.getSolde() + "€ - Taux d'interêt : " + listeComptesEpargne.getTauxInteret() + "%"
                );
            }
        } else {
            TConsole.toprintln("Aucun");
        }
    }
    public Integer getCode() {
        return code;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public static ArrayList<CompteCourant> getListeCompteCourant() {
        return listeCompteCourant;
    }

    public static void setListeCompteCourant(ArrayList<CompteCourant> listeCompteCourant) {
        Compte.listeCompteCourant = listeCompteCourant;
    }

    public static ArrayList<CompteEpargne> getListeCompteEpargne() {
        return listeCompteEpargne;
    }

    public static void setListeCompteEpargne(ArrayList<CompteEpargne> listeCompteEpargne) {
        Compte.listeCompteEpargne = listeCompteEpargne;
    }
}
