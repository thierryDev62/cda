package fr.cda.data;

public class CompteCourant extends Compte{
    private Integer decouvert;

    public CompteCourant(Integer code, double solde, Integer typeDeCompte, Integer decouvert) {
        super(code, (float) solde, typeDeCompte);
        this.decouvert = decouvert;
    }

    public Integer getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Integer decouvert) {
        this.decouvert = decouvert;
    }
}
