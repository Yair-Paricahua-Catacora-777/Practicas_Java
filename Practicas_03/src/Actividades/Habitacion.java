package Actividades;

public class Habitacion {
    private String numero;
    private double precioBase;
    private GestorDisponibilidadHabitacion gestor;

    public Habitacion(String numero, double precioBase, GestorDisponibilidadHabitacion gestor) {
        this.numero = numero;
        this.precioBase = precioBase;
        this.gestor = gestor;
    }

    public boolean verificarDisponibilidad(String fecha) {
        return gestor.estaDisponible(numero, fecha);
    }

    public void reservar(String fecha) {
        gestor.reservar(numero, fecha);
    }

    public String getNumero() { return numero; }
    public double getPrecioBase() { return precioBase; }
}