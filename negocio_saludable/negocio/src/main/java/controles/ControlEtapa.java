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
    
}
