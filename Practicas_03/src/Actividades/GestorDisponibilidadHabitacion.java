package Actividades;

import java.util.ArrayList;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<String> ocupadas = new ArrayList<>();

    public boolean estaDisponible(String numero, String fecha) {
        return !ocupadas.contains(numero + ":" + fecha);
    }

    public void reservar(String numero, String fecha) {
        ocupadas.add(numero + ":" + fecha);
    }
}