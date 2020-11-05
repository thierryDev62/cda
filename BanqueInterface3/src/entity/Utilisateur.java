package entity;

public class Utilisateur {
    private static int utilisateurId;
    private String utilisateurNom;
    private String utilisateurPrenom;
    private String utilisateurMdp;
    private static Boolean compteActif;
    private static int typeUtilisateur;

    public Utilisateur(String utilisateurNom, String utilisateurPrenom, String utilisateurMdp) {
        this.utilisateurNom = utilisateurNom;
        this.utilisateurPrenom = utilisateurPrenom;
        this.utilisateurMdp = utilisateurMdp;
    }

    public static int getUtilisateurId() {
        return utilisateurId;
    }

    public static void setUtilisateurId(int utilisateurId) {
        Utilisateur.utilisateurId = utilisateurId;
    }

    public String getUtilisateurNom() {
        return utilisateurNom;
    }

    public void setUtilisateurNom(String utilisateurNom) {
        this.utilisateurNom = utilisateurNom;
    }

    public String getUtilisateurPrenom() {
        return utilisateurPrenom;
    }

    public void setUtilisateurPrenom(String utilisateurPrenom) {
        this.utilisateurPrenom = utilisateurPrenom;
    }

    public String getUtilisateurMdp() {
        return utilisateurMdp;
    }

    public void setUtilisateurMdp(String utilisateurMdp) {
        this.utilisateurMdp = utilisateurMdp;
    }

    public static Boolean getCompteActif() {
        return compteActif;
    }

    public static void setCompteActif(Boolean compteActif) {
        Utilisateur.compteActif = compteActif;
    }

    public static int getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public static void setTypeUtilisateur(int typeUtilisateur) {
        Utilisateur.typeUtilisateur = typeUtilisateur;
    }
}
