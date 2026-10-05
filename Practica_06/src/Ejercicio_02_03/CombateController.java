package Ejercicio_02_03;

import java.util.Random;

public class CombateController {

    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;
    private Random random;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
        this.random = new Random();
    }

    public void ejecutarTurnoJugadorAtaca() {
        if (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            int dano = jugador.atacar();
            enemigo.recibirDano(dano);
            vista.mostrarMensaje(jugador.getNombre() + " ataca causando " + dano + " de daño.");
            vista.mostrarEstadoCombate(jugador, enemigo);
        }
    }

    public void ejecutarTurnoEnemigo() {
        if (enemigo.getSalud() > 0 && jugador.getSalud() > 0) {
            int accion = random.nextInt(2);
            if (accion == 0) {
                int dano = enemigo.atacar();
                jugador.recibirDano(dano);
                vista.mostrarMensaje(enemigo.getNombre() + " ataca causando " + dano + " de daño.");
            } else {
                vista.mostrarMensaje(enemigo.getNombre() + " gruñe amenazadoramente pero no ataca.");
            }
            vista.mostrarEstadoCombate(jugador, enemigo);
        }
    }

    public void verificarFinCombate() {
        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("Has sido derrotado por " + enemigo.getNombre());
        } else if (enemigo.getSalud() <= 0) {
            vista.mostrarMensaje("¡Has derrotado a " + enemigo.getNombre() + "!");
        }
    }
}	