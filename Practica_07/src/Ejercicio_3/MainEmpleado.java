package Ejercicio_3;
import java.util.Scanner;

public class MainEmpleado {
    public static void main(String[] args) {
        EmpleadoController ec = new EmpleadoController();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- MENÚ EMPLEADOS ---");
            System.out.println("1. Listar");
            System.out.println("2. Agregar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1: 
                    ec.listar(); 
                    break;
                case 2:
                    System.out.print("Número: "); 
                    int n = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Nombre: "); 
                    String nom = sc.nextLine();
                    System.out.print("Sueldo: "); 
                    double s = sc.nextDouble();
                    ec.agregarEmpleado(n, nom, s);
                    break;
                case 3:
                    System.out.print("Número a buscar: ");
                    ec.buscar(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Número a eliminar: ");
                    ec.eliminar(sc.nextInt());
                    break;
            }
        } while (op != 5);
        sc.close();
    }
}