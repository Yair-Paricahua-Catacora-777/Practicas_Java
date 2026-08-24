package Ejercicios;
import java.util.ArrayList;
import java.util.List;
public class Curso {
    public static final int CAPACIDAD_MAXIMA = 30;
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    private List<String> modulos;
    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.modulos = new ArrayList<>();
    }
    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public void inscribirEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < CAPACIDAD_MAXIMA) {
            estudiantes.add(estudiante);
        }
    }
    public void agregarModulo(String nombreModulo) {
        this.modulos.add(nombreModulo);
    }
    public void mostrarDetalle() {
        System.out.println("CURSO: " + nombre);
        System.out.println("PROFESOR: " + (profesor != null ? profesor.getNombre() : "Sin asignar"));
        
        System.out.println("\nMÓDULOS DEL CURSO (Composición):");
        for (String m : modulos) {
            System.out.println(" - " + m);
        }

        System.out.println("\nESTUDIANTES INSCRITOS (Agregación):");
        for (Estudiante e : estudiantes) {
            System.out.println(" - " + e.getNombre() + " | Nota: " + e.getNota() + " | Estado: " + (e.estaAprobado() ? "Aprobado" : "Desaprobado"));
        }
    }
}