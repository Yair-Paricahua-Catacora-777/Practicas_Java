package Ejercicio_3;
public class TestNumero {
    public static void main(String[] args) {
        Numero num = new Numero();
        System.out.println("--- PRUEBAS DE ASIGNACIÓN DE VALORES ---");
        try {
            num.setValor(25.5);
            System.out.println("Valor asignado correctamente: " + num.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            num.setValor(0);
            System.out.println("Valor asignado correctamente: " + num.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("\nIntentando asignar el valor -10.5...");
            num.setValor(-10.5);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nValor final guardado en el objeto: " + num.getValor());
    }
}