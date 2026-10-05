package Actividades;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoController {

    private List<Pedido> modelo;
    private PedidoView vista;

    public PedidoController(PedidoView vista) {
        this.modelo = new ArrayList<>();
        this.vista = vista;
    }

    public void agregarPedido(Pedido pedido) {
        modelo.add(pedido);
    }

    public void eliminarPedido(String id) {
        modelo.removeIf(p -> p.getId().equals(id));
    }

    public void actualizarPedido(String id, String nuevoNombre) {
        for (Pedido p : modelo) {
            if (p.getId().equals(id)) {
                p.setNombre(nuevoNombre);
                break;
            }
        }
    }

    public void buscarPedido(String criterio) {
        List<Pedido> resultados = modelo.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(criterio) || p.getNombre().equalsIgnoreCase(criterio))
                .collect(Collectors.toList());
        vista.mostrarListaPedidos(resultados);
    }

    public void contarPedidos(String tipo) {
        int total = modelo.size();
        int totalPorTipo = (int) modelo.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .count();
        vista.mostrarEstadisticas(total, tipo, totalPorTipo);
    }
}