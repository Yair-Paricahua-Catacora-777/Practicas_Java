package Ejercicio_2;

public class MainMemoria {
    public static void main(String[] args) {
        GestorTrabajadores gestor = new GestorTrabajadores();
        
        gestor.consultarEnMemoria(true, true, true, "Desarrollador", false, 2);
    }
}