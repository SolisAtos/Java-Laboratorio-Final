package mx.com.gm.peliculas;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {
    static Scanner scanner;
    // 1static int opcion;
    static String nombreArchivo = "peliculas.txt";
    static CatalogoPeliculasImpl catalogoPeliculas;

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        catalogoPeliculas = new CatalogoPeliculasImpl();
        scanner = new Scanner(System.in);

        str.append("Elige opción:\n");
        str.append("1.- Iniciar catalogo peliculas\n");
        str.append("2.- Agregar pelicula\n");
        str.append("3.- Listar peliculas\n");
        str.append("4.- Buscar pelicula\n");
        str.append("5.- Borrar catálogo de peliculas\n");
        str.append("0.- Salir\n");

        System.out.print(str);

        int opcion = scanner.nextInt();
        scanner.nextLine();

        selection: switch (opcion) {
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
                System.out.println("Adios\n");
                break;
            default:
                System.out.println("Elige un número del 0 al 4");
                break selection;
        }
    }
}
