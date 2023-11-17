/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Etapa;
import entidades.Tipo;
import interfaces.IConexion;
import interfaces.IEtapasDAO;
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
 * @author velas
 */
public class EtapasDAO implements IEtapasDAO{

    private IConexion conexion = new Conexion();
    
    public EtapasDAO(IConexion conexion)
    {
        this.conexion=conexion;
    }
    public EtapasDAO() {
        
    }

    @Override
    public boolean agregarEtapa(Date inicio, Date fin, int semanas, String tipo) {
        try {
            Connection conexion = this.conexion.crearConexion();
            Etapa etapa = new Etapa(inicio, fin, semanas, tipo);
            String codigoSQL = "INSERT INTO etapa (inicio, fin, semanas, tipo)"
                             + " VALUES (?, ?, ?, ?)";
            PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);

            // Establecer los valores de los parámetros
            comandoSQL.setDate(1, new java.sql.Date(etapa.getInicio().getTime()));
            comandoSQL.setDate(2, new java.sql.Date(etapa.getFin().getTime()));
            comandoSQL.setInt(3, etapa.getSemanas());
            comandoSQL.setString(4, etapa.getTipo());

            int numeroRegistrosModificados = comandoSQL.executeUpdate(); // Ejecutar la inserción

            conexion.close(); // Cerrar conexión
            return numeroRegistrosModificados == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public List<Etapa> consultarEtapas() {
        List<Etapa> etapas = new ArrayList<>();
        try {
            Connection conexion = this.conexion.crearConexion();
            Statement comandoSQL = conexion.createStatement();
            String codigoSQL = "SELECT * FROM etapa";
            ResultSet resultados = comandoSQL.executeQuery(codigoSQL); 

            while (resultados.next()) {
                int id = resultados.getInt("id");
                Date inicio = resultados.getDate("inicio");
                Date fin = resultados.getDate("fin");
                int semanas = resultados.getInt("semanas");
                String tipo = resultados.getString("tipo");

                Etapa etapa = new Etapa(id, inicio, fin, semanas, tipo);
                etapas.add(etapa);
            }

            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return etapas;
    }

    
    
}
