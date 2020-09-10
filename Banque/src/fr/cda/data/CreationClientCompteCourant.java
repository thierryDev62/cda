package fr.cda.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class CreationClientCompteCourant {

    public void creationCompteCourant() {
        TConsole.toprintln("Saisir le numero de client");
        Integer numClient = Tools.askThing(1);
        TConsole.toprintln("Saisir le nom du client");
        String nomClient = Tools.askThing();
        TConsole.toprintln("Saisir le prénom du client");
        String prenomClient = Tools.askThing();


        TConsole.toprintln("Saisir le numero de code du compte client");
        Integer numCodeCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le solde du compte client");
        Float soldeCompte = Tools.askThing((float)1.0);

        TConsole.toprintln("Saisir le découvert du compte courant");
        Integer decouvert = Tools.askThing(1);

        Client clientActuel = new Client(numClient, nomClient, prenomClient, numCodeCompte, soldeCompte, decouvert);
        clientActuel.addClient();

        TConsole.toprintln("Récapitulatif de la création du compte client :" +
                "\nNuméro de client : " + clientActuel.getNumeroClient() +
                "\nNom : " + clientActuel.getNomClient() +
                "\nPrénom : " + clientActuel.getPrenomClient() +
                "\nType de compte : " + "Compte courant - Découvert : " + clientActuel.getCompteCourant().getDecouvert() +
                "\nNuméro de compte : " + clientActuel.getCompteCourant().getCode() +
                "\nSolde du compte de départ : " + clientActuel.getCompteCourant().getSolde() +
                "\n****************************************************************************" +
                "\nLe nouveau client a bien été créé !" +
                "\n****************************************************************************"
        );

    }
}
