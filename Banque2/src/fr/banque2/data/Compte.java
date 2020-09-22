package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Compte {
    private final Integer code;
    private Integer solde;
    private Integer typeDeCompte; // 1 - Compte courant - 2 - Compte épargne
    private Integer titulaire;
    private static ArrayList<Compte> listeDesComptes = new ArrayList<>();

    public Compte(Integer code, Integer solde, Integer typeDeCompte, Integer titulaire) {
        this.code = code;
        this.solde = solde;
        this.typeDeCompte = typeDeCompte;
        this.titulaire = titulaire;
        listeDesComptes.add(this);
    }

    /**
     * Creation compte
     */
    public static void creationNouveauCompte(){
        TConsole.toprintln("*********************************************************" +
                "\nCréation d'un nouveau compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Quel type de compte voulez-vous créer ? \n1 - Compte courant | 2 - Compte épargne");
        TConsole.toprint(">");
        int choix = Tools.askThing(1);

        if(choix == 1) {
            Integer id = Connexion.getId();
            TConsole.toprintln("*********************************************************" +
                    "\nCréation d'un compte courant" +
                    "\n*********************************************************"
            );
            TConsole.toprintln("Saisir le numéro de compte");
            TConsole.toprint(">");
            Integer numeroCompte = Tools.askThing(1);

            for(Compte liste : Compte.getListeDesComptes()) {
                if(numeroCompte.equals(liste.getCode())) {
                    TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                    Compte.creationNouveauCompte();
                    return;
                }
            }

            TConsole.toprintln("Saisir le solde du compte");
            TConsole.toprint(">");
            Integer soldeDuCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le découvert autorisé");
            TConsole.toprint(">");
            Integer decouvert = Tools.askThing(1);

            CompteCourant nouveauCompte = new CompteCourant(numeroCompte, soldeDuCompte, 1, decouvert, id);


            //TODO : attribuer compte

            {
                TConsole.toprintln("*********************************************************" +
                        "\nRécapitulatif de la création du compte courant :" +
                        "\nNuméro de compte : " + nouveauCompte.getCode() +
                        "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                        "\nDécouvert autorisé : " + nouveauCompte.getDecouvert() + "€" +
                        "\n*********************************************************" +
                        "\n*       Le nouveau compte courant a bien été créé !     *" +
                        "\n*********************************************************"
                );
            }
        } else if(choix == 2) {
            Integer id = Connexion.getId();
            TConsole.toprintln("*********************************************************" +
                    "\nCréation d'un compte épargne" +
                    "\n*********************************************************"
            );
            TConsole.toprintln("Saisir le numéro de compte");
            TConsole.toprint(">");
            Integer numeroCompte = Tools.askThing(1);

            for(Compte liste : Compte.getListeDesComptes()) {
                if(numeroCompte.equals(liste.getCode())) {
                    TConsole.toprintln("Ce numéro de compte existe déjà, veuillez en saisir un autre");
                    Compte.creationNouveauCompte();
                    return;
                }
            }

            TConsole.toprintln("Saisir le solde du compte");
            TConsole.toprint(">");
            Integer soldeDuCompte = Tools.askThing(1);
            TConsole.toprintln("Saisir le taux d'intérêt");
            TConsole.toprint(">");
            Integer tauxInteret = Tools.askThing(1);

            CompteEpargne nouveauCompte = new CompteEpargne(numeroCompte, soldeDuCompte, 2, tauxInteret, id);

            TConsole.toprintln("*********************************************************" +
                    "\nRécapitulatif de la création du compte épargne :" +
                    "\nNuméro de compte : " + nouveauCompte.getCode() +
                    "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                    "\nTaux d'interêt : " + nouveauCompte.getTauxInteret() + "%" +
                    "\n*********************************************************" +
                    "\n*     Le nouveau compte épargne a bien été créé !       *" +
                    "\n*********************************************************"
            );
        } else {
            TConsole.toprintln("Vous devez saisir 1 ou 2");
            Compte.creationNouveauCompte();
        }
    }
    /**
     * Consultation du solde d'un compte
     */
    public static void consultationSolde() {
        TConsole.toprintln("*********************************************************" +
                "\nConsultation du solde d'un compte" +
                "\n*********************************************************"
        );

        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        if(saisiNumeroCompte == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
        }

        for (Compte compte : Compte.getListeDesComptes()) {
            if (saisiNumeroCompte.equals(compte.getCode())) {
                Integer typeDeCompte = compte.getTypeDeCompte();
                String type = "";
                if(typeDeCompte == 1) {
                    type = "Compte courant";
                } else if(typeDeCompte == 2) {
                    type = "Compte épargne";
                }
                System.out.println("Numéro de compte : " +
                        compte.getCode() + " | Type de compte : " + type +
                        "\n*********************************************************" +
                        "\nSolde du compte : " + compte.getSolde() + "€" +
                        "\n*********************************************************"
                );
                return;
            }
        }
    }

    /**
     * Liste des opérations sur un compte
     */
    public static void listeOperations() {
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        TConsole.toprintln("Liste des opérations sur le compte n°" + saisiNumeroCompte);
        TConsole.toprintln("*************************************************************************************");
        for (Operation operation : Operation.getListeOperations()) {
            if (saisiNumeroCompte.equals(operation.getNumeroCompteOperation())) {
                System.out.println(
                        " - Numéro d'opération : " + operation.getNumeroOperation() +
                                " - Date : " + operation.getDateOperation() +
                                " - Type : " + operation.getLibelleOperation() +
                                " - Montant : " + operation.getMontantOperation() + "€"
                );
            }
        }
        TConsole.toprintln("*************************************************************************************");
    }
    /**
     * Total des versements
     */
    public static void totalVersements() {
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalVersement = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for(Operation versement : Operation.getListeOperations()) {
            if(saisiNumeroCompte.equals(versement.getNumeroCompteOperation()) && versement.getLibelleOperation().equals("Versement")) {
                totalVersement += versement.getMontantOperation();
            }
        }
        TConsole.toprintln("Montant total : " + totalVersement + "€");
    }
    /**
     * Total des retraits
     */
    public static void totalRetraits() {
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalRetrait = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for(Operation retrait : Operation.getListeOperations()) {
            if(saisiNumeroCompte.equals(retrait.getNumeroCompteOperation()) && retrait.getLibelleOperation().equals("Retrait")) {
                totalRetrait += retrait.getMontantOperation();
            }
        }
        TConsole.toprintln("Montant total : " + totalRetrait + "€");
    }

    /**
     * Liste de tous les comptes
     */
    public static void listeTousLesComptes() {
        Integer id = Connexion.getId();
        TConsole.toprintln("Liste de tous les comptes créés :");

        //TODO : Voir pour appeler l'instance

        if(Compte.getListeDesComptes().size() > 0) {
            for (Compte compte : Compte.getListeDesComptes()) {
                if (compte instanceof CompteCourant && compte.getTitulaire().equals(id)) {
                    Integer decouvert = ((CompteCourant) compte).getDecouvert();
                    System.out.println("Compte courant : " + "- Numéro de compte : " + compte.getCode() + " - Solde : " + compte.getSolde() + "€ - Découvert autorisé : " + decouvert + "€ - Titulaire : " + compte.getTitulaire());
                } else if (compte instanceof CompteEpargne && compte.getTitulaire().equals(id)) {
                    Integer tauxInteret = ((CompteEpargne) compte).getTauxInteret();
                    System.out.println("Compte épargne : " + "- Numéro de compte : " + compte.getCode() + " - Solde : " + compte.getSolde() + "€ - Taux d'interêt : " + tauxInteret + "% - Titulaire : " + compte.getTitulaire());
                }
            }
        } else {
            TConsole.toprintln("Aucun compte de créé !");
        }
    }
    public Integer getCode() {
        return code;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public static ArrayList<Compte> getListeDesComptes() {
        return listeDesComptes;
    }

    public static void setListeDesComptes(ArrayList<Compte> listeDesComptes) {
        Compte.listeDesComptes = listeDesComptes;
    }

    public Integer getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(Integer typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }

    public Integer getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Integer titulaire) {
        this.titulaire = titulaire;
    }
}
