package fr.banque2.data;

import diplo.tools.TConsole;

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
     * Liste de tous les comptes d'un client connecté ou vu par le conseiller
     */
    public static void listeTousLesComptes(Integer type) {
        Integer id = Connexion.getId();
        String typeCompte = "", afficheDecouvertOuTaux = "";
        Integer decouvert, tauxInteret;
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
                        "\n*********************************************************"
                );
            }
            if(type == 2) {
                Menus.menuConseiller();
            }
        } else {
            TConsole.toprintln("Aucun compte de créé !");
            if(type == 2) {
                Menus.menuConseiller();
            } else if(type == 1) {
                Menus.menuClient();
            }
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

    public Integer getTypeDeCompte() {
        return typeDeCompte;
    }

    public Integer getTitulaire() {
        return titulaire;
    }

}
