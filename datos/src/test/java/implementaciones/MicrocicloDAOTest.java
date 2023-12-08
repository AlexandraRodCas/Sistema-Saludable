package implementaciones;

import entidades.Etapa;
import entidades.Microciclo;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba Unitaria HU7
 *
 * @author Gabriel
 */
public class MicrocicloDAOTest {

    public MicrocicloDAOTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of agregarMicrociclo method, of class MicrocicloDAO.
     */
    @org.junit.jupiter.api.Test
    public void testAgregarMicrociclo() {
        System.out.println("agregarMicrociclo");
        Microciclo microciclo = new Microciclo();
        EtapasDAO dao = new EtapasDAO();
        Etapa etapa = dao.consultarEtapaId(0);

        microciclo.setId(0);
        microciclo.setCiclicidad("4,1");
        microciclo.setInicio(new Date());
        microciclo.setFin(new Date());
        microciclo.setNoMesociclo(1);
        microciclo.setEtapa(etapa);
        System.out.println("etapa: " + etapa.toString());
        
        MicrocicloDAO instance = new MicrocicloDAO();
        Object result = instance.agregarMicrociclo(microciclo);
        if (result == null) {
            fail("Error al guardar el microciclo");
        }
        assertNotNull(result);
    }

    /**
     * Test of consultarMicrociclos method, of class MicrocicloDAO.
     */
//    @org.junit.jupiter.api.Test
//    public void testConsultarMicrociclos() {
//        System.out.println("consultarMicrociclos");
//        MicrocicloDAO instance = new MicrocicloDAO();
//        List<Microciclo> expResult = null;
//        List<Microciclo> result = instance.consultarMicrociclos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of consultarMicrocicloId method, of class MicrocicloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testConsultarMicrocicloId() {
//        System.out.println("consultarMicrocicloId");
//        int id = 463;
//        MicrocicloDAO instance = new MicrocicloDAO();
//        Microciclo expResult = instance.consultarMicrocicloId(id);;
//        Microciclo result = instance.consultarMicrocicloId(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
