/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Etapa;
import entidades.Medio;

/**
 *
 * @author Alexandra
 */
public interface IEtapaMedioDAO {
    public boolean agregarEtapaMedio(Etapa etapa, int medio, double volumen);
}
