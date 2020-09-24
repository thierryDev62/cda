package fr.banque2.data;

public class CompteCourant extends Compte{
    private Integer decouvert;

    public CompteCourant(Integer code, Integer solde, Integer typeDeCompte, Integer decouvert, Integer titulaire, Boolean compteValide) {
        super(code, solde, typeDeCompte, titulaire, compteValide);
        this.decouvert = decouvert;
    }

    public Integer getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Integer decouvert) {
        this.decouvert = decouvert;
    }

}
