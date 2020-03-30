/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.serviceImpl;

import com.bee.plataforma.dao.ventaDao;
import com.bee.plataforma.model.VentaModel;
import com.bee.plataforma.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lealva
 */
@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private ventaDao venDao;
    
    @Override
    public VentaModel guardarVenta(VentaModel venta) throws Exception {
       return venDao.guardarVenta(venta);
    }

    @Override
    public VentaModel actualizarVenta(VentaModel venta) throws Exception {
      return venDao.actualizarVenta(venta);
    }
    
}
