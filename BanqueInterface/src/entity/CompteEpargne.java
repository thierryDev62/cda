package entity;

public class CompteEpargne extends Compte {
    private int tauxInteret = 5;

    public CompteEpargne(String typeDeCompte) {
        super(typeDeCompte);
    }

    public int getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(int tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
