package com.revature.comstar.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final DBConnection connect = new DBConnection();

    private Properties prop = new Properties();

    private DBConnection() {
        try{
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            prop.load(loader.getResourceAsStream("db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {

        try {
            Class.forName( "org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }

    public static DBConnection getInstance() { return connect; }

    public Connection getConnection() {

        Connection conn = null;



        try { conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return conn;

    }



}
