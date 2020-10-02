package fr.banque2.data.entity;
import java.util.ArrayList;

public class Compte {
    private final Integer code;
    private Integer solde = 0;
    private Integer typeDeCompte;
    private Integer titulaire;
    private static ArrayList<Compte> listeDesComptes = new ArrayList<>();

    public Compte(Integer code, Integer typeDeCompte, Integer titulaire) {
        this.code = code;
        this.typeDeCompte = typeDeCompte;
        this.titulaire = titulaire;
        listeDesComptes.add(this);
    }

    public void afficheCreationCompte() {
        System.out.println("*********************************************************" +
                "\nRécapitulatif de la création du compte :" +
                "\nNuméro de compte : " + this.getCode() +
                "\nSolde du compte : " + this.getSolde() + "€" +
                "\n*********************************************************" +
                "\n*       Le nouveau compte a bien été créé !             *" +
                "\n*********************************************************"
        );
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

    public static ArrayList<Compte> getListeDesComptes() {
        return listeDesComptes;
    }

    public Integer getTitulaire() {
        return titulaire;
    }

    public Integer getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(Integer typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }

    public void setTitulaire(Integer titulaire) {
        this.titulaire = titulaire;
    }

    public static void setListeDesComptes(ArrayList<Compte> listeDesComptes) {
        Compte.listeDesComptes = listeDesComptes;
    }
}
