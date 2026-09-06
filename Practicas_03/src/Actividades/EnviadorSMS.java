package Actividades;

public class EnviadorSMS implements CanalNotificacion {
    public void enviar(String mensaje) { System.out.println("[SMS] " + mensaje); }
}
