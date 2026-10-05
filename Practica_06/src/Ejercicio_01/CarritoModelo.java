package Ejercicio_01;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {

    private List<Producto> inventarioTienda;
    private List<Producto> carrito;
    private List<String> historialCompras;
    private double descuento;
    private double costoEnvio;

    public CarritoModelo() {
        this.inventarioTienda = new ArrayList<>();
        this.carrito = new ArrayList<>();
        this.historialCompras = new ArrayList<>();
        this.descuento = 0.0;
        this.costoEnvio = 0.0;
    }

    public void agregarProductoTienda(Producto p) {
        inventarioTienda.add(p);
    }

    public List<Producto> getInventarioTienda() {
        return inventarioTienda;
    }

    public void agregarAlCarrito(Producto p) {
        carrito.add(p);
    }

    public void eliminarDelCarrito(Producto p) {
        carrito.remove(p);
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double calcularTotal() {
        double subtotal = carrito.stream().mapToDouble(Producto::getPrecio).sum();
        return (subtotal - descuento) + costoEnvio;
    }

    public void realizarCompra() {
        double total = calcularTotal();
        historialCompras.add("Compra por un total de: $" + total + " con " + carrito.size() + " productos.");
        carrito.clear();
        descuento = 0.0;
        costoEnvio = 0.0;
    }

    public List<String> getHistorialCompras() {
        return historialCompras;
    }
}