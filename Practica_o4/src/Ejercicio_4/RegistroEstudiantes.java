package Ejercicio_4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<String> estudiantes = new ArrayList<>();

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacío o ser nulo.");
        }
        estudiantes.add(nombre);
    }

    public String buscarEstudiante(String nombre) {
        if (!estudiantes.contains(nombre)) {
            throw new NoSuchElementException("El estudiante " + nombre + " no se encuentra en el registro.");
        }
        return nombre;
    }
}

