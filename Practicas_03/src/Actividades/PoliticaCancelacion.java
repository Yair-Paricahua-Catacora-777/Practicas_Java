package Actividades;

public interface PoliticaCancelacion {
    boolean puedeCancelar(int horasAntes);
    double calcularPenalizacion(double montoTotal);
}