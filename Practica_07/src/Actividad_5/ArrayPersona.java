package Actividad_5;

public class ArrayPersona {
    public Persona[] arreglo;
    final int max = 128;
    int tamano = 0;

    public ArrayPersona() {
        this.arreglo = new Persona[this.max];
    }

    public void printArray(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < this.tamano; i++) {
            if (this.arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado -> " + this.arreglo[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void addArray(Persona persona) {
        if (this.tamano < max) {
            this.arreglo[this.tamano++] = persona;
        }
    }
}