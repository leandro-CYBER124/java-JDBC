package com.mycompany.libreriaJPA1.Services;

import java.util.*;
import com.mycompany.Entities.Autor;
import com.mycompany.Entities.Editorial;
import com.mycompany.Entities.Libro;
import com.mycompany.Persistence.LibroDAO;

public class LibroService {

    private LibroDAO libroDao = new LibroDAO();
    private Scanner read = new Scanner(System.in);
    private Editorial editorial = new Editorial();
    private EditorialService editorialServ = new EditorialService();
    private AutorService autorServ = new AutorService();
    private Autor autor = new Autor();

    public Libro guardarLibro(Libro libro) {
        return (Libro) libroDao.guardar(libro);
    }

    public LibroService() {
        this.libroDao = new LibroDAO();

    }

    public Libro crearLib() {
        Libro libro = new Libro();
        try {

            System.out.println("ingrese el titulo del libro");
            libro.setTitulo(read.nextLine());
            System.out.println("ingrese el año del libro");
            libro.setAnio(read.nextInt());
            System.out.println("ingrese la cantidad de ejemplares");
            libro.setEjemplares(read.nextInt());
            System.out.println("ingrese la cantidad de ejemplares prestados");
            libro.setEjemplaresPrestados(read.nextInt());
            read.nextLine();
            libro.setEjemplaresRestantes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            libro.setAlta(true);
            System.out.println("ingrese el nombre de la editorial");
            String nomEd = read.nextLine();
            editorial= editorialServ.buscarNom(nomEd);
            
            if (editorial == null) {
                editorial=editorialServ.crearEd(nomEd);
            }
            
            libro.setEditorial(editorial);
            
                       
            System.out.println("ingrese el nombre del autor");
            String nomAut = read.nextLine();
             autor = autorServ.buscarNombre(nomAut);
               
            if (autor==null) {
            autor=autorServ.crearAutor(nomAut);
            } 
            libro.setAutor(autor);
            libro.setAlta(true);
            libroDao.guardar(libro);
            
           return libro;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
    
    
    public Libro crearLib(String nombre) {
        Libro libro = new Libro();
        try {
          
            libro.setTitulo(nombre);
            System.out.println("ingrese el año del libro");
            libro.setAnio(read.nextInt());
            System.out.println("ingrese la cantidad de ejemplares");
            libro.setEjemplares(read.nextInt());
            System.out.println("ingrese la cantidad de ejemplares prestados");
            libro.setEjemplaresPrestados(read.nextInt());
            read.nextLine();
            libro.setEjemplaresRestantes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            libro.setAlta(true);
            System.out.println("ingrese el nombre de la editorial");
            String nomEd = read.nextLine();
            editorial= editorialServ.buscarNom(nomEd);
            
            if (editorial == null) {
                editorial=editorialServ.crearEd(nomEd);
            }
            
            libro.setEditorial(editorial);
            
                       
            System.out.println("ingrese el nombre del autor");
            String nomAut = read.nextLine();
             autor = autorServ.buscarNombre(nomAut);
               
            if (autor==null) {
            autor=autorServ.crearAutor(nomAut);
            } 
            libro.setAutor(autor);
            libro.setAlta(true);
            libroDao.guardar(libro);
            
           return libro;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    public Libro buscarIsbn(Integer isbn) {

        return libroDao.buscIsbn(isbn);

    }

    public boolean eliminarIsbn(Integer isbn) {
        
        try {
            libroDao.eliminar(isbn);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }

    }

    public List<Libro> listAll() {
        return libroDao.listAll();
    }

    public Libro buscarTit(String titulo) {
        
        return libroDao.buscTitulo(titulo);

    }

    public Libro buscarAut(Autor autor) {
        
        return libroDao.buscAut(autor);

    }

    public Libro buscarEdit(Editorial editorial) {
               
        return libroDao.buscEdit(editorial);
    }

}
