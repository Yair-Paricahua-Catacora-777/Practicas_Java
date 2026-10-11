package Actividade_1;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre del archivo o directorio:");
        Path ruta = Paths.get(sc.nextLine());

        if (Files.exists(ruta)) {
            System.out.printf("%n%s existe.%n", ruta.getFileName());
            System.out.printf("%s un directorio.%n", Files.isDirectory(ruta) ? "Es" : "No es");
            System.out.printf("Tamaño: %s bytes%n", Files.isDirectory(ruta) ? "N/A" : Files.size(ruta));
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

            if (Files.isDirectory(ruta)) {
                System.out.println("%nContenido del directorio:");
                try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                    for (Path p : flujoDirectorio) {
                        System.out.println(p);
                    }
                }
            }
        } else {
            System.out.printf("La ruta %s no existe.%n", ruta);
        }
        sc.close();
    }
}