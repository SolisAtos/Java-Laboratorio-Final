package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImpl implements AccesoDatos {

    public AccesoDatosImpl() {

    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File f = new File(nombreArchivo);
        try {
            if (f.exists() && !f.isDirectory()) {
                return true;
            }
        } catch (Exception e) {
            throw new AccesoDatosEx(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Pelicula> lista = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String line = reader.readLine();
            while (line != null) {
                Pelicula pelicula = new Pelicula(line);
                lista.add(pelicula);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new LecturaDatosEx(e.getMessage());
        }
        return lista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        try {
            FileWriter fw = new FileWriter(nombreArchivo, anexar);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pelicula.getNombre());
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new EscrituraDatosEx(e.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String line = reader.readLine();
            while (line != null) {
                if (line.equals(buscar)) {
                    return line;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new LecturaDatosEx(e.getMessage());
        }
        return null;
    }

    @Override
    public void crear(String nombreArchivo) {
        try {
            File file = new File(nombreArchivo);
            if (file.createNewFile()) {
                System.out.println("Archivo creado: " + file.getName());
            } else {
                System.out.println("Archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        File file = new File(nombreArchivo);
        if (file.delete()) {
            System.out.println("Se borró el archivo: " + file.getName());
        } else {
            System.out.println("No se pudo borrar el archivo");
        }

    }

}
