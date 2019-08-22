package utility;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class GetAllItems {
    private Set<String> Users = new HashSet<>();

    public Set<String> getItems() {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);

            String sql = "SELECT username FROM MyMailUsers";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                String user = rs.getString("username");
                Users.add(user);
            }

        } catch (Exception se) {
            se.printStackTrace();
        }
        finally {
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
            return Users;
        }
    }
}
