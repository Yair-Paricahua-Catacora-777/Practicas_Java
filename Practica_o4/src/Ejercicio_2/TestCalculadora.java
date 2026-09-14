package Ejercicio_2;
public class TestCalculadora {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("--- OPERACIONES BÁSICAS ---");
        System.out.println("Suma (10 + 5): " + calc.sumar(10, 5));
        System.out.println("Resta (10 - 5): " + calc.restar(10, 5));
        System.out.println("Multiplicación (10 * 5): " + calc.multiplicar(10, 5));

        System.out.println("\n--- PRUEBAS DE DIVISIÓN ---");
        try {
            double resultado = calc.dividir(10, 2);
            System.out.println("División (10 / 2): " + resultado);
        } catch (DivisionPorCeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("Intentando dividir 10 / 0...");
            calc.dividir(10, 0);
        } catch (DivisionPorCeroException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}