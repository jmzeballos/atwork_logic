/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.service;

import com.bee.plataforma.model.ProductoModel;
import java.util.List;

/**
 *
 * @author Lealva
 */
public interface ProductoService {

    public List<ProductoModel> listarProducto(ProductoModel producto) throws Exception;
 
}
