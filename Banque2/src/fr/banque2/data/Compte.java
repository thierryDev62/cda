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
        TConsole.toprintln("Création d'un nouveau compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Quel type de compte voulez-vous créer ? \n1 - Compte courant | 2 - Compte épargne");
        Integer choix = Tools.askThing(1);

        if(choix == 1) {
            TConsole.toprintln("Création d'un compte courant" +
                    "\n*********************************************************"
            );
            TConsole.toprintln("Saisir le numéro de compte");
            Integer numeroCompte = Tools.askThing(1);

            /**
             * Test si le numéro de compte existe déjà
             */

            TConsole.toprintln("Saisir le solde du compte");
            Integer soldeDuCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le découvert autorisé");
            Integer decouvert = Tools.askThing(1);

            CompteCourant nouveauCompte = new CompteCourant(numeroCompte, soldeDuCompte, decouvert);
            nouveauCompte.addCompteCourant();

            TConsole.toprintln("Récapitulatif de la création du compte courant :" +
                    "\nNuméro de compte : " + nouveauCompte.getCode() +
                    "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                    "\nDécouvert autorisé : " + nouveauCompte.getDecouvert() + "€" +
                    "\n*********************************************************" +
                    "\n*       Le nouveau compte a bien été créé !             *" +
                    "\n*********************************************************"
            );
        } else if(choix == 2) {
            TConsole.toprintln("Création d'un compte épargne" +
                    "\n*********************************************************"
            );
            TConsole.toprintln("Saisir le numéro de compte");
            Integer numeroCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le solde du compte");
            Integer soldeDuCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le taux d'intérêt");
            Integer tauxInteret = Tools.askThing(1);

            CompteEpargne nouveauCompte = new CompteEpargne(numeroCompte, soldeDuCompte, tauxInteret);
            nouveauCompte.addCompteEpargne();

            TConsole.toprintln("Récapitulatif de la création du compte épargne :" +
                    "\nNuméro de compte : " + nouveauCompte.getCode() +
                    "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                    "\nDécouvert autorisé : " + nouveauCompte.getTauxInteret() + "%" +
                    "\n*********************************************************" +
                    "\n*       Le nouveau compte a bien été créé !             *" +
                    "\n*********************************************************"
            );
        }
    }
    /**
     * Consultation du solde d'un compte
     */
    public static void consultationSolde() {
        TConsole.toprintln("Consultation du solde d'un compte" +
                "\n*********************************************************"
        );

        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
        }

        CompteCourant.rechercheCompteCourant(saisiNumeroCompte);

        CompteEpargne.rechercheCompteEpargne(saisiNumeroCompte);

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
