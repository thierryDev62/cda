package entity;

public class CompteCourant extends Compte {
    private int decouvert = 500;

    public CompteCourant(int numeroCompte, int solde, int typeDeCompte, int titulaire, int decouvert) {
        super(numeroCompte, solde, typeDeCompte, titulaire);
        this.decouvert = decouvert;
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }
}
