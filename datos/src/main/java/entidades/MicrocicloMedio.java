/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Alexandra
 */
@Entity
public class MicrocicloMedio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "microciclo_id")
    private Microciclo microciclo;

    @ManyToOne
    @JoinColumn(name = "medio_id")
    private Medio medio;

    private float volumen;

    public MicrocicloMedio() {
    }

    public MicrocicloMedio(Microciclo microciclo, Medio medio, float volumen) {
        this.microciclo = microciclo;
        this.medio = medio;
        this.volumen = volumen;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Microciclo getMicrociclo() {
        return microciclo;
    }

    public void setMicrociclo(Microciclo microciclo) {
        this.microciclo = microciclo;
    }

    public Medio getMedio() {
        return medio;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.microciclo);
        hash = 47 * hash + Objects.hashCode(this.medio);
        hash = 47 * hash + Float.floatToIntBits(this.volumen);
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
        final MicrocicloMedio other = (MicrocicloMedio) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.volumen) != Float.floatToIntBits(other.volumen)) {
            return false;
        }
        if (!Objects.equals(this.microciclo, other.microciclo)) {
            return false;
        }
        return Objects.equals(this.medio, other.medio);
    }

    @Override
    public String toString() {
        return "id: " + id + ", microciclo: " + microciclo + ", medio: " + medio + ", volumen: " + volumen;
    }

    
}
