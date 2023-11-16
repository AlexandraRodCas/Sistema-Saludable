/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Jefe;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IJefeDAO {
    public boolean agregarJefe(String nombre);
    public List<Jefe> consultarJefes();
}
