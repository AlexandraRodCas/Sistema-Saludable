/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.EtapaMedio;
import entidades.Medio;
import entidades.Microciclo;
import implementaciones.MicrocicloDAO;
import interfaces.IMicrocicloDAO;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class ControlMicroMedio {
    IMicrocicloDAO microcicloDAO = new MicrocicloDAO();
    ControlEtapaMedio controlEtapaMedio = new ControlEtapaMedio();
    
    public ControlMicroMedio(){
        
    }
    
    public List<Microciclo> consultarUltimosMicrosAgregados(int microsCantidad){
        List<Microciclo> listaMicrosAgregados = microcicloDAO.consultarMicrociclos();

        // Obtener el rango correcto
        int totalMicros = listaMicrosAgregados.size();
        int indiceInicio = Math.max(totalMicros - microsCantidad, 0); 

        List<Microciclo> ultimasCuatroAgregadas = new ArrayList<>();
        for (int i = indiceInicio; i < totalMicros; i++) {
            ultimasCuatroAgregadas.add(listaMicrosAgregados.get(i));
        }
        return ultimasCuatroAgregadas;
        
    }
    
    public List<Microciclo> filtrarMicros(List<Microciclo> listMicrociclos, int noMesociclo){
        List<Microciclo> microciclosFiltrados = new ArrayList<>();

        for (Microciclo microciclo : listMicrociclos) {
            if (microciclo.getNoMesociclo() == noMesociclo) {
                microciclosFiltrados.add(microciclo);
            }
        }

        return microciclosFiltrados;
    }
    
    public String consultarCiclicidad(List<Microciclo> listMicrociclos, int noMesociclo){
        List<Microciclo> microciclosFiltrados = filtrarMicros(listMicrociclos, noMesociclo);
        
        return microciclosFiltrados.get(0).getCiclicidad();
    }
    
    public Date consultarInicioMeso(List<Microciclo> listMicrociclos, int noMesociclo){
        List<Microciclo> microciclosFiltrados = filtrarMicros(listMicrociclos, noMesociclo);
        
        return microciclosFiltrados.get(0).getInicio();
    }
    
    public int consultarIdEtapa(List<Microciclo> listMicrociclos, int noMesociclo){
        List<Microciclo> microciclosFiltrados = filtrarMicros(listMicrociclos, noMesociclo);
        return microciclosFiltrados.get(0).getEtapa().getId();
    }
    
    public Date consultarFinMeso(List<Microciclo> listMicrociclos, int noMesociclo){
        List<Microciclo> microciclosFiltrados = filtrarMicros(listMicrociclos, noMesociclo);
        
        return microciclosFiltrados.get(microciclosFiltrados.size()-1).getFin();
    }
    
    public List<String> consultarMedios(int idEtapa){
        List<EtapaMedio> listaEtapaMedios = controlEtapaMedio.consultarTodosCoincidentes(idEtapa);
        ControlMedio controlMedio = new ControlMedio();
        List<String> nombresMedios = new ArrayList<>();
         
        for (EtapaMedio etapaMedio : listaEtapaMedios) {
            Medio medio = controlMedio.consultarMedioPorId(etapaMedio.getMedio().getId());
            if (medio != null) {
                nombresMedios.add(medio.getNombre());
            }
        }
    
        return nombresMedios;
    }
    
    public double consultaVolumenMedio(String medio, int idEtapa){
        List<EtapaMedio> listaEtapaMedios = controlEtapaMedio.consultarTodosCoincidentes(idEtapa);
         
        for (EtapaMedio etapaMedio : listaEtapaMedios) {
            if(etapaMedio.getEtapa().getId() == idEtapa){
                if(etapaMedio.getMedio().getNombre().equals(medio)){
                    return etapaMedio.getVolumen();
                }
            }
            
        }
        return 0;
    }
    
    public List<Integer> consultarPorcentaje(int noColumnas){
        List<Integer> listaPorcentajes = new ArrayList<>();

        if (noColumnas == 2) {
            listaPorcentajes.add(60);
            listaPorcentajes.add(40);
        } else if (noColumnas == 3) {
            listaPorcentajes.add(25);
            listaPorcentajes.add(45);
            listaPorcentajes.add(30);
        } else if (noColumnas == 4) {
            listaPorcentajes.add(15);
            listaPorcentajes.add(28);
            listaPorcentajes.add(35);
            listaPorcentajes.add(22);
        } else if (noColumnas == 5) {
            listaPorcentajes.add(12);
            listaPorcentajes.add(20);
            listaPorcentajes.add(24);
            listaPorcentajes.add(29);
            listaPorcentajes.add(17);
        } else if (noColumnas == 6) {
            listaPorcentajes.add(12);
            listaPorcentajes.add(15);
            listaPorcentajes.add(17);
            listaPorcentajes.add(20);
            listaPorcentajes.add(22);
            listaPorcentajes.add(14);
        }

        return listaPorcentajes;
    }
    
    public void guardarMicroMedio(){
        
    }
}
