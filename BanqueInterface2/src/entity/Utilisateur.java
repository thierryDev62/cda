package entity;

public class Utilisateur {
    private static String typeUtilisateur;

    public static String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public static void setTypeUtilisateur(String typeUtilisateur) {
        Utilisateur.typeUtilisateur = typeUtilisateur;
    }
}
