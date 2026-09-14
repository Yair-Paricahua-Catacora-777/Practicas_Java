 package Actividades;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo + limiteCredito) {
            throw new LimiteCreditoExcedidoException("El monto supera el saldo y el límite de crédito permitido.");
        }
        saldo -= monto;
        registrarTransaccion("Retiro (Crédito usado si saldo < 0): " + monto);
    }
}

