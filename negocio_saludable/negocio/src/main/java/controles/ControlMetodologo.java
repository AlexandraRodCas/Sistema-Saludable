/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Metodologo;
import implementaciones.MetodologosDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class ControlMetodologo {
    MetodologosDAO metodologosDAO = new MetodologosDAO();
    
    public ControlMetodologo() {
    }
    
    public List<Metodologo> consultarMetodologos(){
        List<Metodologo> metodologos = metodologosDAO.consultarMetodologos();
        return metodologos;
    }
    
    public DefaultComboBoxModel<String> convertComboBoxModel(List<Metodologo> metodologos){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        if(metodologos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay metodologos agregados", "Error", JOptionPane.ERROR_MESSAGE);
            return comboBoxModel = null;
        }else{
            
            for (int i = 0; i<metodologos.size(); i++) {
                comboBoxModel.addElement(metodologos.get(i).getNombre());
            }
            return comboBoxModel;
        }
    }
}
