package Ejercicio_4;
public class AplicacionEjercicio4 {

    public static void procesarImpresion(Imprimible equipo) {
        equipo.imprimir();
    }
    public static void procesarEscaneo(Escaneable equipo) {
        equipo.escanear();
    }
    public static void main(String[] args) {
        System.out.println("  APLICACIÓN DE GESTIÓN DE IMPRESORAS  ");
        Impresora impresoraSimple = new Impresora();
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();
        System.out.println("\n--- Área de Impresión ---");
        procesarImpresion(impresoraSimple);
        procesarImpresion(multifuncional);
        System.out.println("\n--- Área de Digitalización ---");
        procesarEscaneo(multifuncional);
        System.out.println("Proceso finalizado correctamente.");
    }
}