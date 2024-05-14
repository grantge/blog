package blog.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

    Properties properties = new Properties();

    public Connection getConnection() {
        return JdbcDBConnection();
    }

    private Connection JdbcDBConnection() {

        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
