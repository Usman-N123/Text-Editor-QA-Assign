package data;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    // The single instance is stored here
    private static DatabaseConnection instance;

    // Private constructor prevents anyone else from using 'new DatabaseConnection()'
    private DatabaseConnection() {}

    // The only way to get the database connection
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Inside DatabaseConnection.java
    private static final String URL = "jdbc:mariadb://localhost:3306/text_editor_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123"; // Put your password here

    // The connection method should look like this:
    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
}