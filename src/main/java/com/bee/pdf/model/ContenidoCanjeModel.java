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
public class ContenidoCanjeModel {

    private int codigoventa;
    private String nombreNegocio;
    private String nombreEmpresa;
    private String correoenvio;
    private int codigoPersona;
    private String fechaventa;
    private String nombrecliente;

    private ArrayList<ProductoCanjeModel> listProductoCanje;

    public ContenidoCanjeModel() {
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getCorreoenvio() {
        return correoenvio;
    }

    public void setCorreoenvio(String correoenvio) {
        this.correoenvio = correoenvio;
    }

    public int getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public ArrayList<ProductoCanjeModel> getListProductoCanje() {
        return listProductoCanje;
    }

    public void setListProductoCanje(ArrayList<ProductoCanjeModel> listProductoCanje) {
        this.listProductoCanje = listProductoCanje;
    }

   

}
