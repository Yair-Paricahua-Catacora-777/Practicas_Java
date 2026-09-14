package Ejercicio_1;
public class ProcesadorCaracteres {   
    public void procesar(char c) throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        if (c == 'q' || c == 'Q') {
            throw new ExcepcionSalida("Se solicitó la salida del programa.");
        } 
        else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                 c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            throw new ExcepcionVocal("Se ingresó una vocal.");
        } 
        else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("Se ingresó un número.");
        } 
        else if (Character.isWhitespace(c)) {
            if (c == '\r' || c == '\n') {
                return; 
            }
            throw new ExcepcionBlanco("Se ingresó un espacio en blanco.");
        }
    }

    public static void main(String[] args) {
        LeerEntrada lector = new LeerEntrada(System.in);
        ProcesadorCaracteres procesador = new ProcesadorCaracteres();
        boolean ejecutando = true;

        System.out.println("Ingrese caracteres (q para salir):");

        while (ejecutando) {
            try {
                char c = lector.getChar();
                procesador.procesar(c);
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println("Saliendo: " + e.getMessage());
                ejecutando = false;
            } catch (Exception e) {
                System.out.println("Error de I/O: " + e.getMessage());
            }
        }
    }
}