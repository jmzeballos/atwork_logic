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
public class EmpresaModel {

    private int empresa_id;
    private String nombre;
    private String empresa_logo;
    private int estado;

    public EmpresaModel() {
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa_logo() {
        return empresa_logo;
    }

    public void setEmpresa_logo(String empresa_logo) {
        this.empresa_logo = empresa_logo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
