package Ejercicio_1;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrabajadorDA0 dao = new TrabajadorDA0();
        dao.inicializarTabla();
        int opcion;

        do {
            System.out.println("=== MENU TRABAJADORES ===");
            System.out.println("1. Mostrar");
            System.out.println("2. Ingresar");
            System.out.println("3. Actualizar");
            System.out.println("4. Borrar");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    dao.mostrar();
                    break;
                case 2:
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Cargo: "); String car = sc.nextLine();
                    System.out.print("Salario: "); double sal = sc.nextDouble(); sc.nextLine();
                    System.out.print("Clave: "); String cl = sc.nextLine();
                    dao.insertarConTransaccion(new Trabajador(id, nom, car, sal), cl);
                    break;
                case 3:
                    System.out.print("ID a actualizar: "); int idA = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo Cargo: "); String nuevoCar = sc.nextLine();
                    System.out.print("Nuevo Salario: "); double nuevoSal = sc.nextDouble(); sc.nextLine();
                    System.out.print("Clave: "); String clA = sc.nextLine();
                    dao.actualizarConTransaccion(idA, nuevoCar, nuevoSal, clA);
                    break;
                case 4:
                    System.out.print("ID a borrar: "); int idB = sc.nextInt(); sc.nextLine();
                    System.out.print("Clave: "); String clB = sc.nextLine();
                    dao.borrarConTransaccion(idB, clB);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion != 5);
        sc.close();
    }
}