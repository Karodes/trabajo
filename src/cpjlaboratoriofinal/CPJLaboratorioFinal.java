
package cpjlaboratoriofinal;

import java.io.IOException;
import java.util.Scanner;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;


public class CPJLaboratorioFinal {

    private static final String NOMBRE_ARCHIVO="C:\\Users\\Carlos\\Desktop\\2018\\04_Programacion Avanzada\\LaboratorioFinal\\catalogoPeliculas\\catalogoPeliculas\\peliculas.txt";
   
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int opcion;
        CatalogoPeliculasImpl catalogoPeliculas;
        Pelicula pelicula;
        do{
            menu();
            opcion=s.nextInt();
            ejecutar(opcion);
        }while (opcion!=0);
    }
    
    
    public static void menu(){
        System.out.println("Elije opción");
        System.out.println("============");
        System.out.println("");
        System.out.println("1.- Iniciar Catálogo");
        System.out.println("2.- Agregar Película");
        System.out.println("3._ Listar Películas");
        System.out.println("4._ Buscar Películas");
        System.out.println("0.- Salir");
        System.out.println("");
        System.out.println("Ingrese opcion: ");
    }
    
    
    public static void ejecutar(int op) throws IOException{
        String nombre;
        Scanner s = new Scanner(System.in);
        CatalogoPeliculasImpl catalogoPeliculas = new CatalogoPeliculasImpl();
        
        switch (op){
            case 1: catalogoPeliculas.iniciarArchivo(NOMBRE_ARCHIVO);
                break;
            case 2:
                System.out.println("Ingrese nombre de pelicula: ");
                nombre=s.nextLine();
                Pelicula pelicula=new Pelicula(nombre);
                catalogoPeliculas.agregarPelicula(nombre,NOMBRE_ARCHIVO);
                break; 
            case 3: catalogoPeliculas.listarPeliculas(NOMBRE_ARCHIVO);
                break;
            case 4:System.out.println("Ingrese nombre de pelicula: ");
                nombre=s.nextLine(); 
                catalogoPeliculas.buscarPelicula(nombre,NOMBRE_ARCHIVO);
                break;
            case 0: System.out.println("Gracias por usar esta aplicación");
                break;
            default: System.out.println("Opcion no válida");
                break;
        }
    }
}
