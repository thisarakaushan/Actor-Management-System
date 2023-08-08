package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Database connection class
 * @author thisara.kaushan
 *
 */
public class DBConnection {
    static Connection connection = null;
    static String url = "jdbc:mysql://localhost:3306/sakila";
    static String username = "root";
    static String password = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful!");
        } catch (Exception e) {
            System.out.println("Failed to establish the database connection: " + e.getMessage());
        }
        return connection;
    }
}