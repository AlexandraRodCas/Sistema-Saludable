/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Etapa;
import interfaces.IConexion;
import interfaces.IEtapasDAO;
import java.sql.Connection;
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
    public boolean agregarEtapa(Etapa etapa) {
        try
        {
            Connection conexion = this.conexion.crearConexion();
            
            Statement comandoSQL = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO etapa (inicio,fin,semanas,tipo)"
                    + " VALUES ('%s','%s','%s','%s');",
                    etapa.getInicio(),etapa.getFin(), 
                    etapa.getSemanas(), etapa.getTipo());
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
