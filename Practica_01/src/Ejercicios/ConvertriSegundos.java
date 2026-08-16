package Ejercicios;
import java.util.Scanner;
public class ConvertriSegundos {
    public static int convertir(int horas, int minutos, int segundos) {
        return (horas * 3600) + (minutos * 60) + segundos;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese las horas: ");
        int horas = sc.nextInt();
        System.out.print("Ingrese los minutos: ");
        int minutos = sc.nextInt();
        System.out.print("Ingrese los segundos: ");
        int segundos = sc.nextInt();
        System.out.println("El equivalente en segundos es: "+ convertir(horas, minutos, segundos));
        sc.close();
    }
}