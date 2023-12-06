/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Alexandra
 */
@Entity
public class Microciclo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String ciclicidad;

    @Column(name = "no_mesociclo", nullable = false)
    private int noMesociclo;

    @Temporal(TemporalType.DATE)
    private Date inicio;

    @Temporal(TemporalType.DATE)
    private Date fin;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    public Microciclo() {
    }

    public Microciclo(String ciclicidad, int noMesociclo, Date inicio, Date fin, Etapa etapa) {
        this.ciclicidad = ciclicidad;
        this.noMesociclo = noMesociclo;
        this.inicio = inicio;
        this.fin = fin;
        this.etapa = etapa;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiclicidad() {
        return ciclicidad;
    }

    public void setCiclicidad(String ciclicidad) {
        this.ciclicidad = ciclicidad;
    }

    public int getNoMesociclo() {
        return noMesociclo;
    }

    public void setNoMesociclo(int noMesociclo) {
        this.noMesociclo = noMesociclo;
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

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.ciclicidad);
        hash = 89 * hash + this.noMesociclo;
        hash = 89 * hash + Objects.hashCode(this.inicio);
        hash = 89 * hash + Objects.hashCode(this.fin);
        hash = 89 * hash + Objects.hashCode(this.etapa);
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
        final Microciclo other = (Microciclo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.noMesociclo != other.noMesociclo) {
            return false;
        }
        if (!Objects.equals(this.ciclicidad, other.ciclicidad)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        return Objects.equals(this.etapa, other.etapa);
    }

    @Override
    public String toString() {
        return "id: " + id + ", ciclicidad: " + ciclicidad + ", noMesociclo: " + noMesociclo + ", inicio: " + inicio + ", fin: " + fin + ", etapa: " + etapa;
    }

    
}
