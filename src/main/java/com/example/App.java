package com.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Conexión exitosa a la base de datos!");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"Taller 3\".cliente";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_cliente");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}