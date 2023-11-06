package implementaciones;

import interfaces.IConexion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gabri
 */
public class Conexion implements IConexion {

    @Override
    public EntityManager crearConexion() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datosPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    /**
     *
     * @Override public EntityManager crearConexion() throws Exception {
     * EntityManagerFactory emf =
     * Persistence.createEntityManagerFactory("datosPU"); EntityManager em =
     * emf.createEntityManager(); return em; }
     */
}
