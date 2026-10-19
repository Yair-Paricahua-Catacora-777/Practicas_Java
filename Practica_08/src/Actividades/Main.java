package Actividades;
public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();

        op.crearTabla();

        op.insertar(1, "Carlos", 22);
        op.insertar(2, "Maria", 19);
        op.insertar(3, "Jose", 18);
        op.recuperar();
        op.actualizar("Carlos Alberto", 1);
        op.borrar(2);
        op.probarTransaccion();
        op.recuperar();
    }
}