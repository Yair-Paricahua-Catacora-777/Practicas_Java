package Ejercicios;
public abstract class Persona {
    protected String nombre;
    protected String correo;
    private static int contadorPersonas = 0;
    public Persona(String nombre, String correo) {
        contadorPersonas++;
        this.nombre = nombre;
        this.correo = correo;
    }
    public abstract String obtenerRol();
    public static int getContadorPersonas() {
        return contadorPersonas;
    }
    public String getNombre() { 
    	return nombre; 
    	}
    public String getCorreo() 
    { return correo; 
    }
}