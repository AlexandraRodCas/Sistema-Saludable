/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Etapa;
import entidades.Plan;
import implementaciones.EtapasDAO;
import implementaciones.PlanEtapaDAO;
import interfaces.IEtapasDAO;
import interfaces.IPlanEtapaDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class ControlEtapa {
    IEtapasDAO etapasDAO = new EtapasDAO();
    ControlPlan controlPlan = new ControlPlan();
    IPlanEtapaDAO planEtapaDAO = new PlanEtapaDAO();
    
    public boolean agregarEtapa(Date inicio, Date fin, int numSemana, String tipo){
        try{
            etapasDAO.agregarEtapa(inicio, fin, numSemana, tipo);
            Etapa etapa = consultarUltimaEtapaAgregada();
            Plan plan = controlPlan.consultarUltimoPlanAgregado();
            planEtapaDAO.agregarPlanEtapa(plan, etapa);
            
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public Etapa consultarUltimaEtapaAgregada(){
        List<Etapa> listaEtapas = etapasDAO.consultarEtapas();
        return listaEtapas.get(listaEtapas.size()-1);
        
    }
    
    public List<Etapa> consultarUltimasEtapasAgregada(){
        List<Etapa> listaEtapas = etapasDAO.consultarEtapas();
        List<Etapa> listaEtapasAgregadas = etapasDAO.consultarEtapas();

        // Obtener el rango correcto
        int totalEtapas = listaEtapasAgregadas.size();
        int indiceInicio = Math.max(totalEtapas - 4, 0); // Índice de inicio para las últimas 4 etapas

        List<Etapa> ultimasCuatroAgregadas = new ArrayList<>();
        for (int i = indiceInicio; i < totalEtapas; i++) {
            ultimasCuatroAgregadas.add(listaEtapasAgregadas.get(i));
        }
        return ultimasCuatroAgregadas;
        
    }
    
}
