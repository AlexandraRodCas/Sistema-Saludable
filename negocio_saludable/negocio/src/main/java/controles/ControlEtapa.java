/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import implementaciones.EtapasDAO;
import interfaces.IEtapasDAO;
import java.sql.Date;

/**
 *
 * @author Alexandra
 */
public class ControlEtapa {
    IEtapasDAO etapasDAO = new EtapasDAO();
    
    public boolean agregarEtapa(Date inicio, Date fin, int numSemana, String tipo){
        try{
            etapasDAO.agregarEtapa(inicio, fin, numSemana, tipo);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
