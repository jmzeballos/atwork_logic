/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.pdf.model;

import java.util.ArrayList;

/**
 *
 * @author Lealva
 */
public class ProductoCanjeModel {

    private int codigoProducto;
    private String nombreProducto;
    private int tipoProducto;
    private String modalidad;
    private int cantidad;
    private String contenido;
    private String complejos;
    private ArrayList<CodigoCanjeModel> listaCodigoCanje;

    public ProductoCanjeModel() {
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getComplejos() {
        return complejos;
    }

    public void setComplejos(String complejos) {
        this.complejos = complejos;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<CodigoCanjeModel> getListaCodigoCanje() {
        return listaCodigoCanje;
    }

    public void setListaCodigoCanje(ArrayList<CodigoCanjeModel> listaCodigoCanje) {
        this.listaCodigoCanje = listaCodigoCanje;
    }

}
