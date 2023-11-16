/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Rama;
import interfaces.IConexion;
import interfaces.IRamasDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class RamasDAO implements IRamasDAO {

    private IConexion conexion = new Conexion();

    public RamasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public RamasDAO() {
    }

    public boolean agregarRama(String nombre) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO rama (nombre) VALUES (?)");
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
    public List<Rama> consultarRamas() {
        List<Rama> ramas = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM rama");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");

                Rama rama = new Rama(id, nombre);
                ramas.add(rama);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return ramas;
    }
}

