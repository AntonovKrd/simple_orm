package krd.antonov.db.connection;

import krd.antonov.db.dataset.DataSet;
import krd.antonov.db.dataset.UserDataSet;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {

    String getMetaData();

    void prepareTable() throws SQLException;

    <T extends DataSet> void saveUser(T user) throws SQLException;

    <T extends DataSet> T loadUser(long id, Class<T> clazz) throws SQLException;

    List<UserDataSet> getAllUsers() throws SQLException;

    void deleteTable() throws SQLException;
}
