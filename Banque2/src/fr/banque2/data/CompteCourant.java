package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class CompteCourant extends Compte{
    private Integer decouvert;
    private static ArrayList<CompteCourant> listeCompte = new ArrayList<>();

    public CompteCourant(Integer code, Integer solde, Integer decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    public void addCompte() {
        listeCompte.add(this);
    }

    public Integer getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Integer decouvert) {
        this.decouvert = decouvert;
    }

    public static ArrayList<CompteCourant> getListeCompte() {
        return listeCompte;
    }

    public static void setListeCompte(ArrayList<CompteCourant> listeCompte) {
        CompteCourant.listeCompte = listeCompte;
    }
}
