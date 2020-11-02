import config.ConfigDb;
import templates.principal.App;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {
    private static Connection connection;

    // Méthode qui permet d'initialiser la connection
    private static void initConnection() {
        try {
            connection = ConfigDb.getINSTANCE().connection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Main
    public static void main(String[] args) {
        initConnection();
        // Applique un thème sympa
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Démarre l'application en ouvrant une nouvelle fenêtre
        App maFenetre = null;
        try {
            maFenetre = new App();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert maFenetre != null;
        maFenetre.setVisible(true);
    }
}
