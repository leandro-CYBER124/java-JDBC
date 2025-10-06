
package com.mycompany.Persistence;

import java.util.*;
import com.mycompany.Entities.Autor;
import com.mycompany.Entities.Editorial;
import com.mycompany.Entities.Libro;


public class LibroDAO extends DAO<Libro> {

    @Override
    public Libro guardar(Libro libro){
        super.guardar(libro);
        
        return libro;
    }
    
    public void eliminar(Integer isbn) {
       Libro libro = buscIsbn(isbn);
        super.eliminar(libro);
    }
    
    public List<Libro> listAll(){
        //nos conectamos a la base
        conectar();
        //creamos una lista para guardar los objetos que trae la consulta 
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        // desconectamos la base
        desconectar();
        //retornamos la lista 
        return libros;
    }
    
    
    public Libro buscIsbn(Integer isbn){
        
        Libro libro=null;
       
        conectar();
        //conecamos la base
        
        try {
            //intentamos traer algun libro con el isbn pedido
            libro=(Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn = :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        } catch (Exception e) {
            //si no hay que traiga un null
            System.out.println("no se encontro el isbn en la base");
            return null;
        }finally{
            //desconectamos
            desconectar();
        }
        return libro;
    }
    
    
    public Libro buscTitulo(String titulo){
       Libro libro=null;
                
        conectar();
        
        //conectamos la base
        
        try {
            //intentamos traer algun libro con el isbn pedido
            libro=(Libro) em.createQuery("SELECT li FROM Libro li WHERE li.titulo = :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        } catch (Exception e) {
            //si no hay que traiga un null
            System.out.println("no se encontro el titulo en la base");
            return null;
        }finally{
            //desconectamos
            desconectar();
        }
        return libro;
    }
    
    public Libro buscAut(Autor autor){
        
        Libro libro=null;
        conectar();
        
        try {
           
            libro=(Libro) em.createQuery("SELECT autor FROM Libro li WHERE li.autor = :autor")
                .setParameter("autor", autor).getSingleResult();
            return libro;
        } catch (Exception e) {
            
            System.out.println("no se encontro el autor en la base");
            return null;
        }finally{
          
            desconectar();
        }
    
    }
    
    public Libro buscEdit(Editorial editorial){
        Libro libro=null;
        
        conectar();
        
        try {
           
            libro=(Libro) em.createQuery("SELECT l FROM Libro l WHERE l.editorial = :editorial")
                .setParameter("editorial", editorial).getSingleResult();
        } catch (Exception e) {
           
            System.out.println("no se encontro la editorial en la base");
            return null;
        }finally{
            
            desconectar();
        }
        return libro;
    }
    
    
}
