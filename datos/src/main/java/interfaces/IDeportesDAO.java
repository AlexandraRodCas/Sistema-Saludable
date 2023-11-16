/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Deporte;
import java.util.List;


/**
 *
 * @author Alexandra
 */
public interface IDeportesDAO {
    public boolean agregarDeporte(String nombre);
    public List<Deporte> consultarDeportes();
}
