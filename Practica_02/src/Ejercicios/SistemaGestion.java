package Ejercicios;
import java.util.ArrayList;
import java.util.List;
public class SistemaGestion {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Juan Pérez", "juan@email.com","61083851" ,15.0);
        Estudiante est2 = new Estudiante("Maria Lopez", "maria@email.com", "61083851",09.5);
        Profesor prof1 = new Profesor("Karim Guevara", "karim@email.com","61083851", "Programación");
        List<Persona> personas = new ArrayList<>();
        personas.add(est1);
        personas.add(est2);
        personas.add(prof1);
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " es un: " + p.obtenerRol());
        }
        System.out.println("\nDATOS DE CLASE Y CONSTANTES");
        System.out.println("Total de Personas registradas: " + Persona.getContadorPersonas());
        System.out.println("Nota Mínima Aprobatoria: " + Estudiante.NOTA_MINIMA);
        Curso curso = new Curso("Lenguajes de Programación III");
        curso.asignarProfesor(prof1);
        curso.inscribirEstudiante(est1);
        curso.inscribirEstudiante(est2);
        curso.agregarModulo("Módulo 1: Herencia y Polimorfismo");
        curso.agregarModulo("Módulo 2: Colecciones y Excepciones");
        System.out.println();
        curso.mostrarDetalle();
    }
}
