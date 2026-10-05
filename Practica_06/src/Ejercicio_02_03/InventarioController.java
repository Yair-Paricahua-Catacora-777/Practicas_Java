package Ejercicio_02_03;

public class InventarioController {

    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.agregarItem(item);
        vista.mostrarMensaje("Ítem agregado al inventario.");
    }

    public void eliminarItem(Item item) {
        modelo.eliminarItem(item);
        vista.mostrarMensaje("Ítem eliminado del inventario.");
    }

    public void verInventario() {
        vista.mostrarMensaje("--- Inventario Actual ---");
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public void buscarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje("Ítem encontrado: " + item.getNombre());
        } else {
            vista.mostrarMensaje("Ítem no encontrado.");
        }
    }
}