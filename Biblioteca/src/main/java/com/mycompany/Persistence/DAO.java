
package com.mycompany.Persistence;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class DAO<T extends Object> {

   protected EntityManager em = Persistence.createEntityManagerFactory("libreriaJPA1PU").createEntityManager();
    
    protected void conectar() {
        if (!em.isOpen()) {
            em = Persistence.createEntityManagerFactory("libreriaJPA1PU").createEntityManager();
        }
    }
    
    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    public T guardar(T objeto) {
        conectar();
        try {
            em.getTransaction().begin();
            em.persist(objeto); 
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ocurrio un error al persistir el objeto de tipo: "+objeto.getClass().getSimpleName());
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return objeto;
    }
    
     protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
