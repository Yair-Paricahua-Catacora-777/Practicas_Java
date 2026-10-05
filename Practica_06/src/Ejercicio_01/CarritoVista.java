package Ejercicio_01;

import java.util.List;

public class CarritoVista {

    public void mostrarProductos(List<Producto> productos, String titulo) {
        System.out.println("--- " + titulo + " ---");
        for (Producto p : productos) {
            System.out.println(p.getId() + " - " + p.getNombre() + " : $" + p.getPrecio());
        }
    }

    public void mostrarTotal(double total) {
        System.out.println("Total a pagar (incluye descuentos y envío): $" + total);
    }

    public void mostrarHistorial(List<String> historial) {
        System.out.println("--- Historial de Compras ---");
        for (String registro : historial) {
            System.out.println(registro);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}