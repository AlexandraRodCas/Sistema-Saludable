/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author elisa
 */
@Entity
public class Etapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="inicio",nullable = false,length = 255)
    private Date inicio;
     
    @Column(name="fin",nullable = false,length = 255)
    private Date fin;
    
    @Column(name="semanas",nullable = false,length = 255)
    private int semanas;
    
    @Column(name="tipo",nullable = false,length = 255)
    private String tipo;

    
    //constructor

    public Etapa(int id, Date inicio, Date fin, int semanas, String tipo) {
        this.inicio = inicio;
        this.fin = fin;
        this.semanas = semanas;
        this.tipo = tipo;
        this.id = id;
    }
    
    public Etapa(Date inicio, Date fin, int semanas, String tipo) {
        this.inicio = inicio;
        this.fin = fin;
        this.semanas = semanas;
        this.tipo = tipo;
    }

    public Etapa() {
    }
    
    

    ///GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id + ", inicio: " + inicio + ", fin: " + fin + ", semanas: " + semanas + ", tipo: " + tipo;
    }

    

    

    
}
