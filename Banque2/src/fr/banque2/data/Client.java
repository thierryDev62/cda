package fr.banque2.data;

import java.util.ArrayList;

public class Client extends Utilisateurs{
    private ArrayList<CompteCourant> listeDesComptesCourants = new ArrayList<>();

    public Client(Integer id, String nom, String prenom, String motDePasse) {
        super(id, nom, prenom, motDePasse);
    }

    public ArrayList<CompteCourant> getListeDesComptesCourants() {
        return listeDesComptesCourants;
    }

    public void setListeDesComptesCourants(ArrayList<CompteCourant> listeDesComptesCourants) {
        this.listeDesComptesCourants = listeDesComptesCourants;
    }
}
