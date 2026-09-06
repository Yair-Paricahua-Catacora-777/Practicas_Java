package Ejercicio_2;

public class TestEjercicio2 {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA EJERCICIO 2 (OCP) ===");
        Forma c = new Circulo();
        Forma r = new Rectangulo();
        
        c.dibujar();
        r.dibujar();
    }
}