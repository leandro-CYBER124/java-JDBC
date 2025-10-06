
package com.mycompany.Persistence;

import java.util.*;
import com.mycompany.Entities.Autor;


public class AutorDAO extends DAO<Autor> {
    
    
    @Override
    public Autor guardar(Autor autor){
     super.guardar(autor);
        return autor;
    }
    
    public void eliminar(Integer id){
        Autor autor= buscarId(id);
        super.eliminar(autor);
    }
    
    public List<Autor> listAll(){
     conectar();
     List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
     desconectar();
           
        return autores;
    }

    public Autor buscarId(Integer id) {
       conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }
    
    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor = null;
        try{
             autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                .setParameter("nombre", nombre).getSingleResult();
         
             
             
        }catch(Exception e){
            System.out.println("no se encontro autor");
          System.out.println(e.getMessage());
          //  e.printStackTrace();
            return null;
        }finally{
        desconectar();
        }
         return autor;      

    }

}
