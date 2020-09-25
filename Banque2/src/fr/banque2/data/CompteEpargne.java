package fr.banque2.data;

public class CompteEpargne extends Compte {
    private Integer tauxInteret = 5;

    public CompteEpargne(Integer code, Integer solde, Integer typeDeCompte, Integer titulaire) {
        super(code, solde, typeDeCompte, titulaire);
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Integer tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
