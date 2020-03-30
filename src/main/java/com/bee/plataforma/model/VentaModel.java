/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.model;

import java.util.ArrayList;

/**
 *
 * @author Lealva
 */
public class VentaModel {

    private int venta_id;
    private int cliente_id;
    private String serie;
    private String correlativo;
    private float total_venta;
    private ArrayList<VentaDetalleModel> listaVentaDetalle;
    /*para respuesta */
    private int respuesta;
    private String fecha;
    private String jsonFE;
    private String jsonCodigo;
    private String cadenacodigo;

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public float getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(float total_venta) {
        this.total_venta = total_venta;
    }

    public ArrayList<VentaDetalleModel> getListaVentaDetalle() {
        return listaVentaDetalle;
    }

    public void setListaVentaDetalle(ArrayList<VentaDetalleModel> listaVentaDetalle) {
        this.listaVentaDetalle = listaVentaDetalle;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getJsonFE() {
        return jsonFE;
    }

    public void setJsonFE(String jsonFE) {
        this.jsonFE = jsonFE;
    }

    public String getJsonCodigo() {
        return jsonCodigo;
    }

    public void setJsonCodigo(String jsonCodigo) {
        this.jsonCodigo = jsonCodigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCadenacodigo() {
        return cadenacodigo;
    }

    public void setCadenacodigo(String cadenacodigo) {
        this.cadenacodigo = cadenacodigo;
    }
    

}
