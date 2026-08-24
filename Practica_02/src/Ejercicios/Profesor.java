package Ejercicios;
public class Profesor extends Persona {
    private String especialidad;
    public Profesor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }
    @Override
    public String obtenerRol() {
        return "Profesor";
    }
    public String getEspecialidad() { 
    	return especialidad; 
    	}
}
