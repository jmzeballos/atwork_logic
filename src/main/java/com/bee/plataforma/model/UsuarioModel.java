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
public class UsuarioModel {
   private int usuario_id;
   private String correo;
   private String nombre;
   private String apellido;
   private String dni;
   private int estado;
   private int empresa_id;
   private String usuario;
   private String password;
   
   private String passwordEmpresa;
   /*Para realizar venta*/
   private int venta_id;
   private int codigo_disponible;   
   private String logo_empresa;
   private String detalle_venta;
   /*Para validar respuesta de la base de datos*/
   private int respuesta;
   private String contenido;
 

    public UsuarioModel() {
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

  

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }

    public int getCodigo_disponible() {
        return codigo_disponible;
    }

    public void setCodigo_disponible(int codigo_disponible) {
        this.codigo_disponible = codigo_disponible;
    }

    public void setLogo_empresa(String logo_empresa) {
        this.logo_empresa = logo_empresa;
    }

    public String getLogo_empresa() {
        return logo_empresa;
    }

    public String getPasswordEmpresa() {
        return passwordEmpresa;
    }

    public void setPasswordEmpresa(String passwordEmpresa) {
        this.passwordEmpresa = passwordEmpresa;
    }

    public String getDetalle_venta() {
        return detalle_venta;
    }

    public void setDetalle_venta(String detalle_venta) {
        this.detalle_venta = detalle_venta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

   
}
