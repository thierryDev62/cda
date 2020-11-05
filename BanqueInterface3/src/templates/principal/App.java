package templates.principal;

import config.ConfigDatabase;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class App extends JFrame {

    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();
    JPanel pagePrincipale = new JPanel();
    JButton goAuthentification = new JButton("Go authentification");
    JButton goPagePrincipale = new JButton("Go page principale");
    JPanel auth = new JPanel();

    EnTete entete = new EnTete();

    public App() throws IOException, SQLException {
        super("Banque Diplo");
        // On se connecte à la base de données
        ConfigDatabase.getInstance();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        content.setLayout(cl);

        pagePrincipale.add(goAuthentification);
        pagePrincipale.setBackground(Color.ORANGE);


    }


}