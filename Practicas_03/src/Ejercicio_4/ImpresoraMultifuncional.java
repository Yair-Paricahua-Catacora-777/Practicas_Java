package Ejercicio_4;
public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir() {
        System.out.println("Multifuncional: Imprimiendo documento.");
    }

    @Override
    public void escanear() {
        System.out.println("Multifuncional: Escaneando documento.");
    }
}