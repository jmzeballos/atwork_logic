/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.fe.model;

/**
 *
 * @author desarrollo.web
 */
public class boletaModel {
    private int id;
    private String serie;
    private String ventanrodoc;
    private int producto_id;
    private String producto_nombre;
    private int venta_cantidad;
    private double total_vendido;
    private double precio_total_no_igv;
    private double igv_total;
    private double precio_venta;
    private double precio_base_no_igv;
    private double igv_base;
    private double venta_total;
    private int orden;
    private String prod_cod_interno;
    private String fechareg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getVentanrodoc() {
        return ventanrodoc;
    }

    public void setVentanrodoc(String ventanrodoc) {
        this.ventanrodoc = ventanrodoc;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public int getVenta_cantidad() {
        return venta_cantidad;
    }

    public void setVenta_cantidad(int venta_cantidad) {
        this.venta_cantidad = venta_cantidad;
    }

    public double getTotal_vendido() {
        return total_vendido;
    }

    public void setTotal_vendido(double total_vendido) {
        this.total_vendido = total_vendido;
    }

    public double getPrecio_total_no_igv() {
        return precio_total_no_igv;
    }

    public void setPrecio_total_no_igv(double precio_total_no_igv) {
        this.precio_total_no_igv = precio_total_no_igv;
    }

    public double getIgv_total() {
        return igv_total;
    }

    public void setIgv_total(double igv_total) {
        this.igv_total = igv_total;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_base_no_igv() {
        return precio_base_no_igv;
    }

    public void setPrecio_base_no_igv(double precio_base_no_igv) {
        this.precio_base_no_igv = precio_base_no_igv;
    }

    public double getIgv_base() {
        return igv_base;
    }

    public void setIgv_base(double igv_base) {
        this.igv_base = igv_base;
    }

    public double getVenta_total() {
        return venta_total;
    }

    public void setVenta_total(double venta_total) {
        this.venta_total = venta_total;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getProd_cod_interno() {
        return prod_cod_interno;
    }

    public void setProd_cod_interno(String prod_cod_interno) {
        this.prod_cod_interno = prod_cod_interno;
    }

    public String getFechareg() {
        return fechareg;
    }

    public void setFechareg(String fechareg) {
        this.fechareg = fechareg;
    }

    
    
}
