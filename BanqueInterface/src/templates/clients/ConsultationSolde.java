package templates.clients;

import templates.principal.Init;

import javax.swing.*;
import java.awt.*;

public class ConsultationSolde extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public ConsultationSolde() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheConsultationSolde());
    }
    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Consultation de solde");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheConsultationSolde() {
        JPanel conteneurSolde = new JPanel();

        JLabel texte = new JLabel("Ici s'affichera le solde d'un compte");

        conteneurSolde.add(texte);
        conteneurSolde.add(BOUTON_RETOUR_MENU);

        return conteneurSolde;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
