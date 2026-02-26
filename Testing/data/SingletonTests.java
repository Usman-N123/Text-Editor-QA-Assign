package data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTests {

    @Test
    public void testDatabaseConnection_StrictSingleton() {
        // Attempt to grab two connections
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();

        // Assert they are the exact same object in memory
        assertSame(conn1, conn2, "DatabaseConnection must strictly follow Singleton properties.");
    }
}