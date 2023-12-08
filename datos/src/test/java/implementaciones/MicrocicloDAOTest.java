/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementaciones;

import entidades.Etapa;
import entidades.Microciclo;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author velas
 */
public class MicrocicloDAOTest {

    public MicrocicloDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    //N
    

    /**
     * Test of agregarMicrociclo method, of class MicrocicloDAO.
     */
    @Test
    public void testAgregarMicrociclo() {
        System.out.println("Test agregarMicrociclo");
        Microciclo microciclo = new Microciclo();
        Date date1 = new Date(2023, 12, 7);
        Date date2 = new Date(2024, 3, 7);
        microciclo.setInicio(date1);
        microciclo.setFin(date2);
        microciclo.setNoMesociclo(1);
        microciclo.setCiclicidad("10,3");
        Etapa etapa = new Etapa();
        etapa.setTipo("Especial");
        etapa.setInicio(date1);
        etapa.setFin(date2);
        etapa.setSemanas(13);
        microciclo.setEtapa(etapa);
        MicrocicloDAO instance = new MicrocicloDAO();
        boolean result = instance.agregarMicrociclo(microciclo);
        if (!result) {
            fail("No se pudo agregar el microciclo.");

        }
        assertNotNull(result);
    }

    /**
     * Test of consultarMicrociclos method, of class MicrocicloDAO.
     */
    @Test
    public void testConsultarMicrociclos() {
        System.out.println("Test consultarMicrociclos");
        MicrocicloDAO instance = new MicrocicloDAO();
        List<Microciclo> expResult = null;
        List<Microciclo> result = instance.consultarMicrociclos();
        if(result.isEmpty()){
            fail("No se pudo consultar los microciclos");
        }
    }

    /**
     * Test of consultarMicrocicloId method, of class MicrocicloDAO.
     */
    @Test
    public void testConsultarMicrocicloId() {
        System.out.println("Test consultarMicrocicloId");
        int id = 0;
        MicrocicloDAO instance = new MicrocicloDAO();
        Microciclo result = instance.consultarMicrocicloId(id);
        if(result.getId()!=id){
            fail("No se pudo consultar el microciclo.");
        }
        assertNotNull(result);
    }

}
