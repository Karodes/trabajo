
package mx.com.gm.peliculas.negocio;

//Se crea la clase a partir de la interface creada

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    AccesoDatos datosat;
    AccesoDatosImpl datos = new AccesoDatosImpl();
    Pelicula pelicula = new Pelicula();
            
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        //Verificar si el archivo existe
        boolean resultado=datos.existe(nombreArchivo);
        if (resultado==false){
            datos.crear(nombreArchivo);
        }else{
            Pelicula pelicula = new Pelicula(nombrePelicula);
          datos.escribir(pelicula, nombreArchivo, resultado);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarPelicula(String buscar, String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        //Verificar si archivo existe
        boolean resultado=datos.existe(nombreArchivo);
        if (resultado==false){
            datos.crear(nombreArchivo);
        }else{
            System.out.println("El archivo ya existe!");
        }
    }
    
}
