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
        TConsole.toprintln("*********************************************************" +
                "\nConnexion à votre compte utilisateur (0 pour annuler)" +
                "\n*********************************************************");
        TConsole.toprintln("Saisir votre identifiant :");
        Integer identifiant = Tools.askThing(1);
        if(identifiant == 0) {
            TConsole.toprintln("Annulation");
            Menus.menuAuthOuCreer(type);
        }

        TConsole.toprintln("Saisir votre mot de passe :");
        String motdepasse = Tools.askThing();

        if(!Utilisateurs.getListeDesUtilisateurs().isEmpty()) {
            for (Utilisateurs verifIdEtMdp : Utilisateurs.getListeDesUtilisateurs()) {
                if (verifIdEtMdp instanceof Client && identifiant.equals(verifIdEtMdp.getId()) && motdepasse.equals(verifIdEtMdp.getMotDePasse()) && type == 1) {
                    TConsole.toprintln("Vous êtes connecté ! \nBienvenue à vous " + verifIdEtMdp.getPrenom());
                    Connexion login = new Connexion(identifiant, motdepasse);
                    Menus.menuClient();
                } else if (verifIdEtMdp instanceof Conseiller && identifiant.equals(verifIdEtMdp.getId()) && motdepasse.equals(verifIdEtMdp.getMotDePasse()) && type == 2){
                    TConsole.toprintln("Vous êtes connecté ! \nBienvenue à vous conseiller " + verifIdEtMdp.getNom() + " " + verifIdEtMdp.getPrenom());
                    verifIdEtMdp.setId(identifiant);
                    verifIdEtMdp.setMotDePasse(motdepasse);
                    Connexion login = new Connexion(identifiant, motdepasse);
                    Menus.menuConseiller();
                }
            }
            TConsole.toprintln("Le mot de passe et/ou l'identifiant ne sont pas bon, veuillez recommencer !");
        } else {
            TConsole.toprintln("Il n'y a pas encore de compte utilisateur d'enregistré");
        }
        login(type);
    }

    public static Integer getId() {
        return id;
    }
}
