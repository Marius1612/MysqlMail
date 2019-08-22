package database;

import utility.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class CreateDatabaseForUsers {
    void createTableForUser(String username) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);

            System.out.println("Creating table...");
            stmt = conn.createStatement();

            String sqlTable = "CREATE TABLE IF NOT EXISTS " + username +" (received TEXT NOT NULL, expeditor VARCHAR(50) NOT NULL)";

            stmt.executeUpdate(sqlTable);
            System.out.println("Database created successfully...");
        } catch (Exception se) {
            se.printStackTrace();
        } finally {

            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
