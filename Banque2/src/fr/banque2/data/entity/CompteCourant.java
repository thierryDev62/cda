package fr.banque2.data.entity;

import fr.banque2.data.entity.Compte;

public class CompteCourant extends Compte {
    private Integer decouvert = 500;

    public CompteCourant(Integer code, Integer typeDeCompte, Integer titulaire) {
        super(code, typeDeCompte, titulaire);
    }
    public Integer getDecouvert() {
        return decouvert;
    }
}
