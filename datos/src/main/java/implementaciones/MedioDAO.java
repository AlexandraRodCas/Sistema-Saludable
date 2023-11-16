/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Medio;
import interfaces.IConexion;
import interfaces.IMedioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class MedioDAO implements IMedioDAO {

    private IConexion conexion = new Conexion();

    public MedioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public MedioDAO() {
    }

    @Override
    public boolean agregarMedio(String nombre) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO medio (nombre) VALUES (?)");
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
    public List<Medio> consultarMedios() {
        List<Medio> medios = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM medio");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");

                Medio medio = new Medio(id, nombre);
                medios.add(medio);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return medios;
    }
}
