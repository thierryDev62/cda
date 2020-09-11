package fr.cda.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class CreationClientCompteEpargne {
    public void creationCompteEpargne() {
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

        TConsole.toprintln("Saisir le taux d'interêt");
        Integer interet = Tools.askThing(1);

        Integer decouvert = 0;
        Integer typeDecompte = 2;

        Client clientActuel = new Client(numClient, nomClient, prenomClient, numCodeCompte, soldeCompte, decouvert, interet, typeDecompte);
        clientActuel.addClient();

        TConsole.toprintln("Récapitulatif de la création du compte client :" +
                "\nNuméro de client : " + clientActuel.getNumeroClient() +
                "\nNom : " + clientActuel.getNomClient() +
                "\nPrénom : " + clientActuel.getPrenomClient() +
                "\nType de compte : " + "Compte épargne - Taux d'interêt : " + clientActuel.getCompteEpargne().getTauxInteret() +
                "\nNuméro de compte : " + clientActuel.getCompteEpargne().getCode() +
                "\nSolde du compte de départ : " + clientActuel.getCompteEpargne().getSolde() + "€" +
                "\nTaux d'interêt : " + clientActuel.getCompteEpargne().getTauxInteret() + "%" +
                "\n****************************************************************************" +
                "\nLe nouveau client a bien été créé !" +
                "\n****************************************************************************"
        );

    }

}
