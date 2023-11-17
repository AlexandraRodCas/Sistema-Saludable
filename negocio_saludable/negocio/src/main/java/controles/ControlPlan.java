/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Plan;
import implementaciones.PlanDAO;
import interfaces.IPlanDAO;
import java.util.Date;

/**
 *
 * @author Alexandra
 */
public class ControlPlan {
    IPlanDAO planDAO = new PlanDAO();
    
    public boolean fechaVacia(Date inicio, Date fin){
        if(inicio == null || fin == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void agregarPlan(Plan plan){
        planDAO.agregarPlan(plan);
    }
}
