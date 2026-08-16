package Ejercicios;
import java.util.Random;
public class Dado {
    public static void main(String[] args) {

        int[] frecuencia = new int[6]; 
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            int cara = random.nextInt(6) + 1;
            frecuencia[cara - 1]++; 
        }
        System.out.println("Frecuencia de las caras del dado:");
        for (int i = 0; i < frecuencia.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i]);
        }
    }
}