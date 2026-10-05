package Ejercicio_02_03;
public class Enemigo {

    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int atacar() {
        return nivel * 4;
    }

    public void recibirDano(int dano) {
        this.salud -= dano;
        if (this.salud < 0) {
            this.salud = 0;
        }
    }
}