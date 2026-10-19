package Ejercicio_1;
public class Trabajador {
    private int id;
    private String nombre;
    private String cargo;
    private double salario;
    public Trabajador(int id, String nombre, String cargo, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public double getSalario() {
        return salario;
    }
}