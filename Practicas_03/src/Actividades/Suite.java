package Actividades;

public class Suite extends Habitacion {
    private double costoJacuzzi;

    public Suite(String numero, double precioBase, GestorDisponibilidadHabitacion gestor, double costoJacuzzi) {
        super(numero, precioBase, gestor);
        this.costoJacuzzi = costoJacuzzi;
    }

    @Override
    public double getPrecioBase() {
        return super.getPrecioBase() + costoJacuzzi;
    }
}