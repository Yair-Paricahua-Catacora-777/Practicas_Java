package Actividades;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    public boolean puedeCancelar(int horasAntes) { return horasAntes >= 24; }
    public double calcularPenalizacion(double montoTotal) { return 0.0; }
}