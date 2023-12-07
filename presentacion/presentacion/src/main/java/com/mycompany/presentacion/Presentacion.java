package com.mycompany.presentacion;

import Frames.FrmCiclicidad;

/**
 *
 * @author gabri
 */
public class Presentacion {

    public static void main(String[] args) {
        FrmCiclicidad menu = new FrmCiclicidad(5, 10, 5);
        menu.setVisible(true);
    }
}
