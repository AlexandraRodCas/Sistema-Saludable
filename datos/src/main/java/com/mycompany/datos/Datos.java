package com.mycompany.datos;

import entidades.Etapa;
import entidades.Tipo;
import implementaciones.EtapasDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gabriel 
 */
public class Datos {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        long tiempoActual = System.currentTimeMillis(); 
        Date fechaI = new Date(tiempoActual);
        Date fechaF = new Date(tiempoActual);
        
        EtapasDAO etapaDAO = new EtapasDAO();
        
        etapaDAO.agregarEtapa(fechaI, fechaF, 0, "General", 1);
        
        List<Etapa> etapas = etapaDAO.consultarEtapas();
         
        for(Etapa elementos:etapas){
            System.out.println(elementos.toString());
        }
        
    }
}
