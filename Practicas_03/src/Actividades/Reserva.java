package Actividades;

public class Reserva {
    private String id;
    private double montoTotal;
    private PoliticaCancelacion politica;

    public Reserva(String id, double montoTotal, PoliticaCancelacion politica) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.politica = politica;
    }

    public void cancelar(int horasAntes) {
        if (politica.puedeCancelar(horasAntes)) {
            double penalizacion = politica.calcularPenalizacion(montoTotal);
            System.out.println("Reserva " + id + " cancelada. Penalización: S/ " + penalizacion);
        } else {
            System.out.println("No se puede cancelar la reserva " + id + " según la política.");
        }
    }
}