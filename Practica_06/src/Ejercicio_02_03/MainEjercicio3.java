package Ejercicio_02_03;

public class MainEjercicio3 {

    public static void main(String[] args) {
        Jugador jugador = new Jugador("Héroe", 100, 5);
        Enemigo enemigo = new Enemigo("Dragón", 80, 4, "Fuego");
        CombateView vista = new CombateView();

        Item espada = new Item("Espada Mágica", 1, "Arma", "Arma legendaria");
        jugador.equiparArma(espada);

        CombateController combate = new CombateController(jugador, enemigo, vista);

        System.out.println("--- ¡INICIA EL COMBATE! ---");
        vista.mostrarEstadoCombate(jugador, enemigo);


        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            combate.ejecutarTurnoJugadorAtaca();
            if (enemigo.getSalud() > 0) {
                combate.ejecutarTurnoEnemigo();
            }
        }

        combate.verificarFinCombate();
    }
}