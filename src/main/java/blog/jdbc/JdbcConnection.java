package blog.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

    Properties properties = new Properties();
    private final String url = properties.getProperty("url");
    private final String username = properties.getProperty("username");
    private final String password = properties.getProperty("password");

    public Connection getConnection() {
        return JdbcDBConnection();
    }

    private Connection JdbcDBConnection() {

        try {
            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
