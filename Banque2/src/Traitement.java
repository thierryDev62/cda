import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.*;

public class Traitement {
    public static void main(String[] arg) {
        TConsole.toprintln("Faites votre choix :" +
                "\n1 - Créer un compte | " +
                "2 - Versement | " +
                "3 - Retrait | " +
                "4 - Virement de compte à compte | " +
                "5 - Consultation solde | " +
                "6 - Liste des opérations effectuées | " +
                "7 - Total des versements | " +
                "8 - Total des retraits | " +
                "9 - Liste de tous les comptes"
        );
        Integer choix = Tools.askThing(1);

        switch(choix) {
            case 1:
                Compte.creationNouveauCompte();
                Traitement.main(new String[0]);
                break;
            case 2:
                Operation.versementSurUnCompte();
                Traitement.main(new String[0]);
                break;
            case 3:
                Operation.retraitSurUnCompte();
                Traitement.main(new String[0]);
                break;
            case 4:
                Operation.virement();
                Traitement.main(new String[0]);
                break;
            case 5:
                Compte.consultationSolde();
                Traitement.main(new String[0]);
                break;
            case 6:
                Compte.listeOperations();
                Traitement.main(new String[0]);
                break;
            case 7:
                Compte.totalVersements();
                Traitement.main(new String[0]);
                break;
            case 8:
                Compte.totalRetraits();
                Traitement.main(new String[0]);
                break;
            case 9:
                Compte.listeTousLesComptes();
                Traitement.main(new String[0]);
                break;
            default:
                TConsole.toprintln("Veuillez saisir un chiffre de 1 à 9");
                Traitement.main(new String[0]);
                break;
        }
    }
}
