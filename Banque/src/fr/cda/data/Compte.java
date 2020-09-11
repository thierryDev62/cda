package fr.cda.data;

public class Compte {
    private Integer code;
    private Float solde;
    private Integer typeDeCompte;

    public Compte(Integer code, Float solde, Integer typeDeCompte) {
        this.code = code;
        this.solde = solde;
        this.typeDeCompte = typeDeCompte;
    }
    public void creationCompte(){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public Integer getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(Integer typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }
}
