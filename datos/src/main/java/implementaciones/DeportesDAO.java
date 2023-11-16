/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

/**
 *
 * @author Alexandra
 */
import entidades.Deporte;
import interfaces.IConexion;
import interfaces.IDeportesDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeportesDAO implements IDeportesDAO {

    private IConexion conexion = new Conexion();

    public DeportesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public DeportesDAO() {
    }

    @Override
    public boolean agregarDeporte(String nombre) {
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
    public List<Deporte> consultarDeportes() {
        List<Deporte> deportes = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM deporte");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");

                Deporte deporte = new Deporte(id, nombre);
                deportes.add(deporte);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return deportes;
    }
}
