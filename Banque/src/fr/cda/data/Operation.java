package fr.cda.data;

import java.sql.Date;

public class Operation {
    private Integer numero;
    private String date;
    private Integer montant;

    public Operation(Integer numero, String date, Integer montant) {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
    }

    public void versement(){

    }
    public void retrait(){

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }
}
