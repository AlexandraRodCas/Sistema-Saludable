/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IUsuariosDAO {
    public boolean agregarUsuario(String nombre, String contrasenia, String telefono, String tipo);
    public List<Usuario> consultarUsuarios();
}
