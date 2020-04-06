/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.fe.util;

import java.util.Arrays;

/**
 *
 * @author Lealva
 */
public class Prueba {
    public static void main(String[] args) {
        GenerarJsonFe json = new GenerarJsonFe();
        System.out.println("Cadena: \n"+Arrays.toString(json.generarJsonFe(128096, 29185)));
    }
}
