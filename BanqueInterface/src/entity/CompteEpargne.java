package entity;

public class CompteEpargne extends Compte {
    private int tauxInteret = 5;

    public CompteEpargne(int numeroCompte, int solde, int typeDeCompte, int titulaire, int tauxInteret) {
        super(numeroCompte, solde, typeDeCompte, titulaire);
        this.tauxInteret = tauxInteret;
    }

    public int getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(int tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
