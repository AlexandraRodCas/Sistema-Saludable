/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Etapa;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author elisa
 */
public interface IEtapasDAO {
    public boolean agregarEtapa(Date inicio, Date fin, int semanas, String tipo);
    public List<Etapa> consultarEtapas();
    public Etapa consultarEtapaId(int id);
}
