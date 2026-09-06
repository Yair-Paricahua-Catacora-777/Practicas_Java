package Actividades;

public class AtencionVIP implements ServicioLimpieza, ServicioComida {
    public void solicitarLimpieza() { System.out.println("Limpieza VIP ejecutada."); }
    public void solicitarComida(String platillo) { System.out.println("Comida servida: " + platillo); }
}