/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.ProductoDao;
import com.bee.plataforma.model.ProductoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lealva
 */
@Repository
public class ProductoDaoImpl implements ProductoDao{
Logger logger = Logger.getLogger(ProductoDaoImpl.class);
    @Override
    public List<ProductoModel> listarProducto(ProductoModel producto) throws Exception{
      List<ProductoModel> listaProducto = new ArrayList<>();
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_producto_listar_x_param_v2("+producto.getZona_id()+","+producto.getTipo_id()+","+producto.getModalidad_id()+")";
            logger.error(query);
            ResultSet rs = cn.Query(query);
            System.out.println("Query: "+query);
            while (rs.next()) {
                ProductoModel productos = new ProductoModel();
                productos.setProducto_id(rs.getInt("out_idprod"));
                productos.setNombre(rs.getString("out_nom"));
                productos.setContenido(rs.getString("out_cont"));
                productos.setDescripcion(rs.getString("out_desc"));
                productos.setCategoria_id(rs.getInt("out_idcate"));
                productos.setModalidad_id(rs.getInt("out_moda"));
                productos.setPrecio_regular(rs.getDouble("out_precrf"));
                productos.setPrecio_venta(rs.getFloat("out_precv"));
                productos.setZona_id(rs.getInt("out_idzona"));
                productos.setTipo_id(rs.getInt("out_idtipo")); 
                productos.setUrl_imagen(rs.getString("out_url"));
                 listaProducto.add(productos);
            }            
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return listaProducto;
    }

    
}
