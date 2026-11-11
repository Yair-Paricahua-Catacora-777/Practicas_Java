package Ejercicio;

import javax.swing.JFrame;

public class PruebaPasaje {
    public static void main(String[] args) {
        PasajeMarco pasajeMarco = new PasajeMarco();
        pasajeMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasajeMarco.setSize(380, 450);
        pasajeMarco.setVisible(true);
    }
}