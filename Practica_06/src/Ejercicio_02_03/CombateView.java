package Ejercicio_02_03;

public class CombateView {

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("=====================================");
        System.out.println(jugador.getNombre() + " | Salud: " + jugador.getSalud());
        System.out.println(enemigo.getNombre() + " | Salud: " + enemigo.getSalud());
        System.out.println("=====================================");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}