package Ejercicio_02_03;

public class MainEjercicio2 {

    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        Item espada = new Item("Espada de Hierro", 1, "Arma", "Corta a los enemigos");
        Item pocion = new Item("Poción Vida", 5, "Poción", "Restaura 20 de salud");

        controlador.agregarItem(espada);
        controlador.agregarItem(pocion);

        controlador.verInventario();
        controlador.mostrarDetalles("Espada de Hierro");
    }
}