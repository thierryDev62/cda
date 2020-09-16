package fr.banque2.data;

public class CompteEpargne extends Compte {
    private Integer tauxInteret;

    public CompteEpargne(Integer code, Integer solde, Integer typeDeCompte, Integer tauxInteret) {
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
