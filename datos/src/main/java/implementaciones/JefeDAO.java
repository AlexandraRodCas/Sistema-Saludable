/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import entidades.Jefe;
import interfaces.IConexion;
import interfaces.IJefeDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class JefeDAO implements IJefeDAO{

    private IConexion conexion =  new Conexion();

    public JefeDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public JefeDAO() {
    }

    @Override
    public boolean agregarJefe(String nombre) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO deporte (nombre) VALUES (?)");
            statement.setString(1, nombre);
            int numeroRegistrosModificados = statement.executeUpdate();
            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Jefe> consultarJefes() {
        List<Jefe> jefes = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM jefe");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");

                Jefe jefe = new Jefe(id, nombre);
                jefes.add(jefe);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return jefes;
    }
}

