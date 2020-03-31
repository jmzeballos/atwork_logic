/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.config;

import com.bee.plataforma.model.VentaDetalleModel;
import java.util.ArrayList;

/**
 *
 * @author Lealva
 */
public class Csv {
     public String generarCsv(ArrayList<VentaDetalleModel> detalleventa) {
        String csv = "";
        for (int i = 0; i < detalleventa.size(); i++) {
            csv += detalleventa.get(i).getProducto_id() + "¦";
            csv += detalleventa.get(i).getModalidad_id()+ "¦";
            csv += detalleventa.get(i).getCantidad() + "¦";
            csv += detalleventa.get(i).getPrecio_venta() + "¦";
            if (i == detalleventa.size() - 1) {
                csv += detalleventa.get(i).getTotal() ;
            } else {
                csv += detalleventa.get(i).getTotal()+ "¬";
            }
        }
        return csv;
    }
}
