package fr.cda.data;

public class CompteCourant extends Compte{
    private Integer decouvert;

    public CompteCourant(Integer code, double solde, Integer decouvert) {
        super(code, (float) solde);
        this.decouvert = decouvert;
    }

    public Integer getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Integer decouvert) {
        this.decouvert = decouvert;
    }
}
