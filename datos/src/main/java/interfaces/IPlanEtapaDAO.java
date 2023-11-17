/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Etapa;
import entidades.Plan;

/**
 *
 * @author Alexandra
 */
public interface IPlanEtapaDAO {
    public boolean agregarPlanEtapa(Plan plan, Etapa etapa);
}
