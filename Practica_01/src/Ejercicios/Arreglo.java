package Ejercicios;
import java.util.Scanner;
public class Arreglo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            while (true) {
                System.out.print("Ingrese el número " + (i + 1) + ": ");
                int num = sc.nextInt();

                if (i == 0) {
                    numeros[i] = num;
                    break;
                } else {

                    if (num > numeros[i - 1]) {
                        numeros[i] = num;
                        break;
                    } else {
                        System.out.println("Error: el número debe ser mayor al anterior.");
                    }
                }
            }
        }
        System.out.println("\nNúmeros guardados en el arreglo:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        sc.close();
    }
}