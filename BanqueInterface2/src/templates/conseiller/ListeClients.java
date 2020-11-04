package templates.conseiller;

import config.ConfigDatabase;
import templates.principal.Init;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListeClients extends JPanel {
    private final JButton BOUTON_RETOUR_MENU = new JButton("Retour au menu");

    public ListeClients() {
        this.add(conteneurPrincipal());
    }

    private JPanel conteneurPrincipal() {
        JPanel espaceListeClients = new JPanel();
        espaceListeClients.setLayout(new BorderLayout());
        espaceListeClients.add(afficheTitre(), BorderLayout.NORTH);
        espaceListeClients.add(afficheListeClients(), BorderLayout.CENTER);

        return espaceListeClients;
    }

    private JPanel afficheTitre() {
        JPanel conteneurTitre = new JPanel();
        JLabel titre = new JLabel("Liste des clients de la banque");
        titre.setFont(new Init().getTitreFont());
        conteneurTitre.add(titre);
        return conteneurTitre;
    }

    private JPanel afficheListeClients() {
        JPanel conteneurListeClients = new JPanel();
        conteneurListeClients.setLayout(new BorderLayout());
        /**********************************************************************/

        String query = "SELECT utl_id, utl_nom, utl_prenom, utl_compte_actif FROM public.t_utilisateur_utl WHERE tut_id = 1";
        try {
            Statement state = ConfigDatabase.getInstance().createStatement();

            ResultSet listeDesClients = state.executeQuery(query);

            String columns[] = { "N° IDENTIFIANT", "NOM", "PRENOM", "COMPTE ACTIF" };

            String data[][] = new String[8][4];

            int i = 0;

            while (listeDesClients.next()) {
                    int id = listeDesClients.getInt("utl_id");
                    String nom = listeDesClients.getString("utl_nom");
                    String prenom = listeDesClients.getString("utl_prenom");
                    boolean compteActif = listeDesClients.getBoolean("utl_compte_actif");

                data[i][0] = id + "";
                data[i][1] = nom;
                data[i][2] = prenom;
                if (compteActif) data[i][3] = "Validé";
                else data[i][3] = "En attente";
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);

            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            conteneurListeClients.add(pane, BorderLayout.NORTH);
            listeDesClients.close();
        } catch (SQLException event) {
            event.printStackTrace();
        }

        /**********************************************************************/

        conteneurListeClients.add(BOUTON_RETOUR_MENU, BorderLayout.SOUTH);
        BOUTON_RETOUR_MENU.setFont(new Init().getTitreFont());
        return conteneurListeClients;
    }

    public JButton getBOUTON_RETOUR_MENU() {
        return BOUTON_RETOUR_MENU;
    }
}
