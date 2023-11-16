/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Rama;
import implementaciones.RamasDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class ControlRama {
    RamasDAO ramasDAO = new RamasDAO();
    
    public ControlRama() {
    }
    
    public List<Rama> consultarRamas(){
        List<Rama> ramas = ramasDAO.consultarRamas();
        return ramas;
    }
    
    public DefaultComboBoxModel<String> convertComboBoxModel(List<Rama> ramas){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        if(ramas.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay ramas agregados", "Error", JOptionPane.ERROR_MESSAGE);
            return comboBoxModel = null;
        }else{
            
            for (int i = 0; i<ramas.size(); i++) {
                comboBoxModel.addElement(ramas.get(i).getNombre());
            }
            return comboBoxModel;
        }
    }
}
