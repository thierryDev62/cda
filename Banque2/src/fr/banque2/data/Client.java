package fr.banque2.data;

import java.util.ArrayList;

public class Client extends Utilisateurs{
    private ArrayList<Compte> listeDesComptes = new ArrayList<>();

    public Client(Integer id, String nom, String prenom, String motDePasse) {
        super(id, nom, prenom, motDePasse);
    }

    public ArrayList<Compte> getListeDesComptes() {
        return listeDesComptes;
    }

    public void setListeDesComptes(ArrayList<Compte> listeDesComptes) {
        this.listeDesComptes = listeDesComptes;
    }
}
