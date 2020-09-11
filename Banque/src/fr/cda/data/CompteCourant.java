package fr.cda.data;

public class CompteCourant extends Compte{
    private Integer decouvert;

    public CompteCourant(Integer code, Float solde, Integer typeDeCompte, Integer decouvert) {
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
