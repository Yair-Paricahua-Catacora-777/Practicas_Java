package Actividad_6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial5 {
    public static void main(String[] args) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))) {
            salida.writeObject(new Alumno("12345678A", "Lucas González", 20, new Fecha(5, 9, 2011)));
            salida.writeObject(new Alumno("98765432B", "Anacleto Jiménez", 19, new Fecha(7, 9, 2011)));
            salida.writeObject(new Alumno("782342122", "María Zapata", 21, new Fecha(8, 9, 2011)));
            
            System.out.println("¡Alumnos serializados y guardados en alumnos.dat con éxito!");
        } catch (IOException e) {
            System.out.println("Error de serialización: " + e.getMessage());
        }
    }
}