/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Medio;
import implementaciones.MedioDAO;
import interfaces.IMedioDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class ControlMedio {
     IMedioDAO medioDAO = new MedioDAO();
    
    public List<Medio> consultarRamas(){
        List<Medio> ramas = medioDAO.consultarMedios();
        return ramas;
    }
    
    public DefaultComboBoxModel<String> convertComboBoxModel(List<Medio> medios){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        if(medios.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay medios agregados", "Error", JOptionPane.ERROR_MESSAGE);
            return comboBoxModel = null;
        }else{
            
            for (int i = 0; i<medios.size(); i++) {
                comboBoxModel.addElement(medios.get(i).toString());
            }
            return comboBoxModel;
        }
    }
    
    public Medio consultarMedioPorId(int id) {
        return medioDAO.consultarMedioId(id);
    }
}
