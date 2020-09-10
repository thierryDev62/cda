package fr.cda.data;

public class CompteEpargne extends Compte {
    private Integer tauxInteret;

    public CompteEpargne(Integer code, Float solde, Integer tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Integer tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
