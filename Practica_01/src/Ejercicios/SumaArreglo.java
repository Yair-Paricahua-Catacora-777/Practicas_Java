package Ejercicios;
public class SumaArreglo {
    public static int sumarArreglo(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma;
    }
    public static void main(String[] args) {
        int[] datos = {1, 2, 3, 4, 5};
        System.out.println("La suma es: " + sumarArreglo(datos));
    }
}	