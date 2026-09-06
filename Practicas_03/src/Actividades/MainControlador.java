package Actividades;

public class MainControlador {
    public static void main(String[] args) {
        System.out.println("=== ACTIVIDADES SOLID COMPLETADAS ===");

        // Exp 1: SRP
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion();
        Habitacion h1 = new Habitacion("101", 100.0, gestor);
        h1.reservar("10/10/2026");
        System.out.println("Habitación 101 disponible el 10/10: " + h1.verificarDisponibilidad("10/10/2026"));

        // Exp 2: OCP
        Reserva r1 = new Reserva("RES-01", 200.0, new PoliticaCancelacionFlexible());
        r1.cancelar(30);

        // Exp 3: LSP
        Habitacion suite = new Suite("201", 200.0, gestor, 50.0);
        System.out.println("Precio total Suite: S/ " + suite.getPrecioBase());

        // Exp 4: ISP
        AtencionVIP vip = new AtencionVIP();
        vip.solicitarLimpieza();
        vip.solicitarComida("Desayuno");

        // Exp 5: DIP
        NotificadorReserva notificador = new NotificadorReserva(new EnviadorSMS());
        notificador.enviarNotificacion("Reserva confirmada con éxito.");
    }
}