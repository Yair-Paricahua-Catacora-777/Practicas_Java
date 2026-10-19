package Actividades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Operaciones {
    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS persona (id INTEGER PRIMARY KEY, nombre TEXT, edad INTEGER);";
        try (Connection con = Conexion.conectar(); Statement stmt = con.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'persona' creada o verificada.");
        } catch (Exception e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }
    public void insertar(int id, String nombre, int edad) {
        String sql = "INSERT INTO persona VALUES (?, ?, ?)";
        try (Connection con = Conexion.conectar(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);
            pstmt.executeUpdate();
            System.out.println("✔ Registro insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    public void recuperar() {
        String sql = "SELECT * FROM persona";
        try (Connection con = Conexion.conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTA DE PERSONAS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " | Nombre: " + rs.getString(2) + " | Edad: " + rs.getInt(3));
            }
            System.out.println("--------------------------\n");
        } catch (Exception e) {
            System.out.println("Error al recuperar: " + e.getMessage());
        }
    }
    public void actualizar(String nuevoNombre, int id) {
        String sql = "UPDATE persona SET nombre = ? WHERE id = ?";
        try (Connection con = Conexion.conectar(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("✔ Registro actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    public void borrar(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";
        try (Connection con = Conexion.conectar(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("✔ Registro borrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }


    public void probarTransaccion() {
        Connection con = Conexion.conectar();
        try {
            con.setAutoCommit(false); 

            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO persona VALUES (50, 'Transaccion1', 20)");
            stmt.executeUpdate("INSERT INTO persona VALUES (51, 'Transaccion2', 25)");

            con.commit(); 
            System.out.println("Transacción exitosa (COMMIT aplicado).");

        } catch (Exception e) {
            try {
                if (con != null) con.rollback(); 
                System.out.println("Error en transacción. Se aplicó ROLLBACK.");
            } catch (Exception ex) {}
        } finally {
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}