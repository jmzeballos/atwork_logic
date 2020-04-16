/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.model;

/**
 *
 * @author RAYP
 */
public class LibrorecModel {
    private int librorec_id;
    private int iddoc;
    private String numdoc;
    private String apepat;
    private String apemat;
    private String nombre;
    private String dep;
    private String prov;
    private String dist;
    private String direc;
    private String telf;
    private String email;
    private int areaid;
    private int motivoid;
    private double monto;
    private String descbien;
    private String tipo;
    private String detalle;
    private String pedido;
    private String ruta_doc;//extension
    private String fecha_reg;
    private String nom_doc; //nombre
    private String ext_doc; //extension
    private int usercrea;
    private String fechamod;
    private int usermod;
    private int userresp;
    private String fechtext;     
    private String descdoc;
    private String desdep;
    private String desprov;
    private String desdist;
    private String desareaid;
    private String desmotivoid;
    private String destipo;
    private String correlativo;
    private String resp;
    private int resplibrorec;

    
    private String est_i;
    
    //botones
    private String btn_est;
    private String btn_env_cor;
    private String btn_detalle;
    
    private String estado;

    
    private int idestado;
    
    public LibrorecModel() {
    }


    public int getLibrorec_id() {
        return librorec_id;
    }

    public void setLibrorec_id(int librorec_id) {
        this.librorec_id = librorec_id;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public int getMotivoid() {
        return motivoid;
    }

    public void setMotivoid(int motivoid) {
        this.motivoid = motivoid;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescbien() {
        return descbien;
    }

    public void setDescbien(String descbien) {
        this.descbien = descbien;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getRuta_doc() {
        return ruta_doc;
    }

    public void setRuta_doc(String ruta_doc) {
        this.ruta_doc = ruta_doc;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public String getNom_doc() {
        return nom_doc;
    }

    public void setNom_doc(String nom_doc) {
        this.nom_doc = nom_doc;
    }

    public String getExt_doc() {
        return ext_doc;
    }

    public void setExt_doc(String ext_doc) {
        this.ext_doc = ext_doc;
    }

    public int getUsercrea() {
        return usercrea;
    }

    public void setUsercrea(int usercrea) {
        this.usercrea = usercrea;
    }

    public String getFechamod() {
        return fechamod;
    }

    public void setFechamod(String fechamod) {
        this.fechamod = fechamod;
    }

    public int getUsermod() {
        return usermod;
    }

    public void setUsermod(int usermod) {
        this.usermod = usermod;
    }

    public int getUserresp() {
        return userresp;
    }

    public void setUserresp(int userresp) {
        this.userresp = userresp;
    }

    public String getFechtext() {
        return fechtext;
    }

    public void setFechtext(String fechtext) {
        this.fechtext = fechtext;
    }

    public String getDescdoc() {
        return descdoc;
    }

    public void setDescdoc(String descdoc) {
        this.descdoc = descdoc;
    }

    public String getDesdep() {
        return desdep;
    }

    public void setDesdep(String desdep) {
        this.desdep = desdep;
    }

    public String getDesprov() {
        return desprov;
    }

    public void setDesprov(String desprov) {
        this.desprov = desprov;
    }

    public String getDesdist() {
        return desdist;
    }

    public void setDesdist(String desdist) {
        this.desdist = desdist;
    }

    public String getDesareaid() {
        return desareaid;
    }

    public void setDesareaid(String desareaid) {
        this.desareaid = desareaid;
    }

    public String getDesmotivoid() {
        return desmotivoid;
    }

    public void setDesmotivoid(String desmotivoid) {
        this.desmotivoid = desmotivoid;
    }

    public String getDestipo() {
        return destipo;
    }

    public void setDestipo(String destipo) {
        this.destipo = destipo;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public int getResplibrorec() {
        return resplibrorec;
    }

    public void setResplibrorec(int resplibrorec) {
        this.resplibrorec = resplibrorec;
    }

    public String getEst_i() {
        return est_i;
    }

    public void setEst_i(String est_i) {
        this.est_i = est_i;
    }

    public String getBtn_est() {
        return btn_est;
    }

    public void setBtn_est(String btn_est) {
        this.btn_est = btn_est;
    }

    public String getBtn_env_cor() {
        return btn_env_cor;
    }

    public void setBtn_env_cor(String btn_env_cor) {
        this.btn_env_cor = btn_env_cor;
    }

    public String getBtn_detalle() {
        return btn_detalle;
    }

    public void setBtn_detalle(String btn_detalle) {
        this.btn_detalle = btn_detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }
}
