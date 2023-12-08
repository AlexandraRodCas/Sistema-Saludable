/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controles;

import entidades.Etapa;
import entidades.Microciclo;
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
public class ControlCiclicidadTest {
    
    public ControlCiclicidadTest() {
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

    /**
     * Test of fechaInicial method, of class ControlCiclicidad.
     */
    @Test
    public void testFechaInicial() {
        System.out.println("Test consultaEtapas");
        ControlCiclicidad instance = new ControlCiclicidad();
        List<Etapa> result = instance.consultaEtapas();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Test of consultaEtapas method, of class ControlCiclicidad.
     */
    @Test
    public void testConsultaEtapas() {
        System.out.println("Test consultaEtapas");
        ControlCiclicidad instance = new ControlCiclicidad();
        List<Etapa> result = instance.consultaEtapas();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Test of agregarMicrociclo method, of class ControlCiclicidad.
     */
    @Test
    public void testAgregarMicrociclo() {
        System.out.println("Test agregarMicrociclo: ");
        int cantidad = 1;
        String ciclicidad = "1,3";
        int mesociclo = 1; 
        String etapa = "Preparatoria";

        ControlCiclicidad instance = new ControlCiclicidad();
        instance.agregarMicrociclo(cantidad, ciclicidad, mesociclo, etapa);

        
        Microciclo lastMicrociclo = instance.consultarUltimoMicroAgregado();
        assertNotNull(lastMicrociclo);
        assertEquals(ciclicidad, lastMicrociclo.getCiclicidad());
        assertEquals(mesociclo, lastMicrociclo.getNoMesociclo());
        assertEquals(etapa, lastMicrociclo.getEtapa().getTipo());
    }

    /**
     * Test of consultarUltimoMicroAgregado method, of class ControlCiclicidad.
     */
    @Test
    public void testConsultarUltimoMicroAgregado() {
        System.out.println("Test consultarUltimoMicroAgregado");
        ControlCiclicidad instance = new ControlCiclicidad();
        Microciclo result = instance.consultarUltimoMicroAgregado();
        assertNull(result); 
    }
    
}
