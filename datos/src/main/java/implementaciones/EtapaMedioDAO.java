/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexion;
import interfaces.IEtapaMedioDAO;
import entidades.Etapa;
import entidades.Medio;
import interfaces.IConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alexandra
 */
public class EtapaMedioDAO implements IEtapaMedioDAO{
    private IConexion conexion = new Conexion();

    public EtapaMedioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public EtapaMedioDAO() {
    }

    @Override
    public boolean agregarEtapaMedio(Etapa etapa, Medio medio, double volumen) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO etapa_medio (etapa_id, medio_id, volumen) VALUES (?, ?, ?)");
            statement.setInt(1, etapa.getId());
            statement.setInt(2, medio.getId());
            statement.setInt(3, volumen);
            int numeroRegistrosModificados = statement.executeUpdate();

            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
