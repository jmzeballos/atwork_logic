/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.dao;

import com.bee.fe.model.boletaModel;
import com.bee.plataforma.model.VentaModel;
import java.util.List;

/**
 *
 * @author Lealva
 */
public interface ventaDao {

    public VentaModel guardarVenta(VentaModel venta) throws Exception;

    public VentaModel actualizarVenta(VentaModel venta) throws Exception;

    public int limpiarVenta(VentaModel venta) throws Exception;

    public int generarCorrelativo(int venta_id);

    public int guardarJson(int venta_id, String jsonVentaFe, String jsonCodigoCanje);

    public List<boletaModel> obtenerDatosBoleta(int codigoVenta);
}
