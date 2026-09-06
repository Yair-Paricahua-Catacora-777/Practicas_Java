package Actividades;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    public boolean puedeCancelar(int horasAntes) { return false; }
    public double calcularPenalizacion(double montoTotal) { return montoTotal; }
}