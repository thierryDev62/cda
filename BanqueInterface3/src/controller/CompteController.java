package controller;

import entity.Compte;
import entity.CompteCourant;
import entity.CompteEpargne;
import templates.clients.CreationCompteBancaire;

import javax.swing.*;

public class CompteController {
    /**
     * Création d'un compte courant ou épargne
     */
    public static void nouveauCompteBancaire() {
        if(CreationCompteBancaire.getTypeDeCompteChoisi().equals("Compte courant")) {
            Compte nouveauCompteCourant = new CompteCourant(CreationCompteBancaire.getTypeDeCompteChoisi());

            nouveauCompteCourant.setNumeroCompte(123);

            JOptionPane.showMessageDialog(null, "Le " + nouveauCompteCourant.getTypeDeCompte() + " a bien été créé ! Il porte le numéro : " + nouveauCompteCourant.getNumeroCompte());

        } else if(CreationCompteBancaire.getTypeDeCompteChoisi().equals("Compte épargne")) {
            Compte nouveauCompteEpargne = new CompteEpargne(CreationCompteBancaire.getTypeDeCompteChoisi());

            nouveauCompteEpargne.setNumeroCompte(456);

            JOptionPane.showMessageDialog(null, "Le " + nouveauCompteEpargne.getTypeDeCompte() + " a bien été créé ! Il porte le numéro : " + nouveauCompteEpargne.getNumeroCompte());
        }
    }

}
