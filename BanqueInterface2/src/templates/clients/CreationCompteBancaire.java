package templates.clients;

import entity.Compte;
import entity.CompteCourant;
import entity.CompteEpargne;
import templates.principal.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreationCompteBancaire extends JPanel {

    private static String typeDeCompteChoisi;
    private final JButton BOUTON_VALIDER = new JButton("Valider");
    private final JButton BOUTON_ANNULER = new JButton("Annuler");

    public CreationCompteBancaire() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre(), BorderLayout.NORTH);
        this.add(creationCompte(), BorderLayout.CENTER);
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        conteneurTitre.setBackground(Color.LIGHT_GRAY);
        JLabel titre = new JLabel("<html>Création d'un compte bancaire<br><div style=\"font-size: 0.9em;margin-top: 10px;\">Choisissez le type de compte que vous voulez créer</div></html>");

        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel creationCompte() {
        JPanel panelCreation = new JPanel();

        // Boutons radio pour choix entre compte courant ou épargne
        JPanel conteneurRadio = new JPanel();

        JRadioButton compteCourant = new JRadioButton("Compte courant");
        compteCourant.setFont(new Init().getDefaultFont());
        compteCourant.addActionListener(this::typeDeCompteChoisi);
        JRadioButton compteEpargne = new JRadioButton("Compte épargne");
        compteEpargne.setFont(new Init().getDefaultFont());
        compteEpargne.addActionListener(this::typeDeCompteChoisi);

        ButtonGroup groupe = new ButtonGroup();
        groupe.clearSelection();
        groupe.add(compteCourant);
        groupe.add(compteEpargne);

        conteneurRadio.add(compteCourant);
        conteneurRadio.add(compteEpargne);

        // Bouton valider
        JPanel conteneurBoutonValider = new JPanel();
        BOUTON_VALIDER.setFont(new Init().getDefaultFont());
        conteneurBoutonValider.add(BOUTON_VALIDER);

        // Bouton annuler
        JPanel conteneurBoutonAnnuler = new JPanel();
        BOUTON_ANNULER.setFont(new Init().getDefaultFont());
        conteneurBoutonAnnuler.add(BOUTON_ANNULER);

        panelCreation.add(conteneurRadio);
        panelCreation.add(conteneurBoutonValider);
        panelCreation.add(conteneurBoutonAnnuler);

        return panelCreation;
    }

    // Méthode de prise en compte du choix du type de compte
    public void typeDeCompteChoisi(ActionEvent e) {
        String typeDeCompte = ((JRadioButton) e.getSource()).getText();
        setTypeDeCompteChoisi(typeDeCompte);
    }

    // Méthode de création du compte bancaire
    public static void creationCompteBancaire() {
        if(getTypeDeCompteChoisi().equals("Compte courant")) {

            Compte nouveauCompte = new CompteCourant(getTypeDeCompteChoisi());

            nouveauCompte.setNumeroCompte(123);

            JOptionPane.showMessageDialog(null, "Le " + nouveauCompte.getTypeDeCompte() + " a bien été créé ! Il porte le numéro : " + nouveauCompte.getNumeroCompte());

            setTypeDeCompteChoisi(null);
        } else if(getTypeDeCompteChoisi().equals("Compte épargne")) {

            Compte nouveauCompte = new CompteEpargne(getTypeDeCompteChoisi());

            nouveauCompte.setNumeroCompte(456);

            JOptionPane.showMessageDialog(null, "Le " + nouveauCompte.getTypeDeCompte() + " a bien été créé ! Il porte le numéro : " + nouveauCompte.getNumeroCompte());

            setTypeDeCompteChoisi(null);
        }
    }

    public JButton getBOUTON_VALIDER() {
        return BOUTON_VALIDER;
    }

    public JButton getBOUTON_ANNULER() {
        return BOUTON_ANNULER;
    }

    public static String getTypeDeCompteChoisi() {
        return typeDeCompteChoisi;
    }

    public static void setTypeDeCompteChoisi(String typeDeCompteChoisi) {
        CreationCompteBancaire.typeDeCompteChoisi = typeDeCompteChoisi;
    }
}
