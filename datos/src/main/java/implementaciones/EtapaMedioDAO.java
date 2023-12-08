/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexion;
import interfaces.IEtapaMedioDAO;
import entidades.Etapa;
import entidades.EtapaMedio;
import entidades.Medio;
import interfaces.IConexion;
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
public class EtapaMedioDAO implements IEtapaMedioDAO{
    private IConexion conexion = new Conexion();

    public EtapaMedioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public EtapaMedioDAO() {
    }

    @Override
    public boolean agregarEtapaMedio(Etapa etapa, int medio, double volumen) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO etapa_medio (etapa_id_etapa, medio_id, volumen) VALUES (?, ?, ?)");
            statement.setInt(1, etapa.getId());
            statement.setInt(2, medio);
            statement.setDouble(3, volumen);
            int numeroRegistrosModificados = statement.executeUpdate();

            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public List<EtapaMedio> consultarTodos() {
        List<EtapaMedio> listaEtapaMedio = new ArrayList<>();

        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM etapa_medio");

            while (resultados.next()) {
                int etapaId = resultados.getInt("etapa_id_etapa");
                int medioId = resultados.getInt("medio_id");
                double volumen = resultados.getDouble("volumen");
                
                EtapasDAO etapaDAO = new EtapasDAO();
                Etapa etapa = etapaDAO.consultarEtapaId(etapaId);
                
                MedioDAO medioDAO = new MedioDAO();
                Medio medio = medioDAO.consultarMedioId(medioId);

                EtapaMedio etapaMedio = new EtapaMedio(etapa, medio, volumen);
                listaEtapaMedio.add(etapaMedio);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listaEtapaMedio;
    }
}
