package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelp {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/news?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "lzizhion2998";
    private static Connection con = null;

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            return con;
        } else {
            return con;
        }
    }
}