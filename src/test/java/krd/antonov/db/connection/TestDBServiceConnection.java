package krd.antonov.db.connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDBServiceConnection {

    @Test
    void testGetConnection() {
        DBService dbService = new DBServiceConnection();
        Assertions.assertFalse(dbService.getMetaData().contains("Exception"));
    }
}
