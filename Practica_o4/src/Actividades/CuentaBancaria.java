package Actividades;
import java.util.ArrayList;
import java.util.List;
public class CuentaBancaria {
    protected String numeroCuenta;
    protected String titular;
    protected double saldo;
    protected List<String> transacciones;
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.transacciones = new ArrayList<>();
        registrarTransaccion("Apertura de cuenta con saldo: " + saldoInicial);
    }
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
        registrarTransaccion("Depósito: " + monto);
    }
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar: " + monto);
        }
        saldo -= monto;
        registrarTransaccion("Retiro: " + monto);
    }
    public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe.");
        }
        this.retirar(monto);
        destino.depositar(monto);
        registrarTransaccion("Transferencia enviada de " + monto + " a " + destino.getNumeroCuenta());
    }
    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo > 0) {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta. El saldo actual es: " + saldo);
        }
    }
    protected void registrarTransaccion(String detalle) {
        transacciones.add(detalle);
    }
    public List<String> getTransacciones() {
        return transacciones;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
}