package Ejercicio_02_03;
public class Jugador {

    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public InventarioModel getInventario() {
        return inventario;
    }

    public void equiparArma(Item arma) {
        if (arma != null && arma.getTipo().equalsIgnoreCase("Arma")) {
            this.armaEquipada = arma;
        }
    }

    public int atacar() {
        if (armaEquipada != null) {
            return (nivel * 5) + 10;
        }
        return nivel * 2;
    }

    public void usarObjeto(Item item) {
        if (item != null && item.getTipo().equalsIgnoreCase("Poción")) {
            item.usarItem();
            this.salud += 20;
        }
    }

    public void recibirDano(int dano) {
        this.salud -= dano;
        if (this.salud < 0) {
            this.salud = 0;
        }
    }
}