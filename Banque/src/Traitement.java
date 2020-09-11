import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.cda.data.Client;
import fr.cda.data.Compte;

import fr.cda.data.CreationClientCompteCourant;
import fr.cda.data.CreationClientCompteEpargne;

public class Traitement {
    public static void main(String[] arg) {
        TConsole.toprintln("Faites votre choix : " +
                "\n1 - Créer un nouveau client - Compte courant" +
                "\n2 - Créer un nouveau client - Compte épargne" +
                "\n3 - Consultation de la liste des clients" +
                "\n4 - Consultation de la fiche d'un client" +
                "\n5 - Effectuer un versement sur un compte" +
                "\n0 - Fin"
        );
        Integer choix = Tools.askThing(1);

        switch(choix) {
            case 1:
                newClientCompteCourant();
                break;
            case 2:
                newClientCompteEpargne();
                break;
            case 3 :
                voirClient();
                break;
            case 4 :
                ficheClient();
                break;
            case 5 :
                versement();
            case 0:
                TConsole.toprintln("Merci de votre visite, au revoir !");
                return;
            default:
                main(arg);
        }
    }
    public static void newClientCompteCourant() {
        CreationClientCompteCourant nouveauClient = new CreationClientCompteCourant();
        nouveauClient.creationCompteCourant();
        Traitement.main(new String[0]);
    }
    public static void newClientCompteEpargne() {
        CreationClientCompteEpargne nouveauClient = new CreationClientCompteEpargne();
        nouveauClient.creationCompteEpargne();
        Traitement.main(new String[0]);
    }
    public static void voirClient() {
        TConsole.toprintln(
                "\n-----------------------------------------------" +
                "\nListe de tous les clients de la banque :" +
                "\n***********************************************" +
                "\n* Numéro | Nom | Prénom | Code Compte | Solde *" +
                "\n***********************************************"
        );
        for(int i = 0; i < Client.getClients().size(); i++) {
            System.out.println(Client.getClients().get(i).getNumeroClient() + " - " +
                    Client.getClients().get(i).getNomClient() + " " +
                    Client.getClients().get(i).getPrenomClient() + " - " +
                    Client.getClients().get(i).getCompteCourant().getCode() + " - " +
                    Client.getClients().get(i).getCompteCourant().getSolde() + "€"
            );
        }
        TConsole.toprintln("***********************************************");
        Traitement.main(new String[0]);
    }
    public static void ficheClient() {
        TConsole.toprintln("Saisir le numéro de client");

        Integer numeroClientDemande = Tools.askThing(1);

        for(int i = 0 ; i < Client.getClients().size(); i++) {
            if(numeroClientDemande.equals(Client.getClients().get(i).getNumeroClient())) {
                TConsole.toprintln("Ok client trouvé !");
                System.out.println(Client.getClients().get(i).getNumeroClient() + " - " +
                        Client.getClients().get(i).getNomClient() + " " +
                        Client.getClients().get(i).getPrenomClient() + " - " +
                        Client.getClients().get(i).getCompteCourant().getCode() + " - " +
                        Client.getClients().get(i).getCompteCourant().getSolde() + "€"
                );
                Traitement.main(new String[0]);
                return;
            }
        }
        TConsole.toprintln("Le client n'a pas été trouvé dans la base de données");
        Traitement.main(new String[0]);
    }
    public static void versement(){
        TConsole.toprintln("Saisir le numéro de client concerné");
        Integer clientConcerne = Tools.askThing(1);
        for(int i = 0; i < Client.getClients().size(); i++) {
            if(clientConcerne.equals(Client.getClients().get(i).getNumeroClient())) {
                TConsole.toprintln("Ok client trouvé !" +
                        "\nClient : " + Client.getClients().get(i).getNomClient() + " " + Client.getClients().get(i).getPrenomClient()
                );

                TConsole.toprintln("Quelle somme voulez-vous verser ?");
                int sommeVersee = Tools.askThing(1);

                Float solde = Client.getClients().get(i).getCompteCourant().getSolde();

                Float total = sommeVersee + solde;

                Client.getClients().get(i).getCompteCourant().setSolde(total);

                TConsole.toprintln("Récapitulatif de la transaction" +
                        "\nSolde de départ : " + solde + "€" +
                        "\nSomme versée : " + sommeVersee + "€" +
                        "\nSolde final : " + total + "€"
                );

                Traitement.main(new String[0]);
                return;
            }
        }
        TConsole.toprintln("Le client n'a pas été trouvé dans la base de données");
        Traitement.main(new String[0]);
    }
}
