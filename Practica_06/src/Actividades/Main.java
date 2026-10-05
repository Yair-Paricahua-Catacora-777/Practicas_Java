package Actividades;

public class Main {

    public static void main(String[] args) {
        PedidoView vista = new PedidoView();
        PedidoController controlador = new PedidoController(vista);
        controlador.agregarPedido(new Pedido("1", "Sopa de Fideos", "Entrada"));
        controlador.agregarPedido(new Pedido("2", "Lomo Saltado", "Plato Principal"));
        controlador.agregarPedido(new Pedido("3", "Ceviche", "Plato Principal"));

        System.out.println("--- Búsqueda de Platos Principales ---");
        controlador.buscarPedido("Plato Principal");

        System.out.println("\n--- Estadísticas ---");
        controlador.contarPedidos("Plato Principal");
    }
}