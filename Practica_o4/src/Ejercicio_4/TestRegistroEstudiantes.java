package Ejercicio_4;
import java.util.NoSuchElementException;
public class TestRegistroEstudiantes {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        System.out.println("--- REGISTRO DE ESTUDIANTES ---");
        try {
            registro.agregarEstudiante("Juan Pérez");
            registro.agregarEstudiante("María López");
            System.out.println("Estudiantes agregados correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            String encontrado = registro.buscarEstudiante("Juan Pérez");
            System.out.println("Estudiante encontrado: " + encontrado);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n--- PRUEBAS DE EXCEPCIONES ---");

        try {
            System.out.println("Intentando agregar estudiante con nombre vacío...");
            registro.agregarEstudiante("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
        try {
            System.out.println("\nIntentando agregar estudiante nulo...");
            registro.agregarEstudiante(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
        try {
            System.out.println("\nIntentando buscar estudiante 'Carlos Gómez'...");
            registro.buscarEstudiante("Carlos Gómez");
        } catch (NoSuchElementException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}