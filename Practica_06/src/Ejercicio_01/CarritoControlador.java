package Ejercicio_01;

public class CarritoControlador {

    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void registrarProducto(String id, String nombre, double precio) {
        modelo.agregarProductoTienda(new Producto(id, nombre, precio));
    }

    public void listarProductos() {
        vista.mostrarProductos(modelo.getInventarioTienda(), "Productos Disponibles");
    }

    public void agregarProductoAlCarrito(String id) {
        for (Producto p : modelo.getInventarioTienda()) {
            if (p.getId().equals(id)) {
                modelo.agregarAlCarrito(p);
                vista.mostrarMensaje("Producto agregado al carrito.");
                return;
            }
        }
    }

    public void eliminarProductoDelCarrito(String id) {
        Producto aEliminar = null;
        for (Producto p : modelo.getCarrito()) {
            if (p.getId().equals(id)) {
                aEliminar = p;
                break;
            }
        }
        if (aEliminar != null) {
            modelo.eliminarDelCarrito(aEliminar);
            vista.mostrarMensaje("Producto eliminado del carrito.");
        }
    }

    public void verCarrito() {
        vista.mostrarProductos(modelo.getCarrito(), "Mi Carrito");
        vista.mostrarTotal(modelo.calcularTotal());
    }

    public void aplicarDescuento(double cantidad) {
        modelo.setDescuento(cantidad);
        vista.mostrarMensaje("Descuento aplicado.");
    }

    public void calcularEnvio(double costo) {
        modelo.setCostoEnvio(costo);
        vista.mostrarMensaje("Costo de envío calculado.");
    }

    public void comprar() {
        if (!modelo.getCarrito().isEmpty()) {
            modelo.realizarCompra();
            vista.mostrarMensaje("Compra realizada con éxito.");
        }
    }

    public void verHistorial() {
        vista.mostrarHistorial(modelo.getHistorialCompras());
    }
}