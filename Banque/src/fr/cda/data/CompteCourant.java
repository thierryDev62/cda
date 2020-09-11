package fr.cda.data;

public class CompteCourant extends Compte{
    private static final Integer typeDeCompte = 1;
    private Integer decouvert;

    public CompteCourant(Integer code, Float solde, Integer integer, Integer decouvert) {
        super(code, solde, typeDeCompte);
        this.decouvert = decouvert;
    }

    public Integer getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Integer decouvert) {
        this.decouvert = decouvert;
    }
}
