/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Microciclo;
import implementaciones.MicrocicloDAO;
import interfaces.IMicrocicloDAO;
import controles.ControlPlan;
import entidades.Etapa;
import entidades.Plan;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class ControlCiclicidad {
    IMicrocicloDAO microcicloDAO = new MicrocicloDAO();
    ControlPlan controlPlan = new ControlPlan();
    ControlEtapa controlEtapa = new ControlEtapa();
    
    Plan plan = new Plan();
    int contador = 0;
    
    public ControlCiclicidad(){
        
    }
    
    public Date fechaInicial(){
        plan = controlPlan.consultarUltimoPlanAgregado();
        return plan.getInicio();
    }
    
    public List<Etapa> consultaEtapas(){
        List<Etapa> listaEtapasAgregadas = controlEtapa.consultarUltimasEtapasAgregada();
        return listaEtapasAgregadas;
    }
    
    public void agregarMicrociclo(int cantidad, String ciclicidad, int mesociclo, String etapa){
        Date inicio = new Date(2023 - 1900, 11, 7 );
        Date fin = new Date(2023 - 1900, 11, 7 );
        Microciclo micro = consultarUltimoMicroAgregado();
            if(micro == null){
                inicio = fechaInicial();
                fin = new Date(inicio.getTime());
            }else{
                inicio = new Date(micro.getFin().getTime());
                fin = new Date(inicio.getTime());
            }
            fin.setDate(inicio.getDate() + 7);
            
            Etapa etapaEncontrada = null;
            List<Etapa> listaEtapas = consultaEtapas();
            for (Etapa etapaActual : listaEtapas) {
                if (etapaActual.getTipo().equals(etapa)) {
                    etapaEncontrada = etapaActual;
                    break;
                }
            }
            
            Microciclo microciclo = new Microciclo(ciclicidad, mesociclo, inicio, fin, etapaEncontrada);
            microcicloDAO.agregarMicrociclo(microciclo);
            
    }
    public Microciclo consultarUltimoMicroAgregado(){
        List<Microciclo> listaMicrociclos = microcicloDAO.consultarMicrociclos();
        if(listaMicrociclos.size() == 0){
            return null;
        }else{
            return listaMicrociclos.get(listaMicrociclos.size()-1);
        }
    }
    
}
