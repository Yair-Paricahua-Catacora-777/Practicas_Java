package Ejercicio_02_03;

import java.util.List;

public class InventarioView {

    public void mostrarInventario(List<Item> items) {
        for (Item item : items) {
            System.out.println("- " + item.getNombre() + " (x" + item.getCantidad() + ")");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("El ítem no existe.");
        }
    }
}