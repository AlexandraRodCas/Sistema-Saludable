/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Medio;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IMedioDAO {
    public boolean agregarMedio(String nombre);
    public List<Medio> consultarMedios();
}
