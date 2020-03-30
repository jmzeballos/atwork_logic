/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.service;

import com.bee.plataforma.model.VentaModel;

/**
 *
 * @author Lealva
 */
public interface VentaService {

    public VentaModel guardarVenta(VentaModel venta) throws Exception;

    public VentaModel actualizarVenta(VentaModel venta) throws Exception;
}
