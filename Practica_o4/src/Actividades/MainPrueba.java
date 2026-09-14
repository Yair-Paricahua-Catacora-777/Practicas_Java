package Actividades;

import java.io.FileNotFoundException;

public class MainPrueba {

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE OPERACIONES ---");

        CuentaBancaria cuenta1 = new CuentaBancaria("CTA-001", "Juan Pérez", 1000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("CTA-002", "Maria Lopez", 200.0);
        CuentaCredito cuentaCredito = new CuentaCredito("CTA-003", "Carlos Gómez", 100.0, 500.0);

        try {
            cuenta1.depositar(500.0);
            cuenta1.retirar(200.0);
            cuenta1.transferir(cuenta2, 300.0);

            System.out.println("Saldo CTA-001: " + cuenta1.getSaldo());
            System.out.println("Saldo CTA-002: " + cuenta2.getSaldo());
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- GENERACIÓN DE REPORTES ---");
        try {
            ReporteTransacciones.generarReporte(cuenta1);
            ReporteTransacciones.leerReporte("CTA-001");
        } catch (HistorialVacioException | FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n--- PRUEBAS DE EXCEPCIONES ---");
        try {
            cuenta1.retirar(5000.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
        try {
            cuentaCredito.retirar(1000.0);
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            cuenta1.transferir(null, 50.0);
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            cuenta1.cerrarCuenta();
        } catch (SaldoNoCeroException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
        try {
            cuenta1.depositar(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        ReporteTransacciones.leerReporte("CTA-999");
    }
}