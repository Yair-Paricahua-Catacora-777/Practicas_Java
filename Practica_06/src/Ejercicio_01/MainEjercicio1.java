package Ejercicio_01;

public class MainEjercicio1 {

    public static void main(String[] args) {
        CarritoModelo modelo = new CarritoModelo();
        CarritoVista vista = new CarritoVista();
        CarritoControlador controlador = new CarritoControlador(modelo, vista);

        controlador.registrarProducto("101", "Laptop", 1200.0);
        controlador.registrarProducto("102", "Mouse", 25.0);

        controlador.listarProductos();

        controlador.agregarProductoAlCarrito("101");
        controlador.agregarProductoAlCarrito("102");

        controlador.aplicarDescuento(50.0);
        controlador.calcularEnvio(15.0);

        controlador.verCarrito();

        controlador.comprar();
        controlador.verHistorial();
    }
}
