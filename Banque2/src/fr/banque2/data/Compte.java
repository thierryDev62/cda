package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

import java.util.ArrayList;

public class Compte {
    private final Integer code;
    private Integer solde;
    private Integer typeDeCompte; // 1 - Compte courant - 2 - Compte épargne
    private Integer titulaire;
    private Boolean compteValide;
    private static ArrayList<Compte> listeDesComptes = new ArrayList<>();

    public Compte(Integer code, Integer solde, Integer typeDeCompte, Integer titulaire, Boolean compteValide) {
        this.code = code;
        this.solde = solde;
        this.typeDeCompte = typeDeCompte;
        this.titulaire = titulaire;
        this.compteValide = compteValide;
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
        Integer choix = Tools.askThing(1);
        
            Integer id = Connexion.getId();

            TConsole.toprintln("*********************************************************" +
                    "\nCréation d'un compte" +
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

            Compte nouveauCompte = null;
            
            if(choix == 1) {
                nouveauCompte = new CompteCourant(numeroCompte, soldeDuCompte, 1, 0, id, false);
            } else if(choix == 2) {
                nouveauCompte = new CompteEpargne(numeroCompte, soldeDuCompte, 2, 0, id, false);
            }

                TConsole.toprintln("*********************************************************" +
                        "\nRécapitulatif de la création du compte :" +
                        "\nNuméro de compte : " + nouveauCompte.getCode() +
                        "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                        "\n*********************************************************" +
                        "\n*       Le nouveau compte a bien été créé !     *" +
                        "\n*********************************************************"
                );
        
    }
    /**
     * Consultation du solde d'un compte
     */
    public static void consultationSolde() {
        Integer id = Connexion.getId();
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
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
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
        Integer id = Connexion.getId();
        TConsole.toprintln("*********************************************************" +
                "\nListe des opérations sur le compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);

        TConsole.toprintln("Liste des opérations sur le compte n°" + saisiNumeroCompte);
        TConsole.toprintln("*************************************************************************************");
        for (Compte compte : Compte.getListeDesComptes()) {
            if (saisiNumeroCompte.equals(compte.getCode()) && compte.getTitulaire().equals(id)) {
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
        }
    }
    /**
     * Total des versements
     */
    public static void totalVersements() {
        Integer id = Connexion.getId();
        TConsole.toprintln("*********************************************************" +
                "\nTotal des versements" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalVersement = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for (Compte compte : Compte.getListeDesComptes()) {
            for (Operation versement : Operation.getListeOperations()) {
                if (saisiNumeroCompte.equals(compte.getCode()) && saisiNumeroCompte.equals(versement.getNumeroCompteOperation()) && versement.getLibelleOperation().equals("Versement") && compte.getTitulaire().equals(id)) {
                    totalVersement += versement.getMontantOperation();
                }
            }
        }
        TConsole.toprintln("Montant total des versements : " + totalVersement + "€");
    }
    /**
     * Total des retraits
     */
    public static void totalRetraits() {
        Integer id = Connexion.getId();
        TConsole.toprintln("*********************************************************" +
                "\nTotal des retraits" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte concerné (0 pour annuler)");
        TConsole.toprint(">");
        Integer saisiNumeroCompte = Tools.askThing(1);
        Integer totalRetrait = 0;
        TConsole.toprintln("Total des versements pour le compte n°" + saisiNumeroCompte);
        for (Compte compte : Compte.getListeDesComptes()) {
            for (Operation retrait : Operation.getListeOperations()) {
                if (saisiNumeroCompte.equals(compte.getCode()) && saisiNumeroCompte.equals(retrait.getNumeroCompteOperation()) && retrait.getLibelleOperation().equals("Retrait") && compte.getTitulaire().equals(id)){
                    totalRetrait += retrait.getMontantOperation();
                }
            }
        }
        TConsole.toprintln("Montant total des retraits : " + totalRetrait + "€");
    }

    /**
     * Liste de tous les comptes d'un client connecté ou le conseiller
     */
    public static void listeTousLesComptes(Integer type) {
        Integer id = Connexion.getId();
        ArrayList<Compte> listeTousLesCompte = new ArrayList<>();
        TConsole.toprintln("*********************************************************" +
                "\nListe des tous les comptes" +
                "\n*********************************************************"
        );
        if(!Compte.getListeDesComptes().isEmpty()) {
            for (Compte compte : Compte.getListeDesComptes()) {
                if (compte.getTitulaire().equals(id)) {
                    listeTousLesCompte.add(compte);
                } else if (type == 2) {
                    listeTousLesCompte.add(compte);
                }
            }
            String typeCompte = "", afficheDecouvertOuTaux = "";
            Integer decouvert, tauxInteret;
            for(Compte listeFinale : listeTousLesCompte) {
                if (listeFinale instanceof CompteCourant) {
                    decouvert = ((CompteCourant) listeFinale).getDecouvert();
                    typeCompte = "Compte courant : ";
                    afficheDecouvertOuTaux = "€ | Découvert autorisé : " + decouvert + "€";

                } else if (listeFinale instanceof CompteEpargne) {
                    tauxInteret = ((CompteEpargne) listeFinale).getTauxInteret();
                    typeCompte = "Compte épargne : ";
                    afficheDecouvertOuTaux = "€ | Taux d'interêt : " + tauxInteret + "%";
                }
                    System.out.println(typeCompte +
                            "- Numéro de compte : " + listeFinale.getCode() +
                            " | Solde : " + listeFinale.getSolde() +
                            afficheDecouvertOuTaux +
                            " | Statut : " + (listeFinale.getCompteValide() ? "Validé" : "En attente de validation")
                    );
                }
            } else {
            // TODO : bug se répète
            TConsole.toprintln("Aucun compte de créé !");
        }
        if(type == 2) {
            Menus.menuConseiller();
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

    public Boolean getCompteValide() {
        return compteValide;
    }

    public void setCompteValide(Boolean compteValide) {
        this.compteValide = compteValide;
    }
}
