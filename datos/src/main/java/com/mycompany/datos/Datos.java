package com.mycompany.datos;

import entidades.Rama;
import implementaciones.RamasDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gabriel 
 */
public class Datos {

    public static void main(String[] args) {
        
        long tiempoActual = System.currentTimeMillis(); 
        Date fechaI = new Date(tiempoActual);
        Date fechaF = new Date(tiempoActual);
        
        RamasDAO etapaDAO = new RamasDAO();
        
        List<Rama> etapas = etapaDAO.consultarRamas();
         
        for(Rama elementos:etapas){
            System.out.println(elementos.toString());
        }
        
    }
}
