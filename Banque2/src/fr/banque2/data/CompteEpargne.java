package fr.banque2.data;

public class CompteEpargne extends Compte {
    private Integer tauxInteret;

    public CompteEpargne(Integer code, Integer solde, Integer tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    public static void soldeCompteEpargne(Integer saisiNumeroCompte) {
        for (CompteEpargne compte : Compte.getListeCompteEpargne()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                Integer soldeFinal = calculSolde(compte.getSolde(), compte.getTauxInteret());
                System.out.println("Numéro de compte : " +
                        compte.getCode() + " - Compte épargne" +
                        "\n*****************************************************************************************" +
                        "\nSolde du compte : " + soldeFinal + "€" + " avec un taux d'interêt de " + compte.getTauxInteret() + "%" +
                        "\n*****************************************************************************************"
                );
                return;
            }
        }
    }

    public static Integer calculSolde(Integer solde, Integer tauxInteret) {
        Integer soldeFinal = null;
        for(CompteEpargne compte : Compte.getListeCompteEpargne()) {
            tauxInteret = compte.getTauxInteret();
            solde = compte.getSolde();
            soldeFinal = solde + (solde * tauxInteret / 100);
        }
        return soldeFinal;
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Integer tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
