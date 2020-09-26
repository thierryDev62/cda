package fr.banque2.data;

public class CompteCourant extends Compte{
    private Integer decouvert = 500;

    public CompteCourant(Integer code, Integer solde, Integer typeDeCompte, Integer titulaire) {
        super(code, solde, typeDeCompte, titulaire);
    }

    public Integer getDecouvert() {
        return decouvert;
    }

}
