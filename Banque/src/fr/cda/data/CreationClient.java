package fr.cda.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class CreationClient {

    public void creation() {
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

        TConsole.toprintln("Saisir le type de compte : 1 - Compte courant | 2 - Compte épargne");
        Integer reponse = Tools.askThing(1);

        switch(reponse) {
            case 1 :
                TConsole.toprintln("Compte courant");
                CompteCourant compteCourant = new CompteCourant(numCodeCompte, soldeCompte, 500);
                break;
            case 2 :
                TConsole.toprintln("Compte épargne");
                CompteEpargne compteEpargne = new CompteEpargne(numCodeCompte, soldeCompte, 5);
                break;
        }


        Client clientActuel = new Client(numClient, nomClient, prenomClient, numCodeCompte, soldeCompte);
        clientActuel.addClient();

        TConsole.toprintln("Récapitulatif de la création du compte client :" +
                "\nNuméro de client : " + clientActuel.getNumeroClient() +
                "\nNom : " + clientActuel.getNomClient() +
                "\nPrénom : " + clientActuel.getPrenomClient() +
                "\nNuméro de compte : " + clientActuel.getCompteClient().getCode() +
                "\nSolde du compte de départ : " + clientActuel.getCompteClient().getSolde() +
                "\n****************************************************************************" +
                "\nLe nouveau client a bien été créé !" +
                "\n****************************************************************************"
        );

    }

}
