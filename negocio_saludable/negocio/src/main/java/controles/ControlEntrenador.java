/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Deporte;
import entidades.Usuario;
import implementaciones.UsuariosDAO;
import interfaces.IUsuariosDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class ControlEntrenador {
    IUsuariosDAO usuariosDAO = new UsuariosDAO();
    
    public List<Usuario> consultarDeportes(){
        List<Usuario> entrenadores = usuariosDAO.consultarUsuarios();
        return entrenadores;
    }
    
    public DefaultComboBoxModel<String> convertComboBoxModel(List<Usuario> entrenadores){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        if(entrenadores.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay entrenadores agregados", "Error", JOptionPane.ERROR_MESSAGE);
            return comboBoxModel = null;
        }else{
            
            for (int i = 0; i<entrenadores.size(); i++) {
                comboBoxModel.addElement(entrenadores.get(i).toString());
            }
            return comboBoxModel;
        }
    }
}
