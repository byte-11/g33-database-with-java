package uz.pdp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatasourceUtils {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_java_test";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1596psql";

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
