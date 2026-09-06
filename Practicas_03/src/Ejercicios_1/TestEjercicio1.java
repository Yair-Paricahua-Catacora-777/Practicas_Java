package Ejercicios_1;

public class TestEjercicio1 {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA EJERCICIO 1 (SRP) ===");
        Empleado emp = new Empleado("Juan Pérez", 3000.0, "Sistemas");
        CalculadorPagoEmpleado calculador = new CalculadorPagoEmpleado();
        
        double pago = calculador.calcularPagoProrrateado(emp, 15);
        System.out.println("Empleado: " + emp.getNombre());
        System.out.println("Pago por 15 días: S/ " + pago);
    }
}