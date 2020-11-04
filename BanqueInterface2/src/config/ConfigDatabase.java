package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDatabase {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/Banque";
    private static final String USER = "admin";
    private static final String PASSWD = "admin";
    private static Connection connect;

    public static Connection getInstance() {
        if(connect == null) {
            try {
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                connect.setAutoCommit(false);
                System.out.println("La connextion à la base de données à bien été effectuée !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

}
