import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.banque2.data.Compte;
import fr.banque2.data.CompteCourant;
import fr.banque2.data.CompteEpargne;

public class Traitement {
    public static void main(String[] arg) {
        TConsole.toprintln("Faites votre choix :" +
                "\n1 - Créer un compte courant" +
                "\n2 - Créer un compte épargne" +
                "\n3 - Versement" +
                "\n4 - Retrait" +
                "\n5 - Virement de compte à compte" +
                "\n6 - Consultation solde" +
                "\n7 - Mettre à jour le solde d'un compte (épargne)" +
                "\n8 - Liste des opérations effectuées" +
                "\n9 - Total des versements" +
                "\10 - Total des retraits"
        );
        Integer choix = Tools.askThing(1);

        switch(choix) {
            case 1:
                creationCompteCourant();
                break;
            case 2:
                creationCompteEpargne();
                break;
            case 3:
                versement();
                break;
            case 4:
                retrait();
                break;
            case 5:
                virement();
                break;
            case 6:
                consultationSolde();
                break;
            case 7:
                miseAJourSoldeCompteEpargne();
                break;
            case 8:
                listeOperations();
                break;
            case 9:
                totalVersements();
                break;
            case 10:
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

    /**
     * Consultation du solde d'un compte
     */
    public static void consultationSolde() {
        TConsole.toprintln("Consultation du solde d'un compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("1 - Compte courant | 2 - Compte épargne | 0 - Annuler");
        Integer reponse = Tools.askThing(1);

        if(reponse == 1) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            for (int i = 0; i < CompteCourant.getListeCompte().size(); i++) {
                System.out.println(CompteCourant.getListeCompte().get(i).getDecouvert());
                if (saisiNumeroCompte.equals(CompteCourant.getListeCompte().get(i).getCode())) {
                    System.out.println("Numéro de compte : " +
                            CompteCourant.getListeCompte().get(i).getCode() +
                            "\nSolde du compte : " + CompteCourant.getListeCompte().get(i).getSolde() + "€"
                    );
                    Traitement.main(new String[0]);
                    return;
                }
            }
        } else if(reponse == 2) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            for (int i = 0; i < CompteEpargne.getListeCompte().size(); i++) {
                System.out.println(CompteEpargne.getListeCompte().get(i).getTauxInteret());
                if (saisiNumeroCompte.equals(CompteEpargne.getListeCompte().get(i).getCode())) {
                    System.out.println("Numéro de compte : " +
                            CompteEpargne.getListeCompte().get(i).getCode() +
                            "\nSolde du compte : " + CompteEpargne.getListeCompte().get(i).getSolde() + "€"
                    );
                    Traitement.main(new String[0]);
                    return;
                }
            }
        } else if(reponse == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            Traitement.main(new String[0]);
        } else {
            TConsole.toprintln("Veuillez saisir 1 ou 2");
            Traitement.consultationSolde();
        }
        TConsole.toprintln("Le compte n'a pas été trouvé !");
        Traitement.main(new String[0]);
    }

    private static void virement() {
    }

    private static void retrait() {
    }

    /**
     * Versement sur un compte
     */
    private static void versement() {
        TConsole.toprintln("Versement sur un compte" +
                "\n*********************************************************"
        );
        TConsole.toprintln("1 - Compte courant | 2 - Compte épargne | 0 - Annuler");
        Integer reponse = Tools.askThing(1);

        if(reponse == 1) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            TConsole.toprintln("Saisir le montant que vous voulez verser sur le compte");
            Integer montantVersement = Tools.askThing(1);

            for (int i = 0; i < CompteCourant.getListeCompte().size(); i++) {
                System.out.println(CompteCourant.getListeCompte().get(i).getDecouvert());
                if (saisiNumeroCompte.equals(CompteCourant.getListeCompte().get(i).getCode())) {
                    System.out.println("Numéro de compte : " +
                            CompteCourant.getListeCompte().get(i).getCode() +
                            "\nSolde du compte avant versement : " + CompteCourant.getListeCompte().get(i).getSolde() + "€"
                    );
                    Integer soldeFinal = montantVersement + CompteCourant.getListeCompte().get(i).getSolde();
                    CompteCourant.getListeCompte().get(i).setSolde(soldeFinal);
                    System.out.println("Solde de compte après versement : " + CompteCourant.getListeCompte().get(i).getSolde() + "€");
                    TConsole.toprintln("Le versement à bien été effectué !");
                    Traitement.main(new String[0]);
                    return;
                }
            }
        } else if(reponse == 2) {
            TConsole.toprintln("Saisir le numéro de compte concerné");
            Integer saisiNumeroCompte = Tools.askThing(1);

            TConsole.toprintln("Saisir le montant que vous voulez verser sur le compte");
            Integer montantVersement = Tools.askThing(1);

        } else if(reponse == 0) {
            TConsole.toprintln(".:: Annulation de l'opération ::.");
            Traitement.main(new String[0]);
        } else {
            TConsole.toprintln("Veuillez saisir 1 ou 2");
            Traitement.consultationSolde();
        }
        TConsole.toprintln("Le compte n'a pas été trouvé !");
        Traitement.main(new String[0]);
    }

    /**
     * Création compte épargne
     */
    private static void creationCompteEpargne() {
        TConsole.toprintln("Création d'un compte épargne" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte");
        Integer numeroCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le solde du compte");
        Integer soldeDuCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le taux d'intérêt");
        Integer tauxInteret = Tools.askThing(1);

        CompteEpargne nouveauCompte = new CompteEpargne(numeroCompte, soldeDuCompte, tauxInteret);
        nouveauCompte.addCompte();

        TConsole.toprintln("Récapitulatif de la création du compte épargne :" +
                "\nNuméro de compte : " + nouveauCompte.getCode() +
                "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                "\nDécouvert autorisé : " + nouveauCompte.getTauxInteret() + "%" +
                "\n*********************************************************" +
                "\n*       Le nouveau compte a bien été créé !             *" +
                "\n*********************************************************"
        );
        Traitement.main(new String[0]);
    }

    /**
     * Création compte courant
     */
    public static void creationCompteCourant() {
        TConsole.toprintln("Création d'un compte courant" +
                "\n*********************************************************"
        );
        TConsole.toprintln("Saisir le numéro de compte");
        Integer numeroCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le solde du compte");
        Integer soldeDuCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le découvert autorisé");
        Integer decouvert = Tools.askThing(1);

        CompteCourant nouveauCompte = new CompteCourant(numeroCompte, soldeDuCompte, decouvert);
        nouveauCompte.addCompte();

        TConsole.toprintln("Récapitulatif de la création du compte courant :" +
                "\nNuméro de compte : " + nouveauCompte.getCode() +
                "\nSolde du compte : " + nouveauCompte.getSolde() + "€" +
                "\nDécouvert autorisé : " + nouveauCompte.getDecouvert() + "€" +
                "\n*********************************************************" +
                "\n*       Le nouveau compte a bien été créé !             *" +
                "\n*********************************************************"
        );
        Traitement.main(new String[0]);
    }
}
