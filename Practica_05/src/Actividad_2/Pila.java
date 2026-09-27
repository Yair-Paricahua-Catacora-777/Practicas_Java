package Actividad_2;
public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;
    public Pila() {
        this(10);
    }
    @SuppressWarnings("unchecked")
    public Pila(int s) {
        this.tamanio = s > 0 ? s : 10;
        this.superior = -1;
        this.elementos = (E[]) new Object[tamanio];
    }
    public void push(E valorAMeter) {
        if (superior == tamanio - 1) {
            throw new ExcepcionPilaLlena(String.format("La Pila está llena, no se puede meter %s", valorAMeter));
        }
        elementos[++superior] = valorAMeter;
    }
    public E pop() {
        if (superior == -1) {
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        }
        return elementos[superior--];
    }
    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i] == null && elemento == null) return true;
            if (elementos[i] != null && elementos[i].equals(elemento)) return true;
        }
        return false;
    }
    public boolean esIgual(Pila<E> otraPila) {
        if (otraPila == null) return false;
        if (this.superior != otraPila.superior) return false;

        for (int i = 0; i <= this.superior; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }
        return true;
    }
}