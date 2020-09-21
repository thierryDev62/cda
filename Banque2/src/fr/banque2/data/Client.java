package fr.banque2.data;

import java.util.ArrayList;

public class Client extends Utilisateurs{
    private ArrayList<Client> listeDesComptes = new ArrayList<>();

    public Client(Integer id, String nom, String prenom, String motDePasse) {
        super(id, nom, prenom, motDePasse);
    }

    public void addCompte() {
        listeDesComptes.add(this);
    }
    public ArrayList<Client> getListeDesComptes() {
        return listeDesComptes;
    }

    public void setListeDesComptes(ArrayList<Client> listeDesComptes) {
        this.listeDesComptes = listeDesComptes;
    }
}
