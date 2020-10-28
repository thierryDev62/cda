package entity;

public class CompteCourant extends Compte {
    private int decouvert = 500;

    public CompteCourant(String typeDeCompte) {
        super(typeDeCompte);
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }
}
