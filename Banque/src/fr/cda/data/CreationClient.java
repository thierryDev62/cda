package fr.cda.data;

import diplo.tools.TConsole;
import diplo.tools.Tools;

public class CreationClient {

    public void creationNouveauClient() {
        TConsole.toprintln("Saisir le numero de client");
        Integer numClient = Tools.askThing(1);
        TConsole.toprintln("Saisir le nom du client");
        String nomClient = Tools.askThing();
        TConsole.toprintln("Saisir le prénom du client");
        String prenomClient = Tools.askThing();
        Integer typeCompte = 1;

        Client clientActuel = new Client(numClient, nomClient, prenomClient, typeCompte);
        clientActuel.addClient();

        TConsole.toprintln("Saisir le numero de compte");
        Integer numeroCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le solde du compte");
        Integer soldeDuCompte = Tools.askThing(1);

        TConsole.toprintln("Saisir le découvert autorisé");
        Integer decouvert = Tools.askThing(1);
        CompteCourant nouveauCompteCourant = new CompteCourant(123, 1.0, 500);

        TConsole.toprintln("Récapitulatif de la création du compte client :" +
                "\nNuméro de client : " + clientActuel.getNumeroClient() +
                "\nNom : " + clientActuel.getNomClient() +
                "\nPrénom : " + clientActuel.getPrenomClient() +
                "\n****************************************************************************" +
                "\nLe nouveau client a bien été créé !" +
                "\n****************************************************************************"
        );
    }
}

