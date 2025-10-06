
package com.mycompany.coneccionjpa.LOGICA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Materias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMateria;

    @Basic
    private String Materia;
    private String profesor;

    @Temporal(TemporalType.DATE)
    private Date Cursado;

    
    public Materias() {
    }

    public Materias(int idMateria, String Materia, String profesor, Date Cursado) {
        this.idMateria = idMateria;
        this.Materia = Materia;
        this.profesor = profesor;
        this.Cursado = Cursado;
    }
    
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Date getCursado() {
        return Cursado;
    }

    public void setCursado(Date Cursado) {
        this.Cursado = Cursado;
    }
    @Override
    public String toString() {
        return "Materia{" + "Materia=" + idMateria + ", materia=" + Materia + ", profesor=" + profesor + ", fechaCursada=" + Cursado + '}';
    }
}

    

