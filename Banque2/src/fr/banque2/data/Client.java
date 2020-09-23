package fr.banque2.data;

public class Client extends Utilisateurs{

    public Client(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur) {
        super(id, nom, prenom, motDePasse, typeUtilisateur);
    }
}
