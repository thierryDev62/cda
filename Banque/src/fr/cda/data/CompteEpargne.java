package fr.cda.data;

public class CompteEpargne extends Compte {
    private static final Integer typeDeCompte = 2;
    private Integer tauxInteret;

    public CompteEpargne(Integer code, Float solde, Integer interet, Integer tauxInteret) {
        super(code, solde, typeDeCompte);
        this.tauxInteret = tauxInteret;
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Integer tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
