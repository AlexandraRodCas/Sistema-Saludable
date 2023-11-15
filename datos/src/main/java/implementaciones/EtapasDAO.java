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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author velas
 */
public class EtapasDAO implements IEtapasDAO{

    private IConexion conexion;
    
    public EtapasDAO(IConexion conexion)
    {
        this.conexion=conexion;
    }
    public EtapasDAO() {
        
    }

    @Override
    public boolean agregarEtapa(Date inicio, Date fin, int semanas, String tipo, int id_mesociclo) {
        try
        {
            Connection conexion = this.conexion.crearConexion();
            Etapa etapa = new Etapa(inicio, fin, semanas, tipo, id_mesociclo);
            Statement comandoSQL = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO etapa (inicio,fin,semanas,tipo, id_plan)"
                    + " VALUES ('%s','%s','%s','%s','%s');",
                    etapa.getInicio(),etapa.getFin(), 
                    etapa.getSemanas(), etapa.getTipo(), etapa.getId_mesociclo());
            int numeroRegistrosModificados = comandoSQL.executeUpdate(codigoSQL); // Sirve para realizar modificaciones en la tabla (INSERT, DELETE, UPDATE)
            
            conexion.close(); //Cerrar conexion
            return numeroRegistrosModificados==1;
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return false;
        }
    }

    
    
}
