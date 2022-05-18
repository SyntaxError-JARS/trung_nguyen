package com.revature.comstar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;

import java.sql.Connection;

public class DBConnectionTestSuite {

    @Test
    public void test_connection() {

        try(Connection conn = DBConnection.getInstance().getConnection()) {

            System.out.println(conn);
            Assertions.assertNotNull(conn);


        } catch(Exception e) {

            e.printStackTrace();
        }

    }

}
