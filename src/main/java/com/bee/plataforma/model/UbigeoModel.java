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
public class UbigeoModel {
    private String departamento_id;
    private String provincia_id;
    private String distrito_id;
    private String nombre;

    public UbigeoModel() {
    }

    public String getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(String departamento_id) {
        this.departamento_id = departamento_id;
    }

    public String getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(String provincia_id) {
        this.provincia_id = provincia_id;
    }

    public String getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(String distrito_id) {
        this.distrito_id = distrito_id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
