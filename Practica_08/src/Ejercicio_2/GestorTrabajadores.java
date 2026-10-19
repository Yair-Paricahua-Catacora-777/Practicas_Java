package Ejercicio_2;
import java.util.ArrayList;
import java.util.List;
public class GestorTrabajadores {
    private List<Trabajador> lista;
    public GestorTrabajadores() {
        lista = new ArrayList<>();
        lista.add(new Trabajador(1, "Ana Perez", "Gerente", 4500.0));
        lista.add(new Trabajador(2, "Luis Gomez", "Desarrollador", 2800.0));
        lista.add(new Trabajador(3, "Carla Soto", "Analista", 3200.0));
        lista.add(new Trabajador(4, "Jorge Ruiz", "Desarrollador", 2500.0));
    }
    public void consultarEnMemoria(boolean mostrarNombre, boolean mostrarCargo, boolean mostrarSalario, String cargoCondicion, boolean ascendentePorSalario, int limite) {
        List<Trabajador> resultado = new ArrayList<>();

        for (Trabajador t : lista) {
            boolean cumpleCondicion = (cargoCondicion == null || cargoCondicion.isEmpty() || t.getCargo().equalsIgnoreCase(cargoCondicion));
            if (cumpleCondicion) {
                resultado.add(t);
            }
        }
        resultado.sort((t1, t2) -> {
            if (ascendentePorSalario) {
                return Double.compare(t1.getSalario(), t2.getSalario());
            } else {
                return Double.compare(t2.getSalario(), t1.getSalario());
            }
        });
        System.out.println("\n--- RESULTADOS DE CONSULTA EN MEMORIA ---");
        int contador = 0;
        for (Trabajador t : resultado) {
            if (contador >= limite) break; 
            String fila = "ID: " + t.getId();
            if (mostrarNombre) fila += " | Nombre: " + t.getNombre();
            if (mostrarCargo) fila += " | Cargo: " + t.getCargo();
            if (mostrarSalario) fila += " | Salario: " + t.getSalario();
            System.out.println(fila);
            contador++;
        }
        System.out.println("------------------------------------------\n");
    }
}