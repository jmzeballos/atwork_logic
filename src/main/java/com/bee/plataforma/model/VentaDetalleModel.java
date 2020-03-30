/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.model;

/**
 *
 * @author Lealva
 */
public class VentaDetalleModel {
    private int id_venta;
    private int producto_id;
    private int cantidad;
    private double precio_venta;
    private double total;
    private int modalidad_id;
    private int orden;

    public VentaDetalleModel() {
    }

    public void setModalidad_id(int modalidad_id) {
        this.modalidad_id = modalidad_id;
    }

    public int getModalidad_id() {
        return modalidad_id;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
    
}
