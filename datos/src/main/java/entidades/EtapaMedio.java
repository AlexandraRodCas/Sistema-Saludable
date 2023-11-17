/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alexandra
 */
@Entity
public class EtapaMedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "medio_id")
    private Medio medio;

    private double volumen;

    // Constructor vacío
    public EtapaMedio() {
    }

    // Constructor con parámetros
    public EtapaMedio(Etapa etapa, Medio medio, double volumen) {
        this.etapa = etapa;
        this.medio = medio;
        this.volumen = volumen;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Medio getMedio() {
        return medio;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    
    
    // Equals, hashCode, toString

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.etapa);
        hash = 97 * hash + Objects.hashCode(this.medio);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.volumen) ^ (Double.doubleToLongBits(this.volumen) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EtapaMedio other = (EtapaMedio) obj;
        if (this.volumen != other.volumen) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.etapa, other.etapa)) {
            return false;
        }
        return Objects.equals(this.medio, other.medio);
    }

    @Override
    public String toString() {
        return "id: " + id + ", etapa: " + etapa + ", medio: " + medio + ", volumen: " + volumen;
    }
    
    
}
