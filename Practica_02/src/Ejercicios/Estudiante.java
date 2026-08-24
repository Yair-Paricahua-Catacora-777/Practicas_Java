package Ejercicios;

public class Estudiante extends Persona {
    private double nota;
    public static final double NOTA_MINIMA = 10.5;
    public Estudiante(String nombre, String correo, double nota) {
        super(nombre, correo);
        this.nota = nota;
    }
    @Override
    public String obtenerRol() {
        return "Estudiante";
    }
    public double getNota() { 
    	return nota; 
    	}
    public boolean estaAprobado() {
        return this.nota >= NOTA_MINIMA;
    }
}