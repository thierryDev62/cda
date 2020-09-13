package fr.banque2.data;

public class Compte {
    private Integer code;
    private Integer solde;

    public Compte(Integer code, Integer solde) {
        this.code = code;
        this.solde = solde;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }
}
