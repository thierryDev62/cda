package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operation {
    private Integer numeroCompteOperation;
    private Integer numeroOperation;
    private String dateOperation;
    private String libelleOperation;
    private Integer montantOperation;
    private static ArrayList<Operation> listeOperations = new ArrayList<>();

    public Operation(Integer numeroCompteOperation, Integer numeroOperation, String dateOperation, String libelleOperation, Integer montantOperation) {
        this.numeroCompteOperation = numeroCompteOperation;
        this.numeroOperation = numeroOperation;
        this.dateOperation = dateOperation;
        this.libelleOperation = libelleOperation;
        this.montantOperation = montantOperation;
        listeOperations.add(this);
    }

    /**
     * Ajout d'une nouvelle opération
     * @param numeroCompteOperation Numéro de compte
     * @param typeOperation Type d'opération
     * @param montant Montant du versement
     */
    public static void nouvelleOperation(Integer numeroCompteOperation, String typeOperation, Integer montant){
        Integer resultRandom = Tools.intRandom(); // Numéro d'opération au hasard

        Operation operation = new Operation(numeroCompteOperation, resultRandom, Banque.dateDuJour(), typeOperation, montant);
        System.out.println("*******************************************************************************" +
                "\nRécapitulatif de l'opération :" +
                "\nDate d'opération : " + operation.dateOperation +
                "\nNuméro d'opération : " + operation.numeroOperation +
                "\nLibellé de l'opération : " + operation.libelleOperation +
                "\nMontant : " + montant + "€" +
                "\n*******************************************************************************"
        );
        TConsole.toprintln(
                "Le "+ typeOperation + " de " + montant + "€ à bien été effectué !" +
                        "\n*******************************************************************************"
        );
    }

    public Integer getNumeroCompteOperation() {
        return numeroCompteOperation;
    }

    public Integer getNumeroOperation() {
        return numeroOperation;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public String getLibelleOperation() {
        return libelleOperation;
    }

    public Integer getMontantOperation() {
        return montantOperation;
    }

    public static ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }
}
