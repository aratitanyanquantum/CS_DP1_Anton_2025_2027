package RentalService.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    // Private constructor to prevent creating objects
    private DatabaseConnection() {
    }

    // Get the global connection
    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed()) {


            // The DBeaver script this class is wired to.
             final String SCRIPT =
                    "/Users/antonkhachatryan/Library/DBeaverData/workspace6/General/Scripts/Script-5.sql";

            // master is where Movies / Addresses / users / LOANS / ACCOUNTS live.
             final String URL =
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=master;"
                            + "encrypt=true;"
                            + "trustServerCertificate=true;"
                            + "loginTimeout=10";

            final String USER = "sa";
            final String PASSWORD = "Qwerty$1234";


            // Assign the FIELD, not a new local variable.
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected: " + connection.getCatalog());

        }
        return connection;
    }
}
