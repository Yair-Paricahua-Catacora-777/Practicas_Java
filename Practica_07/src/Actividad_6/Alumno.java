package Actividad_6;

public class Alumno extends Persona {
    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nif, nombre, edad); // Requiere los atributos base de Persona de prácticas anteriores
        this.fechaMatricula = fechaMatricula;
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }
}