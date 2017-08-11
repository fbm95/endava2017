package com.endava.rest.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {

    public static Connection dbConnector() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring3", "postgres", "567097");

            System.out.println("Opened database successfully");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
}