package fr.banque2.data.entity;

import diplo.tools.TConsole;
import diplo.tools.Tools;
import java.util.ArrayList;

public class Operation {
    private Integer numeroCompteOperation;
    private Integer numeroOperation;
    private String dateOperation;
    private String libelleOperation;
    private Integer montantOperation;
    private static ArrayList<Operation> listeOperations = new ArrayList<>();

    public Operation(Integer numeroCompteOperation, String dateOperation, String libelleOperation, Integer montantOperation) {
        this.numeroCompteOperation = numeroCompteOperation;
        this.numeroOperation = Tools.intRandom();;
        this.dateOperation = dateOperation;
        this.libelleOperation = libelleOperation;
        this.montantOperation = montantOperation;
        listeOperations.add(this);
    }

    /**
     * Affichage du résultat de l'ajout d'une nouvelle opération
     */
    public void affichageOperation(){
        System.out.println("*******************************************************************************" +
                "\nRécapitulatif de l'opération :" +
                "\nNuméro de compte : " + this.numeroCompteOperation +
                "\nDate d'opération : " + this.dateOperation +
                "\nNuméro d'opération : " + this.numeroOperation +
                "\nLibellé de l'opération : " + this.libelleOperation +
                "\nMontant : " + this.montantOperation + "€" +
                "\n*******************************************************************************"
        );
        TConsole.toprintln(
                "Le "+ this.libelleOperation + " de " + this.montantOperation + "€ à bien été effectué !" +
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
