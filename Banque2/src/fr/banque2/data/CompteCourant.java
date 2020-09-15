package fr.banque2.data;

public class CompteCourant extends Compte{
    private Integer decouvert;

    public CompteCourant(Integer code, Integer solde, Integer decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    public static void soldeCompteCourant(Integer saisiNumeroCompte) {
        for (CompteCourant compte : Compte.getListeCompteCourant()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                System.out.println("Numéro de compte : " +
                        compte.getCode() + " - Compte courant" +
                        "\n*********************************************************" +
                        "\nSolde du compte : " + compte.getSolde() + "€" +
                        "\n*********************************************************"
                );
                return;
            }
        }
    }

    public Integer getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Integer decouvert) {
        this.decouvert = decouvert;
    }

}
