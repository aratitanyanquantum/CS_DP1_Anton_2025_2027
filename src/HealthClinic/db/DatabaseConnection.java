package HealthClinic.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed()) {

            final String URL =
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=master;"
                            + "encrypt=true;"
                            + "trustServerCertificate=true;"
                            + "loginTimeout=10";

            final String USER = "sa";
            final String PASSWORD = "Qwerty$1234";

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected: " + connection.getCatalog());
        }
        return connection;
    }
}
