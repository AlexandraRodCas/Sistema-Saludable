package interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public interface IConexion {
    public EntityManager crearConexion() throws Exception;
}
