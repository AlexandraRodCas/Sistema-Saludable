/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import entidades.Metodologo;
import interfaces.IConexion;
import interfaces.IMetodologosDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class MetodologosDAO implements IMetodologosDAO {

    private IConexion conexion = new Conexion();

    public MetodologosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public MetodologosDAO() {
    }

    @Override
    public boolean agregarMetodologo(String nombre) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO metodologo (nombre) VALUES (?)");
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
    public List<Metodologo> consultarMetodologos() {
        List<Metodologo> metodologos = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM metodologo");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");

                Metodologo metodologo = new Metodologo(id, nombre);
                metodologos.add(metodologo);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return metodologos;
    }
}

