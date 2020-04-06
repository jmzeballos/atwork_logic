/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.fe.model.boletaModel;
import com.bee.plataforma.config.Csv;
import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.ventaDao;
import com.bee.plataforma.model.VentaModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lealva
 */
@Repository
public class VentaDaoImpl implements ventaDao {

    Logger logger = Logger.getLogger(VentaDaoImpl.class);

    @Override
    public VentaModel guardarVenta(VentaModel venta) throws Exception {
        try {
            Csv csv = new Csv();
            conexion cn = new conexion();

            String detalle = venta.getListaVentaDetalle() != null ? csv.generarCsv(venta.getListaVentaDetalle()) : "";
            String query = "select * from sh_atworkpf.fn_registra_venta_v2(" + venta.getCliente_id() + "," + venta.getTotal_venta() + ",'" + detalle + "')";
            logger.error(query);

            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                venta.setVenta_id(rs.getInt("out_ventaid"));
                venta.setFecha(rs.getString("out_fechaven"));
                venta.setRespuesta(rs.getInt("out_resp"));
                venta.setCadenacodigo(rs.getString("out_codreser"));
                venta.setFechaActual(rs.getString("out_fecha"));

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return venta;
    }

    @Override
    public VentaModel actualizarVenta(VentaModel venta) throws Exception {
        try {
            Csv csv = new Csv();
            conexion cn = new conexion();
            venta.setRespuesta(4);
            String detalle = venta.getListaVentaDetalle() != null ? csv.generarCsv(venta.getListaVentaDetalle()) : "";
            String query = "select * from sh_atworkpf.fn_actualizar_venta_v3(" + venta.getVenta_id() + ",'" + detalle + "'," + venta.getTotal_venta() + ")";
            logger.error(query);

            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                venta.setVenta_id(rs.getInt("rs_idventa"));
                venta.setFecha(rs.getString("rs_fecha_venta"));
                venta.setRespuesta(rs.getInt("rs_resp"));
                venta.setCadenacodigo(rs.getString("rs_codreser"));
                venta.setFechaActual(rs.getString("rs_fecha_actual"));

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return venta;
    }

    @Override
    public int limpiarVenta(VentaModel venta) throws Exception {
        int respuesta = 3;
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_limpiar_v1(" + venta.getVenta_id() + ")";
            logger.error(query);
            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                respuesta = rs.getInt("resp");

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    @Override
    public int generarCorrelativo(int venta_id) {
        int respuesta =0;
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_genera_correlativoventa_v2(" + venta_id + ",1)";
            logger.error(query);
            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                respuesta = rs.getInt("corre");

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    @Override
    public int guardarJson(int venta_id, String jsonVentaFe, String jsonCodigoCanje) {
       int respuesta = 3;
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_confirmar_venta_v2(" + venta_id + ",'"+jsonVentaFe+"','"+jsonCodigoCanje+"')";
            logger.error(query);
            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
             respuesta= rs.getInt("resp");

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    @Override
    public List<boletaModel> obtenerDatosBoleta(int codigoVenta) {
        ResultSet res;
        String result;
        ArrayList<boletaModel> ListBolMod = new ArrayList<>();
        try {
            conexion cn = new conexion();
            result = "select * from sh_atworkpf.fn_boleta(" + codigoVenta + ")";
            res = cn.Query(result);
            while (res.next()) {
                boletaModel bolMod = new boletaModel();
                bolMod.setId(codigoVenta);
                bolMod.setSerie(res.getString("serie"));
                bolMod.setVentanrodoc(res.getString("ventanrodoc"));
                bolMod.setProducto_id(res.getInt("productoid"));
                bolMod.setProducto_nombre(res.getString("productonombre"));
                bolMod.setVenta_cantidad(res.getInt("ventacantidad"));
                bolMod.setTotal_vendido(res.getDouble("totalvendido"));
                bolMod.setPrecio_total_no_igv(res.getDouble("preciototal"));
                bolMod.setIgv_total(res.getDouble("igvtotal"));
                bolMod.setPrecio_venta(res.getDouble("precioventa"));
                bolMod.setPrecio_base_no_igv(res.getDouble("preciobase"));
                bolMod.setIgv_base(res.getDouble("igvbase"));
                bolMod.setVenta_total(res.getDouble("ventatotal"));
                bolMod.setOrden(res.getInt("ventaorden"));
                bolMod.setProd_cod_interno(res.getString("productocodigointerno"));
                bolMod.setFechareg(res.getString("fecharegi"));

                ListBolMod.add(bolMod);
            }
        } catch (Exception e) {
            logger.error("Persona : " + e.getMessage());
        }
        return ListBolMod;
    }

}
