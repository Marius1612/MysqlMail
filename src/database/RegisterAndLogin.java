package database;

import utility.Constants;

import java.sql.*;

public class RegisterAndLogin {

    private AddDataInDatabase addData = new AddDataInDatabase();
    private CreateDatabaseForUsers usersData = new CreateDatabaseForUsers();

    public void register(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            addData.addData(username, password);
            usersData.createTableForUser(username);
        }
    }

    public boolean LogIn(String user, String pass) {

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);

            stmt = conn.createStatement();
            String sql_res = String.format("SELECT * FROM MyMailUsers WHERE username= '%s' AND password = '%s'", user, pass);

            ResultSet rs = stmt.executeQuery(sql_res);
            System.out.println(rs.next());
            if(!(rs.getString(1)==null))
                return true;

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

        return false;
    }
}
