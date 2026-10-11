package Actividad_2;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Try-with-resources cierra automáticamente el PrintWriter al terminar
        try (PrintWriter salida = new PrintWriter("datos.txt")) {
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            String cadena = sc.nextLine();
            
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
            System.out.println("¡Datos guardados correctamente en datos.txt!");
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
        sc.close();
    }
}