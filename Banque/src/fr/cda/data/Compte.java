package fr.cda.data;

import java.util.ArrayList;

public class Compte {
    private Integer code;
    private Float solde;

    public Compte(Integer code, Float solde) {
        this.code = code;
        this.solde = solde;
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
}
