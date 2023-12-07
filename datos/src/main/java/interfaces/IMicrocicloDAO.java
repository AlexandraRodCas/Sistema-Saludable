/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Microciclo;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IMicrocicloDAO {
    public boolean agregarMicrociclo(Microciclo microciclo);
    public List<Microciclo> consultarMicrociclos();
    public Microciclo consultarMicrocicloId(int id);
}
