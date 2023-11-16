/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Metodologo;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IMetodologosDAO {
    public boolean agregarMetodologo(String nombre);
    public List<Metodologo> consultarMetodologos();
}
