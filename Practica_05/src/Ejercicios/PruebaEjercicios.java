package Ejercicios;
public class PruebaEjercicios {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par.toString());
    }
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE LOS EJERCICIOS 1, 2 Y 3 (CLASE PAR) ===");
        Par<String, Integer> par1 = new Par<>("Juan", 20);
        Par<String, Integer> par2 = new Par<>("Juan", 20);
        Par<Double, Boolean> par3 = new Par<>(15.5, true);
        Par<Persona, Integer> par4 = new Par<>(new Persona("Maria"), 101);
        System.out.println("\n--- Impresión de Pares (imprimirPar) ---");
        imprimirPar(par1);
        imprimirPar(par3);
        imprimirPar(par4);
        System.out.println("\n--- Comparación de Pares (esIgual) ---");
        System.out.println("¿par1 es igual a par2?: " + par1.esIgual(par2));
        System.out.println("\n=== PRUEBA DEL EJERCICIO 4 (CONTENEDOR) ===");
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("Nota 1", 18);
        contenedor.agregarPar("Nota 2", 15);
        contenedor.agregarPar("Nota 3", 20);
        System.out.println("\n--- Lista de Pares Almacenados ---");
        contenedor.mostrarPares();
        System.out.println("\n--- Obtener Par por Índice ---");
        System.out.println("Par en la posición 1: " + contenedor.obtenerPar(1));
    }
}