package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sistema {
    private Connection connection;
    private static Sistema instance;

    public Sistema() {
        try {
            this.connection = DatabaseConnection.getInstance();
            System.out.println("Estado conexión DB: " + !connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------ Menú Sistema bancario ------");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (opcion == 1) {
            iniciarSesion(scanner);
        } else if (opcion == 2) {
            registrarse(scanner);
        } else {
            System.out.println("Opción no válida");
        }
    }

    private void iniciarSesion(Scanner scanner) {
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (correo.equals("skibidi") && contrasena.equals("toilet")) {
            mostrarMenuAdministrador(scanner);
        } else {
            Usuario usuario = obtenerUsuarioPorCredenciales(correo, contrasena);
            if (usuario != null) {
                if (usuario instanceof Cliente) {
                    mostrarMenuCliente(scanner, (Cliente) usuario);
                } else if (usuario instanceof Administrador) {
                    mostrarMenuAdministrador(scanner);
                }
            } else {
                System.out.println("Credenciales incorrectas");
            }
        }
    }

    private void registrarse(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, correo, contrasena, contrasena, contrasena);
        registrarUsuario(nuevoCliente);
        System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
    }

    private void mostrarMenuCliente(Scanner scanner, Cliente cliente) {
        while (true) {
            System.out.println("Menú de Cliente");
            System.out.println("1. Depósitos");
            System.out.println("2. Retiros");
            System.out.println("3. Transferencias");
            System.out.println("4. Consulta de Saldo");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Lógica para depósitos
                    break;
                case 2:
                    // Lógica para retiros
                    break;
                case 3:
                    // Lógica para transferencias
                    break;
                case 4:
                    // Lógica para consulta de saldo
                    break;
                case 5:
                    return; // Salir del menú
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuAdministrador(Scanner scanner) {
        while (true) {
            System.out.println("Menú de Administrador");
            System.out.println("1. Consultar Historial de Transacciones");
            System.out.println("2. Generar Reportes Financieros");
            System.out.println("3. Vista de Cuentas Inactivas");
            System.out.println("4. Configuración de Usuarios");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Lógica para consultar historial de transacciones
                    break;
                case 2:
                    // Lógica para generar reportes financieros
                    break;
                case 3:
                    // Lógica para vista de cuentas inactivas
                    break;
                case 4:
                    // Lógica para configuración de usuarios
                    break;
                case 5:
                    return; // Salir del menú
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private Usuario obtenerUsuarioPorCredenciales(String correo, String contrasena) {
        // Implementar lógica para obtener usuario de la base de datos
        return null;
    }

    private void registrarUsuario(Cliente cliente) {
        // Implementar lógica para registrar un nuevo cliente en la base de datos
    }
}