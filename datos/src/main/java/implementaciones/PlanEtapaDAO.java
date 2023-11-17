/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import entidades.Etapa;
import entidades.Plan;
import interfaces.IConexion;
import interfaces.IPlanEtapaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alexandra
 */
public class PlanEtapaDAO implements IPlanEtapaDAO {

    private IConexion conexion = new Conexion();

    public PlanEtapaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public PlanEtapaDAO() {
    }

    @Override
    public boolean agregarPlanEtapa(Plan plan, Etapa etapa) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO plan_etapa (plan_id, etapa_id) VALUES (?, ?)");
            statement.setInt(1, plan.getId());
            statement.setInt(2, etapa.getId());
            int numeroRegistrosModificados = statement.executeUpdate();

            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    
}