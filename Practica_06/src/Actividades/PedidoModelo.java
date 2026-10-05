package Actividades;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {

    private List<Pedido> pedidos;

    public PedidoModelo() {
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }
}