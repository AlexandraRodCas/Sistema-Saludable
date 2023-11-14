package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public interface IConexion {
   // public EntityManager crearConexion() throws Exception;
    public Connection crearConexion() throws SQLException;
}
