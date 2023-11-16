/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Usuario;
import interfaces.IConexion;
import interfaces.IUsuariosDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class UsuariosDAO implements IUsuariosDAO{
    private IConexion conexion =  new Conexion();

    public UsuariosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public UsuariosDAO() {
    }

    @Override
    public boolean agregarUsuario(String nombre, String contrasenia, String telefono, String tipo) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO usuario (nombre, contrasenia, telefono, tipo) VALUES (?, ?, ?, ?)");
            statement.setString(1, nombre);
            statement.setString(2, contrasenia);
            statement.setString(3, telefono);
            statement.setString(4, tipo);

            int numeroRegistrosModificados = statement.executeUpdate();
            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM usuario");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");
                String contrasenia = resultados.getString("contrasenia");
                String telefono = resultados.getString("telefono");
                String tipo = resultados.getString("tipo");

                Usuario usuario = new Usuario(id, nombre, contrasenia, telefono, tipo);
                usuarios.add(usuario);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuarios;
    }
}
