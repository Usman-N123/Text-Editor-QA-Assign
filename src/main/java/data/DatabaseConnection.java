package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // The single instance is stored here
    private static DatabaseConnection instance;

    // This holds the actual active SQL connection
    private Connection connection;

    // Database credentials
    private static final String URL = "jdbc:mariadb://localhost:3306/text_editor_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    // Private constructor prevents anyone else from using 'new'
    private DatabaseConnection() {
        try {
            // We establish the connection safely inside the constructor
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }

    // The only way to get the Singleton instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Other classes will call this to actually talk to the database
    public Connection getConnection() {
        return connection;
    }
}