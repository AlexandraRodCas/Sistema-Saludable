/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Etapa;
import entidades.Microciclo;
import interfaces.IConexion;
import interfaces.IMicrocicloDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */

public class MicrocicloDAO implements IMicrocicloDAO {

    private IConexion conexion = new Conexion();

    public MicrocicloDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public MicrocicloDAO() {
    }

    @Override
    public boolean agregarMicrociclo(Microciclo microciclo) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO microciclos (ciclicidad, noMesociclo, inicio, fin, etapa_id) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, microciclo.getCiclicidad());
            statement.setInt(2, microciclo.getNoMesociclo());
            statement.setDate(3, new java.sql.Date(microciclo.getInicio().getTime()));
            statement.setDate(4, new java.sql.Date(microciclo.getFin().getTime()));
            statement.setInt(5, microciclo.getEtapa().getId());
            int numeroRegistrosModificados = statement.executeUpdate();

            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Microciclo> consultarMicrociclos() {
        List<Microciclo> microciclos = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM microciclos");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String ciclicidad = resultados.getString("ciclicidad");
                int noMesociclo = resultados.getInt("noMesociclo");
                Date inicio = resultados.getDate("inicio");
                Date fin = resultados.getDate("fin");
                int etapaId = resultados.getInt("etapa_id");

                // Aquí necesitarás lógica para obtener la instancia de Etapa asociada al ID de etapa
                EtapasDAO etapaDAO = new EtapasDAO();
                Etapa etapa = etapaDAO.consultarEtapaId(etapaId);

                Microciclo microciclo = new Microciclo(id, ciclicidad, noMesociclo, inicio, fin, etapa);
                microciclos.add(microciclo);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return microciclos;
    }
    
    @Override
    public Microciclo consultarMicrocicloId(int id) {
        Microciclo microciclo = null; // Valor predeterminado si no se encuentra el microciclo

        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM microciclos WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultados = statement.executeQuery();

            if (resultados.next()) {
                String ciclicidad = resultados.getString("ciclicidad");
                int noMesociclo = resultados.getInt("noMesociclo");
                Date inicio = resultados.getDate("inicio");
                Date fin = resultados.getDate("fin");

                // Aquí debes obtener la instancia de Etapa relacionada al microciclo por su ID
                EtapasDAO etapaDAO = new EtapasDAO();
                Etapa etapa = etapaDAO.consultarEtapaId(resultados.getInt("etapa_id"));

                microciclo = new Microciclo(id, ciclicidad, noMesociclo, inicio, fin, etapa);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return microciclo;
    }

    
}

