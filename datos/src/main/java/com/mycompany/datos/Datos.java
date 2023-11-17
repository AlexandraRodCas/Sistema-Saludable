package com.mycompany.datos;

import entidades.Etapa;
import entidades.Rama;
import implementaciones.EtapasDAO;
import implementaciones.RamasDAO;
import interfaces.IEtapasDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel 
 */
public class Datos {

    public static void main(String[] args) {
        IEtapasDAO etapasDAO = new EtapasDAO();
        List<Etapa> listaEtapas = etapasDAO.consultarEtapas();
        List<Etapa> listaEtapasAgregadas = etapasDAO.consultarEtapas();

        // Obtener el rango correcto
        int totalEtapas = listaEtapasAgregadas.size();
        int indiceInicio = Math.max(totalEtapas - 4, 0); // Índice de inicio para las últimas 4 etapas

        List<Etapa> ultimasCuatroAgregadas = new ArrayList<>();
        for (int i = indiceInicio; i < totalEtapas; i++) {
            ultimasCuatroAgregadas.add(listaEtapasAgregadas.get(i));
        }

        System.out.println(ultimasCuatroAgregadas.get(3));
        
    }
}
