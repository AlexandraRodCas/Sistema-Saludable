/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.MicrocicloMedio;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IMicrocicloMedioDAO {
    public boolean agregarMicrocicloMedio(MicrocicloMedio microcicloMedio);
    public List<MicrocicloMedio> consultarMicrocicloMedios();
}
