
package com.mycompany.Persistence;

import java.util.List;
import com.mycompany.Entities.Editorial;


public class EditorialDao extends DAO<Editorial> {
   
    @Override
    public Editorial guardar(Editorial editorial){
        super.guardar(editorial);
        return editorial;
    }

    public void eliminar (Integer id){
        Editorial editorial = buscarId(id);
        super.eliminar(editorial);
    }
    
    public List<Editorial> listAll(){
        conectar();
        List<Editorial> editoriales=null;
        try {
            editoriales= em.createQuery("SELECT e FROM Editorial e").getResultList();
            return editoriales;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }finally{
             desconectar();
        }
     }
    
    public Editorial buscarId (Integer id){
        conectar();
       Editorial editorial =null;
        try {
             editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id = :id")
                .setParameter("id", id).getSingleResult();
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
            return null;
        }finally{
             desconectar();
           
        }    
    }
    
    public Editorial buscarNombre (String nombre){
        conectar();
        Editorial editorial =null;
        try {
             editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        return editorial;
        
        } catch (Exception e) {
             System.out.println("no se encontro editorial");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }finally{
            desconectar();
        }
       
    }
    
}
