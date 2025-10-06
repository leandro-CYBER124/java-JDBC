package Modelo;

import PersistenciaPU.ControladoraPU;
import PersistenciaPU.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladoraClases {

    private ControladoraPU controladoraPU = new ControladoraPU();

    // ==========================
    // MÉTODOS PARA VENTAS
    // ==========================

   public void guardarCalculo(double precioProd, double descuento) throws Exception {
    Ventas calcularPrecio = new Ventas();
    calcularPrecio.setPrecioProd(precioProd);
    calcularPrecio.setDescuento(descuento);
    calcularPrecio.CalculoFinal();

    System.out.println("guardadooooooo linea 20 con consumidor");
    controladoraPU.guardar(calcularPrecio);
}


    public List<Ventas> obtenerTodosCalculos() {
        return controladoraPU.consultarListaCalcularPrecio();
    }

    public Ventas consultarCalculo(int idCalcularPrecio) {
        return controladoraPU.consultaIDventa(idCalcularPrecio);
    }
    /*
    public void borrarCalculo(int idCalcularPrecio) throws NonexistentEntityException {
        controladoraPU.borrarCalcularPrecio(idCalcularPrecio);
    }*/

    // ==========================
    // MÉTODOS PARA CONSUMIDOR
    // ==========================

    public void guardarDatos(int id, String nombre, String apellido, int dni, String numeroTelefono, String gmail, String localidad) {
        Consumidor consumidor1 = new Consumidor();
        consumidor1.setId(id);
        consumidor1.setNombre(nombre);
        consumidor1.setApellido(apellido);
        consumidor1.setDni(dni);
        consumidor1.setNumeroTelefono(numeroTelefono);
        consumidor1.setGmail(gmail);
        consumidor1.setLocalidad(localidad);
        System.out.println("guardado linea49");
        
        controladoraPU.guardar(consumidor1); // usa el método genérico
    }

    public void create(Consumidor consumidor) throws Exception {
        controladoraPU.create(consumidor);
    }

    public void edit(Consumidor consumidor) throws Exception {
        controladoraPU.edit(consumidor);
    }

    public void destroy(int id) throws NonexistentEntityException {
        controladoraPU.destroyConsumidor(id);
    }

    public List<Consumidor> findConsumidorEntities() {
        return controladoraPU.findConsumidorEntities();
    }

    public List<Consumidor> findConsumidorEntities(int maxResults, int firstResult) {
        return controladoraPU.findConsumidorEntities(maxResults, firstResult);
    }

    public Consumidor findConsumidor(int id) {
        return controladoraPU.findConsumidor(id);
    }

    public int getConsumidorCount() {
        return controladoraPU.getConsumidorCount();
    }
}
