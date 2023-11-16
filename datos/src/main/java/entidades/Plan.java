/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Alexandra
 */
import java.sql.Date;
import java.util.Objects;

public class Plan {
    private int id;
    private Date inicio;
    private Date fin;
    private int jefeId;
    private int metodologoId;
    private int deporteId;
    private int ramaId;
    private int usuarioId;

    public Plan() {
    }

    public Plan(int id, Date inicio, Date fin, int jefeId, int metodologoId, int deporteId, int ramaId, int usuarioId) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.jefeId = jefeId;
        this.metodologoId = metodologoId;
        this.deporteId = deporteId;
        this.ramaId = ramaId;
        this.usuarioId = usuarioId;
    }
    

    // Getters y Setters para todos los atributos

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

    public int getJefeId() {
        return jefeId;
    }

    public void setJefeId(int jefeId) {
        this.jefeId = jefeId;
    }

    public int getMetodologoId() {
        return metodologoId;
    }

    public void setMetodologoId(int metodologoId) {
        this.metodologoId = metodologoId;
    }

    public int getDeporteId() {
        return deporteId;
    }

    public void setDeporteId(int deporteId) {
        this.deporteId = deporteId;
    }

    public int getRamaId() {
        return ramaId;
    }

    public void setRamaId(int ramaId) {
        this.ramaId = ramaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.inicio);
        hash = 41 * hash + Objects.hashCode(this.fin);
        hash = 41 * hash + this.jefeId;
        hash = 41 * hash + this.metodologoId;
        hash = 41 * hash + this.deporteId;
        hash = 41 * hash + this.ramaId;
        hash = 41 * hash + this.usuarioId;
        return hash;
    }

    // Equals, HashCode y ToString
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
        final Plan other = (Plan) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.jefeId != other.jefeId) {
            return false;
        }
        if (this.metodologoId != other.metodologoId) {
            return false;
        }
        if (this.deporteId != other.deporteId) {
            return false;
        }
        if (this.ramaId != other.ramaId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        return Objects.equals(this.fin, other.fin);
    }

    @Override
    public String toString() {
        return "id: " + id + ", inicio: " + inicio + ", fin: " + fin + ", jefeId: " + jefeId + ", metodologoId: " + metodologoId + ", deporteId: " + deporteId + ", ramaId: " + ramaId +", entrenadorId: "+ usuarioId;
    }
    
    
   
}

