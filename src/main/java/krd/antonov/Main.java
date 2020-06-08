package krd.antonov;

import krd.antonov.base.DBService;
import krd.antonov.connection.DBServiceConnection;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceConnection();
    }
}
