import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class App {
    // 1. ¡IMPORTANTE! Cambia "tu_contraseña_aqui" por tu contraseña real de MySQL
    static final String URL = "jdbc:mysql://localhost:3306/gestor_gastos";
    static final String USER = "root";
    static final String PASS = "root123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        // Limpiamos la pantalla al iniciar el programa
        limpiarPantalla();

        // Intentamos conectar a la base de datos
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("¡Conexión exitosa a la base de datos!");
            esperarEnter(scanner);
            limpiarPantalla();

            // Ciclo para mostrar el menú hasta que el usuario elija salir (4)
            while (opcion != 4) {
                System.out.println("\n--- GESTOR DE GASTOS ---");
                System.out.println("1. Agregar Ingreso");
                System.out.println("2. Agregar Gasto");
                System.out.println("3. Ver Estado de Cuenta");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del teclado

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Descripción del ingreso (ej. Sueldo): ");
                        String descIngreso = scanner.nextLine();
                        System.out.print("Monto a sumar: $");
                        double montoIngreso = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        registrarMovimiento(conn, 1, montoIngreso, descIngreso);
                        
                        esperarEnter(scanner);
                        limpiarPantalla();
                    }
                    case 2 -> {
                        System.out.print("Descripción del gasto (ej. Comida): ");
                        String descGasto = scanner.nextLine();
                        System.out.print("Monto a restar: $");
                        double montoGasto = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        registrarMovimiento(conn, 2, montoGasto, descGasto);
                        
                        esperarEnter(scanner);
                        limpiarPantalla();
                    }
                    case 3 -> {
                        mostrarEstadoCuenta(conn);
                        
                        esperarEnter(scanner);
                        limpiarPantalla();
                    }
                    case 4 -> System.out.println("Cerrando el programa. ¡Hasta luego!");
                    default -> {
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        esperarEnter(scanner);
                        limpiarPantalla();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión con MySQL: " + e.getMessage());
            System.out.println("¿Aseguraste que MySQL está encendido y la contraseña es correcta?");
        } finally {
            scanner.close();
        }
    }

    // Método para insertar ingresos (tipo 1) o gastos (tipo 2)
    public static void registrarMovimiento(Connection conn, int tipo, double monto, String descripcion) {
        String sql = "INSERT INTO movimientos (tipo_operacion, monto, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tipo);
            pstmt.setDouble(2, monto);
            pstmt.setString(3, descripcion);
            pstmt.executeUpdate();
            System.out.println("✅ ¡Movimiento guardado con éxito!");
        } catch (SQLException e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
        }
    }

    // Método para leer la base de datos, mostrar el historial y calcular el total
    public static void mostrarEstadoCuenta(Connection conn) {
        String sql = "SELECT * FROM movimientos ORDER BY fecha_hora ASC";
        double saldoTotal = 0.0;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n====================== ESTADO DE CUENTA ======================");
            System.out.printf("%-20s | %-10s | %-10s | %-20s\n", "Fecha", "Tipo", "Monto", "Descripción");
            System.out.println("--------------------------------------------------------------");

            // Recorrer cada fila de la tabla en MySQL
            while (rs.next()) {
                int tipo = rs.getInt("tipo_operacion");
                double monto = rs.getDouble("monto");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha_hora");

                String tipoTexto = (tipo == 1) ? "+ Ingreso" : "- Gasto";
                
                // Si es ingreso sumamos, si es gasto restamos
                if (tipo == 1) {
                    saldoTotal += monto;
                } else {
                    saldoTotal -= monto;
                }

                // Imprimir la fila con formato alineado
                System.out.printf("%-20s | %-10s | $%-9.2f | %-20s\n", fecha, tipoTexto, monto, descripcion);
            }
            
            System.out.println("--------------------------------------------------------------");
            System.out.printf("SALDO TOTAL DISPONIBLE: $%.2f\n", saldoTotal);
            System.out.println("==============================================================");

        } catch (SQLException e) {
            System.out.println("Error al obtener estado de cuenta: " + e.getMessage());
        }
    }

    // --- NUEVOS MÉTODOS AGREGADOS ---

    // Método para limpiar la consola de manera multiplataforma
    public static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");
            
            if (sistemaOperativo.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        // CAMBIO AQUÍ: Usamos un multicatch separando las excepciones con un pipe (|)
        } catch (IOException | InterruptedException e) { 
            // Alternativa en caso de que la consola no soporte el comando
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    // Método para pausar el programa hasta que el usuario decida continuar
    public static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresiona ENTER para continuar...");
        scanner.nextLine();
    }
}