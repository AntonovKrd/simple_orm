package krd.antonov;

import krd.antonov.db.connection.DBService;
import krd.antonov.db.connection.DBServiceConnection;
import krd.antonov.db.dataset.UserDataSet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try(DBService dbService = new DBServiceConnection()) {
            dbService.prepareTable();
            UserDataSet user = new UserDataSet("Vladimir", 22);
            UserDataSet user1 = new UserDataSet("Aleksandr", 28);
            dbService.saveUser(user);
            dbService.saveUser(user1);
            ArrayList <UserDataSet> users = (ArrayList<UserDataSet>) dbService.getAllUsers(UserDataSet.class);
            users.forEach(userDataSet -> System.out.println(userDataSet.toString()));
            dbService.deleteTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
