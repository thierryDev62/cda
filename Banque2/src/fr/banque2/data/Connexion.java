package fr.banque2.data;

public class Connexion {
    private static Integer id;
    private static String motDePasse;

    public Connexion(Integer id, String motDePasse) {
        Connexion.id = id;
        Connexion.motDePasse = motDePasse;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Connexion.id = id;
    }

    public static String getMotDePasse() {
        return motDePasse;
    }

    public static void setMotDePasse(String motDePasse) {
        Connexion.motDePasse = motDePasse;
    }
}
