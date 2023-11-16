/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Plan;
import interfaces.IConexion;
import interfaces.IPlanDAO;
import java.sql.Connection;
import java.sql.Date;
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
public class PlanDAO implements IPlanDAO {

    private IConexion conexion = new Conexion();

    public PlanDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public PlanDAO() {
    }

    @Override
    public boolean agregarPlan(Date inicio, Date fin, int jefeId, int metodologoId, int deporteId, int ramaId) {
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO plan (inicio, fin, jefe_id, metodologo_id, deporte_id, rama_id) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setDate(1, inicio);
            statement.setDate(2, fin);
            statement.setInt(3, jefeId);
            statement.setInt(4, metodologoId);
            statement.setInt(5, deporteId);
            statement.setInt(6, ramaId);
            int numeroRegistrosModificados = statement.executeUpdate();

            conexion.close();
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Plan> consultarPlanes() {
        List<Plan> planes = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM plan");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                Date inicio = resultados.getDate("inicio");
                Date fin = resultados.getDate("fin");
                int jefeId = resultados.getInt("jefe_id");
                int metodologoId = resultados.getInt("metodologo_id");
                int deporteId = resultados.getInt("deporte_id");
                int ramaId = resultados.getInt("rama_id");

                Plan plan = new Plan(id, inicio, fin, jefeId, metodologoId, deporteId, ramaId);
                planes.add(plan);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return planes;
    }
}
