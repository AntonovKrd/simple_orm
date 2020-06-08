package krd.antonov.base;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {

    String getMetaData();

    void prepareTable() throws SQLException;

    void addUser(String name, int age) throws SQLException;

    String getUserName(int id) throws SQLException;

    List<String> getAllNames() throws SQLException;

    List<UsersDataSet> getAllUsers() throws SQLException;

    void deleteTables() throws SQLException;
}
