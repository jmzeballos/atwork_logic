/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.fe.model;

/**
 *
 * @author SOPORTE
 */
public class parametrosAdicionalesReporteBean {

    private String ordencompra;
    private String totalapagar;
    private String observaciones;

    public parametrosAdicionalesReporteBean() {
    }

    /**
     * @return the totalapagar
     */
    public String getTotalapagar() {
        return totalapagar;
    }

    /**
     * @param totalapagar the totalapagar to set
     */
    public void setTotalapagar(String totalapagar) {
        this.totalapagar = totalapagar;
    }

    /**
     * @return the ordencompra
     */
    public String getOrdencompra() {
        return ordencompra;
    }

    /**
     * @param ordencompra the ordencompra to set
     */
    public void setOrdencompra(String ordencompra) {
        this.ordencompra = ordencompra;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
