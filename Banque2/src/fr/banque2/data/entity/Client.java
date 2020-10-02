package fr.banque2.data.entity;

public class Client extends Utilisateurs {

    public Client(Integer id, String nom, String prenom, String motDePasse, Integer typeUtilisateur, Boolean compteValide) {
        super(id, nom, prenom, motDePasse, typeUtilisateur, compteValide);
    }
}
