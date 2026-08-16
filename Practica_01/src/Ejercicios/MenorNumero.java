package Ejercicios;
import java.util.Scanner;
public class MenorNumero {
    public static double menor(double a, double b, double c) {
        double menor = a;
        if (b < menor) {
            menor = b;
        }
        if (c < menor) {
            menor = c;
        }
        return menor;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Primer numero: ");
        double n1 = sc.nextDouble();
        System.out.println("Segundo numero: ");
        double n2 = sc.nextDouble();
        System.out.println("Tercer numero ");
        double n3 = sc.nextDouble();
        System.out.println("El menor es: " + menor(n1, n2, n3));
        sc.close();
    }
}