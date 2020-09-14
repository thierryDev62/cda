package fr.banque2.data;

import java.util.ArrayList;

public class CompteEpargne extends Compte {
    private Integer tauxInteret;
    private static ArrayList<CompteEpargne> listeCompte = new ArrayList<>();

    public CompteEpargne(Integer code, Integer solde, Integer tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }
    public void addCompte() {
        listeCompte.add(this);
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
