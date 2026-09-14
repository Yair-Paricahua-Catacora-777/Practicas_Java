package Actividades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReporteTransacciones {

    public static void generarReporte(CuentaBancaria cuenta) throws HistorialVacioException, FileNotFoundException {
        if (cuenta.getTransacciones().isEmpty()) {
            throw new HistorialVacioException("No hay transacciones para generar el reporte.");
        }

        String nombreArchivo = cuenta.getNumeroCuenta() + "_reporte.txt";

        try (PrintWriter out = new PrintWriter(nombreArchivo)) {
            out.println("Cuenta: " + cuenta.getNumeroCuenta());
            out.println("Titular: " + cuenta.getTitular());
            out.println("Saldo Final: " + cuenta.getSaldo());
            out.println("--- Transacciones ---");
            for (String t : cuenta.getTransacciones()) {
                out.println(t);
            }
        }
    }

    public static void leerReporte(String numeroCuenta) {
        String nombreArchivo = numeroCuenta + "_reporte.txt";
        File file = new File(nombreArchivo);

        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo de reporte para la cuenta " + numeroCuenta);
        }
    }
}

