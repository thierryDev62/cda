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
        Integer compte = 0;


        Client clientActuel = new Client(numClient, nomClient, prenomClient, compte);
        clientActuel.addClient();

        TConsole.toprintln("Saisir le numero de compte");
        Integer numeroCompte = Tools.askThing(1);
        TConsole.toprintln("Saisir le solde du compte");
        Integer soldeDuCompte = Tools.askThing(1);
        Integer typeDeCompte = 1;
        TConsole.toprintln("Saisir le découvert autorisé");
        Integer decouvert = Tools.askThing(1);
        Client nouveauCompteCourant = new CompteCourant(numeroCompte, soldeDuCompte, typeDeCompte, decouvert);

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

