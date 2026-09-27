package Actividad_1;
public class PruebaMetodoGenerico {
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Subíndices fuera de rango o subíndice superior menor/igual al inferior.");
        }
        int contador = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.print(arregloEntrada[i] + " ");
            contador++;
        }
        System.out.println();
        return contador; 
    }
    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};
        System.out.println("--- Impresión Completa ---");
        imprimirArreglo(arregloInteger);
        imprimirArreglo(arregloDouble);
        imprimirArreglo(arregloCharacter);
        System.out.println("\n--- Impresión por Rango (Válido) ---");
        try {
            int impresos = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("Elementos impresos: " + impresos);
        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Prueba Rango Inválido ---");
        try {
            imprimirArreglo(arregloCharacter, 3, 1);
        } catch (InvalidSubscriptException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}