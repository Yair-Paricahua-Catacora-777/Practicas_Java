package Ejercicios;
public abstract class Persona {
    protected String nombre;
    protected String correo;
    protected String dni;
    private static int contadorPersonas = 0;
    public Persona(String nombre, String correo, String dni) {
        contadorPersonas++;
        this.nombre = nombre;
        this.correo = correo;
        this.dni=dni;   }
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
    public String getDetalleCompleto() {
        return "Nombre: " + nombre + " | DNI: " + dni;
    }
    
}