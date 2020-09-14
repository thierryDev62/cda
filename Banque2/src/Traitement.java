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
                "6 - Mettre à jour le solde d'un compte (épargne) | " +
                "7 - Liste des opérations effectuées | " +
                "8 - Total des versements | " +
                "9 - Total des retraits"
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
                break;
            case 5:
                Compte.consultationSolde();
                Traitement.main(new String[0]);
                break;
            case 6:
                miseAJourSoldeCompteEpargne();
                break;
            case 7:
                listeOperations();
                break;
            case 8:
                totalVersements();
                break;
            case 9:
                totalRetraits();
                break;
        }
    }

    private static void totalRetraits() {
    }

    private static void totalVersements() {
    }

    private static void listeOperations() {
    }

    private static void miseAJourSoldeCompteEpargne() {
    }

}
