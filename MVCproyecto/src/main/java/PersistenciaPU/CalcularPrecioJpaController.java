/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaPU;

import Modelo.Ventas;
import PersistenciaPU.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author hackerleandro
 */
public class CalcularPrecioJpaController implements Serializable {

    public CalcularPrecioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    } 
    public CalcularPrecioJpaController() {
        emf = Persistence.createEntityManagerFactory("PersistenciaPU");    
   }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

  
    
    

    public void create(Ventas calcularPrecio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calcularPrecio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ventas calcularPrecio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            calcularPrecio = em.merge(calcularPrecio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = calcularPrecio.getId();
                if (findCalcularPrecio(id) == null) {
                    throw new NonexistentEntityException("The calcularPrecio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventas calcularPrecio;
            try {
                calcularPrecio = em.getReference(Ventas.class, id);
                calcularPrecio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calcularPrecio with id " + id + " no longer exists.", enfe);
            }
            em.remove(calcularPrecio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ventas> findCalcularPrecioEntities() {
        return findCalcularPrecioEntities(true, -1, -1);
    }

    public List<Ventas> findCalcularPrecioEntities(int maxResults, int firstResult) {
        return findCalcularPrecioEntities(false, maxResults, firstResult);
    }

    private List<Ventas> findCalcularPrecioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ventas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ventas findCalcularPrecio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ventas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalcularPrecioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ventas> rt = cq.from(Ventas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
