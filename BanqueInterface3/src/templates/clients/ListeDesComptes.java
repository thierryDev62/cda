package templates.clients;

import entity.Compte;
import entity.CompteCourant;
import templates.principal.Init;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListeDesComptes extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("<html><div style=\"padding: 20px; color: blue;\">Retour au menu</div></html>");

    public ListeDesComptes() {
        this.setLayout(new BorderLayout(5,5));
        this.add(afficheTitre());
        this.add(afficheListeDesComptes());
    }
    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Liste des comptes");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    public JPanel afficheListeDesComptes() {
        JPanel conteneurListe = new JPanel();

        if(!Compte.getListeDesComptes().isEmpty()) {
            conteneurListe.setLayout(new BorderLayout());

            Object[][] data = {
                    {123, "Compte courant", 500},
                    {456, "Compte épargne", 5}
            };

            String[] titresColonnes = {"Numéro de compte", "Type de compte"};
            /*DefaultTableModel model = new DefaultTableModel(titresColonnes, 0);
            ArrayList<String> titresCol = new ArrayList<>();*/

            JTable liste = new JTable(data, titresColonnes);

            liste.setFont(new Init().getDefaultFont());

            conteneurListe.add(liste.getTableHeader(), BorderLayout.NORTH);
            conteneurListe.add(liste, BorderLayout.CENTER);

            BOUTON_RETOUR_MENU.setFont(new Init().getDefaultFont());

            conteneurListe.add(BOUTON_RETOUR_MENU, BorderLayout.SOUTH);

        } else {
            JLabel texteAucunCompte = new JLabel("Aucun compte de créé !");
            texteAucunCompte.setFont(new Init().getDefaultFont());
            conteneurListe.add(texteAucunCompte);
            conteneurListe.add(BOUTON_RETOUR_MENU);
        }
        return conteneurListe;


    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
