package PersistenciaPU;

import Modelo.Consumidor;
import Modelo.Ventas;
import PersistenciaPU.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladoraPU {

    private CalcularPrecioJpaController calcularPrecioJpa;
    private ConsumidorJpaController consumidorJpa;

    public ControladoraPU() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaPU");
        calcularPrecioJpa = new CalcularPrecioJpaController(emf);
        consumidorJpa = new ConsumidorJpaController(emf);
    }

    public EntityManager getEntityManager() {
        return consumidorJpa.getEntityManager();
    }



    public void create(Consumidor consumidor) throws Exception {
        consumidorJpa.create(consumidor);
    }

    public void edit(Consumidor consumidor) throws Exception {
        consumidorJpa.edit(consumidor);
    }

    public void destroyConsumidor(int id) throws NonexistentEntityException {
        consumidorJpa.destroy(id);
    }

    public List<Consumidor> findConsumidorEntities() {
        return consumidorJpa.findConsumidorEntities();
    }

    public List<Consumidor> findConsumidorEntities(int maxResults, int firstResult) {
        return consumidorJpa.findConsumidorEntities(maxResults, firstResult);
    }

    public Consumidor findConsumidor(int id) {
        return consumidorJpa.findConsumidor(id);
    }

    public int getConsumidorCount() {
        return consumidorJpa.getConsumidorCount();
    }

    public void guardar(Ventas calcularPrecio) throws Exception {
        calcularPrecioJpa.create(calcularPrecio);
    }

    public Ventas consultaIDventa(int id) {
        return calcularPrecioJpa.findCalcularPrecio(id);
    }

    public List<Ventas> consultarListaCalcularPrecio() {
        return calcularPrecioJpa.findCalcularPrecioEntities();
    }

    public void modificarCalcularPrecio(Ventas calcularPrecio) throws Exception {
        calcularPrecioJpa.edit(calcularPrecio);
    }

    public void borrarCalcularPrecio(int idCalcularPrecio) throws NonexistentEntityException {
        calcularPrecioJpa.destroy(idCalcularPrecio);
    }

    // ==========================
    // MÉTODO GENÉRICO (GUARDAR CUALQUIER ENTIDAD)
    // ==========================

    public void guardar(Object obj) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }
}

