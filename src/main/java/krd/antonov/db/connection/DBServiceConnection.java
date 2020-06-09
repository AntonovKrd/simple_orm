package krd.antonov.db.connection;

import krd.antonov.db.dataset.DataSet;
import krd.antonov.db.dataset.UserDataSet;
import krd.antonov.db.executor.Executor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
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
        Executor exec = new Executor(getConnection());
        exec.execUpdate("CREATE TABLE IF NOT EXISTS USERS " +
                "(ID SERIAL NOT NULL, NAME VARCHAR(255), AGE BIGINT, PRIMARY KEY (ID))");
        logger.info("Table USERS created");
    }

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException {
        Executor exec = new Executor(getConnection());
    }

    @Override
    public <T extends DataSet> T loadUser(long id, Class<T> clazz) throws SQLException {
        return null;
    }

    @Override
    public List<UserDataSet> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public void deleteTable() throws SQLException {
        Executor exec = new Executor(getConnection());
        exec.execUpdate("DROP TABLE USERS");
        logger.info("Table USERS dropped");
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
