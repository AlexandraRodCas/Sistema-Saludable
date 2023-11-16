/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Rama;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IRamasDAO {
    public boolean agregarRama(String nombre);
    public List<Rama> consultarRamas();
}
