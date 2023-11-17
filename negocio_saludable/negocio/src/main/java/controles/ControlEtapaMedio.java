/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Etapa;
import implementaciones.EtapaMedioDAO;
import implementaciones.MedioDAO;
import interfaces.IEtapaMedioDAO;
import interfaces.IMedioDAO;
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
            System.out.println("Listo");
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
