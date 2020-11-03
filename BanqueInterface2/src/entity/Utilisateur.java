package entity;

public class Utilisateur {
    private static int typeUtilisateur;

    public static int getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public static void setTypeUtilisateur(int typeUtilisateur) {
        Utilisateur.typeUtilisateur = typeUtilisateur;
    }
}
