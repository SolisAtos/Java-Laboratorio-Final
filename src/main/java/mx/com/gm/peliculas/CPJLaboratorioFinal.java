package mx.com.gm.peliculas;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {
    static Scanner scanner;
    static int opcion;
    static String nombreArchivo = "peliculas.txt";
    static CatalogoPeliculasImpl catalogoPeliculas;

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        catalogoPeliculas = new CatalogoPeliculasImpl();
        scanner = new Scanner(System.in);

        str.append("\nElige opción:\n");
        str.append("1.- Iniciar catalogo peliculas\n");
        str.append("2.- Agregar pelicula\n");
        str.append("3.- Listar peliculas\n");
        str.append("4.- Buscar pelicula\n");
        str.append("0.- Salir\n");

        do {
            System.out.print(str);

            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case 1:
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Introduce el nombre de una pelicula a agregar:\n");
                    String nombrePelicula = scanner.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Introduce el nombre de una pelicula a buscar:\n");
                    String buscar = scanner.nextLine();
                    catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Elige un número del 0 al 4\n");
                    break;
            }
        } while (opcion != 0);

        System.out.println("Adios\n");
    }
}
