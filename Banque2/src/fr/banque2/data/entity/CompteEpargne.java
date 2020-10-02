package fr.banque2.data.entity;

public class CompteEpargne extends Compte {
    private Integer tauxInteret = 5;

    public CompteEpargne(Integer code, Integer typeDeCompte, Integer titulaire) {
        super(code, typeDeCompte, titulaire);
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }
}
