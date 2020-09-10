import diplo.tools.TConsole;
import diplo.tools.Tools;
import fr.cda.data.Client;
import fr.cda.data.CreationClient;

public class Traitement {
    public static void main(String[] arg) {
        TConsole.toprintln("Faites votre choix : " +
                "\n1 - Créer un nouveau client" +
                "\n2 - Consultation de la liste des clients" +
                "\n3 - Consultation de la fiche d'un client" +
                "\n4 - Effectuer un versement sur un compte" +
                "\n0 - Fin"
        );
        Integer choix = Tools.askThing(1);

        switch(choix) {
            case 1:
                newClient();
                break;
            case 2 :
                voirClient();
                break;
            case 3 :
                ficheClient();
                break;
            case 0:
                TConsole.toprintln("Merci de votre visite, au revoir !");
                return;
            default:
                main(arg);
        }
    }
    public static void newClient() {
        CreationClient nouveauClient = new CreationClient();
        nouveauClient.creation();
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
                    Client.getClients().get(i).getCompteClient().getCode() + " - " +
                    Client.getClients().get(i).getCompteClient().getSolde() + "€"
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
                        Client.getClients().get(i).getCompteClient().getCode() + " - " +
                        Client.getClients().get(i).getCompteClient().getSolde() + "€"
                );
                Traitement.main(new String[0]);
                return;
            }
        }
        TConsole.toprintln("Le client n'a pas été trouvé dans la base de données");
        Traitement.main(new String[0]);
    }
}
