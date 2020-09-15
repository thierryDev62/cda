package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class CompteEpargne extends Compte {
    private Integer tauxInteret;
    private static ArrayList<CompteEpargne> listeCompte = new ArrayList<>();

    public CompteEpargne(Integer code, Integer solde, Integer tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    public static void rechercheCompteEpargne(Integer saisiNumeroCompte) {
        for (CompteEpargne compte : Compte.getListeCompteEpargne()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("Numéro de compte : " +
                        compte.getCode() + " - Compte épargne" +
                        "\n*********************************************************" +
                        "\nSolde du compte : " + compte.getSolde() + "€" +
                        "\n*********************************************************"
                );
                return;
            }
        }
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Integer tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public static ArrayList<CompteEpargne> getListeCompte() {
        return listeCompte;
    }

    public static void setListeCompte(ArrayList<CompteEpargne> listeCompte) {
        CompteEpargne.listeCompte = listeCompte;
    }
}
