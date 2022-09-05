package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        try {
            datos.escribir(pelicula, nombreArchivo, true);
        } catch (EscrituraDatosEx e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            datos.listar(nombreArchivo).forEach(pelicula -> System.out.println("Pelicula: " + pelicula.getNombre()));
        } catch (LecturaDatosEx e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            String coincidencia = datos.buscar(nombreArchivo, buscar);
            System.out.println("Se econtró una coincidencia para la búsqueda de: " + coincidencia);
        } catch (LecturaDatosEx e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        datos.crear(nombreArchivo);
    }

}
