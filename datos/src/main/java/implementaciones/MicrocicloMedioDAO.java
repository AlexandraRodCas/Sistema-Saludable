/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Medio;
import entidades.Microciclo;
import entidades.MicrocicloMedio;
import interfaces.IConexion;
import interfaces.IMicrocicloMedioDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */


public class MicrocicloMedioDAO implements IMicrocicloMedioDAO {

    private IConexion conexion = new Conexion();

    public MicrocicloMedioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public MicrocicloMedioDAO() {
    }

    @Override
    public boolean agregarMicrocicloMedio(MicrocicloMedio microcicloMedio) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO microciclo_medio (microciclo_id, medio_id, volumen) VALUES (?, ?, ?)");
            statement.setInt(1, microcicloMedio.getMicrociclo().getId());
            statement.setInt(2, microcicloMedio.getMedio().getId());
            statement.setFloat(3, microcicloMedio.getVolumen());
            int numeroRegistrosModificados = statement.executeUpdate();

            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<MicrocicloMedio> consultarMicrocicloMedios() {
        List<MicrocicloMedio> microciclosMedios = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM microciclo_medio");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                int microcicloId = resultados.getInt("microciclo_id");
                int medioId = resultados.getInt("medio_id");
                float volumen = resultados.getFloat("volumen");

                MicrocicloDAO microcicloDAO = new MicrocicloDAO();
                Microciclo microciclo = microcicloDAO.consultarMicrocicloId(microcicloId);

                MedioDAO medioDAO = new MedioDAO();
                Medio medio = medioDAO.consultarMedioId(medioId);

                MicrocicloMedio microcicloMedio = new MicrocicloMedio(microciclo, medio, volumen);
                microciclosMedios.add(microcicloMedio);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return microciclosMedios;
    }
}

