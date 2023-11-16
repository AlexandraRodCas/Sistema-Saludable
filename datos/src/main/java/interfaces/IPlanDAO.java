/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Plan;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IPlanDAO {
    public boolean agregarPlan(Plan plan);
    public List<Plan> consultarPlanes();
}
