import templates.principal.App;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.IOException;
import java.sql.SQLException;

public class MainApp {

    // Main
    public static void main(String[] args) {

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
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        assert maFenetre != null;
        maFenetre.setVisible(true);
    }
}
