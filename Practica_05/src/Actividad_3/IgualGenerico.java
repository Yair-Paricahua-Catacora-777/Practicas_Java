package Actividad_3;

public class IgualGenerico {
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }
    public static void main(String[] args) {
        System.out.println("Integers iguales (5, 5): " + esIgualA(5, 5));
        System.out.println("Strings iguales ('Hola', 'Hola'): " + esIgualA("Hola", "Hola"));
        System.out.println("Strings distintos ('Hola', 'Mundo'): " + esIgualA("Hola", "Mundo"));
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("Objects iguales (misma ref): " + esIgualA(obj1, obj1));
        System.out.println("Objects distintos: " + esIgualA(obj1, obj2));
        System.out.println("Comparación con nulls: " + esIgualA(null, null));
    }
}