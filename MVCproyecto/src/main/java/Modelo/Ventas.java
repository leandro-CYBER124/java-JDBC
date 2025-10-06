package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Ventas implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Basic
    private double precioProd;
    private double descuento;
    private double PrecioTotal;
    
     @ManyToOne
    @JoinColumn(name = "id_Consumidor") // columna FK en la tabla Ventas
    private Consumidor consumidor; // atributo que representa la relación
    
    public Ventas() {
    }

    public Ventas(int id,double PrecioProd, double descuento, double resultado) {
        this.id = id;
        this.precioProd = PrecioProd;
        this.descuento = descuento;
        this.PrecioTotal = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    public double CalculoFinal() {
        PrecioTotal = precioProd - (precioProd * descuento / 100);
        return PrecioTotal;
    }

    void setConsumidor(Consumidor consumidor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

  
}
