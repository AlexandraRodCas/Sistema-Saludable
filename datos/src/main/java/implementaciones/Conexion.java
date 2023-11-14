package implementaciones;

import interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gabri
 */
public class Conexion implements IConexion {
/*
    @Override
    public EntityManager crearConexion() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datosPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }*/
    
    final String CADENA_CONEXION = "jdbc:mysql://localhost/sistema_saludable";
    final String USUARIO = "root";
    final String CONTRASENIA = "12345";
    
    @Override
    public Connection crearConexion() throws SQLException
    {
        //Se establece la conexion a MySQL con los paremetros indicados
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
        return conexion;
    }

    /**
     *
     * @Override public EntityManager crearConexion() throws Exception {
     * EntityManagerFactory emf =
     * Persistence.createEntityManagerFactory("datosPU"); EntityManager em =
     * emf.createEntityManager(); return em; }
     */
}
