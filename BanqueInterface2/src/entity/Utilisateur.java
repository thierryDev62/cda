package entity;

public class Utilisateur {
    private static int utilisateurId;
    private static String utilisateurNom;
    private static String utilisateurPrenom;
    private static String utilisateurMdp;
    private static Boolean compteActif;
    private static int typeUtilisateur;

    public static int getUtilisateurId() {
        return utilisateurId;
    }

    public static void setUtilisateurId(int utilisateurId) {
        Utilisateur.utilisateurId = utilisateurId;
    }

    public static String getUtilisateurNom() {
        return utilisateurNom;
    }

    public static String setUtilisateurNom(String utilisateurNom) {
        Utilisateur.utilisateurNom = utilisateurNom;
        return utilisateurNom;
    }

    public static String getUtilisateurPrenom() {
        return utilisateurPrenom;
    }

    public static String setUtilisateurPrenom(String utilisateurPrenom) {
        Utilisateur.utilisateurPrenom = utilisateurPrenom;
        return utilisateurPrenom;
    }

    public static String getUtilisateurMdp() {
        return utilisateurMdp;
    }

    public static String setUtilisateurMdp(String utilisateurMdp) {
        Utilisateur.utilisateurMdp = utilisateurMdp;
        return utilisateurMdp;
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
