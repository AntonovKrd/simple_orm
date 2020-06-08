package krd.antonov.connection;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class ConnectionHelper {

    private static final Logger logger = Logger.getLogger(ConnectionHelper.class);
    private static Properties properties;

    static Connection getConnection() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            String url = "jdbc:postgresql://" +
                    "localhost:" +
                    "8888/" +
                    "postgres";
            getAuthData();
            return DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("pass"));
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    private static void getAuthData() {
        properties = new Properties();
        try (InputStream inputStream = ConnectionHelper.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Database Auth data not found", e);
            throw new RuntimeException("Database Auth data not found");
        }

    }
}
