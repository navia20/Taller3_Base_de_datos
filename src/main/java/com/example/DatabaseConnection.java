package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.ikahhcjgbgkhnsjztnkx";
    private static final String PASSWORD = "tc39KYBe3c2QJfQ9";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}