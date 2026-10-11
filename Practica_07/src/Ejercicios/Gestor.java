package Ejercicios;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestor {
    private List<Personaje> personajes = new ArrayList<>();
    private final String archivo = "personajes.txt";

    public Gestor() {
        cargarArchivo();
    }

    public void agregar(Personaje p) {
        for (Personaje existing : personajes) {
            if (existing.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardarArchivo();
        System.out.println("Personaje agregado con éxito.");
    }

    public void borrar(String nombre) {
        personajes.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        guardarArchivo();
        System.out.println("Personaje eliminado si existía.");
    }

    public void mostrar() {
        System.out.println("--- LISTA DE PERSONAJES ---");
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    private void cargarArchivo() {
        File f = new File(archivo);
        if (!f.exists()) return;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                personajes.add(Personaje.desdeString(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        }
    }

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        gestor.agregar(new Personaje("Caballero", 4, 2, 4, 2));
        gestor.agregar(new Personaje("Guerrero", 2, 4, 2, 4));
        gestor.mostrar();
    }
}