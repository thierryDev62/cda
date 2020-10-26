package entity;

import java.util.ArrayList;

public class Compte {
    private static int numeroCompte;
    private int solde = 0;
    private String typeDeCompte;
    private int titulaire;
    private static ArrayList<Compte> listeDesComptes = new ArrayList<>();

    public Compte(String typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
        listeDesComptes.add(this);
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        Compte.numeroCompte = numeroCompte;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(String typeDeCompte) {
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
