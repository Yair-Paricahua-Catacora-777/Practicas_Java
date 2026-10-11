package Actividad_3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Binarios2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int filas, columnas;

        do {
            System.out.print("Número de filas (>0): ");
            filas = sc.nextInt();
        } while (filas <= 0);

        do {
            System.out.print("Número de columnas (>0): ");
            columnas = sc.nextInt();
        } while (columnas <= 0);

        double[][] matriz = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        try (DataOutputStream salida = new DataOutputStream(new FileOutputStream("matriz.dat"))) {
            salida.writeInt(filas);
            salida.writeInt(columnas);

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }
            System.out.println("Matriz guardada con éxito en matriz.dat");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
        sc.close();
    }
}