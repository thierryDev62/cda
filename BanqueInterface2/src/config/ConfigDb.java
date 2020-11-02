package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConfigDb {
    /**
     * La seule instance de cette classe pendant toute la durée de vie de l'application
     */
    private static ConfigDb INSTANCE = new ConfigDb();

    /**
     * Constructeur privé
     */
    private ConfigDb() {
    }

    public Connection connection() throws SQLException {
        final String URL = "jdbc:postgresql://127.0.0.1:5432/Banque";
        Properties props = new Properties();
        props.setProperty("user", "admin");
        props.setProperty("password", "admin");
        props.setProperty("ssl", "false");
        Connection connection = DriverManager.getConnection(URL, props);
        if(connection.isValid(100)) {
            System.out.println("La connexion a bien été effectuée !");
        } else {
            System.out.println("La connexion n'a pas été effectuée !");
        }
        return connection;
    }

    public static ConfigDb getINSTANCE() {
        return INSTANCE;
    }
}
