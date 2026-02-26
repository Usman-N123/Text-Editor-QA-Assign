package data;

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
}