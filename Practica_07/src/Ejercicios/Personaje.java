package Ejercicios;

public class Personaje {
    private String nombre;
    private int vida, ataque, defensa, alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    public String getNombre() { 
        return nombre; 
    }

    @Override
    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance;
    }

    public static Personaje desdeString(String linea) {
        String[] p = linea.split(",");
        return new Personaje(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), 
                             Integer.parseInt(p[3]), Integer.parseInt(p[4]));
    }
}