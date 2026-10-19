package Ejercicio_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrabajadorDA0 {
    private static final String URL = "jdbc:sqlite:compania.db";
    private static final String CLAVE_SEGURIDAD = "1234";

    public Connection conectar() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
        }
        return DriverManager.getConnection(URL);
    }

    public void inicializarTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS trabajador (id INTEGER PRIMARY KEY, nombre TEXT, cargo TEXT, salario REAL);";
        try (Connection con = conectar(); Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
        }
    }

    public void insertarConTransaccion(Trabajador t, String claveIngresada) {
        if (!claveIngresada.equals(CLAVE_SEGURIDAD)) {
            System.out.println("Clave incorrecta.");
            return;
        }

        String sql = "INSERT INTO trabajador(id, nombre, cargo, salario) VALUES(?, ?, ?, ?)";
        try (Connection con = conectar()) {
            con.setAutoCommit(false);
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, t.getId());
                pstmt.setString(2, t.getNombre());
                pstmt.setString(3, t.getCargo());
                pstmt.setDouble(4, t.getSalario());
                pstmt.executeUpdate();
                con.commit();
                System.out.println("Operacion confirmada.");
            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaccion revertida.");
            }
        } catch (SQLException e) {
        }
    }

    public void borrarConTransaccion(int id, String claveIngresada) {
        if (!claveIngresada.equals(CLAVE_SEGURIDAD)) {
            System.out.println("Clave incorrecta.");
            return;
        }

        String sql = "DELETE FROM trabajador WHERE id = ?";
        try (Connection con = conectar()) {
            con.setAutoCommit(false);
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                con.commit();
                System.out.println("Registro eliminado.");
            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaccion revertida.");
            }
        } catch (SQLException e) {
        }
    }

    public void actualizarConTransaccion(int id, String nuevoCargo, double nuevoSalario, String claveIngresada) {
        if (!claveIngresada.equals(CLAVE_SEGURIDAD)) {
            System.out.println("Clave incorrecta.");
            return;
        }

        String sql = "UPDATE trabajador SET cargo = ?, salario = ? WHERE id = ?";
        try (Connection con = conectar()) {
            con.setAutoCommit(false);
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoCargo);
                pstmt.setDouble(2, nuevoSalario);
                pstmt.setInt(3, id);
                pstmt.executeUpdate();
                con.commit();
                System.out.println("Registro actualizado.");
            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaccion revertida.");
            }
        } catch (SQLException e) {
        }
    }

    public void mostrar() {
        String sql = "SELECT * FROM trabajador";
        try (Connection con = conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTA DE TRABAJADORES ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " | Nombre: " + rs.getString(2) + " | Cargo: " + rs.getString(3) + " | Salario: " + rs.getDouble(4));
            }
            System.out.println("-----------------------------\n");
        } catch (SQLException e) {
        }
    }
}