/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Etapa;
import entidades.EtapaMedio;
import implementaciones.EtapaMedioDAO;
import implementaciones.MedioDAO;
import interfaces.IEtapaMedioDAO;
import interfaces.IMedioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class ControlEtapaMedio {
    IEtapaMedioDAO etapaMedioDAO = new EtapaMedioDAO();
    ControlEtapa controlEtapa = new ControlEtapa();
    IMedioDAO medioDAO = new MedioDAO();
    
    public boolean agregarEtapaMedio(int medio, double volumen, String tipo){
        try{
            List<Etapa> listaEtapasAgregadas = controlEtapa.consultarUltimasEtapasAgregada();
            for(int i = 0; i<listaEtapasAgregadas.size(); i++){
                System.out.println(listaEtapasAgregadas.get(i).getTipo().equals(tipo));
                if(listaEtapasAgregadas.get(i).getTipo().equals(tipo)){
                    etapaMedioDAO.agregarEtapaMedio(listaEtapasAgregadas.get(i), medio, volumen);
                }
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public List<EtapaMedio> consultarTodosCoincidentes(int idEtapa){
        List<EtapaMedio> listaEtapasMedios = etapaMedioDAO.consultarTodos();
        List<EtapaMedio> listaEtapasMediosCoincidente = new ArrayList<>();
        for (EtapaMedio etapaMedio : listaEtapasMedios) {
            if (etapaMedio.getEtapa().getId() == idEtapa) {
                listaEtapasMediosCoincidente.add(etapaMedio);
            }
        }

        if(listaEtapasMediosCoincidente == null){
            return null;
        }else{
            return listaEtapasMediosCoincidente;
        }
    }
    
}
