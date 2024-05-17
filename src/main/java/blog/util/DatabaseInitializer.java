package blog.util;

import blog.jdbc.JdbcConnection;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        String sqlFilePath = "src/main/resources/schema.sql";
        String sql;
        try {
            sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            System.out.println("Failed to initialize the database.");
            throw new RuntimeException(e);
        }
    }
}
