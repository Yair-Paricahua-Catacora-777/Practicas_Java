package Ejercicio_4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContadorPalabras {
    public static void main(String[] args) {
        File archivo = new File("datos.txt"); 
        if (!archivo.exists()) {
            System.out.println("El archivo 'datos.txt' no existe. Crea uno para probar.");
            return;
        }

        int lineas = 0, palabrasTotal = 0, caracteres = 0;
        Map<String, Integer> frecuencias = new HashMap<>();

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                lineas++;
                caracteres += linea.length();

                String[] palabras = linea.split("\\s+");
                for (String p : palabras) {
                    StringBuilder sb = new StringBuilder();
                    for (char c : p.toCharArray()) {
                        if (Character.isLetterOrDigit(c)) {
                            sb.append(Character.toLowerCase(c));
                        }
                    }
                    String limpia = sb.toString();
                    if (!limpia.isEmpty()) {
                        palabrasTotal++;
                        frecuencias.put(limpia, frecuencias.getOrDefault(limpia, 0) + 1);
                    }
                }
            }

            System.out.println("--- RESULTADOS DEL ANÁLISIS ---");
            System.out.println("Total de líneas: " + lineas);
            System.out.println("Total de palabras: " + palabrasTotal);
            System.out.println("Total de caracteres: " + caracteres);
            System.out.println("Promedio de palabras por línea: " + (lineas > 0 ? (double) palabrasTotal / lineas : 0));
            
            if (!frecuencias.isEmpty()) {
                String masFrecuente = Collections.max(frecuencias.entrySet(), Map.Entry.comparingByValue()).getKey();
                System.out.println("Palabra más frecuente: '" + masFrecuente + "' (" + frecuencias.get(masFrecuente) + " veces)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}