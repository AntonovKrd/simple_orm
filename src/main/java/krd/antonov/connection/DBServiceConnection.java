package krd.antonov.connection;

import krd.antonov.base.DBService;
import krd.antonov.base.UsersDataSet;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBServiceConnection implements DBService {

    private final Connection connection;
    private final Logger logger = Logger.getLogger(DBServiceConnection.class);

    public DBServiceConnection() {
        this.connection = ConnectionHelper.getConnection();
    }

    @Override
    public String getMetaData() {
        try {
            return "Connected to: " + getConnection().getMetaData().getURL() + "\n" +
                    "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n" +
                    "DB version: " + getConnection().getMetaData().getDatabaseProductVersion() + "\n" +
                    "Driver: " + getConnection().getMetaData().getDriverName();
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public void prepareTable() throws SQLException {

    }

    @Override
    public void addUser(String name, int age) throws SQLException {

    }

    @Override
    public String getUserName(int id) throws SQLException {
        return null;
    }

    @Override
    public List<String> getAllNames() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public List<UsersDataSet> getAllUsers() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public void deleteTables() throws SQLException {

    }

    @Override
    public void close() throws Exception {
        connection.close();
        logger.info("Connection closed");
    }

    private Connection getConnection() {
        return connection;
    }
}
