package Ejercicio_3;
public class TestEjercicio3 {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA EJERCICIO 3 (LSP) ===");
        Vehiculo miCoche = new Coche();
        Vehiculo miBici = new Bicicleta();
        
        miCoche.acelerar();
        miBici.acelerar();
    }
}