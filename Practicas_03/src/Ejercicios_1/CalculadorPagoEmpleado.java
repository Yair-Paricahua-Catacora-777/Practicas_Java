package Ejercicios_1;

public class CalculadorPagoEmpleado {
    public double calcularPagoProrrateado(Empleado empleado, int diasTrabajados) {
        return (empleado.getSalarioMensual() / 30) * diasTrabajados;
    }
}