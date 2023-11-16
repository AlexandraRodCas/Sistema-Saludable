/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Deporte;
import implementaciones.DeportesDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class ControlDeporte {
    DeportesDAO deportesDAO = new DeportesDAO();
    
    public ControlDeporte() {
    }
    
    public List<Deporte> consultarDeportes(){
        List<Deporte> deportes = deportesDAO.consultarDeportes();
        return deportes;
    }
    
    public DefaultComboBoxModel<String> convertComboBoxModel(List<Deporte> deportes){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        if(deportes.isEmpty()){
            return comboBoxModel = null;
        }else{
            
            for (int i = 0; i<deportes.size(); i++) {
                comboBoxModel.addElement(deportes.get(i).getNombre());
            }
            return comboBoxModel;
        }
    }
}
