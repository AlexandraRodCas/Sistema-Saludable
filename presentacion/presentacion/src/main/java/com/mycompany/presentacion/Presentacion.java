package com.mycompany.presentacion;

import Frames.FrmAcentos;

/**
 *
 * @author gabri
 */
public class Presentacion {

    public static void main(String[] args) {
        FrmAcentos menu = new FrmAcentos(5, 10, 5, 4, 1);
        menu.setVisible(true);
    }
}
