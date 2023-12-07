/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Microciclo;
import implementaciones.MicrocicloDAO;
import interfaces.IMicrocicloDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class ControlMicroMedio {
    IMicrocicloDAO microcicloDAO = new MicrocicloDAO();
    
    public List<Microciclo> consultarUltimosMicrosAgregados(int microsCantidad){
        List<Microciclo> listaMicrosAgregados = microcicloDAO.consultarMicrociclos();

        // Obtener el rango correcto
        int totalEtapas = listaMicrosAgregados.size();
        int indiceInicio = Math.max(totalEtapas - microsCantidad, 0); 

        List<Microciclo> ultimasCuatroAgregadas = new ArrayList<>();
        for (int i = indiceInicio; i < totalEtapas; i++) {
            ultimasCuatroAgregadas.add(listaMicrosAgregados.get(i));
        }
        return ultimasCuatroAgregadas;
        
    }
}
