package entity;

import java.util.ArrayList;

public class Compte {
    private int numeroCompte = 123;
    private int solde = 0;
    private int typeDeCompte;
    private int titulaire;
    private static ArrayList<Compte> listeDesComptes = new ArrayList<>();

    public Compte(int numeroCompte, int solde, int typeDeCompte, int titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.typeDeCompte = typeDeCompte;
        this.titulaire = titulaire;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(int typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }

    public int getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(int titulaire) {
        this.titulaire = titulaire;
    }

    public static ArrayList<Compte> getListeDesComptes() {
        return listeDesComptes;
    }

    public static void setListeDesComptes(ArrayList<Compte> listeDesComptes) {
        Compte.listeDesComptes = listeDesComptes;
    }
}
