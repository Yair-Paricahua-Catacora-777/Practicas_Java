package Ejercicio_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {
    private List<Empleado> empleados = new ArrayList<>();
    private final String archivo = "empleados.dat";

    public EmpleadoController() {
        leerEmpleados();
    }

    @SuppressWarnings("unchecked")
    public void leerEmpleados() {
        File f = new File(archivo);
        if (!f.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            empleados = (List<Empleado>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error al cargar empleados.");
        }
    }

    public void guardarEmpleados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo.");
        }
    }

    public void agregarEmpleado(int num, String nom, double sueldo) {
        empleados.add(new Empleado(num, nom, sueldo));
        guardarEmpleados();
        System.out.println("Empleado agregado exitosamente.");
    }

    public void listar() {
        System.out.println("--- LISTA DE EMPLEADOS ---");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public void buscar(int num) {
        for (Empleado e : empleados) {
            if (e.getNumero() == num) {
                System.out.println("Encontrado: " + e);
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    public void eliminar(int num) {
        boolean removido = empleados.removeIf(e -> e.getNumero() == num);
        if (removido) {
            guardarEmpleados();
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("No se encontró el empleado.");
        }
    }
}