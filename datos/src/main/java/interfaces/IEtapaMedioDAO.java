/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Etapa;
import entidades.EtapaMedio;
import entidades.Medio;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public interface IEtapaMedioDAO {
    public boolean agregarEtapaMedio(Etapa etapa, int medio, double volumen);
    public List<EtapaMedio> consultarTodos();
}
