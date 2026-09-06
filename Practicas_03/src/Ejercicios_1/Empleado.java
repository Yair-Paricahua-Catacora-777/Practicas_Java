package Ejercicios_1;

public class Empleado {
    private String nombre;
    private double salarioMensual;
    private String departamento;

    public Empleado(String nombre, double salarioMensual, String departamento) {
        this.nombre = nombre;
        this.salarioMensual = salarioMensual;
        this.departamento = departamento;
    }

    public String getNombre() { return nombre; }
    public double getSalarioMensual() { return salarioMensual; }
    public String getDepartamento() { return departamento; }
}