package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;


@Entity
@Table(name = "consumidor", indexes = {
    @Index(name = "idx_dni", columnList = "dni")
})
public class Consumidor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Basic
    public String nombre;

    public String apellido;

    public int dni;

    public String numeroTelefono;

    public String gmail;

    public String localidad;

    public Consumidor() {
    }

    public Consumidor(int id, String nombre, String apellido, int dni, String numeroTelefono, String gmail, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numeroTelefono = numeroTelefono;
        this.gmail = gmail;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

   
}
