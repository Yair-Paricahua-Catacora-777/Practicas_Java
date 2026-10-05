package Actividades;
import java.util.List;

public class PedidoView {

    public void mostrarDetallesPedido(Pedido pedido) {
        System.out.println("ID: " + pedido.getId() + " | Nombre: " + pedido.getNombre() + " | Tipo: " + pedido.getTipo());
    }

    public void mostrarListaPedidos(List<Pedido> pedidos) {
        for (Pedido p : pedidos) {
            mostrarDetallesPedido(p);
        }
    }

    public void mostrarEstadisticas(int total, String tipoBusqueda, int totalPorTipo) {
        System.out.println("Total de pedidos: " + total);
        System.out.println("Total de pedidos del tipo '" + tipoBusqueda + "': " + totalPorTipo);
    }
}