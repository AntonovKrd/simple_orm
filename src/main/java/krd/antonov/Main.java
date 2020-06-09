package krd.antonov;

import krd.antonov.db.connection.DBService;
import krd.antonov.db.connection.DBServiceConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceConnection();
        System.out.println(dbService.getMetaData());
        try {
            dbService.prepareTable();
            dbService.deleteTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
