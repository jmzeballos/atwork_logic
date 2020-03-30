/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.Csv;
import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.ventaDao;
import com.bee.plataforma.model.VentaModel;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lealva
 */
@Repository
public class VentaDaoImpl implements ventaDao{
    Logger logger = Logger.getLogger(VentaDaoImpl.class);
    @Override
    public VentaModel guardarVenta(VentaModel venta) throws Exception {
        try {
            Csv csv = new Csv();
            conexion cn = new conexion();
            
            String detalle = venta.getListaVentaDetalle()!=null? csv.generarCsv(venta.getListaVentaDetalle()) :"";
            String query = "select * from sh_atworkpf.fn_registra_venta_1p("+venta.getCliente_id()+","+venta.getTotal_venta()+",'"+detalle+"')";
            logger.error(query);
            
            System.out.println("Query "+query);
            ResultSet rs = cn.Query(query);
         
            while (rs.next()) {
                venta.setVenta_id(rs.getInt("out_ventaid"));
                venta.setFecha(rs.getString("out_fecha"));
                venta.setRespuesta(rs.getInt("out_resp"));
                venta.setCadenacodigo(rs.getString("out_codreser")); 
                
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return venta;
    }

    @Override
    public VentaModel actualizarVenta(VentaModel venta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
