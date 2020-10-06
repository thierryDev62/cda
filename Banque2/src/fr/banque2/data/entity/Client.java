package fr.banque2.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Client extends Utilisateurs implements Serializable {

    private static ArrayList<Client> listeDesClients = new ArrayList<>();

    public Client(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur, Boolean compteValide) {
        super(id, nom, prenom, motDePasse, typeUtilisateur, compteValide);
    }

    public static ArrayList<Client> getListeDesClients() {
        return listeDesClients;
    }

    public static void setListeDesClients(ArrayList<Client> listeDesClients) {
        Client.listeDesClients = listeDesClients;
    }
}
