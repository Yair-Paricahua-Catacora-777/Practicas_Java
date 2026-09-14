package Ejercicio_2;
public class Calculadora {
    public double sumar(double a, double b) { return a + b; }
    public double restar(double a, double b) { return a - b; }
    public double multiplicar(double a, double b) { return a * b; }
    
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new DivisionPorCeroException("No es posible dividir un número entre cero.");
        }
        return a / b;
    }
}
