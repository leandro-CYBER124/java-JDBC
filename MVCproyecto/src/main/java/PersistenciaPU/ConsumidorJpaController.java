
package PersistenciaPU;

import Modelo.Consumidor;
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


public class ConsumidorJpaController implements Serializable {

    public ConsumidorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ConsumidorJpaController() {
        emf = Persistence.createEntityManagerFactory("PersistenciaPU");  
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consumidor consumidor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(consumidor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consumidor consumidor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            consumidor = em.merge(consumidor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = consumidor.getId();
                if (findConsumidor(id) == null) {
                    throw new NonexistentEntityException("The consumidor with id " + id + " no longer exists.");
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
            Consumidor consumidor;
            try {
                consumidor = em.getReference(Consumidor.class, id);
                consumidor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consumidor with id " + id + " no longer exists.", enfe);
            }
            em.remove(consumidor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consumidor> findConsumidorEntities() {
        return findConsumidorEntities(true, -1, -1);
    }

    public List<Consumidor> findConsumidorEntities(int maxResults, int firstResult) {
        return findConsumidorEntities(false, maxResults, firstResult);
    }

    private List<Consumidor> findConsumidorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consumidor.class));
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

    public Consumidor findConsumidor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consumidor.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsumidorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consumidor> rt = cq.from(Consumidor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
