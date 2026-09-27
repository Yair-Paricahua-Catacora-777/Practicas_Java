package Actividad_2;

public class PruebaPilaActividades {
    public static void main(String[] args) {
        Pila<Integer> p1 = new Pila<>(5);
        Pila<Integer> p2 = new Pila<>(5);

        p1.push(10);
        p1.push(20);
        p1.push(30);

        p2.push(10);
        p2.push(20);
        p2.push(30);
        System.out.println("¿La pila p1 contiene el 20?: " + p1.contains(20));
        System.out.println("¿La pila p1 contiene el 50?: " + p1.contains(50));
        System.out.println("¿La pila p1 es igual a p2?: " + p1.esIgual(p2));

        p2.pop();
        p2.push(99);
        System.out.println("¿La pila p1 es igual a p2 (modificada)?: " + p1.esIgual(p2));
    }
}