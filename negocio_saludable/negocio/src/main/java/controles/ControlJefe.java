/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Jefe;
import implementaciones.JefeDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class ControlJefe {
    JefeDAO jefeDAO = new JefeDAO();
    
    public ControlJefe() {
    }
    
    public List<Jefe> consultarJefes(){
        List<Jefe> jefes = jefeDAO.consultarJefes();
        return jefes;
    }
    
    public DefaultComboBoxModel<String> convertComboBoxModel(List<Jefe> jefes){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        if(jefes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay jefes agregados", "Error", JOptionPane.ERROR_MESSAGE);
            return comboBoxModel = null;
        }else{
            
            for (int i = 0; i<jefes.size(); i++) {
                comboBoxModel.addElement(jefes.get(i).getNombre());
            }
            return comboBoxModel;
        }
    }
}
