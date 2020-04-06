/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.fe.util;

import com.bee.fe.model.boletaModel;
import com.bee.fe.model.lDetalleDocVentaBean;
import com.bee.fe.model.lImpuestoBean;
import com.bee.fe.model.lNotaBean;
import com.bee.fe.model.oAdquirienteBean;
import com.bee.fe.model.oEmisorBean;
import com.bee.fe.model.oProductoBean;
import com.bee.fe.model.parametrosAdicionalesReporteBean;
import com.bee.plataforma.daoImpl.UsuarioDaoImpl;
import com.bee.plataforma.daoImpl.VentaDaoImpl;
import com.bee.plataforma.model.UsuarioModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 *
 * @author Lealva
 */
public class GenerarJsonFe {
    public String[] generarJsonFe(int codigoPersona, int codigoVenta) {
        String nombrearchivo = "";
        String jsonOutput[] = new String[2];
        try {
            UsuarioModel perMod = null;
            List<boletaModel> bolMod = null;
            boletaModel bolModelo = null;

            Map<String, Object> datosEnv = new HashMap();

            oEmisorBean oEmisor = new oEmisorBean();
            oAdquirienteBean oAdquiriente = new oAdquirienteBean();

            //Data HARDCODE
            oEmisor.setCodigoEstablecimientoAnexo("0000");
            oEmisor.setCodigoTipoDocumentoIdentidad("6");
            oEmisor.setNumeroDocumentoIdentidad("20605636889");
            oEmisor.setApellidosNombresDenominacionRazonSocial("PRIZE PROMOTION S.A.C.");
            oEmisor.setNombreComercial("PRIZE");
            oEmisor.setCodigoUbicacionGeografica("150120");
            oEmisor.setDepartamento("LIMA");
            oEmisor.setProvincia("LIMA");
            oEmisor.setDistrito("MAGDALENA DEL MAR");
            oEmisor.setCodigoPais("PE");
            oEmisor.setDireccion("AV. ANTONIO MIROQUESADA 427 - Ofc 511 ( EX AV. JUÁN DE ALIAGA ) MAGDALENA DEL MAR - LIMA");
            oEmisor.setUrbanizacion("MAGDALENA DEL MAR");

            datosEnv.put("oEmisor", oEmisor);
            UsuarioModel usu = new UsuarioModel();
            usu.setUsuario_id(codigoPersona);
            perMod = new UsuarioDaoImpl().usuarioperfil(usu);
            oAdquiriente.setCodigoTipoDocumentoIdentidad("1"); //TIPO DNI
            oAdquiriente.setNumeroDocumentoIdentidad(perMod.getDni());
            oAdquiriente.setDescripcionTipoDocumentoIdentidad("DNI"); //DESCRIPCION DNI
            oAdquiriente.setApellidosNombresDenominacionRazonSocial(perMod.getNombre()+ " " + perMod.getApellido());
            oAdquiriente.setCodigoPais("PE");// NACIONALIDAD

            datosEnv.put("oAdquiriente", oAdquiriente);

           bolMod = new VentaDaoImpl().obtenerDatosBoleta(codigoVenta);

            ArrayList<lDetalleDocVentaBean> ArraylDetalleBoletaVenta = new ArrayList<>();
            for (boletaModel mod : bolMod) {

                //lDetalleBoletaVenta = new lDetalleDocVentaBean();
                lDetalleDocVentaBean lDetalleBoletaVenta = new lDetalleDocVentaBean();
                oProductoBean oProducto = new oProductoBean();
                oProducto.setCodigoUnidadMedida("NIU");
                oProducto.setCodigo(mod.getProd_cod_interno());
                oProducto.setDescripcion(mod.getProducto_nombre());
                oProducto.setCodigoSunat("10000000");
                lDetalleBoletaVenta.setoProducto(oProducto);

                //LISTA IMPUESTOS DE lDetalleBoletaVenta
                ArrayList<lImpuestoBean> ArraylImpuesto = new ArrayList<>();

                lImpuestoBean lImpuesto = new lImpuestoBean();
                lImpuesto.setCodigoTipoAfectacionIGV("10");
                lImpuesto.setMontoTotalMonedaOriginal(mod.getIgv_base());
                lImpuesto.setCodigoInternacional("VAT");
                lImpuesto.setMontoBaseMonedaOriginal(mod.getPrecio_base_no_igv());
                lImpuesto.setNombre("IGV");
                lImpuesto.setPorcentaje(18);
                lImpuesto.setCodigo("1000");
                ArraylImpuesto.add(lImpuesto);

                lDetalleBoletaVenta.setlImpuesto(ArraylImpuesto);

                lDetalleBoletaVenta.setMontoValorVentaUnitarioMonedaOriginal(mod.getPrecio_base_no_igv() / mod.getVenta_cantidad());
                lDetalleBoletaVenta.setMontoValorVentaTotalMonedaOriginal(mod.getPrecio_base_no_igv());
                lDetalleBoletaVenta.setMontoPrecioVentaUnitarioMonedaOriginal(mod.getPrecio_venta());
                lDetalleBoletaVenta.setMontoTotalMonedaOriginal(mod.getVenta_total());
                lDetalleBoletaVenta.setNumeroOrden(mod.getOrden());
                lDetalleBoletaVenta.setCantidad(mod.getVenta_cantidad());

                ArraylDetalleBoletaVenta.add(lDetalleBoletaVenta);
            }
            bolModelo = bolMod.get(0);

            datosEnv.put("lDetalleBoletaVenta", ArraylDetalleBoletaVenta);
            //EMPIEZA EL LLENADO DE IMPUESTO

            ArrayList<lImpuestoBean> ArraylImpuesto2 = new ArrayList<>();

            lImpuestoBean lImpuesto2 = new lImpuestoBean();
            lImpuesto2.setCodigoTipoAfectacionIGV("10");
            lImpuesto2.setMontoTotalMonedaOriginal(bolModelo.getIgv_total());
            lImpuesto2.setCodigoInternacional("VAT");
            lImpuesto2.setMontoBaseMonedaOriginal(bolModelo.getPrecio_total_no_igv());
            lImpuesto2.setNombre("IGV");
            lImpuesto2.setPorcentaje(18);
            lImpuesto2.setCodigo("1000");

            ArraylImpuesto2.add(lImpuesto2);
            datosEnv.put("lImpuesto", ArraylImpuesto2);

            ArrayList<lNotaBean> ArraylNota = new ArrayList<lNotaBean>();
            lNotaBean lNota = new lNotaBean();

            lNota.setCodigo("1000");
            //lNota.setDescripcion("CUARENTA Y NUEVE Y 00/100 SOLES.");
            lNota.setDescripcion(NumeroaLetra.convertir(String.valueOf(bolModelo.getTotal_vendido()), true));
            ArraylNota.add(lNota);

            datosEnv.put("lNota", ArraylNota);

            parametrosAdicionalesReporteBean parametrosAdicionalesReporte = new parametrosAdicionalesReporteBean();
            parametrosAdicionalesReporte.setTotalapagar(Double.toString(bolModelo.getTotal_vendido()));

            datosEnv.put("parametrosAdicionalesReporte", parametrosAdicionalesReporte);

            datosEnv.put("montoImpuestoMonedaOriginal", bolModelo.getIgv_total());
            datosEnv.put("codigoTipoDocumento", "03");//Boleta de venta
            datosEnv.put("codigoTipoOperacion", "0101");//Venta interna
            datosEnv.put("numeroCorrelativo", bolModelo.getVentanrodoc());
            datosEnv.put("montoTotalMonedaOriginal", bolModelo.getTotal_vendido());
            datosEnv.put("codigoTipoMoneda", "PEN");
            datosEnv.put("montoValorVentaMonedaOriginal", bolModelo.getPrecio_total_no_igv());
            datosEnv.put("fechaEmision", bolModelo.getFechareg().substring(0, 10) + "T00:00:00-05:00");
            datosEnv.put("horaEmision", bolModelo.getFechareg() + "-05:00");
            datosEnv.put("numeroSerie", bolModelo.getSerie());
            nombrearchivo = "20605636889-03-" + bolModelo.getSerie() + "-" + bolModelo.getVentanrodoc();
            Gson gson = new Gson();
            System.out.println("Cadena de respuesta " + gson.toJson(datosEnv));;
            jsonOutput[0] = gson.toJson(datosEnv);

            jsonOutput[1] = nombrearchivo;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GenerarJsonFe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonOutput;
    }
}
