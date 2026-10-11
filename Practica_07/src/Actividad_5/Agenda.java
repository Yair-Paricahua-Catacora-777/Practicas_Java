package Actividad_5;

import java.io.*;
import java.util.Scanner;

public class Agenda {
    ArrayPersona lista;

    public Agenda() {
        this.lista = cargaContactos();
    }
    
    public void bucle() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("Introduzca un nombre para buscar (o presione Enter para salir):");
        
        while (!(nombre = sc.nextLine()).isEmpty()) {
            lista.printArray(nombre);
            System.out.println("\nIntroduzca otro nombre (o Enter para salir):");
        }
        sc.close();
    }

    private ArrayPersona cargaContactos() {
        ArrayPersona directorio = new ArrayPersona();
        File archivo = new File("agenda.txt");
        
        if (!archivo.exists()) {
            System.out.println("El archivo agenda.txt no existe.");
            return directorio;
        }

        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String nombre = scanner.nextLine();
                if (!scanner.hasNextLine()) break;
                String telefono = scanner.nextLine();
                if (!scanner.hasNextLine()) break;
                String direccion = scanner.nextLine();
                
                directorio.addArray(new Persona(nombre, telefono, direccion));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer la agenda.");
        }
        return directorio;
    }
}