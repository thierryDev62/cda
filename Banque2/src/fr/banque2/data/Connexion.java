package fr.banque2.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class Connexion {
    private static Integer id;
    private static String motDePasse;

    public Connexion(Integer id, String motDePasse) {
        Connexion.id = id;
        Connexion.motDePasse = motDePasse;
    }
    public static void login(Integer type) {
        TConsole.toprintln("Connexion");
        TConsole.toprintln("Saisir votre identifiant :");
        Integer identifiant = Tools.askThing(1);

        if(Utilisateurs.getListeDesUtilisateurs().size() > 0) {

            TConsole.toprintln("Saisir votre mot de passe :");
            String motdepasse = Tools.askThing();

            Connexion login = new Connexion(identifiant, motdepasse);
            TConsole.toprintln("Vous êtes connecté !!");

            if (type == 1) {
                Menus.menuClient();
            } else if (type == 2) {
                Menus.menuConseiller();
            }
        } else {
            TConsole.toprintln("Ce numéro d'identifiant n'existe pas, veuillez recommencer ! (0 pour annuler)");
            Integer choix = Tools.askThing(1);
            if (choix == 0) {
                Menus.menuAuthOuCreer(type);
            } else {
                login(type);
            }

        }
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
